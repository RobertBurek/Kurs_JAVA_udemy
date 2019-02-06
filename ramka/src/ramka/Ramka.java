
package ramka;

import javax.swing.*;
import java.awt.*;

public class Ramka extends JFrame {
   
   public Ramka(){
      super("Nowy program!!!");
/*      JFrame frame = new JFrame("Nowy program");
      // frame.setTitle("Nowy program!!!");
      // frame.setSize(600, 200);
      frame.setSize(new Dimension(600, 200));
      // frame.setLocation(300, 300);
      // frame.setLocation(new Point(400, 400));
      frame.setBounds(400, 400, 600, 200);
      frame.setResizable(false);
      frame.setIconImage(Toolkit.getDefaultToolkit().getImage("ikonka2.jpg"));
      // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);,
      frame.setDefaultCloseOperation(3);
      frame.setVisible(true);
*/
      int width = Toolkit.getDefaultToolkit().getScreenSize().width;
      int height = Toolkit.getDefaultToolkit().getScreenSize().height;
//      int widthRamka = 1200;
//      int heightRamka = 800;
      this.setSize(width/2, height/2);
      int widthRamka = this.getSize().width;
      int heightRamka = this.getSize().height;
      
      
      
//      this.setTitle("Nowy program!!!");
      this.setBounds((width-widthRamka)/2, (height-heightRamka)/2, widthRamka, heightRamka);
      
      // this.setTitle("Nowy program!!!");
     
      this.setIconImage(Toolkit.getDefaultToolkit().getImage("ikonka2.jpg"));
      // this.setVisible(true);
     // this.pack();
      initComponents();
  //    this.pack();
      this.setDefaultCloseOperation(3);
   }
   
   public void initComponents(){
      Anuluj.setPreferredSize(new Dimension(80, 30));
      Centrum.setPreferredSize(Centrum.getPreferredSize());
      panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
//      Gora.setPreferredSize(Gora.getPreferredSize());
//      Dolny.setPreferredSize(Dolny.getPreferredSize());
//      Lewy.setPreferredSize(Lewy.getPreferredSize());
//      Prawy.setPreferredSize(Prawy.getPreferredSize());
      panel.add(Anuluj);
      panel.add(Centrum);
      panel.add(Gora);
      panel.add(Dolny);
      panel.add(Lewy);
      panel.add(Prawy);
    //  this.getContentPane().add(panel, BorderLayout.CENTER);
      this.getContentPane().add(panel);
    
    //  NOWY.setPreferredSize(new Dimension(50, 50));
    //  this.getContentPane().add(NOWY, BorderLayout.PAGE_START);
//      NOWY.setLocation(100,150);
//      NOWY.setSize(NOWY.getPreferredSize());
//      Anuluj.setLocation(850,450);
//      Anuluj.setSize(Anuluj.getPreferredSize());
//      container.add(Anuluj);
//      container.setLayout(null);
//      container.add(NOWY);
        
//      przyciskCentrum = new JButton("Wykres Centrum");
//      przyciskGora = new JButton("Wykres Góra");
//      przyciskDolny = new JButton("Wykres Dolny");
//      przyciskLewy = new JButton("Wykres Lewy");
//      przyciskPrawy = new JButton("Wykres Prawy");
//      Container container = this.getContentPane();
//      container.add(przyciskCentrum, BorderLayout.CENTER);
//      container.add(przyciskGora, BorderLayout.PAGE_START);
//      container.add(przyciskDolny, BorderLayout.PAGE_END);
//      container.add(przyciskLewy, BorderLayout.WEST);
//      container.add(przyciskPrawy, BorderLayout.EAST);
   }
   
     JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//     JButton NOWY= new JButton ("NOWY");
//     JButton Anuluj= new JButton ("Anuluj");
     
   JButton Anuluj = new JButton("Anuluj");
   JButton Centrum = new JButton("Centrum");
   JButton Gora = new JButton("Góra");
   JButton Dolny = new JButton("Dolny");
   JButton Lewy = new JButton("Lewy");
   JButton Prawy = new JButton("Prawy");
   
   public static void main(String[] args) {
      new Ramka().setVisible(true);
   }
   
}
