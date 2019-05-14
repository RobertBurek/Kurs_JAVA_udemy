import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Robert Burek
 */
public class Main {

    public static void main(String[] args) {

        Figura figura1 = new Kolo();
        Figura figura2 = new Kwadrat();
        Figura[] figury = new Figura[50];
        List<Figura> listaFigur = new ArrayList<Figura>();
        listaFigur.add(figura1);
        listaFigur.add(figura2);

        System.out.println("---- z metody wypisz -----");
        Edytor.wypisz(listaFigur);

        System.out.println("----- z metody wypisz2 -----");
        Edytor.wypisz2(listaFigur);

        System.out.println("----- z metody wypisz3 -----");
        Edytor.wypisz3(listaFigur);

        Float[] fl = new Float[50];
        Integer[] in = new Integer[50];
        Number[] nu = new Number[50];
        Collection<Number> colectionNumber = new ArrayList<Number>();
        Edytor.przepiszTabliceDoKolekcji(fl, colectionNumber);
        Edytor.przepiszTabliceDoKolekcji(in, colectionNumber);
        Edytor.przepiszTabliceDoKolekcji(nu, colectionNumber);

    }
}


class Edytor {

    public static void wypisz(List<? extends Figura> lista) {
        for (Figura figura : lista)
            System.out.println(figura.pobierzNazwe());
        // lista.add(new Kolo()); - nie mogę bo nie jest podtypem "?"
        lista.add(null); //mogę bo null jest podtypem "?"
        System.out.println("--------");
        for (Figura figura : lista) {
            if (figura == null) {
                System.out.println("null");
                break;
            }
            System.out.println(figura.pobierzNazwe());
        }
    }

    public static <T extends Figura> void wypisz2(List<T> lista) {
        lista.remove(2); //musimy usunąć z listy trzeci element null gdyż on nie posiada nazwy
        for (T figura : lista)
            System.out.println(figura.pobierzNazwe());
        lista.add((T) new Kolo());
        lista.add((T) new Kolo());
        lista.add((T) new Kolo());
        lista.add((T) new Kolo());
        lista.add(null);
        System.out.println("--------");
        for (T figura : lista) {
            if (figura == null) {
                System.out.println("null");
                break;
            }
            System.out.println(figura.pobierzNazwe());
        }
    }


    public static void wypisz3(List<Figura> lista) {
        lista.remove(6); //musimy usunąć z listy 6 element null gdyż on nie posiada nazwy
        for (Figura figura : lista)
            System.out.println(figura.pobierzNazwe());
        lista.add(new Kwadrat());
        lista.add(new Kwadrat());
        lista.add(new Kwadrat());
        lista.add(new Kwadrat());
        lista.add(null);
        System.out.println("--------");
        for (Figura figura : lista) {
            if (figura == null) {
                System.out.println("null");
                break;
            }
            System.out.println(figura.pobierzNazwe());
        }
    }

    //metoda generyczna - wymyslamy element <Type>
    public static <Type> void przepiszTabliceDoKolekcji(Type[] tab, Collection<Type> c) {
        for (Type o : tab)
            c.add(o);
    }
}

class Figura<K> {

    K lala;
    String nazwa = "";

    public String pobierzNazwe() {
        return nazwa;
    }
}

class Kolo extends Figura {

    public Kolo() {
        super.nazwa = "Kolo";
    }
}

class Kwadrat extends Figura {

    public Kwadrat() {
        super.nazwa = "Kwadrat";
    }
}
