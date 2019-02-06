
package podzielonepanelemoje;

import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class PodzielonePaneleMoje extends JFrame
{  
   
    public PodzielonePaneleMoje()
    {
         
        initComponents();
         int szer = Toolkit.getDefaultToolkit().getScreenSize().width;
         int wys = Toolkit.getDefaultToolkit().getScreenSize().height;
         int szerR = this.getSize().width;
         int wysR = this.getSize().height;

      
         
         this.setLocation((szer-szerR)/2,(wys-wysR)/2);

    }
    
    public void initComponents()
    {
      this.setSize(850, 675);
      this.setTitle("PodzielonePaneleMoje"); 
      panelListy.add(lista);
      panelObrazka.add(obrazek);
      //panelOpisu.add(opis);
      //panelOpisu.add(listaPlikow);
      scrollPane.setBounds(0, 0, 300, 300);
      panelOpisu.add(scrollPane);
     // panelDodatkowy.add(opis);
      lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      lista.addListSelectionListener(new ListSelectionListener()
      {
         @Override
         public void valueChanged(ListSelectionEvent e)
         {
            //System.out.println("lala");
           //
            if (!e.getValueIsAdjusting())
            {
              Obrazek img = (Obrazek)((JList)e.getSource()).getSelectedValue();
               System.out.println(img.toString());
               obrazek.setIcon(img.getImage());
               opis.setText(img.getDescrition());
               
            }
         }
      });
      
      JSplitPane podzielony = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panelListy,panelObrazka);
      
      JSplitPane podzielonyG = new JSplitPane(JSplitPane.VERTICAL_SPLIT,podzielony,panelOpisu);
     // JSplitPane podzielonyOpis = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,podzielonyG,panelDodatkowy);
       
      this.getContentPane().add(podzielonyG);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
   JPanel panelListy = new JPanel();
   JPanel panelObrazka = new JPanel();
   JPanel panelOpisu = new JPanel();
  // JPanel panelDodatkowy = new JPanel();
   JList lista = new JList(new Obrazek[]{
      new Obrazek("niebieski","Piękny kolorek niebieski"),
      new Obrazek("czerwony","Piękny kolorek czerwony"),
      new Obrazek("zielony","Piękny kolorek zielony")
   });
//           String[]{"dsf","gfg","rry","qew"});
   JLabel obrazek = new JLabel();
   JLabel opis = new JLabel();
     
   private class Obrazek
   {
      private final String nazwa;
      private final String opis;
      private final ImageIcon obrazek;
      
      public Obrazek(String nazwa, String opis)
      {
         this.nazwa = nazwa;
         this.opis = opis;
         obrazek = new ImageIcon(nazwa+".gif");
      }  
      public String toString()
      {
         return nazwa;
      }
      public ImageIcon getImage()
      {
         return obrazek;
      }
      public String getDescrition()
      {
         return opis;
      }
   }
     static        File plik2 = new File("Nowy" + File.separator + "podkatalog1" + File.separator + "podkatalog2","tekst2.txt");
    public static void main(String[] args) 
    {
       try {
          new PodzielonePaneleMoje().setVisible(true);
          
        
          File katalog = new File("Nowy" + File.separator + "podkatalog1" + File.separator + "podkatalog2");
          katalog.mkdirs();
       //   File plik2 = new File("Nowy" + File.separator + "podkatalog1" + File.separator + "podkatalog2","tekst2.txt");
          if (!plik2.exists())
             plik2.createNewFile();
          wszystkieSciezki(new File(System.getProperty("user.dir")));
          File plik = new File("tekst.txt");
          if (!plik.exists())
             plik.createNewFile();
          
          System.out.println("Czy mogę pisać? :"+plik.canWrite());
          System.out.println("Czy mogę odpalić? :"+plik.canExecute());
          System.out.println("Czy mogę czytać? :"+plik.canRead());
          System.out.println("Czy jest ukryty? :"+plik.isHidden());
          System.out.println("Czy jest plikiem? :"+plik.isFile());
          System.out.println("Czy ostatnia modyfikacja? :" + new Date(plik.lastModified()));
          System.out.println("Długość pliku w bajtach 'znaków'? : " + plik.length());
          //plik.delete();
          System.out.println("---------------------------------------");
          System.out.println(plik.getPath());
          System.out.println(plik.getAbsolutePath());
          System.out.println(plik.getCanonicalPath());
          System.out.println("---------------------------------------");
       } catch (IOException ex)
               {
                //  Logger.getLogger(PodzielonePaneleMoje.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println(ex.getMessage());
               }
        System.out.println("1) "+System.getProperty("Operating system version"));
        System.out.println("2) "+System.getProperty("file.separator"));
        System.out.println("3) "+System.getProperty("user.dir"));
        System.out.println("4) "+System.getProperty("os.name"));
        System.out.println("5) "+System.getProperty("user.home"));
        System.out.println("6) "+System.getProperty("java.vm.name"));
        System.out.println("7) "+System.getProperty("java.version"));
        System.out.println("8) "+System.getProperty("java.compiler"));
        System.out.println("9) "+System.getProperty("java.home"));
//        System.out.println("---------------------------------------");
//        System.out.println(plik.getPath());
//        System.out.println("---------------------------------------");
        
        
        
    }
    static public JTextArea listaPlikow = new JTextArea();
    static public JScrollPane scrollPane = new JScrollPane (listaPlikow,
                     JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                     JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    static void wszystkieSciezki (File nazwaSciezki)
    {
       System.out.println("---------------------------------------");
       //System.out.println(nazwaSciezki.getPath());
       System.out.println("Zawartość folderu:");
       String[] listaWszyskiego = nazwaSciezki.list();
//       JScrollPane scrollPane = 
//                     new JScrollPane (listaPlikow,
//                     JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
//                     JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//      listaPlikow.setEditable (false);
       for (int i = 0; i < listaWszyskiego.length; i++)
       {

          File p = new File(nazwaSciezki.getPath(),listaWszyskiego[i]);
                    if (p.isFile())
          {
          System.out.println(p.getPath());
          listaPlikow.setRows(7);
          listaPlikow.setColumns(73);
          listaPlikow.setText(listaPlikow.getText()+nazwaSciezki.getPath()+System.getProperty("file.separator")+listaWszyskiego[i]+"\r\n");
          
           }
             
          if (p.isDirectory())
             wszystkieSciezki(new File(p.getPath()));
         
       }
       System.out.println("---------------------------------------");

    }
    
}
