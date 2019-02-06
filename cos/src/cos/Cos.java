/*
 * Napisane 12.2018 pierwsze kroki pisanie w JAVA. 
 */
package cos;
 abstract class Produkty
{
   String rodzaj;
Produkty(String rodzaj)
   {
   this.rodzaj = rodzaj;
   }
   abstract void pokazInformacje();
}

class Kursy extends Produkty
{
   String nazwa;
   int a;
   int b;
   Kursy (String rodzaj, String nazwa, int a, int b)
   {
      super(rodzaj);
      this.nazwa = nazwa;
      this.a = a;
      this.b = b;
   }
   public String toString()
   {
      return getClass().getName()+" "+nazwa;
   }
   void pokazInformacje()
   {
      System.out.println(rodzaj);
      System.out.println(nazwa);
      System.out.println(a);
      System.out.println(b);
   }
}
class Ksiazki extends Produkty
{
   int strony;
   
   Ksiazki(String rodzaj, int strony)
   {
      super(rodzaj);
      this.strony = strony;
   }

   void pokazInformacje() 
   {
      System.out.println(rodzaj);
      System.out.println(strony);
   }
}
class Kurs{}
class Programowanie extends Kurs
{
   
}
class KursJava extends Programowanie{
   final String tytnazwa;
   KursJava(String tytnazwa){
      this.tytnazwa = tytnazwa;
   }
}


public class Cos 
{
   public static void main(String[] args) {
      KursJava j1 = new KursJava(":Kurs JAVA");
      
    //  Produkty p1 = new Produkty("Biurowe","Kurs Excel", 45, 58);
    Kursy kurs1 = new Kursy("Biurowe","Kurs Excel", 45, 58);
    Kursy kurs2 = new Kursy("Biurowe","Kurs Word", 45, 58);
   // System.out.println(kurs1.toString());
   // System.out.println(kurs2.getClass()+" "+kurs2.nazwa);
    System.out.println(kurs1.rodzaj.equals(kurs2.rodzaj));
    if (kurs1.nazwa == null ? kurs2.nazwa == null : kurs1.nazwa.equals(kurs2.nazwa))
         System.out.println("tak");
    System.out.println(kurs1.nazwa.equals(kurs2.nazwa));
   // kurs1.pokazInformacje();
   // kurs2.pokazInformacje();
    Ksiazki ksiazka1 = new Ksiazki("Internetowe", 55);
    ksiazka1.pokazInformacje();
   }
   
}
