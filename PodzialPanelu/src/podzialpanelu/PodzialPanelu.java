/*
 * Napisane 02.2019  
 */
package podzialpanelu;

import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.io.*;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyleConstants;

/**
 *
 * @author Robert Burek
 */
public final class PodzialPanelu extends JFrame {


 
   public PodzialPanelu() {
         
         initComponents();
         int szer = Toolkit.getDefaultToolkit().getScreenSize().width;
         int wys = Toolkit.getDefaultToolkit().getScreenSize().height;
         int szerR = this.getSize().width;
         int wysR = this.getSize().height;

      

         this.setLocation((szer-szerR)/2,(wys-wysR)/2);

   }
   
   Boolean widac;
   JPanel panelMenu = new JPanel();
   JPanel panelGorny = new JPanel();
   JPanel panelLewy = new JPanel();
   JPanel panelPrawy = new JPanel();
   JPanel panelSrodek = new JPanel();
   JPanel panelDolny = new JPanel();
   JList spisTresci = new JList(new Tresc[] {
      new Tresc("Introduction", "Wprowadzenie", "Krótki opis wprowadzenia"),
      new Tresc("Spis treści", "Treść - spisu treści", "Krótki opis spisu treści"),
      new Tresc("Chapter 1", "Część 1", "Krótki opis rozdziału 1"), 
      new Tresc("Chapter 2", "Część 2", "Krótki opis rozdziału 2"), 
      new Tresc("Chapter 3", "Część 3", "Krótki opis rozdziału 3"), 
      new Tresc("Chapter 4", "Część 4", "Krótki opis rozdziału 4"), 
      new Tresc("Rozdział 5", "Część 5", "Krótki opis rozdziału 5"), 
      new Tresc("Rozdział 6", "Część 6", "Krótki opis rozdziału 6"), 
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
   public static JScrollPane scrollPaneSrodek = new JScrollPane (zawartoscRozdzialu,
                     JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                     JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
   JButton zapiszSlowka = new JButton("ZAPISZ Słówka");
   JButton zapiszZdania = new JButton("ZAPISZ Zdania");
   JButton pokaz = new JButton("POKAZ");
   JButton ukryjPokaz = new JButton("Ukryj/Pokaż");
   Tresc wyborListy;
   JMenuBar menuBar = new JMenuBar();
   JMenu plik = new JMenu("Plik");
   JMenu edycja = new JMenu("Edycja");
   JMenu pomoc = new JMenu("Pomoc");
   JTextArea dymek = new JTextArea();
  // JTextField dymekNew = new JTextField("Dyyyymmmeeekk",20);
   JTextArea oknoPOL = new JTextArea();
   JTextArea oknoANG = new JTextArea();
   public JScrollPane polPane = new JScrollPane (oknoPOL);
   public JScrollPane angPane = new JScrollPane (oknoANG);
   JCheckBox slowka = new JCheckBox("Słówka");
   JCheckBox zdania = new JCheckBox("Zdania");
   JCheckBox porownaj = new JCheckBox("Porównaj");
   static String[] slowaPolskie= new String[150000];
   
   
    
   public void initComponents() {
      this.setSize(1300, 800);
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
      wygladD.setDividerLocation(540);
      Dimension minimumSize = new Dimension(this.getWidth()-200, this.getHeight()-200);

      panelSrodek.setSize(minimumSize);
      panelPrawy.setMaximumSize(new Dimension(200,0));

         wygladLS.setDividerLocation(100);
            wygladS.setDividerLocation(1150);
 
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

      zawartoscRozdzialu.setLineWrap(true);
      zawartoscRozdzialu.setEditable(false);
      

      angPane.setBounds(100, 50, 500, 700);
      polPane.setBounds(605, 50, 500, 700);
      
      add(angPane).setVisible(false);
      add(polPane).setVisible(false);
      widac=false;

      tytul.setText("Forrest Gump");
      tytul.setForeground(Color.WHITE);
      panelMenu.add(menu);
      menu.setText(" ");
      panelGorny.add(tytul);
      panelDolny.add(opis);
      panelLewy.add(spisTresci);

      zawartoscRozdzialu.setRows(20);
      zawartoscRozdzialu.setColumns(55);
      Font tenFont = zawartoscRozdzialu.getFont();

      zawartoscRozdzialu.setFont(new Font(tenFont.getName(),Font.PLAIN,20));
      
      JScrollPane scrollPaneTmp = new JScrollPane (zawartoscRozdzialu);
      scrollPaneTmp.setBounds(112, 78, 940, 535);

      panelSrodek.add(scrollPaneTmp);
      panelPrawy.add(utwory);
      panelPrawy.add(zapiszSlowka);
      panelPrawy.add(zapiszZdania);
      panelPrawy.add(pokaz);
      panelPrawy.add(ukryjPokaz);
      dymek.setFont(new Font(dymek.getFont().getFamily(),Font.ROMAN_BASELINE,20));
      dymek.setForeground(Color.WHITE);

      dymek.setVisible(false);
      
      zawartoscRozdzialu.addMouseListener(new MouseListener() {
         @Override
         public void mouseClicked(MouseEvent e) {
         }
         @Override
         public void mousePressed(MouseEvent e) {

            int pozycjaSlowa = zawartoscRozdzialu.getCaretPosition();
            int pX = e.getX();
            int pY = e.getY();
            if (pY<=25) pY=27; else
            if ((25<pY)&(pY<51)) pY=53; else pY=e.getY()-50;
            if (pX>zawartoscRozdzialu.getWidth()-100) pX=zawartoscRozdzialu.getWidth()-100;
            if (e.getButton() == MouseEvent.BUTTON1) {
               try {
                  int poczTekstu=zawartoscRozdzialu.getCaretPosition();
                  int konTekstu=zawartoscRozdzialu.getCaretPosition();
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

                     }
                  zawartoscRozdzialu.select(poczTekstu,konTekstu);
                  

               } catch (BadLocationException ex) {
                  System.out.println(ex);
               }

               dymek.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
               dymek.setBackground(Color.black);
               dymek.setText(slowaPolskie[pozycjaSlowa]);
    FontMetrics metrics = dymek.getFontMetrics(dymek.getFont());
    Rectangle2D bounds = metrics.getStringBounds(dymek.getText(), null); 
    int widthInPixels = (int) bounds.getWidth(); 
               
               if (zawartoscRozdzialu.getSelectedText()!=null) {
                  
                 dymek.setVisible(true);

               if (widthInPixels<4) widthInPixels=-8;
               dymek.setBounds(pX,pY, widthInPixels+8, 33);
               }
            }
         }
         @Override
         public void mouseReleased(MouseEvent e) {
            dymek.setVisible(false);
            String calyTekst;
              if (zawartoscRozdzialu.getSelectedText()!=null) {
              calyTekst=zawartoscRozdzialu.getSelectedText();
            if (calyTekst.contains(" ")) {
               try {
                  int poczTekstu=zawartoscRozdzialu.getSelectionStart();
                  System.out.println(zawartoscRozdzialu.getSelectionStart());
                  int konTekstu=zawartoscRozdzialu.getSelectionStart();
                  String znakTekstu=zawartoscRozdzialu.getText(poczTekstu-1,2);
                     while (!znakTekstu.equals(". ")) {
                     poczTekstu=poczTekstu-1;
                     znakTekstu = zawartoscRozdzialu.getText(poczTekstu-1,2);
                     if (znakTekstu.equals("  ")) break;
                     if (znakTekstu.equals("! ")) break;
                     if (znakTekstu.equals("? ")) break;
                     }
                     poczTekstu=poczTekstu+1;
                     znakTekstu=zawartoscRozdzialu.getText(konTekstu,2);
                     while (!znakTekstu.equals(". ")) {
                        System.out.println(konTekstu+" - "+znakTekstu);
                     konTekstu=konTekstu+1;
                     znakTekstu = zawartoscRozdzialu.getText(konTekstu,2);
                     if (znakTekstu.equals("  ")) {
                        konTekstu=konTekstu-3;
                        break;
                     }
                     if (znakTekstu.equals("! ")) {
                        konTekstu=konTekstu;
                        break;
                     }
                     if (znakTekstu.equals("? ")) {
                        konTekstu=konTekstu;
                        break;
                     }
                     }
                     konTekstu=konTekstu+1;
                  zawartoscRozdzialu.select(poczTekstu,konTekstu);
                  System.out.println(poczTekstu+" - "+konTekstu);
                  System.out.println(zawartoscRozdzialu.getSelectedText());
                  //  System.out.println(zawartoscRozdzialu.getCaret());
               } catch (BadLocationException ex) {
                  System.out.println(ex);
               }
            }
           else zawartoscRozdzialu.select(zawartoscRozdzialu.getCaretPosition(),0);
         }}
         @Override
         public void mouseEntered(MouseEvent e) {
         }
         @Override
         public void mouseExited(MouseEvent e) {
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
          //  System.out.println("2 akcja");
         }
         @Override
         public void ancestorMoved(AncestorEvent event) {
          //  System.out.println("3 akcja");
         }
      });
      
      pokaz.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
         }
      });
      
      ukryjPokaz.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
          if (widac) {
             polPane.setVisible(false); 
             angPane.setVisible(false); 
             widac=false;
          }
             else {
             polPane.setVisible(true);
             angPane.setVisible(true);
             widac=true;
          }
         }
      });

      
      panelPrawy.setLayout(new GridLayout(10, 1));
      
      //dymekNew.setVisible(false);
      
      zawartoscRozdzialu.add(dymek);
     // zawartoscRozdzialu.add(dymekNew);
      slowka.setSelected(false);
      zdania.setSelected(true);
      porownaj.setSelected(false);
      panelPrawy.add(slowka);
      panelPrawy.add(zdania);
      panelPrawy.add(porownaj);
      
      
      zapiszSlowka.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            zapiszPlik("C:\\Users\\DELL\\Documents\\Forrest Gump\\" + wyborListy.tytulAN + "_slowka.txt", oknoANG, oknoPOL);
         }
      });
      
      zapiszZdania.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            zapiszPlik("C:\\Users\\DELL\\Documents\\Forrest Gump\\" + wyborListy.tytulPL + "_zdania.txt",oknoANG, oknoPOL);
         }
      });
      
      spisTresci.addListSelectionListener((ListSelectionEvent e) -> {
         if (!e.getValueIsAdjusting()){
            wyborListy=(Tresc)((JList)e.getSource()).getSelectedValue();
            czytajRozdzial("C:\\Users\\DELL\\Documents\\Forrest Gump\\" + wyborListy.tytulAN + ".txt");
            wczytajSlowka("C:\\Users\\DELL\\Documents\\Forrest Gump\\" + wyborListy.tytulAN + "_slowka.txt");
            if (slowka.isSelected()) {
               wyborListy=(Tresc)((JList)e.getSource()).getSelectedValue();
               listaPomocniczaSlowek("C:\\Users\\DELL\\Documents\\Forrest Gump\\" + wyborListy.tytulAN + ".txt",oknoANG);
              // czytajPlikSlowka("C:\\Users\\DELL\\Documents\\Forrest Gump\\" + wyborListy.tytulAN + "_S.txt",oknoPOL);
            } else {
               czytajPlik("C:\\Users\\DELL\\Documents\\Forrest Gump\\" + wyborListy.tytulAN + ".txt",oknoANG);
               czytajPlik("C:\\Users\\DELL\\Documents\\Forrest Gump\\" + wyborListy.tytulPL + ".txt",oknoPOL);
            }
         }
      });
     
      this.getContentPane().add(wyglad);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   }

    
   private class Tresc{
      String tytulAN, tytulPL, opis;
      public Tresc (String podTytul, String tresc, String opis) {
         this.tytulAN =podTytul;
         this.tytulPL =tresc;
         this.opis =opis;
      }
      public String toString() {
         return tytulAN;
      }
      public String getTresc() {
         return tytulPL;
      }
      public String getOpis() {
         return opis;
      }
   }
   
   //niepotrzebna już jest
      private static String zamienNaSlowa(String linia) {
         linia= linia.replace(" ", "\n");
          System.out.println(linia);
            return linia;

   }
 
   //na razie nie jest potrzebna
   static void wypiszSciezki(File nazwaSciezki) {
       String[] wszystkiePliki = nazwaSciezki.list();
      for (int i = 0; i < wszystkiePliki.length; i++) {
         File tmp = new File(nazwaSciezki.getPath(), wszystkiePliki[i]);
         opis.setText(opis.getText()+wszystkiePliki[i]+"\n");
      }
   } 
   
   static void zapiszPlik(String rozdzial, JTextArea oknoA, JTextArea oknoP){
      try {
         try (BufferedWriter tmpOut = new BufferedWriter(new FileWriter(rozdzial))) {
            Scanner scanerA = new Scanner(oknoA.getText());
            Scanner scanerP = new Scanner(oknoP.getText());
            while (scanerA.hasNext()){
               //   if (scanerA.nextLine()==null) System.out.println("było");
               //  if (scanerP.nextLine()==null) tmp.write(" | \n");
               //  else tmp.write(" |"+scanerP.nextLine()+"\n");
               //    } //else
               //    if (scanerP.nextLine()==null) scanerP.nextLine().concat(scanerA.nextLine());
               //  if (scanerP.nextLine()==null) tmp.write(" | \n");
               tmpOut.write(scanerA.nextLine()+" | "+scanerP.nextLine()+"\n");
            }
            tmpOut.close();
         }
      } catch (IOException ex) {
         System.out.println(ex.getMessage());
      } finally {
      //   tmpOut.close(); 
      } 
   }
   
   static void listaPomocniczaSlowek(String sciezkaPomSlowka, JTextArea oknoA){
      try {
         JTextArea tmpArea;
         try (BufferedReader tmpPomSlowka = new BufferedReader(new FileReader(sciezkaPomSlowka))) {
            tmpArea = new JTextArea();
            String tmpTresc;
         //   System.out.println(tmpPomSlowka.readLine());
            while ((tmpTresc = tmpPomSlowka.readLine()) != null){
               if (tmpTresc.length() == 0) tmpTresc = " ";
               tmpArea.setText(tmpArea.getText()+ tmpTresc.replace(" ", "\n"));
            }
            tmpPomSlowka.close();  
         }
            oknoA.setText(tmpArea.getText());
         oknoA.select(0, 0);
      } catch (IOException ex) {
         System.out.println(ex.getMessage());
      }  finally {
      }
   }
   
   static void wczytajSlowka(String sciezkaSlowka){
      try {
         try (BufferedReader tmpInSlowka = new BufferedReader(new FileReader(sciezkaSlowka))) {
            String tmpLinia;
            String slowoA;
            String slowoP;
            int i=0;
            int j;
            while ((tmpLinia = tmpInSlowka.readLine()) != null){
               StringTokenizer token = new StringTokenizer(tmpLinia, "|");
             
               while (token.countTokens()>0) {
                  slowoA=token.nextToken();
                  slowoP=token.nextToken().trim();
                  slowaPolskie[i]=slowoP;
                  System.out.println(i+"! "+slowoP);
                  if (!slowoA.equals(" ")) {
                     for (j=1;j<slowoA.length(); j++){
                       slowaPolskie[i+j]=slowoP;
                       System.out.println((i+j)+"|"+j+"| "+slowoP);
                     }
                     i=(i+j)-1;
                  }
                  i++;
               }
            }
            tmpInSlowka.close();
         }
      } catch (IOException ex) {
         System.out.println(ex.getMessage());
      } finally {
      //   tmpInpSlowka.close();
      }
   }
  
   
   static void czytajPlik(String rozdzial, JTextArea okno){
      try {
         BufferedReader tmp = new BufferedReader(new FileReader(rozdzial));
         String tmpTresc = "";
         okno.setText("");
         while ((tmpTresc = tmp.readLine()) != null){
            if (tmpTresc.length() == 0) tmpTresc = "";
            okno.setText(okno.getText()+ tmpTresc+"\n");
         }
       //  System.out.println(angPane.getVerticalScrollBar().getValue());
       //  System.out.println(angPane.getHorizontalScrollBar().getValue());

         tmp.close();
         okno.select(PROPERTIES, PROPERTIES);
         //okno.select(20, 40);
      } catch (IOException ex) {
         System.out.println(ex.getMessage());
      } finally {
      //   tmp.close();
      }
   }

   static void czytajRozdzial(String rozdzial){
      try {
         BufferedReader czytajRozdzial = new BufferedReader(new FileReader(rozdzial));
         String tmpTresc = "";
         zawartoscRozdzialu.setText("");
         while ((tmpTresc = czytajRozdzial.readLine()) != null){
            if (tmpTresc.length() == 0) tmpTresc = "\n";
            zawartoscRozdzialu.setText(zawartoscRozdzialu.getText()+ tmpTresc);
         }
         
         czytajRozdzial.close();
         zawartoscRozdzialu.select(0, 0);
      } catch (IOException ex) {
         System.out.println(ex.getMessage());
      }  finally {
      //   czytajRozdzial.close();
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