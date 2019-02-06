/*
 * Napisane 12.2018 pierwsze kroki pisanie w JAVA. 
 */
package dziedziczenia.potwory;

/**
 *
 * @author DELL
 */
public class Zombie extends Potwor
{
   public double zapach;
   public String typBroni;
   
   public Zombie()
   {
      
   }
   
   public Zombie(double predkoscChodzenia, double zywotnosc, double zapach, String typBroni) 
   {
      super(predkoscChodzenia, zywotnosc);
      this.typBroni = typBroni;
      this.zapach = zapach;
      System.out.println("konstruktor Domyślny ZOMBIE");
   }
  
   
}
