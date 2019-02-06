package zdarzenia;

import javax.swing.*;
import java.awt.event.*;

public class NoweOknoClass extends JFrame
{  
   
    public NoweOknoClass(JFrame parent)
    {
         
        initComponents();
         int szer = (int)parent.getBounds().getWidth();
         int wys = (int)parent.getBounds().getHeight();
         int szerR = this.getSize().width;
         int wysR = this.getSize().height;

         miejsceRamki=miejsceRamki+20;
         
         this.setLocation(parent.getBounds().x+miejsceRamki+(szer-szerR)/2,parent.getBounds().y+miejsceRamki+(wys-wysR)/2);

    }
    
    public void initComponents()
    {
 
     this.setBounds(600, 600 , 550, 75);

      this.setTitle("Ramek z CLASS nr " + (++numerRamki)); 
      

       
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
     
    }
    
   
    JButton noweOkno = new JButton("NOWE OKNO");
    static int numerRamki = 0;
    static int miejsceRamki = 0;

    

    
        
    public static void main(String[] args) 
    {
        new Main().setVisible(true);
        
        
    }
    
}
