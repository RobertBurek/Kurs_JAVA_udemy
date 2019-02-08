package podzialpanelu;

public class Testowa {
    
      double nn,mm;
  
      void napiszDouble(double mnoznik){
         mnoznik = (nn + mm) * mnoznik;
         System.out.println(mnoznik);
      }
      void napiszString(String tekst2){
       double  mnoznik = (nn + mm);
         System.out.println(tekst2+mnoznik);
         tekst2="Wcale nie!";
      }
      void napiszObject(Testowa cc){
        double  mnoznik = (cc.nn * cc.mm);
         System.out.println(mnoznik);
         cc.nn=1500;
         cc.mm=1700;
      }
   }


//       Testowano zmienne w metodach!!!
//
//      Testowa nic= new Testowa();
//      Testowa nic2= new Testowa();
//      nic.nn=4;
//      nic.mm=1;
//      nic.napiszDouble(2);
//      String tekst = "To jest: ";
//      nic.napiszString(tekst);
//      nic2.nn=10;
//      nic2.mm=20;
//      nic.napiszObject(nic2);
//      System.out.println(nic2.nn+" - "+nic2.mm);

