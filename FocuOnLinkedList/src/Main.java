import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Robert Burek
 */
public class Main {

    public static void main(String[] args) {

        LinkedList<String> listaPowiazana = new LinkedList<String>();

        listaPowiazana.add("lala1");

        listaPowiazana.add("lala2");
        listaPowiazana.add("lala3");
        listaPowiazana.add("lala4");

        Long startTime = System.nanoTime();
        Long endTime = System.nanoTime();

        System.out.println("Elementy LinkedList z pętli FOR:");
        for (int i = 0; i < listaPowiazana.size(); i++) {
            System.out.println(listaPowiazana.get(i));
        }
        endTime = System.nanoTime();
        System.out.println("Czas w nanoSek: " + (endTime - startTime));
        System.out.println("");

        startTime = System.nanoTime();

        System.out.println("Elementy LinkedList poprzez metodę: ");
        Main.wypiszElementyListy(listaPowiazana);

        endTime = System.nanoTime();
        System.out.println("Czas w nanoSek: " + (endTime - startTime));
        System.out.println("");

        System.out.println("------- w odwrotnej kolejności----------");
        ListIterator<String> iter = listaPowiazana.listIterator(listaPowiazana.size());
        /*
         *
         * | A B C D
         * A | B C D
         * A B | C D
         * A B C  | D
         * A B C D |
         *
         * n+1
         * */

        while (iter.hasPrevious()) {
            System.out.println(iter.previous());
            iter.set("podmiana");
        }

        iter = listaPowiazana.listIterator();
        iter.next();
        iter.add("nowylala");
        //iter.remove();//usuwa poprzednika
        iter.next();
        iter.next();
        iter.add("kolejny Element " + listaPowiazana.size());
        listaPowiazana.add(listaPowiazana.size(), "Na koniec listy " + listaPowiazana.size());

        Main.wypiszElementyListy(listaPowiazana);

        System.out.println("-----------jeden element----kilka sposobów -----------");
        wypiszJedenElementListy(listaPowiazana, 4);
        wypiszGetElementListy(listaPowiazana, 4);
        wypiszElement(listaPowiazana, 4);

    }

    public static void wypiszElementyListy(LinkedList<?> lista) {
        Iterator iteratorListy = lista.iterator();
        int i = 0;
        while (iteratorListy.hasNext()) {
            System.out.println(i + ") " + iteratorListy.next());
            i++;
        }
    }

    public static void wypiszJedenElementListy(LinkedList<?> lista, int pozycja) {
        Iterator iteratorListy = lista.iterator();
        for (int i = 0; i < pozycja; i++)
            if (iteratorListy.hasNext()) iteratorListy.next();
        System.out.println(iteratorListy.next());
    }

    public static void wypiszGetElementListy(LinkedList<?> lista, int pozycja) {
        System.out.println(lista.get(pozycja));
    }

    public static void wypiszElement(LinkedList<?> lista, int pozycja) {
        ListIterator listIterator = lista.listIterator(pozycja);
        System.out.println(listIterator.next());
    }
}
/*

====
|  |  - 0
====

 * INNE OBIEKTY
TU ZNAJDUJE SIE ITERATOR
====
|  |  - 1
====
====
|  | - 200
====
====
|  | - 400
====
====
|  | - 1000
====

      */