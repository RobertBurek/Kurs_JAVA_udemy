import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Robert Burek
 */
public class Main {

    public static void main(String[] args) {

        long mili = 0;
        long totalMili = 0;
        Set<String> set = new HashSet<String>(1024);
        //set = new TreeSet<String>();
        String plik1 = "C:\\Users\\DELL\\Documents\\Forrest Gump\\Chapter 2_zdania.txt";
        String plik2 = "informatyka.txt";

        try {
            Scanner reader = new Scanner(new BufferedReader(new FileReader(plik2)));
            while (reader.hasNext()) {
                mili = System.currentTimeMillis();
                set.add(reader.next());
                totalMili += (System.currentTimeMillis() - mili);
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Iterator<String> iter = set.iterator();
        while (iter.hasNext())
            System.out.println(iter.next());

        System.out.println("Czas wykonania: " + totalMili + " ms");
        System.out.println("Wielkość zbioru: " + set.size());
    }
}


class Element {
    public Element(int wartosc) {
        this.wartosc = wartosc;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        return this.wartosc == ((Element) obj).wartosc;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 14 * hash + this.wartosc;
        return hash;
    }

    int wartosc;
}