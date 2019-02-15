/*
 * Napisane 02.2019  
 */
package podzialpanelu;

import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.*;
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
   
   Boolean widac;
   JPanel panelMenu = new JPanel();
   JPanel panelGorny = new JPanel();
   JPanel panelLewy = new JPanel();
   JPanel panelPrawy = new JPanel();
   JPanel panelSrodek = new JPanel();
   JPanel panelDolny = new JPanel();
   JList spisTresci = new JList(new Tresc[] {
      new Tresc("IntroductionR", "Treść - wprowadzenia", "Krótki opis wprowadzenia"),
      new Tresc("Spis treści", "Treść - spisu treści", "Krótki opis spisu treści"),
      new Tresc("Chapter 1", "Część 1", "Krótki opis rozdziału 1"), 
      new Tresc("Chapter 2", "Część 2", "Krótki opis rozdziału 2"), 
      new Tresc("Chapter 3", "Część 3", "Krótki opis rozdziału 3"), 
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
   JTextArea dymek = new JTextArea("Dyyyymmmeeekk");
   JTextArea oknoPOL = new JTextArea();
   JTextArea oknoANG = new JTextArea();
   public JScrollPane polPane = new JScrollPane (oknoPOL);
   public JScrollPane angPane = new JScrollPane (oknoANG);
   JCheckBox slowka = new JCheckBox("Słówka");
   JCheckBox inny = new JCheckBox("Inny");
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
            wygladS.setDividerLocation(1150);
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
      zawartoscRozdzialu.setEditable(false);
      
      //oknoPOL.czytajPlik(Buffered plik);
      //oknoANG.czytajPlik(Buffered plik);
      angPane.setBounds(100, 50, 500, 700);
      polPane.setBounds(605, 50, 500, 700);
      
      add(angPane).setVisible(false);
      add(polPane).setVisible(false);
      widac=false;
      
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
      panelPrawy.add(zapiszSlowka);
      panelPrawy.add(zapiszZdania);
      panelPrawy.add(pokaz);
      panelPrawy.add(ukryjPokaz);
      
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
           // System.out.println("nacisniety-trzymany");
           // System.out.println(zawartoscRozdzialu.getCaretPosition());
            int pozycjausun = zawartoscRozdzialu.getCaretPosition();
            int pX = e.getX();
            int pY = e.getY();
            if (pY<=25) pY=27; else
            if ((25<pY)&(pY<51)) pY=53; else pY=e.getY()-50;
            if (pX>zawartoscRozdzialu.getWidth()-100) pX=zawartoscRozdzialu.getWidth()-100;
            if (e.getButton() == MouseEvent.BUTTON1) {
               try {
                  int poczTekstu=zawartoscRozdzialu.getCaretPosition();
                  int konTekstu=zawartoscRozdzialu.getCaretPosition();
               //   System.out.println(poczTekstu+" - "+konTekstu);
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
                  
                  //System.out.println(poczTekstu+" - "+konTekstu);
                  //System.out.println(zawartoscRozdzialu.getSelectedText());
                  //  System.out.println(zawartoscRozdzialu.getCaret());
               } catch (BadLocationException ex) {
                  System.out.println(ex);
               }
              // zawartoscRozdzialu.add(dymek);
               //kom(zawartoscRozdzialu.getSelectedText().length());
               //dymek.setVisible(true);
               //dymek.setLineWrap(true);
               dymek.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
               
               dymek.setBackground(Color.black);
               dymek.setLocation(pX, pY);
               dymek.setText(pozycjausun+slowaPolskie[pozycjausun]);
               if (zawartoscRozdzialu.getSelectedText()!=null) {
                  
              //    System.out.println(zawartoscRozdzialu.getSelectedText().length()); 
             //     System.out.println(zawartoscRozdzialu.getSelectedText().length()); 
                 
            //   if (zawartoscRozdzialu.getSelectedText().equals(" ")) dymek.setVisible(false); else 
                  dymek.setVisible(true);
               double dlugosc;
               int dl;
               dlugosc = zawartoscRozdzialu.getSelectedText().length();
               if (dlugosc==0) dl=0;
               else if(dlugosc==1) dl=26;
                else if(dlugosc==2) dl=40; 
                   else if(dlugosc==3) dl=50; 
                      else if(dlugosc==4) dl=60; else dl=zawartoscRozdzialu.getSelectedText().length()*12;
                
               dymek.setBounds(pX,pY, dl, 35);
              // zawartoscRozdzialu.setAlignmentX(CENTER_ALIGNMENT);
               }
               //dymek.getText();
               //dymek.setColumns(zawartoscRozdzialu.getSelectedText().length());
               //dymek.setRows(3);
               //dymek.setPreferredSize(null);
               //dymek.setLineWrap(true);
               //dymek.setWrapStyleWord(true);
              // System.out.println(zawartoscRozdzialu.getSelectedText().length());
               //dymek.requestFocus();
            }
          //  System.out.println(zawartoscRozdzialu.getFocusListeners());
            //System.out.println("trzymam");
           // System.out.println(zawartoscRozdzialu.getSelectedText());
            //i=0;
         }

         @Override
         public void mouseReleased(MouseEvent e) {
            
            dymek.setVisible(false);
            String calyTekst;
              if (zawartoscRozdzialu.getSelectedText()!=null) {
              calyTekst=zawartoscRozdzialu.getSelectedText();
          //  System.out.println(zawartoscRozdzialu.getSelectedText());
            //zawartoscRozdzialu.setToolTipText("zfggggfgdg");
            if (calyTekst.contains(" ")) {
               //System.out.println(zawartoscRozdzialu.getSelectedText());
               try {
                  int poczTekstu=zawartoscRozdzialu.getSelectionStart();
                  System.out.println(zawartoscRozdzialu.getSelectionStart());
                          //.getCaretPosition();
               //   int konTekstu=zawartoscRozdzialu.getCaretPosition();
                  int konTekstu=zawartoscRozdzialu.getSelectionStart();
                  //.getSelectedText().indexOf(calyTekst);
                  //System.out.println(poczTekstu+" - "+konTekstu);
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
                   //  System.out.println(konTekstu+" - "+znakTekstu);
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
            
         //   System.out.println("puszczony");
         //   System.out.println("nie wiem");
          //  if (zawartoscRozdzialu.getSelectedText() != null)
          //     System.out.println(zawartoscRozdzialu.getSelectedText());
         }}

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
      dymek.setFont(new Font(dymek.getFont().getFamily(),Font.ROMAN_BASELINE,20));
      dymek.setForeground(Color.WHITE);
      //dymek.setBackground(Color.black);
      dymek.setVisible(false);
      //dymek.setBounds(200, 100, 200, 200);
      
      
      zawartoscRozdzialu.add(dymek);
      
      panelPrawy.add(slowka);
      panelPrawy.add(inny);
      
      
      zapiszSlowka.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {
            //zawartosc=(Tresc)((JList)e.getSource()).getSelectedValue();
            System.out.println(wyborListy.tytulAN+"_new.txt");
            zapiszPlik("C:\\Users\\DELL\\Documents\\Forrest Gump\\" + wyborListy.tytulAN + "_slowka.txt", oknoANG, oknoPOL);
         }
      });
      zapiszZdania.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {
            //zawartosc=(Tresc)((JList)e.getSource()).getSelectedValue();
            System.out.println(wyborListy.tytulPL+"_new.txt");
            zapiszPlik("C:\\Users\\DELL\\Documents\\Forrest Gump\\" + wyborListy.tytulPL + "_zdania.txt",oknoANG, oknoPOL);
         }
      });
      
      spisTresci.addListSelectionListener((ListSelectionEvent e) -> {
         if (!e.getValueIsAdjusting()){
            wyborListy=(Tresc)((JList)e.getSource()).getSelectedValue();
            //     System.out.println(((JList)e.getSource()).getSelectedValue());
            //      System.out.println(zawartosc.opis);
            //opis.setText(wyborListy.opis);
            //zawartoscRozdzialu.setText(wyborListy.tresc);
            czytajRozdzial("C:\\Users\\DELL\\Documents\\Forrest Gump\\" + wyborListy.tytulAN + ".txt");
            czytajSlowka("C:\\Users\\DELL\\Documents\\Forrest Gump\\" + wyborListy.tytulAN + "_slowka.txt");
            
            if (slowka.isSelected()) {
               czytajPlikSlowka("C:\\Users\\DELL\\Documents\\Forrest Gump\\" + wyborListy.tytulAN + ".txt",oknoANG,oknoPOL);
              // czytajPlikSlowka("C:\\Users\\DELL\\Documents\\Forrest Gump\\" + wyborListy.tytulAN + "_S.txt",oknoPOL);
            } else {
               czytajPlik("C:\\Users\\DELL\\Documents\\Forrest Gump\\" + wyborListy.tytulAN + ".txt",oknoANG);
               czytajPlik("C:\\Users\\DELL\\Documents\\Forrest Gump\\" + wyborListy.tytulPL + ".txt",oknoPOL);
            }
            
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
   
   static void wypiszSciezki(File nazwaSciezki) {
      String[] wszystkiePliki = nazwaSciezki.list();
      //System.out.println(nazwaSciezki.getPath());
      for (int i = 0; i < wszystkiePliki.length; i++) {
         File tmp = new File(nazwaSciezki.getPath(), wszystkiePliki[i]);
         //System.out.println(tmp.getPath());
         opis.setText(opis.getText()+wszystkiePliki[i]+"\n");
      }
   } 
   
   static void zapiszPlik(String rozdzial, JTextArea oknoA, JTextArea oknoP){
      try {
         BufferedWriter tmp = new BufferedWriter(new FileWriter(rozdzial));
         Scanner scanerA = new Scanner(oknoA.getText());
         Scanner scanerP = new Scanner(oknoP.getText());
         while (scanerA.hasNext()){
           // if (scaner.nextLine()==null) tmp.write("");
            tmp.write(scanerA.nextLine()+"|"+scanerP.nextLine()+"\n");
         }
         tmp.close();
      } catch (IOException ex) {
         System.out.println(ex.getMessage());
      } finally {
      //   tmp.close(); 
      } 
   }
   
   static void czytajPlikSlowka(String rozdzial, JTextArea oknoA, JTextArea oknoP){
      try {
         BufferedReader tmp = new BufferedReader(new FileReader(rozdzial));
         JTextArea tmpArea = new JTextArea();
         String tmpTresc = "";
         String slowo = "";
         tmpArea.setText("");
         oknoA.setText("");
         oknoP.setText("");
         while ((tmpTresc = tmp.readLine()) != null){
            if (tmpTresc.length() == 0) tmpTresc = "\n";
            tmpArea.setText(tmpArea.getText()+ tmpTresc);
         }
         
         tmp.close();
         int j=0;
         //zawartoscRozdzialu.select(0, 0);
         for (int i=0; i<=tmpArea.getText().length(); i++){
            if (!(tmpArea.getText(i,1)).equals(" ")){
               if (!(tmpArea.getText(i,1)).equals("\n")){
               j++;
               slowo = slowo+tmpArea.getText(i,1);
               }
            }
            
           if ((tmpArea.getText(i,1)).equals(" ")) {
           //   if ((tmpArea.getText(i,1)).equals("\n ")) okno.setText(okno.getText()+(i-j)+"|"+j+"|"+slowo+" "); else
              oknoA.setText(oknoA.getText()+(i-j)+"|"+j+"|"+slowo+"\n");
              oknoP.setText(oknoP.getText()+slowo+"\n");
              
              slowo="";
              j=0;
           }
           oknoA.select(0, 0);
           oknoP.select(0, 0);
//           tmpTresc="\n";
//            slowo = slowo+tmpArea; poczatekSlowa=i;
//            okno.setText(tmpTresc);tmpArea.getText(i,1));
         }
      } catch (IOException ex) {
         System.out.println(ex.getMessage());
      } catch (BadLocationException ex) {
         Logger.getLogger(PodzialPanelu.class.getName()).log(Level.SEVERE, null, ex);
      } finally {
      //   tmp.close();
      }
   }
   
   static void czytajSlowka(String rozdzial){
      try {
         BufferedReader tmp = new BufferedReader(new FileReader(rozdzial));
         String tmpLinia = "";
         String slowoA = "";
         String slowoP = "";
         //String[] slowaPolskie= new String[5000];
         //okno.setText("");
         int nrPoczatek=0;
         int ileZnakow=0;
         int i=0;
         int j=0;
         //StringTokenizer slowo = new StringTokenizer(tmpLinia, "|");
         String dl = tmp.readLine();
         System.out.println(dl);
         while ((tmpLinia = tmp.readLine()) != null){
            System.out.print(i+"-->");
            StringTokenizer token = new StringTokenizer(tmpLinia, "|");
            System.out.print(tmpLinia+"-->");
            while (token.countTokens()>0) {
               
              // System.out.print(token.nextToken());
            nrPoczatek=Integer.parseInt(token.nextToken());
            System.out.print(nrPoczatek);
            ileZnakow=Integer.parseInt(token.nextToken());
            System.out.print("|"+ileZnakow);
            slowoA=token.nextToken();
            System.out.print("|"+slowoA);
            slowoP=token.nextToken();
            System.out.print("|"+slowoP);
            // System.out.print(ileZnakow+" "+slowoA+" " +slowoP);
            
            for (j=0;j<ileZnakow; j++){
               //System.out.println(j);
            slowaPolskie[i+j]=slowoP;
               System.out.println("-->"+(i+j)+"| "+slowoP);
            }
            i=(i+j);
            //System.out.println("-->"+(i)+"|  ");
            //i++;
            //i++;
            }
         }
       //  System.out.println(angPane.getVerticalScrollBar().getValue());
       //  System.out.println(angPane.getHorizontalScrollBar().getValue());

         tmp.close();
         //okno.select(0, 0);
      } catch (IOException ex) {
         System.out.println(ex.getMessage());
      } finally {
      //   tmp.close();
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
         //okno.select(20, 40);
      } catch (IOException ex) {
         System.out.println(ex.getMessage());
      } finally {
      //   tmp.close();
      }
   }

   static void czytajRozdzial(String rozdzial){
      try {
         BufferedReader tmp = new BufferedReader(new FileReader(rozdzial));
         String tmpTresc = "";
         zawartoscRozdzialu.setText("");
         while ((tmpTresc = tmp.readLine()) != null){
            if (tmpTresc.length() == 0) tmpTresc = "\n";
            zawartoscRozdzialu.setText(zawartoscRozdzialu.getText()+ tmpTresc);
         }
         
         tmp.close();
         zawartoscRozdzialu.select(0, 0);
//         for (int i=0; i<=zawartoscRozdzialu.getText().length(); i++){
//            if ((zawartoscRozdzialu.getText(i,1)).equals(" ")) System.out.println("");
//         System.out.print(zawartoscRozdzialu.getText(i,1));
//         }
      } catch (IOException ex) {
         System.out.println(ex.getMessage());
      }  finally {
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