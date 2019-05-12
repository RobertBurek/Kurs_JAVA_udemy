import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Robert Burek
 */
public class FileZipper extends JFrame {

    private JButton bDodaj;
    private JButton bUsun;
    private JButton bZip;
    private JButton bWyczysc;
    private JMenuBar pasekMenu = new JMenuBar();
    private JFileChooser wybieracz = new JFileChooser();
    private DefaultListModel modelListy = new DefaultListModel() {
        ArrayList lista = new ArrayList();

        @Override
        public void addElement(Object obj) {
            lista.add(obj);
            super.addElement(((File) obj).getName());
        }

        @Override
        public Object get(int index) {
            return lista.get(index);
        }

        @Override
        public Object remove(int index) {
            lista.remove(index);
            return super.remove(index);
        }
    };
    private JList lista = new JList(modelListy);

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

        JScrollPane scrollPane = new JScrollPane(lista);

        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(scrollPane, 200, 250, Short.MAX_VALUE)
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
                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                dodajWpisyDoArchiwum();
            else if (e.getActionCommand().equals("Usuń"))
                usuwanieWpisowZList();
            else if (e.getActionCommand().equals("Zip"))
                System.out.println("Zipowanie");
            else if (e.getActionCommand().equals("O mnie"))
                System.out.println("Robert Burek");
            else if (e.getActionCommand().equals("Wyczyść"))
                System.out.println("Czyszczę listę");
        }

        private void usuwanieWpisowZList() {
            int[] tmp = lista.getSelectedIndices();
            for (int i = 0; i < tmp.length; i++)
                modelListy.remove(tmp[i] - i);
        }

        private void dodajWpisyDoArchiwum() {
            wybieracz.setCurrentDirectory(new File(System.getProperty("user.dir")));
            wybieracz.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            wybieracz.setMultiSelectionEnabled(true);
            int tmp = wybieracz.showDialog(rootPane, "Dodaj do archiwum");
            if (tmp == JFileChooser.APPROVE_OPTION) {
                File[] sciezki = wybieracz.getSelectedFiles();
                for (int i = 0; i < sciezki.length; i++)
                    if (!czyWpisSiePowtarza(sciezki[i].getPath()))
                        modelListy.addElement(sciezki[i]);
            }
        }

        private boolean czyWpisSiePowtarza(String testowanyWpis) {
            for (int i = 0; i < modelListy.getSize(); i++)
                if (((File) modelListy.get(i)).getPath().equals(testowanyWpis))
                    return true;
            return false;
        }
    }
}

