
package wewnetrzneramkimoje;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public class WewnetrzneRamkiMoje extends JFrame
{  
   
    public WewnetrzneRamkiMoje()
    {
         
        initComponents();
         int szer = Toolkit.getDefaultToolkit().getScreenSize().width;
         int wys = Toolkit.getDefaultToolkit().getScreenSize().height;
         int szerR = this.getSize().width;
         int wysR = this.getSize().height;
         
      
         this.setLocation((szer-szerR)/2,(wys-wysR)/2);

    }
    private JDesktopPane desktopPane = new JDesktopPane();
    
    
    public void initComponents()
    {
      this.setSize(550, 375);
      this.setTitle("Wewnętrzne ramki"); 
         
      JInternalFrame wewnetrznaramka1 = new JInternalFrame("Tytuł ramki1",true,true,true,true);
      JInternalFrame wewnetrznaramka2 = new JInternalFrame("Tytuł ramki2",true,true,true,true);
         
         desktopPane.add(wewnetrznaramka1);
         wewnetrznaramka1.setVisible(true);
         wewnetrznaramka1.add(new JButton("test"),BorderLayout.NORTH);
         wewnetrznaramka1.setBounds(0, 0, 300, 100);
         wewnetrznaramka1.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
         //wewnetrznaramka1.pack();
         desktopPane.add(wewnetrznaramka2);
         wewnetrznaramka2.setVisible(true);
         wewnetrznaramka2.add(new JLabel("Tekst drugiej ramki"),BorderLayout.NORTH);
         wewnetrznaramka2.setBounds(150, 150, 300, 100);
         
         
         //wewnetrznaramka2.pack();
         wewnetrznaramka1.addInternalFrameListener(new InternalFrameListener() {

         @Override
         public void internalFrameOpened(InternalFrameEvent e)
         {
            System.out.println("otwieranie");
         }

         @Override
         public void internalFrameClosing(InternalFrameEvent e)
         {
            System.out.println("zamykanie");
            String odp = JOptionPane.showInternalInputDialog(e.getInternalFrame(), "Wpisz 'Wyjdź' - wyście, wpisz 'Zamknij' - zakmnięcie");
            if (odp != null)
               if (odp.equals("Wyjdź"))
                  System.exit(0);
               else if (odp.equals("Zamknij"))
                  e.getInternalFrame().dispose();
         }

         @Override
         public void internalFrameClosed(InternalFrameEvent e)
         {
            System.out.println("zamknięcie");
         }

         @Override
         public void internalFrameIconified(InternalFrameEvent e)
         {
            System.out.println("zmiejszenie");
         }

         @Override
         public void internalFrameDeiconified(InternalFrameEvent e)
         {
            System.out.println("powiększenie");
         }

         @Override
         public void internalFrameActivated(InternalFrameEvent e)
         {
            System.out.println("aktywny");
         }

         @Override
         public void internalFrameDeactivated(InternalFrameEvent e)
         {
            System.out.println("nieaktywny");
         }
      } );
     

         
      this.getContentPane().add(desktopPane, BorderLayout.CENTER);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
   
        
    public static void main(String[] args) 
    {
        new WewnetrzneRamkiMoje().setVisible(true);
        
        
    }
    
}
