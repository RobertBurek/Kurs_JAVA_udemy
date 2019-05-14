import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert Burek
 */
public class Main {

    public static void main(String[] args) {
        /*
         * MÓWIĘ, ŻE podkładam za "E" : "String" we wszystkich deklaracjach/definicjach metod
         * Lista Stringów
         * */
        List<String> listaStringow = new ArrayList<String>();

        //List<SuperClass> listaClass = new ArrayList<SuperClass>();
        List<SubClass> listaClass = new ArrayList<SubClass>();
        // listaClass.add(new SuperClass());
        listaClass.add(new SubClass());

        SuperClass.tester(listaStringow);

       /*
        ŹLE
        ArrayList<String> listaS = new ArrayList<String>();
       ArrayList<Object> listaO = listaS;

       listaO.add(new Integer(4));
       String a = (String) listaO.get(0);*/

    }
}

class SuperClass {
    public static void tester(List<? extends Object> lista) {
        /*
         *  ? - wildcard - znak wieloznacznośći
         *  ? extends JakasClassa - znak wieloznacznosci jest ograniczony klasa JakasClassa bounded wildcard
         */
    }
}

class SubClass extends SuperClass {
}