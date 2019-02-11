/*
 * Napisane 02.2019  
 */
package podzialpanelu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.*;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Robert Burek
 */
public final class PodzialPanelu extends JFrame {

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
   JButton pokaz = new JButton("POKAZ");
   Tresc wyborListy;
   JMenuBar menuBar = new JMenuBar();
   JMenu plik = new JMenu("Plik");
   JMenu edycja = new JMenu("Edycja");
   JMenu pomoc = new JMenu("Pomoc");
   JTextArea dymek = new JTextArea("Dyyyymmmeeekk");
    
   public void initComponents() {
      this.setSize(1200, 800);
      this.setTitle("Podział panelu"); 

      JSplitPane wygladG = new JSplitPane(JSplitPane.VERTICAL_SPLIT,panelMenu,panelGorny);
      JSplitPane wygladLS = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panelLewy,panelSrodek);
      JSplitPane wygladS = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,wygladLS,panelPrawy);
      JSplitPane wygladD = new JSplitPane(JSplitPane.VERTICAL_SPLIT,wygladS,panelDolny);
      JSplitPane wyglad = new JSplitPane(JSplitPane.VERTICAL_SPLIT,wygladG,wygladD);
      wygladG.setDividerSize(5);
      wygladLS.setDividerSize(1);
      wygladS.setDividerSize(5);
      wygladD.setDividerSize(1);
      wyglad.setDividerSize(5);
     // panelMenu.setMinimumSize(new Dimension(0,25));
    // wygladG.setSize(new Dimension(330,300));
    // wygladG.setSize(new Dimension(50,50));
      
      wygladD.setDividerLocation(540);
    //  System.out.println(panelGorny.getHeight()+" - "+panelGorny.getWidth());
      
      
     // panelMenu.setSize(new Dimension(200, 200));
      Dimension minimumSize = new Dimension(this.getWidth()-200, this.getHeight()-200);
    //  panelSrodek.setMinimumSize(minimumSize);
      panelSrodek.setSize(minimumSize);
      panelPrawy.setMaximumSize(new Dimension(200,0));
    //  pictureScrollPane.setMinimumSize (minimumSize);
              // wygladLS.setOneTouchExpandable (true);
         wygladLS.setDividerLocation(100);
            wygladS.setDividerLocation(1050);
     // wyglad.setDividerLocation(250);
    //    Font tenFont = zawartoscRozdzialu.getFont();
    //    zawartoscRozdzialu.setFont(new Font(tenFont.getName(),Font.ITALIC,16));
      panelMenu.setBackground(Color.red);
      menuBar.add(plik);
      menuBar.add(edycja);
      menuBar.add(pomoc);
      panelMenu.add(menuBar);

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
      zawartoscRozdzialu.setBackground(Color.green);
      //zawartoscRozdzialu.setAutoscrolls(true);
      zawartoscRozdzialu.setLineWrap(true);
      
      //zawartoscRozdzialu.add(dymek);
      //dymek.requestFocus();
      
      
      
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
     // Font nowyf=new Font(tenFont.getName(),Font.PLAIN,20);
      zawartoscRozdzialu.setFont(new Font(tenFont.getName(),Font.PLAIN,20));
      
      JScrollPane scrollPaneTmp = new JScrollPane (zawartoscRozdzialu);
      scrollPaneTmp.setBounds(112, 78, 940, 535);
     // scrollPaneTmp.setBounds(200, 178, 940, 535);
      //panelSrodek.add(scrollPaneSrodek);
      panelSrodek.add(scrollPaneTmp);
      panelPrawy.add(utwory);
      panelPrawy.add(zapisz);
      panelPrawy.add(pokaz);
      
      zawartoscRozdzialu.addMouseListener(new MouseListener() {
         int i=0;
         @Override
         public void mouseClicked(MouseEvent e) {
          //  System.out.println("clik");
            //System.out.println(i++);
            //System.out.println(e.getSource());
            //System.out.println(zawartoscRozdzialu.getSelectedText());
         }

         @Override
         public void mousePressed(MouseEvent e) {
            System.out.println("nacisniety-trzymany");
            System.out.println(zawartoscRozdzialu.getCaretPosition());
            int pX = e.getX();
            int pY = e.getY();
            if (e.getButton() == MouseEvent.BUTTON1) {
               try {
                  int poczTekstu=zawartoscRozdzialu.getCaretPosition();
                  int konTekstu=zawartoscRozdzialu.getCaretPosition();
                  System.out.println(poczTekstu+" - "+konTekstu);
                  String znakTekstu=zawartoscRozdzialu.getText(poczTekstu-1,1);
                     while (!znakTekstu.equals(" ")) {
                     poczTekstu=poczTekstu-1;
                     znakTekstu = zawartoscRozdzialu.getText(poczTekstu-1,1);
                   
                     }
                     znakTekstu=zawartoscRozdzialu.getText(konTekstu,1);
                     while (!znakTekstu.equals(" ")) {
                        System.out.println(konTekstu+" - "+znakTekstu);
                     konTekstu=konTekstu+1;
                     znakTekstu = zawartoscRozdzialu.getText(konTekstu,1);
                   //  System.out.println(konTekstu+" - "+znakTekstu);
                     }
                  zawartoscRozdzialu.select(poczTekstu,konTekstu);
                  System.out.println(poczTekstu+" - "+konTekstu);
                  System.out.println(zawartoscRozdzialu.getSelectedText());
                  //  System.out.println(zawartoscRozdzialu.getCaret());
               } catch (BadLocationException ex) {
                  System.out.println(ex);
               }
              // zawartoscRozdzialu.add(dymek);
               dymek.setVisible(true);
               //dymek.setLineWrap(true);
               dymek.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
               dymek.setText(zawartoscRozdzialu.getSelectedText());
               dymek.setBackground(Color.red);
               dymek.setLocation(pX, pY);
               dymek.setColumns(zawartoscRozdzialu.getSelectedText().length());
               dymek.setRows(1);
               //dymek.setLineWrap(true);
               System.out.println(zawartoscRozdzialu.getSelectedText().length());
            }
          //  System.out.println(zawartoscRozdzialu.getFocusListeners());
            //System.out.println("trzymam");
           // System.out.println(zawartoscRozdzialu.getSelectedText());
            //i=0;
         }

         @Override
         public void mouseReleased(MouseEvent e) {
            
            dymek.setVisible(false);
            String calyTekst =zawartoscRozdzialu.getSelectedText();
            System.out.println(zawartoscRozdzialu.getSelectedText());
            //zawartoscRozdzialu.setToolTipText("zfggggfgdg");
            if (calyTekst.contains(" ")) {
               //System.out.println(zawartoscRozdzialu.getSelectedText());
               try {
                  int poczTekstu=zawartoscRozdzialu.getSelectionStart();
                  System.out.println(zawartoscRozdzialu.getSelectionStart());
                          //.getCaretPosition();
               //   int konTekstu=zawartoscRozdzialu.getCaretPosition();
                  int konTekstu=zawartoscRozdzialu.getSelectionEnd();
                  //.getSelectedText().indexOf(calyTekst);
                  //System.out.println(poczTekstu+" - "+konTekstu);
                  String znakTekstu=zawartoscRozdzialu.getText(poczTekstu-1,1);
                     while (!znakTekstu.equals(".")) {
                     poczTekstu=poczTekstu-1;
                     znakTekstu = zawartoscRozdzialu.getText(poczTekstu-1,1);
                   
                     }
                     znakTekstu=zawartoscRozdzialu.getText(konTekstu,1);
                     while (!znakTekstu.equals(".")) {
                        System.out.println(konTekstu+" - "+znakTekstu);
                     konTekstu=konTekstu+1;
                     znakTekstu = zawartoscRozdzialu.getText(konTekstu,1);
                   //  System.out.println(konTekstu+" - "+znakTekstu);
                     }
                  zawartoscRozdzialu.select(poczTekstu,konTekstu);
                  System.out.println(poczTekstu+" - "+konTekstu);
                  System.out.println(zawartoscRozdzialu.getSelectedText());
                  //  System.out.println(zawartoscRozdzialu.getCaret());
               } catch (BadLocationException ex) {
                  System.out.println(ex);
               }
            }
           else zawartoscRozdzialu.select(zawartoscRozdzialu.getCaretPosition(),0);
            
         //   System.out.println("puszczony");
         //   System.out.println("nie wiem");
          //  if (zawartoscRozdzialu.getSelectedText() != null)
          //     System.out.println(zawartoscRozdzialu.getSelectedText());
         }

         @Override
         public void mouseEntered(MouseEvent e) {
         //   System.out.println("4");
         }

         @Override
         public void mouseExited(MouseEvent e) {
          //  System.out.println("5");
         }

      });
      zawartoscRozdzialu.addAncestorListener(new AncestorListener() {

         @Override
         public void ancestorAdded(AncestorEvent event) {
          //  System.out.println("1 akcja");
          //  System.out.println(event.getSource());
         }

         @Override
         public void ancestorRemoved(AncestorEvent event) {
            System.out.println("2 akcja");
         }

         @Override
         public void ancestorMoved(AncestorEvent event) {
          //  System.out.println("3 akcja");
         }
      });
      pokaz.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
          //  System.out.println(zawartoscRozdzialu.select(zawartoscRozdzialu.getText().indexOf("idiot"), zawartoscRozdzialu.getText().indexOf("idiot")));
           // int ttt = zawartoscRozdzialu.getText().indexOf("idiot");
         //   zawartoscRozdzialu.select(ttt, ttt+5);
            System.out.println(zawartoscRozdzialu.getSelectedText());
            System.out.println(zawartoscRozdzialu.getText().indexOf(zawartoscRozdzialu.getSelectedText()));
         //   System.out.println("robie to : "+ttt);
         //   zawartoscRozdzialu.requestFocus();
         }
      });

      
      panelPrawy.setLayout(new GridLayout(6, 1));
      dymek.setFont(new Font("Arial",Font.BOLD,20));
      dymek.setForeground(Color.WHITE);
      dymek.setBackground(Color.black);
      dymek.setVisible(false);
      dymek.setBounds(200, 100, 200, 200);
      add(dymek);
      
      
      zapisz.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {
            //zawartosc=(Tresc)((JList)e.getSource()).getSelectedValue();
            System.out.println(wyborListy.podTytul+"_new.txt");
            zapiszRozdzial("C:\\Users\\DELL\\Documents\\Forrest Gump\\" + wyborListy.podTytul + "_new.txt");
         }
      });
      spisTresci.addListSelectionListener((ListSelectionEvent e) -> {
         if (!e.getValueIsAdjusting()){
            wyborListy=(Tresc)((JList)e.getSource()).getSelectedValue();
            //     System.out.println(((JList)e.getSource()).getSelectedValue());
            //      System.out.println(zawartosc.opis);
            opis.setText(wyborListy.opis);
            zawartoscRozdzialu.setText(wyborListy.tresc);
            czytajRozdzial("C:\\Users\\DELL\\Documents\\Forrest Gump\\" + wyborListy.podTytul + ".txt");
           // zawartoscRozdzialu.select(zawartoscRozdzialu.getText().indexOf("idiot"),zawartoscRozdzialu.getText().indexOf("idiot")+"idiot".length());
            //System.out.println(zawartoscRozdzialu.getText());
         }
      });
     
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
      } finally {
      //   tmp.close();
      }
   }
  
   static void zapiszRozdzial(String rozdzial){
      try {
         BufferedWriter tmp = new BufferedWriter(new FileWriter(rozdzial));
         Scanner scaner = new Scanner(zawartoscRozdzialu.getText());
         while (scaner.hasNext()){
            tmp.write(scaner.nextLine()+"\n");
         }
         tmp.close();
      } catch (IOException ex) {
         System.out.println(ex.getMessage());
      } finally {
      //   tmp.close(); 
      } 
   }
   
   public static void main(String[] args) {
       czytajRozdzial("C:\\Users\\DELL\\Documents\\Forrest Gump\\Spis treści.txt");
     // zawartoscRozdzialu.select(1,3);
     // zawartoscRozdzialu.selectAll();
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