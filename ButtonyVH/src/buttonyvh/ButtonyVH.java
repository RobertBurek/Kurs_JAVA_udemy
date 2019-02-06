
package buttonyvh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonyVH extends JFrame {
   
   public ButtonyVH (){
   super("Nowy program!!! Buttony V i H");
      int width = Toolkit.getDefaultToolkit().getScreenSize().width;
      int height = Toolkit.getDefaultToolkit().getScreenSize().height;
      this.setSize(width/2, height/2);
      int widthRamka = this.getSize().width;
      int heightRamka = this.getSize().height;
      this.setBounds((width-widthRamka)/2, (height-heightRamka)/2, widthRamka, heightRamka);
      this.setIconImage(Toolkit.getDefaultToolkit().getImage("ikonka2.jpg"));

      initComponents();

      this.setDefaultCloseOperation(3);
   }
   
   public void initComponents(){
      GroupLayout layout = new GroupLayout (getContentPane());
      
  //    panel.add(bAnuluj);
  //    panel.setLayout(layout);
  //    layout.addLayoutComponent(panel, rootPane);
  //    panel.setBackground(Color.BLUE);
      this.getContentPane().setLayout(layout);
      
      layout.setAutoCreateGaps(true);
      layout.setAutoCreateContainerGaps(true);
      
      layout.setHorizontalGroup(
              layout.createSequentialGroup()
              .addComponent(button1)
              .addGroup(
              layout.createParallelGroup()
                     .addComponent(button2)
                     .addComponent(button4)
                     .addComponent(button5)
                        )
              .addComponent(button3)
              .addContainerGap(20, Short.MAX_VALUE)
              .addComponent(bAnuluj)
              );
      layout.setVerticalGroup(
              layout.createSequentialGroup()
              .addGroup(
              layout.createParallelGroup()
                      .addComponent(button1)
                      .addComponent(button2)
                      .addComponent(button3)
                        )
              .addComponent(button4)
              .addComponent(button5)
              .addContainerGap(20, Short.MAX_VALUE)
              .addComponent(bAnuluj)
      );
      bAnuluj.addActionListener(new sluchaczbAnuluj(Color.RED));
      button5.addActionListener(new ActionListener(){

         @Override
         public void actionPerformed(ActionEvent e) {
            new NewJFrameMoja().setVisible(true);
         }
                 
              });
   }
//   JPanel panel = new JPanel();
   JButton button1 = new JButton("BUTTON1");
   JButton button2 = new JButton("BUTTON2");
   JButton button3 = new JButton("BUTTON3");
   JButton button4 = new JButton("BUTTON4");
   JButton button5 = new JButton("Drugi pulpit");
   JButton bAnuluj = new JButton("Anuluj");
   
   private class sluchaczbAnuluj implements ActionListener
   {
      Color kolor;
      Color kolorTla = Color.BLUE;

      
      public sluchaczbAnuluj(Color kolor)
      {
         this.kolor = kolor;
         
      }
      
      @Override
      public void actionPerformed(ActionEvent e) 
      {
        // System.out.println(e);
         if (bAnuluj.getForeground()==kolor)
               bAnuluj.setForeground(Color.BLACK);
                       else
               bAnuluj.setForeground(kolor);
        // bAnuluj.setBackground(kolorTla);
       // panel.setBackground(kolorTla);
        
//         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         
      }
        
   }
  
   
   public static void main(String[] args) {
   new ButtonyVH().setVisible(true);
  // new NewJFrameMoja().setVisible(true);
   
   }

   
}
