
package tokenizacjamoja;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.StringTokenizer;
//import java.util.*;

public class Towar
{
   private double cena;
   private String nazwa;
   private Date dataWydania;

   public Towar()
   {
      this.cena = 0.0;
      this.nazwa = " ";
      this.dataWydania = new GregorianCalendar().getTime();
   }
   
   public Towar(double cena, String nazwa)
   {
      this();
      this.cena = cena;
      this.nazwa = nazwa;
   }
   public static int nr = 0;
   public Towar(double cena, String nazwa, int rr, int mm, int dd)
   {
      this(cena, nazwa);
      GregorianCalendar nowaDataWydania = new GregorianCalendar(rr, mm-1,dd);
      dataWydania = nowaDataWydania.getTime();
      System.out.println(dataWydania +"  "+ (nr));
   }
   
   public double getCena()
   {
      return this.cena;
   }
   public String getNazwa()
   {
      return this.nazwa;
   }
   public Date getDataWydania()
   {
      return this.dataWydania;
   }
   
   public void setCena(double cena)
   {
      this.cena = cena;
   }
   
   public void setNazwa(String nazwa)
   {
      this.nazwa = nazwa;
   }
   
   public void setDataWydania(int rr,int mm,int dd)
   {
      GregorianCalendar nowaDataWydania = new GregorianCalendar(rr, mm,dd);
      dataWydania = nowaDataWydania.getTime();
      this.dataWydania = dataWydania;
      System.out.println(dataWydania);
   }
   
   public void setDataWydania(Date data)
   {
      this.dataWydania = data;
   }
   
   @Override
   public String toString()
   {
      GregorianCalendar kalendarz = new GregorianCalendar();
      kalendarz.setTime(this.dataWydania);
      return this.cena+" zł; nazwa: "+this.nazwa+"   data wydania: "+kalendarz.get(Calendar.YEAR)+"."+(kalendarz.get(Calendar.MONTH)+1)+"."+kalendarz.get(Calendar.DAY_OF_MONTH);
   }
   
   public static void zapiszDoPliku(Towar[] towar, PrintWriter outS)
   {
      outS.println(towar.length);
      GregorianCalendar tmpKalendarz = new GregorianCalendar();
      for (int i = 0; i < towar.length; i++)
      {
         tmpKalendarz.setTime(towar[i].getDataWydania());
         outS.println(towar[i].getCena() + "|" + towar[i].getNazwa() + "|" + tmpKalendarz.get(Calendar.YEAR) + "|" + (tmpKalendarz.get(Calendar.MONTH)+1) + "|" + tmpKalendarz.get(Calendar.DAY_OF_MONTH));
         
      }
   }
   
   public static Towar[] odczytajZPliku(BufferedReader inS) throws IOException
   {
      int dl = Integer.parseInt(inS.readLine());
      Towar[] towar = new Towar[dl];
      for (int i = 0; i < dl; i++)
      {
         String linia = inS.readLine();
         StringTokenizer tokeny = new StringTokenizer(linia, "|");
         
         double cena = Double.parseDouble(tokeny.nextToken());
         String nazwa = tokeny.nextToken();
         int rr = Integer.parseInt(tokeny.nextToken());
         int mm = Integer.parseInt(tokeny.nextToken());
         int dd = Integer.parseInt(tokeny.nextToken());
         towar[i] = new Towar(cena, nazwa, rr, mm, dd);
        nr++;
      }
      return towar;
   }
    
      
           
   
}
