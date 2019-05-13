/**
 * Created by Robert Burek
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

//        System.out.println("----------------------------------------nie synchronicznie ----------------------");
//        //Dwa wątki nie działające synchronicznie - asynchronicznie
//        Runnable wypisanie = new Runnable() {
//            @Override
//            public void run() {
//                String msg[] = {"To", "nie", "jest", "synchronicznie", "wypisana", "wiadomość"};
//                for (int i = 0; i < msg.length; i++) {
//                    System.out.println(Thread.currentThread().getName() + ": " + msg[i]);
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        System.out.println(e.getMessage());
//                    }
//                }
//            }
//        };
//        Thread watek11 = new Thread(wypisanie, "Watek 1");
//        Thread watek22 = new Thread(wypisanie, "Watek 2");
//        watek11.start();
//        watek22.start();
//
//        Thread.sleep(500);
//
//        System.out.println("----------------------------------------synchronicznie po klasie lock---------------");
//        //Dwa wątki działające synchronicznie poprzez dodatkową klasę lock
//        Object lock = new Object();
//        Thread watek = new Thread(new WypisanieRunnable(lock), "Watek 1");
//        Thread watek2 = new Thread(new WypisanieRunnable(lock), "Watek 2");
//        watek.start();
//        watek2.start();
//
//        Thread.sleep(500);

        System.out.println("----------------------------------------synchronicznie po zmiennej licznik---------------");
        Counter licznik = new Counter();
        //Runnable costam = new CounterRunnable(licznik, false);

        Thread watek3 = new Thread(new CounterRunnable(licznik, false), " Maleje ");
        Thread watek4 = new Thread(new CounterRunnable(licznik, true), " Rośnie ");

        watek3.start();
        watek4.start();
    }
}

class WypisanieRunnable implements Runnable {

    static String msg[] = {"To", "jest", "synchronicznie", "wypisana", "wiadomosc"};
    private Object lock;

    public WypisanieRunnable(Object lock) {
        this.lock = lock;
    }


    public void run() {
        display(Thread.currentThread().getName());
    }

    public void display(String threadName) {
        synchronized (lock) {
            for (int i = 0; i < msg.length; i++) {
                System.out.println(threadName + ": " + msg[i]);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}

class Counter {

    private int counter = 50;

    public void increaseCounter() {
        counter++;
        System.out.print(Thread.currentThread().getName() + ": " + counter);
    }

    public void decreaseCounter() {
        counter--;
        System.out.print(Thread.currentThread().getName() + ": " + counter);
    }
}

class CounterRunnable implements Runnable {

    boolean increase;
    Counter licznik;

    public CounterRunnable(Counter licznik, boolean increase) {
        this.licznik = licznik;
        this.increase = increase;
    }

    public void run() {
        synchronized (licznik) {
            for (int i = 0; i < 50; i++) {
                if (increase)
                    licznik.increaseCounter();
                else
                    licznik.decreaseCounter();
                try {
                    Thread.sleep(100);
                    System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}

