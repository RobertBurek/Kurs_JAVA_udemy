package butelka;

public class Butelka {
  private double ileLitrow;
  private double maxIlosc;
  
   
   Butelka(double ileLitrow, double maxIlosc)
   {
      if (ileLitrow>maxIlosc)
         ileLitrow = maxIlosc;
      
     
          this.ileLitrow = ileLitrow;
          this.maxIlosc = maxIlosc;
     
   }
   
   double getIleLitrow()
   {
      return ileLitrow;
   }
   double getMaxIlosc()
   {
      return maxIlosc;
   }
   
   void wlej(double ilosc){
      if ((this.ileLitrow +=ilosc)>this.maxIlosc)
      {
         double zaduzo = this.ileLitrow - this.maxIlosc;
         System.out.println("Wylałeś " + zaduzo + "L !!!");
         this.ileLitrow = this.maxIlosc;
      }
   }
   boolean wylej(double ilosc){
      if (ilosc <= this.ileLitrow)
         this.ileLitrow -=ilosc;
      else
         return false;
      
      return true;
   }
   void przelej(double ilosc, Butelka doKtorej){
//      this.ileLitrow -= ilosc;
//      doKtorej.ileLitrow +=ilosc;
        if (this.wylej(ilosc))
         doKtorej.wlej(ilosc);
         else System.out.println("Nie ma " + ilosc + "L w tej butelce.");
   }

   public static void main(String[] args) {
      Butelka[] butla = new Butelka[3];
      
      butla[0] = new Butelka(5,8);
      butla[1] = new Butelka(10,13);
      butla[2] = new Butelka(15,18);
//      for(int i=0; i<3; i++)
//         System.out.println(butla[i].getIleLitrow());
   //   butla[0].wlej(17);
   //     butla[2].wylej(16);
  //    butla[1].przelej(3, butla[0]);
      butla[0].przelej(3, butla[1]);
      for(Butelka kolejna: butla)
      {
         System.out.print("Zawartość : "+kolejna.getIleLitrow());
         System.out.println("   Max ilość : "+kolejna.getMaxIlosc());
      }
   }
   
}
