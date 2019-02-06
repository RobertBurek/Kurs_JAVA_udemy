
package javaapplication1;

/**
 *
 * @author Robert
 */

 import newpackage.Testes;



public class JavaApplication1 {
   
   static int mnozenie (int a, int b){
      return a*b;
   }
   
   
   public static void main(String[] args) {
      //możenie za pomocą wywołania metody static
      System.out.println("metoda static, wynik mnożenia : "+mnozenie(15, 6));
      
      int takaInnaZNowyTest = NowyTest.zmiennaWNowyTest;
    int obcaZmiennaZKlasyTestes = Testes.jakasZmienna;
   //   NowyTest.r = 30;
      int tutaj = NowyTest.r;
      System.out.println(tutaj+"  "+takaInnaZNowyTest);
      System.out.println(" Zmienna z Testes "+obcaZmiennaZKlasyTestes);
   /**
     * @param args the command line arguments
     */
//       String g = "rtgrtgr";
//       int yes=50;
//       switch(yes)
//               {
//                  case 50:
//                  System.out.println("prawda ");
//                     System.out.println("kkk");
//                     if (!(yes==50)) System.out.println("tttt");
//                  break;
//                  case 100:
//                  System.out.println("nie prawda");
//                  break;
//                  default:
//                  System.out.println("nie wiem");
//               }
//       boolean tak = true;
// //      String jakJest = tak == true ? "prawda" : "fałsz";
//       
// //      System.out.println(jakJest);
//       int z = 0;
//       String[] tab;
//       tab = new String [5];
//       tab[0] = "ja";tab[1] = "ty";tab[2] = "on";tab[3] = "my";tab[4] = "oni";
//       System.out.println(tab.length);
//       while (z < tab.length)
//          {
//          System.out.println(tab[z]);
//          z++;
//          }
//       int[] tab2;
//       tab2 = new int [10];
//   //    int i = 0;
//       for (int i = 0; i < 10; i++)
//       {
//       tab2 [i] = 10 * (i +1);   
//     //     System.out.println(i+"  "+tab2[i]);
//      //    i++;
//       }
//             for (int myVaule: tab2)
//               {
//                myVaule += 100;
//                System.out.println(myVaule);
//               }

//       for(int i = 1; i <= 10; i++)
//       {
//          if (i%2==0) continue;
//          for (int j=1; j<=10; j++)
//          {
//             System.out.print(i*j + "  ");
//          }
//          System.out.println(" ");
//       }
      
      Punkt p1 = new Punkt(55,77,"blalakk");
      System.out.println(p1.x);
      System.out.println(p1.y);
      System.out.println(p1.tytul);
      Punkt[] linia = new Punkt[4];
       linia[0]= new Punkt();
       linia[1]= new Punkt(111,11,"ghjggfgf");
       linia[2]= new Punkt(222,22,"hjkhjkhk");
       linia[3]= new Punkt(333,33,"etyrtyre");
       for (Punkt lol: linia){
          System.out.print(lol.tytul);
          System.out.print("---");
          System.out.print(lol.x);
          System.out.print("-------");
          System.out.print(lol.y);
          System.out.println(""); 
              }
       p1.pokazDane("Jakis tam tytuł");
    Test a = new Test(); 
    double wynikPlus= a.dodawanie( 4 , 1 );
    System.out.println(wynikPlus);
   double wynik = a.dzielenie(10,10);
      System.out.println(wynik);
   }
}     
class Test
{
      double dzielenie(double a, double b)
         {
         if (b==0) return 0;
        return a/b;
         }
      int dodawanie(int a, int b)
         {
            return a + b + a;
         }
      double dodawanie(double a, double b)
         {
            return a + b;
         }
}

       class Punkt
       {
          Punkt()
          {
             x=23;
             y=34;
             tytul = "default";
          }
          Punkt(int xx, int yy)
          {
             this.x=x;
             this.y=y;
//             x=xx;
//             y=yy;
          }
          Punkt(String tekst)
          {
        //     this.x=x;
         //    this.y=y;
             tytul=tekst;
          }
          Punkt(int xx, int yy, String tekst)
          {
             x=xx;
             y=yy;
             tytul=tekst+xx+yy;
          }
       int x;
       int y;
       String tytul;
       
       void pokazDane(String pokazTytul){
          System.out.println(pokazTytul);
          
       }
       }
       
    