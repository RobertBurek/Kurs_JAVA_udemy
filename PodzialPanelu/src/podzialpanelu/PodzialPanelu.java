/*
 * Napisane 02.2019  
 */
package podzialpanelu;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.*;

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
      new Tresc("Wstęp", "Treść - wstepu", "Krótki opis wstępu"),
      new Tresc("Rozdział I", "Treść - zawartość Rozdział I", "Krótki opis rozdziału 1"), 
      new Tresc("Rozdział II", "Treść - zawartość Rozdział II", "Krótki opis rozdziału 2"), 
      new Tresc("Rozdział III", "Treść - zawartość Rozdział III", "Krótki opis rozdziału 3"), 
      new Tresc("Rozdział IV", "Treść - zawartość Rozdział IV", "Krótki opis rozdziału 4")});
   JLabel tytul = new JLabel();
   JLabel opis = new JLabel();
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
      tytul.setText("Forrest Gump");
      tytul.setForeground(Color.WHITE);
      panelGorny.add(tytul);
      panelDolny.add(opis);
      panelLewy.add(spisTresci);
      panelPrawy.add(utwory);
      
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
   }
    
}