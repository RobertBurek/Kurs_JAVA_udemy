import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Robert Burek
 */
public class FileZipper extends JFrame {
    private JList lista = new JList();
    private JButton bDodaj;
    private JButton bUsun;
    private JButton bZip;
    private JButton bWyczysc;
    private JMenuBar pasekMenu = new JMenuBar();

    public static void main(String[] args) {
        new FileZipper().setVisible(true);
    }

    public FileZipper() {
        this.setTitle("Zipper");
        this.setBounds(375, 300, 650, 450);
        this.setJMenuBar(pasekMenu);

        JMenu menuPlik = pasekMenu.add(new JMenu("Plik"));
        JMenu menuOMnie = pasekMenu.add(new JMenu("O mnie"));

        Action akcjaDodawania = new Akcja("Dodaj", "Dodaj nowy wpis do archiwum", "ctrl D", new ImageIcon("dodaj.png"));
        Action akcjaUsuwania = new Akcja("Usuń", "Usuń zaznaczony/zaznaczone wpisy z archiwum", "ctrl U", new ImageIcon("usun.png"));
        Action akcjaZipowania = new Akcja("Zip", "Zipuj", "ctrl Z");
        Action akcjaOMnie = new Akcja("O mnie", "Informacje o autorze", "ctrl O");
        Action akcjaWyczysc = new Akcja("Wyczyść", "Czyszczenie listy", "ctrl C");

        JMenuItem menuOtworz = menuPlik.add(akcjaDodawania);
        JMenuItem menuUsun = menuPlik.add(akcjaUsuwania);
        JMenuItem menuZip = menuPlik.add(akcjaZipowania);
        JMenuItem menuNic = menuPlik.add("-----------------------");
        menuNic.setEnabled(false);
        JMenuItem menuWyczysc = menuPlik.add(akcjaWyczysc);

        JMenuItem menuInfoOMnie = menuOMnie.add(akcjaOMnie);

        bDodaj = new JButton(akcjaDodawania);
        bUsun = new JButton(akcjaUsuwania);
        bZip = new JButton(akcjaZipowania);

        lista.setBorder(BorderFactory.createEtchedBorder());
        GroupLayout layout = new GroupLayout(this.getContentPane());

        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(lista, 200, 250, Short.MAX_VALUE)
                        .addContainerGap(0, 20)
                        .addGroup(
                                layout.createParallelGroup()
                                        .addComponent(bDodaj)
                                        .addComponent(bUsun)
                                        .addComponent(bZip)
                        )
        );

        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addComponent(lista, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addComponent(bDodaj)
                                        .addComponent(bUsun)
                                        .addGap(5, 40, Short.MAX_VALUE)
                                        .addComponent(bZip))
        );

        this.getContentPane().setLayout(layout);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pack();
    }


    private class Akcja extends AbstractAction {
        public Akcja(String nazwa, String opis, String klawiaturowySkrot) {
            this.putValue(Action.NAME, nazwa);
            this.putValue(Action.SHORT_DESCRIPTION, opis);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(klawiaturowySkrot));
        }

        public Akcja(String nazwa, String opis, String klawiaturowySkrot, Icon ikona) {
            this(nazwa, opis, klawiaturowySkrot);
            this.putValue(Action.SMALL_ICON, ikona);
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Dodaj"))
                System.out.println("Dodawanie");
            else if (e.getActionCommand().equals("Usuń"))
                System.out.println("Usuwanie");
            else if (e.getActionCommand().equals("Zip"))
                System.out.println("Zipowanie");
            else if (e.getActionCommand().equals("O mnie"))
                System.out.println("Robert Burek");
            else if (e.getActionCommand().equals("Wyczyść"))
                System.out.println("Czyszczę listę");
        }

    }
}

