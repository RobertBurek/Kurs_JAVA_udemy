import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Robert Burek
 */
public class Main {

    //final static private File sciezkaGlowna = new File(System.getProperty("user.dir"));
    final static private File sciezkaGlowna = new File("C:\\Users\\DELL\\IdeaProjects\\Kurs_JAVA_udemy\\");
    //final static private File sciezkaGlowna = new File("C:\\Users\\DELL\\IdeaProjects");
    final static private String slowoSzukane = new String("czyli");

    public static void main(String[] args) {
        BlockingQueue<File> kolejkaBlokujaca = new ArrayBlockingQueue<File>(5);
        //BlockingQueue<File> kolejkaBlokujaca = new LinkedBlockingDeque<>();

        new Thread(new PoszukiwaczSciezek(kolejkaBlokujaca, sciezkaGlowna)).start();

        for (int i = 0; i < 20; i++) {
            new Thread(new PrzeszukiwaczPlikow(kolejkaBlokujaca, slowoSzukane)).start();
            //System.out.println(i + ") " + kolejkaBlokujaca);
        }
    }
}


class PoszukiwaczSciezek implements Runnable {

    BlockingQueue<File> kolejka;
    File sciezkaGlowna;

    public PoszukiwaczSciezek(BlockingQueue<File> kolejka, File sciezkaGlowna) {
        this.kolejka = kolejka;
        this.sciezkaGlowna = sciezkaGlowna;
    }

    public void run() {
        try {
            szukajSciezek(sciezkaGlowna);
            kolejka.put(new File("pusty"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void szukajSciezek(File sciezka) throws InterruptedException {
        File[] sciezki = sciezka.listFiles();
        for (int i = 0; i < sciezki.length; i++)
            if (sciezki[i].isDirectory())
                szukajSciezek(sciezki[i]);
            else {
                kolejka.put(sciezki[i]);
                //System.out.println(sciezki[i]);
            }
    }
}


class PrzeszukiwaczPlikow implements Runnable {

    BlockingQueue<File> kolejka;
    String szukaneSlowo;

    public PrzeszukiwaczPlikow(BlockingQueue<File> kolejka, String szukaneSlowo) {
        this.kolejka = kolejka;
        this.szukaneSlowo = szukaneSlowo;
    }

    public void run() {
        boolean skonczone = false;
        while (!skonczone) {
            try {
                File przeszukiwanyPlik = kolejka.take();
                if (przeszukiwanyPlik.equals(new File("pusty"))) {
                    System.out.println(new File("pusty"));
                    kolejka.put(przeszukiwanyPlik);
                    skonczone = true;
                } else
                    szukajSlowa(przeszukiwanyPlik);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void szukajSlowa(File przeszukiwanyPlik) throws FileNotFoundException {
        System.out.println("Szukam w pliku : " + przeszukiwanyPlik.getName());
        Scanner reader = new Scanner(new BufferedReader(new FileReader(przeszukiwanyPlik)));
        int numerLini = 0;
        while (reader.hasNextLine()) {
            //if (przeszukiwanyPlik.getName().equals("informatyka.txt")) System.out.println(reader.nextLine());
            numerLini++;
            if (reader.nextLine().contains(szukaneSlowo))
                System.out.println("Szukane słowo znajduje się w pliku: " + przeszukiwanyPlik.getPath() + " w lini " + numerLini);
        }
        reader.close();
    }
}
