package butelka;

import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Butelka {
    private double ileLitrow;

    Butelka(double ileLitrow)
    {
        this.ileLitrow = ileLitrow;
    }
    
    double getIleLitrow()
    {
        return ileLitrow;
    }
    void wlej(double ilosc)
    {
        this.ileLitrow += ilosc;
    }
    void wylej(double ilosc) throws Exception
    {
        if (ilosc < ileLitrow)
            this.ileLitrow -= ilosc;
        else
            throw new Exception("Nie ma tyle w butelce, zmień ilość.");
        
       
    }
    
    void przelej(double ilosc, Butelka gdziePrzelac) throws Exception
    {
        this.wylej(ilosc);
        gdziePrzelac.wlej(ilosc);
    
    }
    

    public static void main(String[] args) {
       
       Object obj = new Person();
         ((Person)obj).sample();
       
        Butelka[] butla = new Butelka[3]; //NULL
        
        butla[0] = new Butelka(5);
        butla[1] = new Butelka(8);
        butla[2] = new Butelka(10);
        
     //   butla[0].wlej(4);
        
       try {
          butla[0].przelej(4, butla[1]);
       } catch (Exception ex) {
          System.out.println(ex.getMessage());
       }
        
        System.out.println(butla[0].getIleLitrow());
        System.out.println(butla[1].getIleLitrow());
        System.out.println(butla[2].getIleLitrow());
        
    }

}


class Person 
{
  void sample()
  {
    System.out.println("i'm working");
  }
}
