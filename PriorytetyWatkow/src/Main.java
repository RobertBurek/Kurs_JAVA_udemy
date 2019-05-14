/**
 * Created by Robert Burek
 */
public class Main {

    public static int limitWatek1, limitWatek2 = 0;

    public static void main(String[] args) {

        Thread.currentThread().setPriority(7); //priorytet dla metody main
        System.out.println(Thread.currentThread().getPriority());

        Thread watek1 = new Thread(new Thread1(), "maly");
        Thread watek2 = new Thread(new Thread2(), "duzy");

        watek1.setPriority(Thread.MIN_PRIORITY);
        watek2.setPriority(Thread.MAX_PRIORITY);

        System.out.println(watek1.getPriority());
        System.out.println(watek2.getPriority());

        watek1.start();
        watek2.start();
    }
}

class Thread1 implements Runnable {

    public void run() {
        while (Main.limitWatek1 < 20) {
            Main.limitWatek1++;
            System.out.println(Thread.currentThread().getName() + " " + Main.limitWatek1);
        }
    }
}

class Thread2 implements Runnable {

    public void run() {
        while (Main.limitWatek2 < 20) {
            Main.limitWatek2++;
            System.out.println(Thread.currentThread().getName() + " " + Main.limitWatek2);
        }
    }
}
