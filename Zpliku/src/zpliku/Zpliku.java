/*
 * Napisane 01.2019 pierwsze kroki pisanie w JAVA. 
 */
package zpliku;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


/**
 *
 * @author Robert
 */

public class Zpliku {
   
  static String[][] readFile(String file) throws IOException
   {
    String[][] array = new String[1000][2];
    try{
    Scanner data = new Scanner(new File("C:\\Users\\DELL\\Documents\\NetBeansProjects\\Zpliku\\"+file));
    
    int i = 0;
    while (data.hasNextLine()){
        array[i][0] = data.next();
        array[i][1] = data.next();
        System.out.println(array[i][0]+" - "+array[i][1]);
        i++;
    } 
    data.close();
    } catch (IOException ex) {
		  System.out.println("Niepoprawny parametr, rozmiar tablicy to: "+ex.getMessage());
	  }
    return array; 
}

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
     try {
        readFile("test.txt");
     }catch(IOException ex){
        System.out.println("Niepoprawny rozmiar tablicy: "+ex.getMessage());
     }
        
//      int i = 0;
//    while (i>5){
//        System.out.println(array[i][0]+" - "+array[i][1]); 
//        i++;
//    }
     
   }
   
}
