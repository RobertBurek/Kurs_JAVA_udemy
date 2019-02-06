
package spinermoj;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.*;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;

public class SpinerMoj extends JFrame
{  
   
    public SpinerMoj()
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
      this.setTitle("Spiner mój"); 
      
      String[] miesiace = new DateFormatSymbols().getMonths();
      MySpinnerListModel modelMiesiace = new MySpinnerListModel(skrocArray(miesiace,5));
      SpinnerNumberModel modelLiczb = new SpinnerNumberModel(1, 1, 5, 2);
      
      Calendar kalendarz = Calendar.getInstance();
      Date poczatek = kalendarz.getTime();
      kalendarz.add(Calendar.DAY_OF_MONTH, -20);
      Date minimum = kalendarz.getTime();
      kalendarz.add(Calendar.DAY_OF_MONTH, 40);
      Date maximum = kalendarz.getTime();   


               
           
      
      SpinnerDateModel modelDat = new SpinnerDateModel(poczatek, minimum, maximum, Calendar.DAY_OF_MONTH);
      JSpinner spinner1 = new JSpinner(modelMiesiace);
      JSpinner spinner2 = new JSpinner(modelLiczb);
      JSpinner spinner3 = new JSpinner(modelDat);
      this.getContentPane().add(spinner1);
      JPanel panel = new JPanel();
      panel.add(spinner1);
      panel.add(spinner2);
      panel.add(spinner3);
      this.getContentPane().add(panel, BorderLayout.NORTH);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
    private class MySpinnerListModel extends SpinnerListModel 
    {
       Object fristValue, lastValue;
       public MySpinnerListModel (Object[] values)
       {
          super(values);
          fristValue = values[0];
          lastValue = values[values.length-1];
          
       }
       @Override
       public Object getNextValue()
       {
          if (super.getNextValue() == null)
             return fristValue;
          else
          return super.getNextValue();
       }
       @Override
       public Object getPreviousValue()
       {
          if (super.getPreviousValue() == null)
             return lastValue;
          else
          return super.getPreviousValue();
       }
    }
  // Object[] tmp; 
   private Object[] skrocArray(Object[] nazwa, int ileznakow)
   {
      ileznakow = ileznakow>nazwa.length? nazwa.length-ileznakow:ileznakow;
      ileznakow = ileznakow<0? 0:ileznakow;
      
      Object[] tmp = new Object[nazwa.length-ileznakow];
      for(int i=0; i<nazwa.length-ileznakow; i++)
         tmp[i] = nazwa[i];
      
        return tmp; 
   }
    private Object[] modyfikujArray(Object[] nazwa, int poczatek, int koniec)
    {
       koniec = koniec>nazwa.length-1 || koniec<0?nazwa.length:koniec;
        poczatek = poczatek<0 || poczatek > koniec? 0:poczatek;
        poczatek = poczatek>nazwa.length?nazwa.length:poczatek;
       Object[] tmp = new Object[nazwa.length+poczatek-koniec];
       int j = 0;

     for (int i = 0; i < nazwa.length; i++)
     {
        
     //   poczatek = poczatek>
        if (!((i >= poczatek)&&(i < koniec))){
       tmp[j] = nazwa[i];
      System.out.println(i+" - " +j+"   "+nazwa[j]);
      j++;}
        
     }    
    for (int i = 0; i < tmp.length; i++)
          System.out.println(i + "  "+tmp[i]);

       return tmp;
    }
         
    public static void main(String[] args) 
    {
        new SpinerMoj().setVisible(true);
    }
    
}
