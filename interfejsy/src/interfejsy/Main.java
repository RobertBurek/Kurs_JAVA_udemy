package interfejsy;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    
    public static void main(String[] args) 
    {

//        System.out.println(nazwaInterfejsu.PI);
//        nazwaInterfejsu a = new Pracownik(10);
//        System.out.println(a.getClass());
//        System.out.println(((Pracownik)a).getWynagrodzenie());
        int[] tab = new int[3];
        
        tab[0] = 3;
        tab[1] = -5;
        tab[2] = 13;
                
         Arrays.sort(tab);
        for(int element: tab)
           System.out.println(element);
        
        Pracownik[] pracownik = new Pracownik[7];
        pracownik[0] = new Pracownik(10000);
        pracownik[1] = new Pracownik(1000);
        pracownik[2] = new Pracownik(5000);
        pracownik[3] = new Pracownik(2000);
        pracownik[4] = new Pracownik(7000);
        pracownik[5] = new Pracownik(3000);
        pracownik[6] = new Pracownik(15000);
     
            
//        System.out.println(pracownik[0].getWynagrodzenie());
//        System.out.println(pracownik[1].getWynagrodzenie());
//        System.out.println(pracownik[2].getWynagrodzenie());
        System.out.println("Przed sortowaniu: ");
        for (Pracownik p: pracownik)
        {
            System.out.println(p.getWynagrodzenie());
        }
     
       
        
     //   System.out.println(pracownik[0].compareTo(pracownik[1]));
        
     //   Arrays.sort(pracownik, 4, 6);
        Arrays.sort(pracownik, Collections.reverseOrder());
        
        System.out.println("Po sortowaniu: ");
        for (Pracownik p: pracownik)
        {
            System.out.println(p.getWynagrodzenie());
        }        
           
        
    }
}
class A
{
   double stanKonta;

   public A(double stanKonta) {
      this.stanKonta = stanKonta;
   }
   
}
class B extends A{
int dd;

   public B(int dd, double stanKonta) {
      super(stanKonta);
      this.dd = dd;
   }

}

interface nazwaInterfejsu
{
    double PI = 3.14; //public static final
    
    void cos(); //public abstract
}
interface cosik
{
    
}

class Pracownik implements nazwaInterfejsu, cosik, Comparable
{

   
    Pracownik(double wynagrodzenie)
    {
        this.wynagrodzenie = wynagrodzenie;
    }
    public double getWynagrodzenie()
    {   
        return wynagrodzenie;
    }
        
   private double wynagrodzenie;

    @Override
    public int compareTo(Object t) 
    {
       Pracownik przyslany = (Pracownik)t;
        
       if (this.wynagrodzenie < przyslany.wynagrodzenie)
        return -1;
       
       
       if (this.wynagrodzenie > przyslany.wynagrodzenie)  
        return 1;
       
       return 0;
    }

   @Override
   public void cos() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

    
}
