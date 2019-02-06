package akcje;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame
{
    public Main()
    {
        initComponents();
    }
    public void initComponents()
    {
        this.setTitle("Działania");
        this.setBounds(300, 300, 300, 200);
        this.setJMenuBar(pasekMenu);
        
        JMenu menuPlik = pasekMenu.add(new JMenu("Plik"));
        menuPlik.setMnemonic('P');
        

        
        JMenuItem podMenuNowy = menuPlik.add(new JMenuItem("Nowy"));
        podMenuNowy.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.out.println("Tu jest kod, który tworzy nowy plik");
            }
        });
        menuPlik.addSeparator();
         //  
        final Action actionSave = new ActionSave("Zapisz", "Zapisuje na dysku", "ctrl S", new ImageIcon("zapis.gif"), KeyEvent.VK_Z);        
        final JMenuItem podMenuZapisz = menuPlik.add(actionSave);
        buttonZapisz = new JButton(actionSave);
    
        actionSave.setEnabled(false);
        /*
        podMenuZapisz.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                System.out.println("ZAPISUJEMY NA DYSKU");
                
                podMenuZapisz.setEnabled(flagaObszaruTekstowe=false);
            }
        });
        
        podMenuZapisz.setToolTipText("Zapisanie pliku na dysku");
        podMenuZapisz.setMnemonic('Z');
        podMenuZapisz.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
        //podMenuZapisz.setAccelerator(KeyStroke.getKeyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK)));
        //
         * */
        menuPlik.add(new JMenuItem("Wczytaj"));
        menuPlik.addSeparator();
        JMenu menuOpcje = new JMenu("Opcje");
        menuPlik.add(menuOpcje);
        
        menuOpcje.add(new JMenuItem("Opcja 1"));
        menuOpcje.add(new JMenuItem("Opcja 2"));
        menuOpcje.add(tylkoDoOdczytu);
        
        tylkoDoOdczytu.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
               if (tylkoDoOdczytu.isSelected())
                   actionSave.setEnabled(false);
               else 
                   actionSave.setEnabled(flagaObszaruTekstowe);
            }
        });
        
        JMenu menuPomoc = pasekMenu.add(new JMenu("Pomoc"));
        
        menuPomoc.add(new JMenuItem("FAQ"));
        
        obszarTekstowy.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) 
            {
                if (tylkoDoOdczytu.isSelected())
                    e.consume();
            }


            public void keyPressed(KeyEvent e) 
            {
                if (tylkoDoOdczytu.isSelected())
                    e.consume();
                else if (!(obszarTekstowy.getText()+e.getKeyChar()).equals(przedZmianaObszaruTekstowego) && czyToAscii(e.getKeyChar()))
                {
                    przedZmianaObszaruTekstowego = obszarTekstowy.getText()+e.getKeyChar();
                    actionSave.setEnabled(flagaObszaruTekstowe=true);
                    
                }
            }
        
        });
      
        
        this.getContentPane().setLayout(new GridLayout(2, 1));
        
        this.getContentPane().add(obszarTekstowy);
        this.getContentPane().add(buttonZapisz);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    private JMenuBar pasekMenu = new JMenuBar();
    private JCheckBoxMenuItem tylkoDoOdczytu = new JCheckBoxMenuItem("Tylko do odczytu");
    private JRadioButtonMenuItem radio;
    private JTextArea obszarTekstowy = new JTextArea();
    private boolean flagaObszaruTekstowe = false;
    private String przedZmianaObszaruTekstowego = "";
    private JButton buttonZapisz;
    
    
    private class ActionSave extends AbstractAction
    {
        public ActionSave(String nazwa, String podpowiedz, String klawiaturySkrot, Icon ikona, int mnemonickKey)
        {
            this.putValue(Action.NAME, nazwa);
            this.putValue(Action.SHORT_DESCRIPTION, podpowiedz);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(klawiaturySkrot));
            this.putValue(Action.SMALL_ICON, ikona);
            this.putValue(Action.MNEMONIC_KEY, mnemonickKey);
        }
        public void actionPerformed(ActionEvent e) 
        {
            System.out.println("ZAPISUJEMY NA DYSKU");

            this.setEnabled(flagaObszaruTekstowe=false);           
        }
        
    }
    private boolean czyToAscii(char zn)
    {
        for (int i = 0; i < 255; i++)
            if (zn == i)
                return true;
        
        return false;
    }
    public static void main(String[] args)
    {
        new Main().setVisible(true);
    }
    

}

