
package zakladkimoje;

import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.*;

public class ZakladkiMoje extends JFrame
{  
   
    public ZakladkiMoje()
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
      this.setTitle("Zakładki"); 
      //1
      zakladki.addTab("Zakładka1",new JLabel("Pierwsza zakładka jest tutaj."));
      //2
      JPanel panel = new JPanel();
      JButton przeskocz = new JButton("Przejdź do 'Zakładka1'");
      panel.add(przeskocz);
      przeskocz.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e)
         {
            zakladki.setSelectedIndex(0);
         }
      });
      zakladki.addTab("Zakładka2",new ImageIcon("czerwony.gif"),panel,"Pierwsza zakładka jest tutaj.");
      zakladki.setMnemonicAt(0, KeyEvent.VK_T);
      //3
      panelTworzenia.add(new JLabel("Stwórz nowy plik o nazwie: "));
      JTextField nazwaNowejZakladki = new JTextField(7);
      panelTworzenia.add(nazwaNowejZakladki);
      JButton stworzZakladke = new JButton("Stwórz!");
      panelTworzenia.add(stworzZakladke);
      zakladki.addTab("Vodeo kursy", panelTworzenia);
      stworzZakladke.addActionListener(new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent e)
         {
            JPanel panelTekstowy = new JPanel();
            panelTekstowy.setLayout(new GridLayout(1, 1));
            
            JTextArea obszarTekstowy = new JTextArea();
            panelTekstowy.add(new JScrollPane(obszarTekstowy));
            
            
            zakladki.addTab(nazwaNowejZakladki.getText()+".txt",panelTekstowy);
            zakladki.setSelectedIndex(zakladki.getTabCount()-1);
            obszarTekstowy.addKeyListener(new KeyAdapter()
            {
               @Override
               public void keyPressed(KeyEvent e)
               {
                  if (!(tytulZakladki+e.getKeyChar()).equals(przedZmianaOszaruTekstowego) && czyToAscii(e.getKeyChar()) && flagaZapisu)
                  {
                     przedZmianaOszaruTekstowego = tytulZakladki+e.getKeyChar();
                     zakladki.setTitleAt(indexZakladki, tytulZakladki+"*");
                     flagaZapisu=false;
                     //System.out.println("Test");
                  }
                  else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S && !flagaZapisu)
                  {
                     zakladki.setTitleAt(indexZakladki, tytulZakladki);
                     //System.out.println("Zapisany");
                     flagaZapisu=true;

                  }
               }
               private boolean czyToAscii(char zn)
               {
                  for (int i = 0; i < 255; i++)
                     if(zn == i)
                        return true;

                  return false;
               }
               int indexZakladki = zakladki.getSelectedIndex();
               String tytulZakladki = zakladki.getTitleAt(indexZakladki);
               boolean flagaZapisu = true;
               String przedZmianaOszaruTekstowego = "";
            });
         }
      });
      // inne
      zakladki.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
      
      this.getContentPane().add(zakladki);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
   private JTabbedPane zakladki = new JTabbedPane();
   private JPanel panelTworzenia = new JPanel();
    
   private boolean czyToAscii(char zn)
   {
      for (int i = 0; i < 255; i++)
         if(zn == i)
            return true;
      
      return false;
   }
   
    public static void main(String[] args) 
    {
        new ZakladkiMoje().setVisible(true);
        
        
    }
    
}
