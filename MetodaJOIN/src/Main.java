/**
 * Created by Robert Burek
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Thread watek = new Thread(new WypisanieRunnable(lock), "Watek 1");
        Thread watek2 = new Thread(new WypisanieRunnable(lock), "Watek 2");

        watek.start();

        watek.join();

        watek2.start();

        System.out.println(Thread.currentThread().getName());
        System.out.println("To dzieje sie OD RAZU po skonczonym watku watek");
    }
}

class WypisanieRunnable implements Runnable {

    private Object lock;

    public WypisanieRunnable(Object lock) {
        this.lock = lock;
    }

    static String msg[] = {"To", "jest", "synchronicznie", "wypisana", "wiadomosc"};

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
