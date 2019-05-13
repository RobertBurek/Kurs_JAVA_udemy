import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Robert Burek
 */
public class Main {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Thread watek1 = new Thread(new WypisanieRunnable(lock), "Watek 1");
        Thread watek2 = new Thread(new WypisanieRunnable(lock), "Watek 2");

        watek1.start();

        System.out.println(Thread.currentThread().getName());
        System.out.println("cos tu sie dzieje OD RAZU po skonczonym watku watek");

        watek2.start();
    }
}

class WypisanieRunnable implements Runnable {

    private Lock lock;
    static String msg[] = {"To", "jest", "synchronicznie", "wypisana", "wiadomosc"};

    public WypisanieRunnable(Lock lock) {
        this.lock = lock;
    }


    public void run() {
        display(Thread.currentThread().getName());
    }

    public void display(String threadName) {
        lock.lock();
        try {
            for (int i = 0; i < msg.length; i++) {
                System.out.println(threadName + ": " + msg[i]);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        } finally {
            lock.unlock();
        }
    }
}