/*
 * Napisane 02.2019  
 */
package podzialpanelu;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Robert Burek
 */
public class PodzialPanelu extends JFrame {

   /**
    * @param args the command line arguments
    */
 
   public PodzialPanelu() {
         
         initComponents();
         int szer = Toolkit.getDefaultToolkit().getScreenSize().width;
         int wys = Toolkit.getDefaultToolkit().getScreenSize().height;
         int szerR = this.getSize().width;
         int wysR = this.getSize().height;

      

         this.setLocation((szer-szerR)/2,(wys-wysR)/2);

   }
   
   JPanel panelMenu = new JPanel();
   JPanel panelGorny = new JPanel();
   JPanel panelLewy = new JPanel();
   JPanel panelPrawy = new JPanel();
   JPanel panelSrodek = new JPanel();
   JPanel panelDolny = new JPanel();
   JList spisTresci = new JList(new Tresc[] {
      new Tresc("IntroductionR", "Treść - wprowadzenia", "Krótki opis wprowadzenia"),
      new Tresc("Spis treści", "Treść - spisu treści", "Krótki opis spisu treści"),
      new Tresc("Część 1", "Treść - zawartość Rozdział I", "Krótki opis rozdziału 1"), 
      new Tresc("Część 2", "Treść - zawartość Rozdział II", "Krótki opis rozdziału 2"), 
      new Tresc("Chapter III", "Treść - zawartość Rozdział III", "Krótki opis rozdziału 3"), 
      new Tresc("Chapter IV", "Treść - zawartość Rozdział IV", "Krótki opis rozdziału 4"), 
      new Tresc("Rozdział V", "Treść - zawartość Rozdział V", "Krótki opis rozdziału 5"), 
      new Tresc("Rozdział VI", "Treść - zawartość Rozdział VI", "Krótki opis rozdziału 6"), 
      new Tresc("Rozdział VII", "Treść - zawartość Rozdział VII", "Krótki opis rozdziału 7"), 
      new Tresc("Rozdział VIII", "Treść - zawartość Rozdział VIII", "Krótki opis rozdziału 8"), 
      new Tresc("Rozdział IX", "Treść - zawartość Rozdział IX", "Krótki opis rozdziału 9"), 
      new Tresc("Rozdział X", "Treść - zawartość Rozdział X", "Krótki opis rozdziału 10"), 
      new Tresc("Rozdział XI", "Treść - zawartość Rozdział XI", "Krótki opis rozdziału 11"), 
      new Tresc("Rozdział XII", "Treść - zawartość Rozdział XII", "Krótki opis rozdziału 12")});
   static JLabel menu = new JLabel();
   JLabel tytul = new JLabel();
   static JTextArea opis = new JTextArea();
   static JTextArea zawartoscRozdzialu = new JTextArea();
   JList utwory = new JList(new String[] {"Forrest Gump", "Alicja w krainie", "Strefa Zet"});
   public JScrollPane scrollPaneSrodek = new JScrollPane (zawartoscRozdzialu,
                     JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                     JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
   JButton zapisz = new JButton("ZAPISZ");
   
    
   public void initComponents() {
      this.setSize(1200, 800);
      this.setTitle("Podział panelu"); 
    //    Font tenFont = zawartoscRozdzialu.getFont();
    //    zawartoscRozdzialu.setFont(new Font(tenFont.getName(),Font.ITALIC,16));
      panelMenu.setBackground(Color.red);
      menu.setForeground(Color.white);      
      panelGorny.setBackground(Color.blue);
      panelLewy.setBackground(Color.yellow);
      panelPrawy.setBackground(Color.black);
      panelSrodek.setBackground(Color.green);
      panelDolny.setBackground(Color.gray);
      spisTresci.setBackground(Color.yellow);
      spisTresci.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      opis.setBackground(Color.gray);
      opis.setForeground(Color.black);
//      zawartoscRozdzialu.setText("                                                                   "
//              + "                                                                                    "
//              + "                                                                                    "
//              + "                                                                                    ");
      zawartoscRozdzialu.setBackground(Color.green);
      //zawartoscRozdzialu.setAutoscrolls(true);
      zawartoscRozdzialu.setLineWrap(true);
      //zawartoscRozdzialu.setRows(70);
      //zawartoscRozdzialu.setColumns(70);
      //zawartoscRozdzialu.setSize(200, 200);
      //zawartoscRozdzialu.setMaximumSize(200);
      //System.out.println(zawartoscRozdzialu.getMaximumSize());
      tytul.setText("Forrest Gump");
      tytul.setForeground(Color.WHITE);
      panelMenu.add(menu);
      menu.setText(" ");
      panelGorny.add(tytul);
      panelDolny.add(opis);
      panelLewy.add(spisTresci);
      //panelSrodek.add(zawartoscRozdzialu);
      //scrollPaneSrodek.add(zawartoscRozdzialu);
     // scrollPaneSrodek.setBounds(0, 0, 300, 300);
      zawartoscRozdzialu.setRows(20);
      zawartoscRozdzialu.setColumns(55);
      Font tenFont = zawartoscRozdzialu.getFont();
      Font nowyf=new Font(tenFont.getName(),Font.PLAIN,20);
      zawartoscRozdzialu.setFont(nowyf);
      panelSrodek.add(scrollPaneSrodek);
      panelPrawy.add(utwory);
      panelPrawy.add(zapisz);
      panelPrawy.setLayout(new GridLayout(6, 1));
      zapisz.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            Tresc zawartosc=(Tresc)((JList)e.getSource()).getSelectedValue();
            zapiszRozdzial("C:\\Users\\DELL\\Documents\\Forrest Gump\\" + zawartosc.podTytul + "_new.txt");
         }
      });
      spisTresci.addListSelectionListener(new ListSelectionListener() {
         @Override
         public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()){
               Tresc zawartosc=(Tresc)((JList)e.getSource()).getSelectedValue();
          //     System.out.println(((JList)e.getSource()).getSelectedValue());
         //      System.out.println(zawartosc.opis);
               opis.setText(zawartosc.opis);
               zawartoscRozdzialu.setText(zawartosc.tresc);
               czytajRozdzial("C:\\Users\\DELL\\Documents\\Forrest Gump\\" + zawartosc.podTytul + ".txt");
               //IntroductionR.txt");
            }
         }
      });
      
      JSplitPane wygladG = new JSplitPane(JSplitPane.VERTICAL_SPLIT,panelMenu,panelGorny);
      JSplitPane wygladLS = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panelLewy,panelSrodek);
      JSplitPane wygladS = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,wygladLS,panelPrawy);
      JSplitPane wygladD = new JSplitPane(JSplitPane.VERTICAL_SPLIT,wygladS,panelDolny);
      JSplitPane wyglad = new JSplitPane(JSplitPane.VERTICAL_SPLIT,wygladG,wygladD);
      
       
      
      this.getContentPane().add(wyglad);
    //    Font tenFont = zawartoscRozdzialu.getFont();
    //    zawartoscRozdzialu.setFont(new Font(tenFont.getName(),Font.ITALIC,16));
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   }
    
   private class Tresc{
      String podTytul, tresc, opis;
      public Tresc (String podTytul, String tresc, String opis) {
         this.podTytul =podTytul;
         this.tresc =tresc;
         this.opis =opis;
      }
      public String toString() {
         return podTytul;
      }
      public String getTresc() {
         return tresc;
      }
      public String getOpis() {
         return opis;
      }
   }
   
   static void wypiszSciezki(File nazwaSciezki) {
      String[] wszystkiePliki = nazwaSciezki.list();
      //System.out.println(nazwaSciezki.getPath());
      for (int i = 0; i < wszystkiePliki.length; i++) {
         File tmp = new File(nazwaSciezki.getPath(), wszystkiePliki[i]);
         //System.out.println(tmp.getPath());
         opis.setText(opis.getText()+wszystkiePliki[i]+"\n\r");
      }
   } 
   
   static void czytajRozdzial(String rozdzial){
      try {
         BufferedReader tmp = new BufferedReader(new FileReader(rozdzial));
         String tmpTresc = "";
         zawartoscRozdzialu.setText("");
         while ((tmpTresc = tmp.readLine()) != null){
            if (tmpTresc.length() == 0) tmpTresc = "\n\r";
            zawartoscRozdzialu.setText(zawartoscRozdzialu.getText()+ tmpTresc);
         }
         tmp.close();
      } catch (IOException ex) {
         System.out.println(ex.getMessage());
      }
   }
  
   
   public static void main(String[] args) {
       czytajRozdzial("C:\\Users\\DELL\\Documents\\Forrest Gump\\Spis treści.txt");
      
      new PodzialPanelu().setVisible(true);
      String znak = File.separator;  
      try {
         
         File plik = new File("C:"+znak+"Users"+znak+"DELL"+znak+"Documents"+znak+"Forrest Gump"+znak+"IntroductionR.txt");
         File folder = new File("C:"+znak+"Users"+znak+"DELL"+znak+"Documents"+znak+"Forrest Gump"+znak);
         
         if (!plik.exists())
            plik.createNewFile();
         else {
           // System.out.println("jest OK, plik istnieje");
            Date modyfikacja = new Date(plik.lastModified());
            menu.setText(modyfikacja.toString()+" ||   Ilość znaków: "+plik.length());
            menu.setText(menu.getText()+" ||  ścieżka do pliku: "+plik.getPath());

            wypiszSciezki(folder);
         }
      } catch (IOException ex) {
         System.out.println(ex.getMessage());
      }

   }
    
}