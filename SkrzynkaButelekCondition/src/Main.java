import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Robert Burek
 */
public class Main {
    public static void main(String[] args) {
        Skrzynka skrzynka = new Skrzynka();

        Lock lock = new ReentrantLock();
        Condition oczekiwanie = lock.newCondition();
        MaszynaProdukujacaButelki maszyna1 = new MaszynaProdukujacaButelki(skrzynka, lock, oczekiwanie);
        MaszynaZmieniajacaSkrzynki maszyna2 = new MaszynaZmieniajacaSkrzynki(skrzynka, lock, oczekiwanie);

        Thread produkcja = new Thread(maszyna1, "producent");
        Thread zmieniacz = new Thread(maszyna2, "zmieniacz");

        produkcja.start();
        zmieniacz.start();
    }
}

class MaszynaProdukujacaButelki implements Runnable {

    private Condition oczekiwanie;
    private Lock lock;
    private Skrzynka skrzynka;
    private int i = 0;

    public MaszynaProdukujacaButelki(Skrzynka skrzynka, Lock lock, Condition oczekiwanie) {
        this.skrzynka = skrzynka;
        this.lock = lock;
        this.oczekiwanie = oczekiwanie;
    }

    public void run() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ": Zaczynam produkować butelki.");
            while (i < 66) {
                while (skrzynka.jestPelna()) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ": Informuję, że trzeba wymienić skrzynkę, ponieważ jest pełna");
                        oczekiwanie.await();
                        System.out.println(Thread.currentThread().getName() + ": Powróciłem do produkcji! :-)");
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() + ": Wyprodukowałem " + (++i) + " buteleczkę");
                skrzynka.dodaj(new Butelka());

                oczekiwanie.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }
}

class MaszynaZmieniajacaSkrzynki implements Runnable {

    private Condition oczekiwanie;
    private Lock lock;
    private Skrzynka skrzynka;

    public MaszynaZmieniajacaSkrzynki(Skrzynka skrzynka, Lock lock, Condition oczekiwanie) {
        this.skrzynka = skrzynka;
        this.lock = lock;
        this.oczekiwanie = oczekiwanie;
    }

    public void run() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ": Zaczynam się przygotowywać do zmiany skrzynki ");
            while (true) {
                System.out.println(Thread.currentThread().getName() + ": jakaś informacja");
                while (!skrzynka.jestPelna()) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ": Informuję, że skończyłem zamieniać");
                        oczekiwanie.await();
                        System.out.println(Thread.currentThread().getName() + ": Powróciłem do zamiany! :-)");
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                skrzynka.pobierzIloscButelek();
                skrzynka.zamiana();
                skrzynka.pobierzIloscButelek();

                oczekiwanie.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }
}

class Skrzynka {

    private final int POJEMNOSC = 10;
    private ArrayList listaButelek = new ArrayList(POJEMNOSC);

    public synchronized boolean jestPelna() {
        if (listaButelek.size() == POJEMNOSC)
            return true;
        return false;
    }

    public synchronized int pobierzIloscButelek() {
        System.out.println(Thread.currentThread().getName() + " Aktualnie w skrzynce jest: " + this.listaButelek.size());
        return this.listaButelek.size();
    }

    public synchronized void dodaj(Butelka butelka) {
        listaButelek.add(butelka);
    }

    public synchronized void zamiana() {
        System.out.println(Thread.currentThread().getName() + " Zamieniam skrzynki");
        listaButelek.clear();
    }
}

class Butelka {
}