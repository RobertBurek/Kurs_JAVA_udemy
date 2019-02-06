/*
 * Napisane 12.2018 pierwsze kroki pisanie w JAVA. 
 */
package dziedziczenia.potwory;

/**
 *
 * @author DELL
 */
public class Szkielet extends Potwor
{
   public String typBroni;
   
   /**
    *
    */
   
   public void atakuj()
   {
      super.atakuj();
      System.out.println("Metoda atakuj w klasie POTWOR w pakiecie DZIEDZICZENIA.SZKIELET");
   }
   
   public Szkielet() 
   {
      System.out.println("konstruktor Domyślny SZKIELET");
   }
   
   public Szkielet(double predkoscChodzenia, double zywotnosc, String typBroni) 
   {
      super(predkoscChodzenia, zywotnosc);
      this.typBroni = typBroni;
      System.out.println("konstruktor NIEdomyślny SZKIELET");
        
   }

  
   
}
