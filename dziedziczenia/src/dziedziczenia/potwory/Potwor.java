/*
 * Napisane 12.2018 pierwsze kroki pisanie w JAVA. 
 */
package dziedziczenia.potwory;

/**
 *
 * @author DELL
 */
public class Potwor {
   public double predkoscChodzenia;
   public double zywotnosc;
   
   public void atakuj()
   {
      System.out.println("Metoda atakuj w klasie POTWOR w pakiecie DZIEDZICZENIA.POTWORY");
   }
   public Potwor()
   {
      System.out.println("konstruktor domyślny POTWOR");
   }
   public Potwor(double predkoscChodzenia, double zywotnosc)
   {
      this.predkoscChodzenia = predkoscChodzenia;
      this.zywotnosc = zywotnosc;
      System.out.println("konstruktor NIEDomyślny POTWOR");
   }

}
