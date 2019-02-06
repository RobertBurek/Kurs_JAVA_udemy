
package obramowanie;


import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;



public class Obramowanie extends JFrame
{  
   
    public Obramowanie()
    {
        initComponents();
    //    MyGridLayout();
    }
    
    public void initComponents()
    {
       this.setTitle("Krawędzie"); 
       this.setBounds(700, 300 , 500, 500);

       dodajPrzelacznik("Etched", BorderFactory.createEtchedBorder());
       dodajPrzelacznik("LoweredBovel", BorderFactory.createLoweredBevelBorder());
       dodajPrzelacznik("Bovel", BorderFactory.createBevelBorder(BevelBorder.RAISED));
       dodajPrzelacznik("Compound", BorderFactory.createCompoundBorder());
       dodajPrzelacznik("Line RED", BorderFactory.createLineBorder(Color.red,5));
       
       panelRadioG.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
       panelRadioG.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "Krawędzie",TitledBorder.RIGHT,TitledBorder.BOTTOM));
   //    panelRadioS.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    //   panelRadioS.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "Krawędzie środek"));
   //    panelRadioD.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
   //   panelRadioD.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "Krawędzie",TitledBorder.RIGHT,TitledBorder.BOTTOM));

       this.getContentPane().setLayout(new GridLayout(3,3));       
       this.getContentPane().add(panelRadioGP).setBackground(Color.red);
       this.getContentPane().add(panelRadioG);
       this.getContentPane().add(panelRadioS);
       this.getContentPane().add(panelRadioD);
       this.getContentPane().add(panelRadioGP).setBackground(Color.red);
       this.getContentPane().add(panelRadioSP).setBackground(Color.blue);
       this.getContentPane().add(panelRadioDP).setBackground(Color.yellow);
       this.getContentPane().add(panelRadioGL).setBackground(Color.black);
       this.getContentPane().add(panelRadioSL).setBackground(Color.gray);
       this.getContentPane().add(panelRadioDL).setBackground(Color.cyan);
       panelRadioGL.setBorder(BorderFactory.createLineBorder(Color.red,20));
       panelRadioSL.setBorder(BorderFactory.createLineBorder(Color.blue,20));
       panelRadioDL.setBorder(BorderFactory.createLineBorder(Color.yellow,20));
       this.setDefaultCloseOperation(3); 
    }
    
    private JPanel panelRadioG = new JPanel();
    private JPanel panelRadioS = new JPanel();
    private JPanel panelRadioD = new JPanel();
    private JPanel panelRadioGP = new JPanel();
    private JPanel panelRadioSP = new JPanel();
    private JPanel panelRadioDP = new JPanel();
    private JPanel panelRadioGL = new JPanel();
    private JPanel panelRadioSL = new JPanel();
    private JPanel panelRadioDL = new JPanel();
    private ButtonGroup grupaRadio = new ButtonGroup();
//    static int numerRamki = 0;
//    static int miejsceRamki = 0;

    public void dodajPrzelacznik(final String nazwa,final Border kr)
    {
       JRadioButton przelacznik = new JRadioButton(nazwa);
       przelacznik.addActionListener(new ActionListener() 
       {
          @Override
          public void actionPerformed(ActionEvent e) 
          {
             panelRadioS.setBorder(BorderFactory.createTitledBorder(kr, nazwa));
          }
       });
       grupaRadio.add(przelacznik);
       panelRadioD.add(przelacznik);
       
    }
JFrame f = new JFrame();
  public void MyGridLayout()
  {
      
 
	f=new JFrame();
	
	JButton b1=new JButton("1");
	JButton b2=new JButton("2");
	JButton b3=new JButton("3");
	JButton b4=new JButton("4");
	JButton b5=new JButton("5");
        JButton b6=new JButton("6");
        JButton b7=new JButton("7");
	JButton b8=new JButton("8");
        JButton b9=new JButton("9");
		
	f.add(b1);f.add(b2);f.add(b3);f.add(b4);f.add(b5);
	f.add(b6);f.add(b7);f.add(b8);f.add(b9);

	f.setLayout(new GridLayout(3,3));//creating grid layout of 3 row and 3 columns
	f.setSize(300,300);
	f.setVisible(true);
          f.setDefaultCloseOperation(f.DISPOSE_ON_CLOSE);
         } 
   
        
    public static void main(String[] args) 
    {
        new Obramowanie().setVisible(true);
        //new MyGridLayout();
        
        
    }
    
}
