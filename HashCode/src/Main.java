import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Robert Burek
 */
public class Main {
    public static void main(String[] args) {
        Element a = new Element(47);
        Element b = new Element(47);
        Element c = null;
        System.out.println(a.equals(b));

        System.out.println(a.hashCode() % 128);
        System.out.println(b.hashCode() % 128);

        System.out.println(Element.co3.hashCode());
        System.out.println("fgt".hashCode());

        System.out.println(Element.cos.hashCode());
        System.out.println(((Double) 45.5465654).hashCode());

        System.out.println(Element.cos2.hashCode());
        System.out.println(((Long) 86343433444444446L).hashCode());

        ArrayList<LinkedList> listaList = new ArrayList<>(8);

        LinkedList<String> nazwiska = new LinkedList();

        nazwiska.add("Kowalski");
        System.out.println(nazwiska.get(0) + " " + nazwiska.get(0).hashCode());
        nazwiska.add("Moniuszko");
        System.out.println(nazwiska.get(1) + " " + nazwiska.get(1).hashCode());
        nazwiska.add("Ktośtam");
        System.out.println(nazwiska.get(2) + " " + nazwiska.get(2).hashCode());

        listaList.add(nazwiska);

    }
}


class Element {

    static int wartosc;

    static Double cos = 45.5465654;
    static Long cos2 = 86343433444444446L;
    static String co3 = "fgt";


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
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.cos) ^ (Double.doubleToLongBits(this.cos) >>> 32));
        hash = 89 * hash + (int) (this.cos2 ^ (this.cos2 >>> 32));
        hash = 89 * hash + (this.co3 != null ? this.co3.hashCode() : 0);
        return hash;
    }
}
