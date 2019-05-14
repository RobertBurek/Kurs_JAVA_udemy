import java.util.ArrayList;

/**
 * Created by Robert Burek
 */
public class Main {

    public static void main(String[] args) {
        Skrzynka skrzynka = new Skrzynka();

        MaszynaProdukujacaButelki maszyna1 = new MaszynaProdukujacaButelki(skrzynka);
        MaszynaZmieniajacaSkrzynki maszyna2 = new MaszynaZmieniajacaSkrzynki(skrzynka);

        Thread produkcja = new Thread(maszyna1, "producent");
        Thread zmieniacz = new Thread(maszyna2, "zmieniacz");

        produkcja.start();
        zmieniacz.start();
    }
}

class MaszynaProdukujacaButelki implements Runnable {

    private Skrzynka skrzynka;
    private int i = 0;

    public MaszynaProdukujacaButelki(Skrzynka skrzynka) {
        this.skrzynka = skrzynka;
    }

    public void run() {
        synchronized (skrzynka) {
            System.out.println(Thread.currentThread().getName() + ": Zaczynam produkować butelki.");
            while (i < 66) {
                while (skrzynka.jestPelna()) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ": Informuję, że trzeba wymienić skrzynkę, ponieważ jest pełna");
                        skrzynka.wait();
                        System.out.println(Thread.currentThread().getName() + ": Powróciłem do produkcji! :-)");
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() + ": Wyprodukowałem " + (++i) + " buteleczkę");
                skrzynka.dodaj(new Butelka());

                skrzynka.notifyAll();
            }
        }
    }
}

class MaszynaZmieniajacaSkrzynki implements Runnable {

    private Skrzynka skrzynka;

    public MaszynaZmieniajacaSkrzynki(Skrzynka skrzynka) {
        this.skrzynka = skrzynka;
    }

    public void run() {

        synchronized (skrzynka) {
            System.out.println(Thread.currentThread().getName() + ": Zaczynam się przygotowywać do zmiany skrzynki ");
            while (true) {
                System.out.println(Thread.currentThread().getName() + ": jakaś informacja");
                while (!skrzynka.jestPelna()) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ": Informuję, że skończyłem zamieniać");
                        skrzynka.wait();
                        System.out.println(Thread.currentThread().getName() + ": Powróciłem do zamiany! :-)");
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                skrzynka.pobierzIloscButelek();
                skrzynka.zamiana();
                skrzynka.pobierzIloscButelek();

                skrzynka.notifyAll();
            }
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
        System.out.println("W skrzynce jest teraz: " + listaButelek.size());
    }

    public synchronized void zamiana() {
        System.out.println(Thread.currentThread().getName() + " Zamieniam skrzynki");
        listaButelek.clear();
    }
}

class Butelka {
}