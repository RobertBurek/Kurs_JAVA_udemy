
package tokenizacjamoja;

import java.io.*;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TokenizacjaMoja {


    public static void main(String[] args) {

        Towar[] nowyTowar = new Towar[4];
        nowyTowar[0] = new Towar();
        nowyTowar[1] = new Towar(29.9, "Harry Potter");
        nowyTowar[2] = new Towar(55.5, "Coś Nowego", 2019, 01, 10);
        nowyTowar[3] = new Towar(35.58, "Stary człowiek", 2018, 12, 15);

        try {

            FileOutputStream outS = new FileOutputStream("nowy.txt");
            DataOutputStream dOutS = new DataOutputStream(new FileOutputStream("nowy2.txt"));


            outS.write(49);
            dOutS.writeDouble(125.258);


            outS.close();
            dOutS.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            //   zapis.close();
        }

    }

}
