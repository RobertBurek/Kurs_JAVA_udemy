
package pliki;
import java.util.Scanner;
/**
 *
 * @author DELL
 */
  

public class PLIKI{
  public static void main(String[] args){
	  int tab[] = {1,2,3,4,5};
	  Scanner odczyt = new Scanner(System.in);
	  int index = -1;

	  System.out.println("Podaj indeks tablicy, który chcesz zobaczyć: ");
	  index = odczyt.nextInt();

	  if(index>=0 && index<tab.length)
		  System.out.println(tab[index]);
	  else
		  System.out.println("Niepoprawna wartość, rozmiar tablicy to: "+tab.length);
  }
}

