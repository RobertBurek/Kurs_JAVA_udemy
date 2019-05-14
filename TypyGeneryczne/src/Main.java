import java.util.ArrayList;

/**
 * Created by Robert Burek
 */
public class Main {

    public static void main(String[] args) {

        ArrayList<String> a = new ArrayList<String>();

        a.add(new String("lala1"));
        a.add(new String("lala2"));
        a.add(new String("lala3"));
        a.add(new String("lala4"));
        a.add(new String("lala5"));
        a.add(new String("lala6"));


        //a.add(new Integer(4));

      /*  for (int i = 0; i < a.size(); i++)
            System.out.println((String)a.get(i));
        */
        for (String stringi : a)
            System.out.println(stringi);

        Zwykla<String> nazwaZmiennej = new Zwykla();
        nazwaZmiennej.nadajWartosc("JakiśTekst");
        System.out.println(nazwaZmiennej.zwroc());
    }
}

class Zwykla<COKOLWIEK> {

    COKOLWIEK nazwaZmiennejTypuCokolwiek;

    public void nadajWartosc(COKOLWIEK wartosc) {
        this.nazwaZmiennejTypuCokolwiek = wartosc;
    }

    public COKOLWIEK zwroc() {
        return this.nazwaZmiennejTypuCokolwiek;
    }
}
