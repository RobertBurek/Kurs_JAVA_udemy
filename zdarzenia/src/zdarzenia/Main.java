package zdarzenia;

import java.awt.Color;
import javax.swing.*;
//import java.awt.*;
import java.awt.event.*;
//import java.util.Calendar;
//import java.util.GregorianCalendar;


public class Main extends JFrame implements /*ActionListener,*/ WindowListener
{  
   
    public Main()
    {
      //  super("Zdarzenia i RadioPrzełączniki");
        this.setBounds(300, 300, 800, 200);
 
       
        initComponents();
        
     //   this.setDefaultCloseOperation(3);
    }
    
    public void initComponents()
    {
        
 //       this.setTitle("Znajdź i zamień");
//        panelEtykieta2.add(etykietaRadio);
// 
// /*    Zamieściliśmy to wszystko w metodzie "budujPrzyciskRadio"
//        JRadioButton przelacznikW1 = new JRadioButton("Wybór 1 - Mały");
//        JRadioButton przelacznikW2 = new JRadioButton("Wybór 2 - Średni");
//        JRadioButton przelacznikW3 = new JRadioButton("Wybór 3 - Duży");
//        
//        przelacznikW1.addActionListener(new ActionListener() 
//               {
//                  public void actionPerformed(ActionEvent e) 
//                  {
//                    etykietaRadio.setFont(new Font("Monospaced",Font.BOLD,15));
//                  }
//               });
//        przelacznikW2.addActionListener(new ActionListener() 
//               {
//                  public void actionPerformed(ActionEvent e) 
//                  {
//                    etykietaRadio.setFont(new Font("Monospaced",Font.BOLD,25));
//                  }
//               });
//             przelacznikW3.addActionListener(new ActionListener() 
//               {
//                  public void actionPerformed(ActionEvent e) 
//                  {
//                    etykietaRadio.setFont(new Font("Monospaced",Font.BOLD,35));
//                  }
//               });
//        grupaRadio.add(przelacznikW1);
//        grupaRadio.add(przelacznikW2);
//        grupaRadio.add(przelacznikW3);
//        
//        panelRadio1.add(przelacznikW1);
//        panelRadio1.add(przelacznikW2);
//        panelRadio1.add(przelacznikW3);
// */       
//        budujPrzyciskRadioRozmiar("Wybór I - Mały", 15);
//        budujPrzyciskRadioRozmiar("Wybór II - Średni", 25);
//        budujPrzyciskRadioRozmiar("Wybór III - Duży", 35);
//        
//        budujPrzyciskRadioKolor("Czerwony", Color.RED);
//        budujPrzyciskRadioKolor("Niebieski", Color.BLUE);
//        budujPrzyciskRadioKolor("Zielony", Color.GREEN);
//        
//
//
//        panelEtykieta2.add(gornyE2);
//        panelEtykieta2.add(dolnyE2);
//        this.getContentPane().add(gornyE2, BorderLayout.NORTH);
//      //  this.getContentPane().add(dolnyE2, BorderLayout.CENTER);
//        
//        gornyE2.setBackground(Color.BLUE);
//      //  dolnyE2.setBackground(Color.BLACK);
//        
//        gornyE2.add(pogrubiony);
//        gornyE2.add(pochylony);      
//        etykietaRadio.setFont(new Font("Monospaced", Font.PLAIN, 25));
//        pogrubiony.addActionListener(new obslugaCheckBox());
//        pochylony.addActionListener(new obslugaCheckBox());
//        
//        
//        this.getContentPane().add(panelRadio1, BorderLayout.SOUTH);
//        
//        this.getContentPane().add(panelRadio2, BorderLayout.EAST);
//        this.getContentPane().add(panelEtykieta2, BorderLayout.CENTER);
//
//       // this.getContentPane().add(panel, BorderLayout.NORTH);
//        
//        
//        kolorCzerwony = new JButton("Czerwony");   
//        kolorCzarny = new JButton("Czarny"); 
//        kolorNiebieski = new JButton("Niebieski");
//        
//        
//        kolorCzerwony.addActionListener(new sluchaczKolorow(Color.RED));
////        kolorCzarny.addActionListener(new sluchaczKolorow(Color.BLACK));
//
//        kolorNiebieski.addActionListener(this);
//        
//        panel.add(kolorCzerwony);
//        panel.add(kolorCzarny);
//        panel.add(kolorNiebieski);
//        
//        kolorCzarny.addActionListener(new ActionListener() {
//
//            public void actionPerformed(ActionEvent e) 
//            {
//               panel.setBackground(Color.BLACK);
//            }
//        });
//        
//        budujButton("Zielony", Color.GREEN);
//        budujButton("Default", null);
//        
//        panel.add(etykieta);
//        
//        panel.setBackground(Color.CYAN);
//        panelRadio1.setBackground(Color.LIGHT_GRAY);
//        panelRadio2.setBackground(Color.PINK);
//        panelEtykieta2.setBackground(Color.ORANGE);
//
//        panel.add(czas).setForeground(Color.red);
//        ActionListener stoper = new Zegar();
//        Timer zegar = new Timer(1000,stoper);
//        
//       zegar.start();
       
        
    //    this.getContentPane().add(panel);
// -------------  Znajdź i zamień------------------------------------- 
//       this.setTitle("Znajdź i zamień");
     //   this.getContentPane().add(obszarTekstowy);
        
       // obszarTekstowy.selectAll();
       // obszarTekstowy.select(0, 10);
//        obszarTekstowy.replaceSelection("Nowy fragment tekstu - ");
//        obszarTekstowy.replaceRange("NOWY !!!",0,4);
//        obszarTekstowy.select(obszarTekstowy.getText().indexOf("tekst") , obszarTekstowy.getText().indexOf("tekst")+"tekst".length());
//        panelSzukania.add(znajdz);
//        panelSzukania.add(szukany);
//        panelSzukania.add(etykietaI);
//        panelSzukania.add(zamien);
//        panelSzukania.add(etykietaNa);
//        panelSzukania.add(nowyTekst);
//        
//        znajdz.addActionListener(new zajdowanieHandler());
//        zamien.addActionListener(new zamienianieHandler());
//   
//               
//        
//        this.getContentPane().add(obszarPrzewijania, BorderLayout.NORTH);
//        this.getContentPane().add(panelSzukania, BorderLayout.CENTER);
        
 // --------------  Znajdź i zamień---------------------   
 // ----START----------  Combo BOX--------------------- 
//       this.setTitle("Combo BOX");
//       
//       kombinacja.addActionListener(new ActionListener() 
//       {
//
//          public void actionPerformed(ActionEvent e) 
//          {
//         //    ComBoxColor handler = (ComBoxColor)((JComboBox)e.getSource()).getSelectedItem();
//             ((JComboBox)e.getSource()).setBackground(((ComBoxColor)((JComboBox)e.getSource()).getSelectedItem()).getColor());
////             System.out.println(((JComboBox)e.getSource()).getSelectedItem());
//          }
//       });
//       
//       panelCombo.add(kombinacja);
//       kombinacja.addItem(new ComBoxColor("Czarny",Color.BLACK));
//       kombinacja.addItem(new ComBoxColor("Zielony",Color.GREEN));
//       kombinacja.addItem(new ComBoxColor("Czerwony",Color.RED));
//       kombinacja.addItem(new ComBoxColor("Biały",Color.WHITE));
//       kombinacja.addItem(new ComBoxColor("Żółty",Color.YELLOW));
//       
//       this.getContentPane().add(panelCombo, BorderLayout.CENTER);
//       
//  // -----KONIEC---------  Combo BOX--------------------- 
// ----- START --------- WindowListener --------------------       
//       this.setTitle("Operacje na oknach");
//       
//       this.addWindowListener(this);
//       
//       
//       
//       this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
// ----- END --------- WindowListener -------------------- 
  // ----- START --------- Wiele OKNIEN -------------------- 
      this.setTitle("Wiele OKNIENEK - Ramek"); 
      
      this.getContentPane().add(noweOkno);
      noweOkno.addActionListener(new ActionListener() 
      {
         public void actionPerformed(ActionEvent e)
         {
            NowaRamka n1 = new NowaRamka();
            n1.setVisible(true);
            n1.setTitle(n1.getName());

            new dialog(taRamka).setVisible(true); // okno z własnej classy
         }
      });
       
      this.setDefaultCloseOperation(3); 
 // ----- END --------- Wiele OKNIEN --------------------      
    }
    
    
   // ----- START --------- Wiele OKIEN --------------------

    JFrame taRamka = this;
    JButton noweOkno = new JButton("NOWE OKNO");
    
    // ----- START --------- WindowListener --------------------

   public void windowOpened(WindowEvent e) 
   {
      JOptionPane.showMessageDialog(rootPane, "Witaj :-)");
   }

   public void windowClosing(WindowEvent e) 
   {
      int opcja = JOptionPane.showConfirmDialog(rootPane,"Chcesz zakmnąć?");
      if (opcja == 0) 
         this.dispose();
   }

   public void windowClosed(WindowEvent e) 
   {
      System.out.println("Zapisujemy dane na dysku.");
   }

   public void windowIconified(WindowEvent e) 
   {
      System.out.println("Z okna do paska");
   }

   public void windowDeiconified(WindowEvent e) 
   {
      System.out.println("Z paska do okna");
   }

   public void windowActivated(WindowEvent e) 
   {
      System.out.println("Jestem aktywnym oknem");
   }

   public void windowDeactivated(WindowEvent e) 
   {
      System.out.println("Jestem NIEaktywnym oknem");
   }
   
//    // ----- KONIEC --------- WindowListener --------------------   
//
//   // -----START---------  Combo BOX---------------------
//    private class ComBoxColor
//    {
//       private String nazwaComBox;
//       private Color kolor;
//       
//       public ComBoxColor(String nazwa, Color k)
//       {
//          this.nazwaComBox = nazwa;
//          this.kolor = k;
//       }
//       
//       @Override
//       public String toString()
//       {
//          return this.nazwaComBox;
//       }
//       
//       public Color getColor()
//       {
//          return this.kolor;
//       }
//    }
//   // -----KONIEC---------  Combo BOX--------------------- 
//    
//    private class Zegar implements ActionListener{
//
//
//      public void actionPerformed(ActionEvent e) {
//        czas.setText(pobierzCzas());
//      }
//      
//
//       
//    }
//    
//          public String pobierzCzas(){
//        GregorianCalendar kalendarz = new GregorianCalendar();
//        String hh = ""+kalendarz.get(Calendar.HOUR_OF_DAY);
//        String mm = ""+kalendarz.get(Calendar.MINUTE);
//        String ss = ""+kalendarz.get(Calendar.SECOND);
//        
//        if (Integer.parseInt(hh) < 10) hh = "0"+hh;
//        if (Integer.parseInt(mm) < 10) mm = "0"+mm;
//        if (Integer.parseInt(ss) < 10) ss = "0"+ss;
//        
//         return hh+" : "+mm+" : "+ss;
//      }
//          
//        JPanel gornyE2 = new JPanel();
//        JPanel dolnyE2 = new JPanel();
//    
//    JPanel panel = new JPanel();
//    JPanel panelRadio1 = new JPanel();
//    JPanel panelRadio2 = new JPanel();
//    JPanel panelEtykieta2 = new JPanel();
//    JButton kolorCzerwony;
//    JButton kolorCzarny;   
//    JButton kolorNiebieski;
//    JLabel etykieta = new JLabel("Czas: ");
//    JLabel etykietaRadio = new JLabel("Ten tekst będzie ulegał zmianie");
//    JLabel czas = new JLabel(pobierzCzas());
//    ButtonGroup grupaRadioRozmiar = new ButtonGroup();
//    ButtonGroup grupaRadioKolor = new ButtonGroup();
//    JCheckBox pogrubiony = new JCheckBox("Pogrubiony");
//    JCheckBox pochylony = new JCheckBox("Pochylony");
//    private JTextArea obszarTekstowy = new JTextArea("Taki sobie tekst, Taki sobie tekst, Taki sobie tekst.",7, 10);
//    private JScrollPane obszarPrzewijania = new JScrollPane(obszarTekstowy);
//    private JPanel panelSzukania = new JPanel();
//    private JButton znajdz = new JButton("Znajdź");
//    private JButton zamien = new JButton("Zamień");
//    private JTextField szukany = new JTextField(10);
//    private JTextField nowyTekst = new JTextField(10);
//    private JLabel etykietaI = new JLabel("i");
//    private JLabel etykietaNa = new JLabel("na");
//    // combo box
//    private JPanel panelCombo = new JPanel();
//    private JComboBox kombinacja = new JComboBox();
//    
//    private class zamienianieHandler implements ActionListener
//    {
//      public void actionPerformed(ActionEvent e) 
//      {
////         String tekstZaznaczony = obszarTekstowy.getSelectedText();
////         JOptionPane.showConfirmDialog(rootPane, "Czy zaznaczyłeś: " + tekstZaznaczony,"Uwaga zaznaczono !", JOptionPane.YES_NO_OPTION);
//         
//         if (obszarTekstowy.getSelectionStart() != obszarTekstowy.getSelectionEnd())
//               zamienTekst();
//         else
//         {
//            znajdz.doClick(0);
//         if (obszarTekstowy.getSelectionStart() != obszarTekstowy.getSelectionEnd())   
//            zamienTekst();
//         }
//      } 
//      private void zamienTekst()
//      {
//         obszarTekstowy.requestFocus();
//         int opcja = JOptionPane.showConfirmDialog(rootPane, "Czy chcesz zamienić \'" + szukany.getText() + "\'","Uwaga nastąpi zmiana !", JOptionPane.YES_NO_OPTION);
//         if (opcja == 0)
//         obszarTekstowy.replaceRange(nowyTekst.getText(), obszarTekstowy.getSelectionStart(), obszarTekstowy.getSelectionEnd());
//      }
//       
//    }
//    
//    private class zajdowanieHandler implements ActionListener
//    {
//      private int poczatekSzukanego = 0;
//      public void actionPerformed(ActionEvent e) 
//      {
//          poczatekSzukanego = obszarTekstowy.getText().indexOf(szukany.getText(),poczatekSzukanego + szukany.getText().length());
//          if (poczatekSzukanego == -1)
//             poczatekSzukanego = obszarTekstowy.getText().indexOf(szukany.getText());
//          
//          if (poczatekSzukanego >= 0 && szukany.getText().length() > 0)
//          {
//             obszarTekstowy.requestFocus();
//             obszarTekstowy.select(poczatekSzukanego, poczatekSzukanego + szukany.getText().length());
//          }
//      }
//       
//    }
//    
//    public class obslugaCheckBox implements ActionListener
//    {
//      public void actionPerformed(ActionEvent e) 
//      {
//         int style = Font.PLAIN;
//         
//         if (pogrubiony.isSelected()) style += Font.BOLD;
//         if (pochylony.isSelected()) style += Font.ITALIC;
//         
//            etykietaRadio.setFont(new Font(etykietaRadio.getFont().getFamily(), style, etykietaRadio.getFont().getSize()));
//      }
//       
//    }
//   
//
//    public void budujPrzyciskRadioRozmiar(String nazwa, final int rozmiar)
//    {
//      JRadioButton przelacznik = new JRadioButton(nazwa);
//      przelacznik.addActionListener(new ActionListener() 
//         {
//            public void actionPerformed(ActionEvent e) 
//            {
//               etykietaRadio.setFont(new Font("Monospaced", Font.BOLD, rozmiar));
//            }
//         });
//      grupaRadioRozmiar.add(przelacznik);
//      panelRadio1.add(przelacznik);
//    }
//
//    public void budujPrzyciskRadioKolor(String nazwa, final Color k)
//    {
//      JRadioButton przelacznik = new JRadioButton(nazwa);
//      przelacznik.addActionListener(new ActionListener() 
//         {
//            public void actionPerformed(ActionEvent e) 
//            {
//               etykietaRadio.setForeground(k);
//            }
//         });
//      przelacznik.setForeground(k);
//      grupaRadioKolor.add(przelacznik);
//      panelRadio2.add(przelacznik);
//    }
//    
//    
//    public void budujButton(String nazwa, final Color k)
//    {
//        JButton przycisk = new JButton(nazwa);
//        przycisk.addActionListener(new ActionListener() 
//        {
//            public void actionPerformed(ActionEvent e) 
//            {
//               panel.setBackground(k);
//               if (k==null)
//               czas.setForeground(Color.BLACK);
//            }
//        });
//        
//        panel.add(przycisk);
//    }
//    
//    private class sluchaczKolorow implements ActionListener
//    {
//        public sluchaczKolorow(Color k)
//        {
//            this.kolor = k;
//        }
//        
//        public void actionPerformed(ActionEvent e) 
//        {
//           panel.setBackground(kolor);
//           
//           czas.setForeground(Color.WHITE);
//        }
//        
//        Color kolor;
//    }
//
//
//    public void actionPerformed(ActionEvent e) 
//    {
//       if (e.getSource() == kolorNiebieski)
//           panel.setBackground(Color.BLUE);
//      
//    }
    
        
    public static void main(String[] args) 
    {
        new Main().setVisible(true);
        
        
    }
    
}
