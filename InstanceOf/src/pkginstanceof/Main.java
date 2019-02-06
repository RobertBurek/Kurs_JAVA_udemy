package pkginstanceof;



public class Main {

    public static void main(String[] args) 
    {
         Osoba[] osoby = new Osoba[4]; 
         osoby[0] = new Pracownik("Arkadiusz", "Włodarczyk", 1000000);
         osoby[1] = new Student("Alusia", "Matikusa");
         osoby[2] =  new Pracownik("Arek", "Włodyk", 500000);
         osoby[3] = new Pracownik("Arek", "Włodyk", 3000);
        if ((osoby[2].toString()).equals((osoby[3].toString()))) 
      //  if ((osoby[2].toString()) == (osoby[3].toString()))
           System.out.println(osoby[2]+"!");
                   else
           System.out.println(osoby[0]+"!");
       for (int i=0; i < osoby.length; i++)
          System.out.println(osoby[i]);

         // for (Osoba person: osoby)
         {
           //  if (person instanceof Osoba){
          //      System.out.println(person);
               // person.pobierzOpis();
               // ((Pracownik)person).pobierzOpis();
             }
            // else
               //  break;
         }
    }
    

abstract class Osoba
{
    String imie;
    String nazwisko;
    
    Osoba(String imie, String nazwisko)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
    abstract void pobierzOpis();
}

class Pracownik extends Osoba
{
    double wynagrodzenie;
 
    Pracownik(String imie, String nazwisko, double wynagrodzenie)
    {
        super(imie, nazwisko);
        this.wynagrodzenie = wynagrodzenie;
    }

    @Override
    void pobierzOpis()
    {
        System.out.println("--------------------------");
        System.out.println("Jestem pracownikiem");
        System.out.println("Imię:" + imie);
        System.out.println("Nazwisko:" + nazwisko);
        System.out.println("Wynagrodzenie:" + wynagrodzenie);
        //System.out.println("--------------------------");
    }
    void czyPracuje(){
       System.out.println("TAK - pracuje");
    }
   public String toString() {
        return nazwisko+" "+imie;
    }
}

class Student extends Osoba
{
    Student(String imie, String nazwisko)
    {
        super(imie, nazwisko);
    }  
    @Override
    void pobierzOpis()
    {
        System.out.println("Jestem studentem");
        System.out.println("Imię:" + imie);
        System.out.println("Nazwisko:" + nazwisko);
       
    }  
    public String toString() {
        return nazwisko+" "+imie;
    }
}