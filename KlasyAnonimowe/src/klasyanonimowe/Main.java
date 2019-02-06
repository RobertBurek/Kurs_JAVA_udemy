package klasyanonimowe;


public class Main {

    public static void main(String[] args) 
    {
        ZachowaniePoWcisnieciu z;
       z = () -> {
          System.out.println("jestem z klasy anonimowej");
       };
        
        MojaLambda mL;
       mL = () -> {
                      System.out.println("LAMBDA 2");
                   };
        mL.dodajCOS();
        
        Przycisk p = new Przycisk();
        p.dodajAkcje(z);
       
//        Przycisk p = new Przycisk();
//        
//        p.dodajAkcje(new ZachowaniePoWcisnieciu() {
//
//            @Override
//            public void akcja() {
//                System.out.println("jestem z klasy anonimowej");
//            }
//        });
        
    }
    
}
interface ZachowaniePoWcisnieciu
{
    void akcja();
}
      
class Przycisk
{

    void dodajAkcje(ZachowaniePoWcisnieciu z)
    {
        z.akcja();
    }
    
}
interface MojaLambda{
  abstract void dodajCOS();
}

/*
    JButton
    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
        {
            // do something.
        }
    });

*/