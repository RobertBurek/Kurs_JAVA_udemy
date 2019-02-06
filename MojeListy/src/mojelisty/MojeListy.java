
package mojelisty;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MojeListy extends JFrame
{  
   
    public MojeListy()
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
      this.setSize(550, 375);
      this.setTitle("Listy");
      String[] nazwa = new String[] {"el1","el2","msdmdsmmd"};      

//      listaPrzedmiotow.setVisibleRowCount(10);
//      listaPrzedmiotow.setPrototypeCellValue("mmmmmmmmmmmmm");
////      listaPrzedmiotow.setFixedCellHeight(20);
////      listaPrzedmiotow.setFixedCellWidth(110);
//      listaPrzedmiotow.setBackground(Color.yellow);
//      listaPrzedmiotow.setSelectionBackground(Color.blue);
//      listaPrzedmiotow.setSelectionForeground(Color.white);
////      listaPrzedmiotow.setLayoutOrientation(JList.HORIZONTAL_WRAP);
//      listaPrzedmiotow.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//   
//      listaPrzedmiotow.addListSelectionListener(new ListSelectionListener()
//      {
//         @Override
//         public void valueChanged(ListSelectionEvent e)
//         {
//            System.out.println(((JList)e.getSource()).getSelectedValue());
//            if (e.getValueIsAdjusting())
//               System.out.println("Trzymam przycisk myszki");
//            else
//               System.out.println("Póściłem przycisk myszki");
//            
//            if (!e.getValueIsAdjusting())
//            {
//              // e.getSource()
//               komunikat.setText(((JList)e.getSource()).getSelectedValuesList().toString());
//            //   Object wartosciListy = ((JList)e.getSource()).getSelectedValuesList();
//                              String przedmioty = "";
////                  int size = ((JList)e.getSource()).getSelectedValuesList().getSize();
////                  int size1 = listaPrzedmiotow.getSize();
//          //     przedmioty = ((JList)e.getSource()).getSelectedValuesList().get(3).toString();
////               for (int i=0; i<wartosciListy.length; i++)
////                  przedmioty +=(String)wartosciListy[i]+" ";
////               System.out.println(przedmioty);
////              Object[] ggg = listaPrzedmiotow.getModel();
////               przedmiot = listData[1];
//               System.out.println(komunikat);
//           //    JList wartosciListy = new ((JList)e.getSource()).getSelectedValuesList();
//            }
//         }
//      });
      
      DefaultListModel nowaLista = new DefaultListModel();
      String[] kilkaNowych = new String[] {"Matematyka","Polski","Fizyka","Informatyka","Histora","Matematyka","Polski","Fizyka","Informatyka","Histora","Matematyka","Polski","Fizyka","Informatyka","Histora"};
      for (int i = 0; i < kilkaNowych.length; i++)
      {
         nowaLista.addElement(kilkaNowych[i]);
         System.out.println(i + " "+kilkaNowych[i]);
      }
      nowaLista.addElement("J.Angielski");
      nowaLista.addElement("J.Polski");
      nowaLista.addElement("J.Niemiecki");
      
      
      listaPrzedmiotow = new JList(nowaLista);
      
      scrollListy = new JScrollPane(listaPrzedmiotow);
      
    //  listaPrzedmiotow = nowaLista;
      
      panelListy.add(scrollListy);
      panelKomunikat.add(komunikat);
    //-------------------------------------------------
      listaPrzedmiotow.setVisibleRowCount(10);
      listaPrzedmiotow.setPrototypeCellValue("mmmmmmmmmmmmm");
//      listaPrzedmiotow.setFixedCellHeight(20);
//      listaPrzedmiotow.setFixedCellWidth(110);
      listaPrzedmiotow.setBackground(Color.yellow);
      listaPrzedmiotow.setSelectionBackground(Color.blue);
      listaPrzedmiotow.setSelectionForeground(Color.white);
//      listaPrzedmiotow.setLayoutOrientation(JList.HORIZONTAL_WRAP);
      listaPrzedmiotow.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
           listaPrzedmiotow.addListSelectionListener(new ListSelectionListener()
      {
         @Override
         public void valueChanged(ListSelectionEvent e)
         {
            System.out.println(((JList)e.getSource()).getSelectedValue());
            if (e.getValueIsAdjusting())
               System.out.println("Trzymam przycisk myszki");
            else
               System.out.println("Póściłem przycisk myszki");
            
            if (!e.getValueIsAdjusting())
            {
              // e.getSource()
               komunikat.setText(((JList)e.getSource()).getSelectedValuesList().toString());
            //   Object wartosciListy = ((JList)e.getSource()).getSelectedValuesList();
                              String przedmioty = "";
//                  int size = ((JList)e.getSource()).getSelectedValuesList().getSize();
//                  int size1 = listaPrzedmiotow.getSize();
          //     przedmioty = ((JList)e.getSource()).getSelectedValuesList().get(3).toString();
//               for (int i=0; i<wartosciListy.length; i++)
//                  przedmioty +=(String)wartosciListy[i]+" ";
//               System.out.println(przedmioty);
//              Object[] ggg = listaPrzedmiotow.getModel();
//               przedmiot = listData[1];
               System.out.println(komunikat);
           //    JList wartosciListy = new ((JList)e.getSource()).getSelectedValuesList();
            }
         }
      });
   //-------------------------------------------------------
      this.getContentPane().add(panelListy, BorderLayout.NORTH);
   //   this.getContentPane().add(panelListy, BorderLayout.NORTH);
      this.getContentPane().add(panelKomunikat, BorderLayout.CENTER);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
   private JList listaPrzedmiotow = new JList();
           //new String[] {"Matematyka","Polski","Fizyka","Informatyka","Histora","Matematyka","Polski","Fizyka","Informatyka","Histora","Matematyka","Polski","Fizyka","Informatyka","Histora"});
   private JPanel panelListy = new JPanel();
   private JPanel panelKomunikat = new JPanel();
   private static JLabel komunikat = new JLabel("Nie lubię: ");
   private JScrollPane scrollListy = new JScrollPane();
   
   
        
    public static void main(String[] args) 
    {
        new MojeListy().setVisible(true);
        
        
    }
    
}
