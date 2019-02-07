/*
 * Napisane 02.2019  
 */
package podzialpanelu;

import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.Date;
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
      new Tresc("Wprowadzenie", "Treść - wprowadzenia", "Krótki opis wprowadzenia"),
      new Tresc("Spis treści", "Treść - spisu treści", "Krótki opis spisu treści"),
      new Tresc("Chapter I", "Treść - zawartość Rozdział I", "Krótki opis rozdziału 1"), 
      new Tresc("Chapter II", "Treść - zawartość Rozdział II", "Krótki opis rozdziału 2"), 
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
   JLabel opis = new JLabel();
   JLabel zawartoscRozdzialu = new JLabel();
   JList utwory = new JList(new String[] {"Forrest Gump", "Alicja w krainie", "Strefa Zet"});
   
    
   public void initComponents() {
      this.setSize(1200, 800);
      this.setTitle("Podział panelu"); 
      panelMenu.setBackground(Color.red);
      panelGorny.setBackground(Color.blue);
      panelLewy.setBackground(Color.yellow);
      panelPrawy.setBackground(Color.black);
      panelSrodek.setBackground(Color.green);
      panelDolny.setBackground(Color.gray);
      spisTresci.setBackground(Color.yellow);
      spisTresci.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      zawartoscRozdzialu.setText("                                                                   "
              + "                                                                                    "
              + "                                                                                    "
              + "                                                                                    ");
      tytul.setText("Forrest Gump");
      tytul.setForeground(Color.WHITE);
      panelMenu.add(menu);
      menu.setText(" ");
      panelGorny.add(tytul);
      panelDolny.add(opis);
      panelLewy.add(spisTresci);
      panelSrodek.add(zawartoscRozdzialu);
      panelPrawy.add(utwory);
      spisTresci.addListSelectionListener(new ListSelectionListener() {

         @Override
         public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()){
               Tresc zawartosc=(Tresc)((JList)e.getSource()).getSelectedValue();
          //     System.out.println(((JList)e.getSource()).getSelectedValue());
         //      System.out.println(zawartosc.opis);
               opis.setText(zawartosc.opis);
               zawartoscRozdzialu.setText(zawartosc.tresc);
            }
         }
      });
      
      JSplitPane wygladG = new JSplitPane(JSplitPane.VERTICAL_SPLIT,panelMenu,panelGorny);
      JSplitPane wygladLS = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panelLewy,panelSrodek);
      JSplitPane wygladS = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,wygladLS,panelPrawy);
      JSplitPane wygladD = new JSplitPane(JSplitPane.VERTICAL_SPLIT,wygladS,panelDolny);
      JSplitPane wyglad = new JSplitPane(JSplitPane.VERTICAL_SPLIT,wygladG,wygladD);
      
       
      
      this.getContentPane().add(wyglad);
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
   
        
   public static void main(String[] args) {
      new PodzialPanelu().setVisible(true);

      try {
         File plik = new File("C:\\Users\\DELL\\Documents\\Forrest Gump\\IntroductionR.txt");
         
         if (!plik.exists())
            plik.createNewFile();
         else {
            System.out.println("jest OK, plik istnieje");
            Date modyfikacja = new Date(plik.lastModified());
            menu.setText(modyfikacja.toString()+" ilość znaków: "+plik.length());
         }
         

      } catch (IOException ex) {
         System.out.println(ex.getMessage());
      }

   }
    
}