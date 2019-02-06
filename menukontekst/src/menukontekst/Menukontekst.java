package menukontekst;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.*;

public final class Menukontekst extends JFrame
{  
   
    public Menukontekst()
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
      this.setTitle("Menu kontekstowe"); 
      
      JPopupMenu menuKontekstowe = new JPopupMenu();
      menuKontekstowe.add(new JMenuItem(new AbstractAction("Zamknij")
      {
         @Override
         public void actionPerformed(ActionEvent e)
         {
            System.exit(0);
         }
      }));
      menuKontekstowe.add(new JMenuItem("Usuń"));
      menuKontekstowe.add(new JMenuItem("Popraw"));
      menuKontekstowe.add(new JMenuItem("Przenieś"));
      
      
      
      m1 = menuKontekstowe.add(new JMenuItem(new AbstractAction("Dodaj 'TEST'") {
         
         @Override
         public void actionPerformed(ActionEvent e)
         {
            test.setVisible(true);
            m1.setEnabled(false);
            m2.setEnabled(true);
         }
      }));
       m1.setEnabled(false);
      m2 = menuKontekstowe.add(new JMenuItem(new AbstractAction("Ukryj 'TEST'") {

         @Override
         public void actionPerformed(ActionEvent e)
         {
            test.setVisible(false);
            m1.setEnabled(true);
            m2.setEnabled(false);
         }
      }));
      
      JPopupMenu menuKontekstoweButton = new JPopupMenu();
      menuKontekstoweButton.add(new JMenuItem(new AbstractAction("Ukryj")
      {
         @Override
         public void actionPerformed(ActionEvent e)
         {
            test.setVisible(false);
            m2.setEnabled(false);
            m1.setEnabled(true);
         }
      }));

      this.getContentPane().addMouseListener(new MouseAdapter() {


         @Override
         public void mouseReleased(MouseEvent e) 
         {      
            if (e.isPopupTrigger())
            //if (e.getButton() == MouseEvent.BUTTON3)
               menuKontekstowe.show(e.getComponent(), e.getX(), e.getY());
            //System.out.println(e.getClickCount
         }


      });
      this.getContentPane().add(test, BorderLayout.SOUTH);
      test.addMouseListener(new MouseAdapter()
      {
         @Override
         public void mouseReleased(MouseEvent e) 
         {      
            if (e.isPopupTrigger())
            //if (e.getButton() == MouseEvent.BUTTON3)
               menuKontekstoweButton.show(e.getComponent(), e.getX(), e.getY());
            //System.out.println(e.getClickCount
         }


      });
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
   JButton test = new JButton("TEST");
   JMenuItem m1 = new JMenuItem(); 
   JMenuItem m2 = new JMenuItem();

        
    public static void main(String[] args) 
    {
        new Menukontekst().setVisible(true);
        
        
    }
    
}
