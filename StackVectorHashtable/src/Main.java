import java.util.*;

/**
 * Created by Robert Burek
 */
public class Main {

    public static void main(String[] args) {
        Stack<String> stos = new Stack<String>();

        stos.push("lala1");
        stos.push("lala2");
        stos.push("lala3");
        stos.push("lala4");
        stos.push("lala5"); //usuń dla poniższego warunku

        System.out.println(stos.pop());
        System.out.println(stos.pop());
        System.out.println(stos.pop());
        System.out.println(stos.pop());

        try {
            String nazwa = stos.peek();

            if (nazwa.equals("lala1")) {
                System.out.println(stos.pop().getBytes());
                System.out.println("Wziąłem ze stosu LALA1");
            } else
                System.out.println("nie ma takiego na samej gorze");
        } catch (EmptyStackException e) {
            System.out.println("Nie nic na stosie.");
        }

        Vector<String> wektor = new Vector<String>();

        wektor.add("lala");

        wektor.get(0);

        HashMap a;
        Hashtable b;
    }
}