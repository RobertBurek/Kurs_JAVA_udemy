
package mojemenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MojeMenu extends JFrame
{
   public MojeMenu()
   {
        initComponents();
   }
    
    public void initComponents()
      {
        this.setTitle("Moje pierwsze MENU");
        this.setBounds(300, 300, 800, 600);
        
        panelMenu.setLayout(new GridLayout(3, 1));
        panelMenu.add(menu1);
        panelMenu.add(menu2);
        panelMenu.add(menu3);
        
        
        kontener.add(panelMenu);
        this.setDefaultCloseOperation(3);
      }

    private Container kontener = this.getContentPane();
    private JPanel panelMenu = new JPanel();
    private MenuButton menu1 = new MenuButton("1. Dodaj");
    private MenuButton menu2 = new MenuButton("2. Usuń");
    private MenuButton menu3 = new MenuButton("3. Zmień");
    int i = 0;
    
    
    
    private class MenuButton extends JButton implements FocusListener, ActionListener
    {
      private Color kFocusGained = (Color.RED);
      private Color kFocusLost = (Color.BLUE);
      
       
       public MenuButton(String nazwa)
       {
          super(nazwa);
          this.addFocusListener(this);
          this.addActionListener(this);
          this.addKeyListener(new KeyAdapter() 
          {
             @Override
             public void keyPressed(KeyEvent e) 
             {
               keyPressedHandler(e); 
             }
          });
          this.setBackground(kFocusLost);
       }
       
       private void keyPressedHandler(KeyEvent e)
       {
          int dlMenu = panelMenu.getComponentCount();
          
          if (i==0) i = 10*dlMenu;
          if (e.getKeyCode() == KeyEvent.VK_DOWN)
          {
            // ++i;
             panelMenu.getComponent(++i%dlMenu).requestFocus();
          }
          else if (e.getKeyCode() == KeyEvent.VK_UP)
          {
            // --i;
             panelMenu.getComponent(--i%dlMenu).requestFocus();
          }
          else if (e.getKeyCode() == KeyEvent.VK_ENTER)
          {
             ((MenuButton)e.getSource()).doClick();
 // Inny sposób            
//            MenuButton temp = (MenuButton)e.getSource();
//            temp.doClick();
          }
       }

      @Override
      public void focusGained(FocusEvent e) 
      {
         this.setBackground(kFocusGained);
      }

      @Override
      public void focusLost(FocusEvent e) 
      {
          this.setBackground(kFocusLost);
      }

      @Override
      public void actionPerformed(ActionEvent e) 
      {
//         System.out.println("Zrobione  -  " + e);
         JOptionPane.showMessageDialog(this, ((MenuButton)e.getSource()).getText());
      }
      
    }
    
    public static void main(String[] args) 
   {
         new MojeMenu().setVisible(true);
   }
   
}
