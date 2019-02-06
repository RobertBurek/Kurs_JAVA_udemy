
package suwak;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Suwak extends JFrame
{  
   
    public Suwak()
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
      this.setTitle("Suwaki");
      
      suwak.setMajorTickSpacing(5);
      suwak.setMinorTickSpacing(1);
      suwak.setPaintTicks(true);
      suwak.setPaintLabels(true);
   //   suwak.setSnapToTicks(true);
      
      suwak.addChangeListener(new ChangeListener() 
      {
         @Override
         public void stateChanged(ChangeEvent e) 
         {
            wartoscSuwaka.setText(""+((JSlider)e.getSource()).getValue());
            tekst.setFont(new Font(tekst.getFont().getFontName(),tekst.getFont().getStyle(),((JSlider)e.getSource()).getValue()));
         }
      });
      
      this.getContentPane().add(suwak, BorderLayout.NORTH);
      this.getContentPane().add(tekst, BorderLayout.CENTER);
      this.getContentPane().add(wartoscSuwaka, BorderLayout.SOUTH );
      wartoscSuwaka.setEditable(false);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
   JSlider suwak = new JSlider(JSlider.HORIZONTAL,0 , 10, 5);
   JTextField wartoscSuwaka = new JTextField(""+suwak.getValue());
   JLabel tekst = new JLabel("Tekst");
   
        
    public static void main(String[] args) 
    {
        new Suwak().setVisible(true);
        
        
    }
    
}
