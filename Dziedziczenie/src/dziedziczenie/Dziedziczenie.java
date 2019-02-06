
package dziedziczenie;
class Figura{
      int bok_a;
      int bok_b;      
   Figura(int a, int b){
      this.bok_a = a;
      this.bok_b = b;
   }
   }
   class Trojkat extends Figura{
      int bok_c;   
   Trojkat(int a, int b, int c){
      super(a , b);
      this.bok_c = c;
   }
   }
public class Dziedziczenie {

   public static void main(String[] args) {
         Figura obiekt1 = new Figura(43, 56);
         //obiekt1(23,45);
         System.out.println(obiekt1.bok_a);
         System.out.println(obiekt1.bok_b);
            Figura ob2 = obiekt1;
          System.out.println(ob2.bok_a);
         System.out.println(ob2.bok_b);  
         ob2.bok_a=22;
         ob2.bok_b=33;
         System.out.println(obiekt1.bok_a);
         System.out.println(obiekt1.bok_b);
         
   }
   
}
