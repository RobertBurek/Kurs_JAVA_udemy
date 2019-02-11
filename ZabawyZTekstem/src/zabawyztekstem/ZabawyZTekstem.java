/*
 * Napisane 12.2018 pierwsze kroki pisanie w JAVA. 
 */
package zabawyztekstem;


import javax.swing.*;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;


public class ZabawyZTekstem
{
  
  public static void main(String args[])
  {
    Okno okno=new Okno();
    okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    okno.setVisible(true);
  }
}  

class Okno extends JFrame
{
  public Okno()
  {
    setTitle("Elementy okna");
    setSize(340,400);
    //do??czenie panelu do powierzchni zawarto?ci okna
    MojPanel p=new MojPanel(); 
    Container powzaw=getContentPane(); //powierzchnia zawarto?ci
    powzaw.add(p);
  }
}
  
//panel, na kt�rym mo?na rysowa? zawarto?? okna (ramki)
class MojPanel extends JPanel
{
  
  JTextArea txa;
  JCheckBox bold;
  JComboBox foncik;  
  
  
  public MojPanel()
  {
   setLayout(new FlowLayout(FlowLayout.LEFT));
    
    txa=new JTextArea("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Quisque nec mauris. Proin consectetuer, metus laoreet mollis fringilla, neque neque consectetuer diam, condimentum convallis ante nisi sed dui. Mauris lorem tortor, scelerisque a, adipiscing in, scelerisque id, lectus.)",8,20);
    txa.setLineWrap(true);
    //txa.setBorder(new LineBorder(Color.GRAY));    
    add(txa);
   
    
    
    
    bold=new JCheckBox("Pogrubiony");
    add(bold);
    
    ActionListener bolduj=new Bolduj();
    bold.addActionListener(bolduj);   
    
    
    JLabel ofoncik=new JLabel("Rozmiar czcionki");
    ofoncik.setFont(new Font("Dialog",Font.BOLD,20));
    add(ofoncik);
    foncik=new JComboBox(new String[]{"10","12","14","18","22","26"});
    add(foncik);
        
    ActionListener resizuj=new Resizuj();
    foncik.addActionListener(resizuj);  
    
    
    
 
     
    
  }

   

class Bolduj implements ActionListener   
  {
    public void actionPerformed(ActionEvent zdarzenie) // wykryj zdarzenie - klikni?cie
    {
      Font f=txa.getFont();
      if(bold.isSelected())
      txa.setFont(new Font(f.getName(),Font.BOLD,f.getSize()));
      else
      txa.setFont(new Font(f.getName(),Font.PLAIN,f.getSize()));  
    }
  }


class Resizuj implements ActionListener   
  {
    public void actionPerformed(ActionEvent zdarzenie) // wykryj zdarzenie - klikni?cie
    {
      Font f=txa.getFont();
      
      Object cos=foncik.getSelectedItem();
      int rozmiar=Integer.valueOf(cos.toString());
      
      txa.setFont(new Font(f.getName(),f.getStyle(),rozmiar));
     
      
    }
  }
}

