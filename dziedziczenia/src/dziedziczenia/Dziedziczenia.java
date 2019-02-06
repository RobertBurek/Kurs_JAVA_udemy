
package dziedziczenia;

import dziedziczenia.potwory.Potwor;
import dziedziczenia.potwory.Szkielet;
import dziedziczenia.potwory.Zombie;

public class Dziedziczenia {

  
   public static void main(String[] args) 
   {
      Potwor p = new Szkielet();
      p.atakuj();
      Potwor p2 = new Zombie();
      System.out.println(p2.getClass());
//      System.out.println(p.predkoscChodzenia);
//
//      Szkielet s = new Szkielet(20, 50, "ŁUK");
//      System.out.println(s.predkoscChodzenia);
//      System.out.println(s.typBroni);
//      s.atakuj();
//      Zombie z = new Zombie(30, 60, 35, "MACZUGA");
//      System.out.println(z.zapach);
//      System.out.println(z.typBroni);
   }
   
   
}
