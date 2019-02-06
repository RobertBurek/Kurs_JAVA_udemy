
package referencje;

public class Referencje {

    public static void main(String[] args) {
       String imie = new String("Robert");
       String imie2 = new String("Robert");
       if (imie.equals(imie2))
          System.out.println("są takie same");
       int a = 5;
        Test x = new Test();
        x.zmienWartosc(a);
        a=x.zmienWartosc(a);
        System.out.println(a);
        Foo ref = new Foo();
        x.zmienZawartosc(ref);
        System.out.println(ref.y);
    }
    
}

class Test
{
    int zmienWartosc( int zm)
    {
        zm = zm + 2;
        return zm;
    }
    void zmienZawartosc(Foo zm) 
    {
        zm.y = zm.y + 40;
    }
}

class Foo
{
    int y = 20;
}