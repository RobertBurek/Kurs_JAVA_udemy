import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Robert Burek
 */
public class Main {

    public static void main(String[] args) {
        Set<Element> set = new TreeSet<Element>(
                new Comparator<Element>() {

                    public int compare(Element o1, Element o2) {
//                        String opisO1 = o1.pobierzOpis();
//                        String opisO2 = o2.pobierzOpis();
//                        return opisO1.compareTo(opisO2);
                        return (o1.pobierzOpis()).compareTo(o2.pobierzOpis());
                    }
                }
        );

        set.add(new Element(1245, "opis"));
        set.add(new Element(5, "aopis"));
        set.add(new Element(445, "zopis"));

        Iterator<Element> iter = set.iterator();
        while (iter.hasNext())
            System.out.println(iter.next().pobierzOpis());

        System.out.println("Wielkość zbioru: " + set.size());
    }
}


class Element implements Comparable {

    int wartosc;
    String opis;

    public Element(int wartosc) {
        this.wartosc = wartosc;
    }

    public Element(int wartosc, String opis) {
        this(wartosc);
        this.opis = opis;
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

    public String pobierzOpis() {
        return opis;
    }

    public int compareTo(Object o) {
        return wartosc - ((Element) o).wartosc;
    }
}