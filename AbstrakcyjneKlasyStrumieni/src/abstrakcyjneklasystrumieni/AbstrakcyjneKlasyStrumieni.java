
package abstrakcyjneklasystrumieni;

import java.awt.List;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;


public class AbstrakcyjneKlasyStrumieni extends JFrame
{  
   
    public AbstrakcyjneKlasyStrumieni()
    {
         
        initComponents();
         int szer = Toolkit.getDefaultToolkit().getScreenSize().width;
         int wys = Toolkit.getDefaultToolkit().getScreenSize().height;
         int szerR = this.getSize().width;
         int wysR = this.getSize().height;

      
         
         this.setLocation((szer-szerR)/2,(wys-wysR)/2);

    }
    
    public void initComponents()
    {
      this.setSize(550, 175);
      this.setTitle("Abstrakcyjne Klasy Strumieni"); 
      

       

      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
   
        
    public static void main(String[] args) throws IOException
    {
        new AbstrakcyjneKlasyStrumieni().setVisible(true);
       
//        InputStream inS;
//        OutputStream outS;
//        
//        Reader reader;
//        File plik = new File("nazwaPliku.txt");
//        //Writer writer = new FileWriter("nazwaPliku.txt");
//        //Writer writer = new BufferedWriter(new FileWriter("nazwaPliku.txt"));
//        //Writer writer = new BufferedWriter(new FileWriter("nazwaPliku.txt"));
//        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(plik)));
//        
//        writer.write("Pierwsza linia z klasy WRITER");
//        ((BufferedWriter)writer).newLine();
//        ((BufferedWriter)writer).write("Coś nowego w nowej linii 2");
//        ((BufferedWriter)writer).newLine();
//        ((BufferedWriter)writer).write("Coś nowego w nowej linii 3");
//        writer.close();
        
        PrintWriter drukuj = new PrintWriter(new FileWriter("NowyPlik.txt"));
        drukuj.println(1232);
        drukuj.println();
        drukuj.append("cos innego \n\r");
        drukuj.println();
        drukuj.printf("printf %d", 56);
        drukuj.println();
        drukuj.printf("printf %d oraz cos na %.2f cmentymetrów", 56, 165.4);
        drukuj.println();
        drukuj.printf("printf %s oraz cos na %.2f cmentymetrów", "NONO", 165.4);
       // drukuj.flush();
        drukuj.close();
        File pliczek = new File("NowyPlik.txt");
        File pliczek2 = new File("Baza.txt");
        BufferedReader reader = new BufferedReader(new FileReader(pliczek));
      //  BufferedReader przetwazanie = new BufferedReader(new FileReader(pliczek2));
        PrintWriter zrobTo = new PrintWriter(new FileWriter(pliczek2,true));
         // System.out.println(reader.read());
//        System.out.println(reader.readLine());
//        System.out.println(reader.readLine());
//        System.out.println(reader.readLine());
//        System.out.println(reader.readLine());
//        System.out.println(reader.readLine());
//        System.out.println(reader.readLine());
//        System.out.println(reader.readLine());
//        System.out.println(reader.readLine());
       String tresc = "";
        while((tresc = reader.readLine()) != null)
           System.out.println(tresc);
          // System.out.println(reader.readLine());
        reader.close();
        Scanner odczyt = new Scanner(pliczek);
        while(odczyt.hasNextLine())
        {
           tresc = odczyt.nextLine();
           zrobTo.println(tresc);
        }
       // System.out.println(odczyt.nextLine());
        
        odczyt.close();
         zrobTo.close();
        
       // AbstrakcyjneKlasyStrumieni.test(3,4,45454,"lall",456,"fterr",34.56,"TTT");
       
    } 
    
    
    static void test(Object... a)
    {
       for (int i=0; i<a.length; i++ )
       {
         System.out.println(a[i]);
       }
    }
}
