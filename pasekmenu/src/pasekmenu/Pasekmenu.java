package pasekmenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
//import javafx.scene.Cursor;

public class Pasekmenu extends JFrame
{  
   
    public Pasekmenu()
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
      this.setSize(550, 400);
      this.setTitle("Pasek menu"); 
      
      pasekNarzedzi.add(new MojButton(new ActionKolor("Zmieniam na zielony",new ImageIcon("zielony.gif"), Color.GREEN)));
      pasekNarzedzi.add(new MojButton(new ActionKolor("Zmieniam na czerwony",new ImageIcon("czerwony.gif"), Color.RED)));
      pasekNarzedzi.add(new MojButton(new ActionKolor("Zmieniam na niebieski",new ImageIcon("niebieski.gif"), Color.BLUE)));
      pasekNarzedzi.add(button);
      Color defaultB = obszarTekstowy.getBackground();
     
      button.addActionListener(new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent e)
         {
            obszarTekstowy.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            aktywny = null;
            obszarTekstowy.setBackground(defaultB);
         }
      });
      
      obszarTekstowy.addMouseListener(new MouseAdapter()
      {
         public void mousePressed(MouseEvent e)
         {
            if (aktywny != null)
            obszarTekstowy.setBackground((Color)aktywny.getAction().getValue("kolor"));
         }
      });
      
      
      this.setJMenuBar(pasekMenu);
      

       
      JMenu menuPlik = pasekMenu.add(new JMenu("Plik"));
      menuPlik.setMnemonic('P');
 
      JMenuItem podMenuNowy = menuPlik.add(new JMenuItem("Nowy"));
      podMenuNowy.addActionListener(new ActionListener() 
      {
         @Override
         public void actionPerformed(ActionEvent e) 
         {
            System.out.println("KOD dla podMenuNowy");
         }
      });
      menuPlik.addSeparator();
      
      Action menuActionZapisz = new ActionZapisz("Zapisz", "Zapisujemy na dysk.", "ctrl S", new ImageIcon("ikonka.gif"), KeyEvent.VK_Z);
      JMenuItem podMenuZapisz = menuPlik.add(menuActionZapisz);
//     podMenuZapisz.setEnabled(false);
//      podMenuZapisz.addActionListener(new ActionListener() {
//         @Override
//         public void actionPerformed(ActionEvent e) 
//         {
//            System.out.println("Kod zapisu na dysk");
//            podMenuZapisz.setEnabled(flagaObszaruTekstowego=false);
//
//         }
//      });
//      podMenuZapisz.setToolTipText("Zapisanie na dysku");
//      podMenuZapisz.setMnemonic('Z');
//      podMenuZapisz.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
    
      zapiszB = new JButton(menuActionZapisz);
      menuActionZapisz.setEnabled(false);
      
      
      JMenuItem podMenuWczytaj = menuPlik.add("Wczytaj");
      JMenuItem podMenuUsin = menuPlik.add(new JMenuItem("Usuń"));
      JMenuItem podMenuZamien = menuPlik.add("Zamień");
      podMenuZamien.setMnemonic('m');
      podMenuZamien.addActionListener(new ActionListener() 
      {
         @Override
         public void actionPerformed(ActionEvent e) 
         {
            System.out.println("KOD dla zamień");
         }
      });
      menuPlik.addSeparator();
      JMenu podMenuOpcje = new JMenu("Opcje");
      menuPlik.add(podMenuOpcje);
      JMenuItem podMenuOpcja1 = podMenuOpcje.add("opcja 1");
      JMenuItem podMenuOpcja2 = podMenuOpcje.add("opcja 2");
      JMenuItem podMenuOpcja3 = podMenuOpcje.add("opcja 3");
      JMenuItem podMenuOpcja4 = podMenuOpcje.add("opcja 4");
      JMenuItem podMenuOpcja5 = podMenuOpcje.add("opcja 5");
      JMenuItem podMenuTylkoOdczyt = podMenuOpcje.add(tylkoOdczyt);
      podMenuTylkoOdczyt.addActionListener(new ActionListener() 
      {
         @Override
         public void actionPerformed(ActionEvent e) 
         {
            if (podMenuTylkoOdczyt.isSelected()) menuActionZapisz.setEnabled(false);
            else menuActionZapisz.setEnabled(flagaObszaruTekstowego);
         }
      });
      
     
      
      JMenu menuEdycja = pasekMenu.add(new JMenu("Edycja"));
      JMenu menuPomoc = pasekMenu.add(new JMenu("Pomoc"));
      menuPomoc.add(new JMenuItem("FAQ"));
      
      this.getContentPane().setLayout(new GridLayout(3, 1));
      this.getContentPane().add(pasekNarzedzi).setBounds(0, 0, 200, 70);
      this.getContentPane().add(obszarTekstowy).setBounds(71, 0, 220, 170);
      this.getContentPane().add(zapiszB);
 

      obszarTekstowy.addKeyListener(new KeyAdapter() 
      {
       public void keyTyped(KeyEvent e) 
       {
          if(tylkoOdczyt.isSelected()) e.consume();
       }

      public void keyPressed(KeyEvent e) 
      {
         //   if(e.isControlDown() && (e.getKeyCode() == KeyEvent.VK_V) && (tylkoOdczyt.isSelected())) e.consume(); 
         if(tylkoOdczyt.isSelected()) e.consume();
         else if (!(obszarTekstowy.getText()+e.getKeyChar()).equals(przedZmianaObszaruTekstowego) && czyToAscii(e.getKeyChar())) 
         {
            przedZmianaObszaruTekstowego = obszarTekstowy.getText()+e.getKeyChar();
            menuActionZapisz.setEnabled(flagaObszaruTekstowego=true);
         }
      //   System.out.println(obszarTekstowy.getText()+e.getKeyChar());
      }
      });
      


      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
    private JMenuBar pasekMenu = new JMenuBar();
    private JCheckBoxMenuItem tylkoOdczyt = new JCheckBoxMenuItem("Tylko do odczytu");
    private JTextArea obszarTekstowy = new JTextArea();
    private JButton zapiszB;
    private JButton button = new JButton("Wyłącz malowanie!");
    private boolean flagaObszaruTekstowego = false;
    private String przedZmianaObszaruTekstowego = "";
    private  JToolBar pasekNarzedzi = new JToolBar("Nazwa Nowej ramki");
    private  JPanel panel = new JPanel();
    private MojButton aktywny = null;
    
    private class MojButton extends JButton
    {
          MojButton ten = this;
          boolean zaznaczony = false;
       public MojButton(final ActionKolor actionKolor)
       {
          super(actionKolor);
          this.setBackground(Color.WHITE);
          this.addActionListener(new ActionListener()
          {
             @Override
             public void actionPerformed(ActionEvent e)
             {
                for (int i = 0; i < pasekNarzedzi.getComponentCount(); i++)
                  {
                     if (pasekNarzedzi.getComponent(i) instanceof MojButton)
                     {
                     MojButton tmp = (MojButton)pasekNarzedzi.getComponent(i);
                     tmp.setBackground(Color.WHITE);
                     tmp.setZaznaczony(false);
                     obszarTekstowy.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("kursorek.png").getImage(), new Point(30, 30), "Nasz kursorek"));
                     }
                  }
                
                ten.setBackground((Color)actionKolor.getValue("kolor"));
                ten.setZaznaczony(true);
             }
          });
       }
       public void setZaznaczony(boolean zaznacz)
       {
          this.zaznaczony = zaznacz;
       }
    }
    
    private class ActionKolor extends AbstractAction
    {
       ActionKolor(String toolTip, Icon ikonka, Color kolor)
       {
          this.putValue(Action.SHORT_DESCRIPTION, toolTip);
          this.putValue(Action.SMALL_ICON, ikonka);
          this.putValue("kolor", kolor);
       }
      @Override
      public void actionPerformed(ActionEvent e)
      {
         aktywny = (MojButton) e.getSource();
      }
    }
    
    private class ActionZapisz extends AbstractAction
    {
       ActionZapisz(String nazwa, String podpowiedz, String sKey, Icon ikona, int mKey)
       {
          this.putValue(Action.NAME, nazwa);
          this.putValue(Action.SHORT_DESCRIPTION, podpowiedz);
          this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(sKey));
          this.putValue(Action.SMALL_ICON, ikona);
          this.putValue(Action.MNEMONIC_KEY, mKey);
       }
      @Override
      public void actionPerformed(ActionEvent e) 
      {
         System.out.println("Kod zapisu na dysk");
         this.setEnabled(flagaObszaruTekstowego=false);
      }
    }
            
    private boolean czyToAscii(char zn)
    {
       for (int i = 0; i<255; i++)
          if (zn == i) return true;
       
       return false;
    }
    
    public static void main(String[] args) 
    {
        new Pasekmenu().setVisible(true);
        
        
    }
    
}
