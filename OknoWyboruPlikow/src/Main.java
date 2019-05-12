import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Robert Burek
 */
public class Main extends JFrame {
    public Main() {
        this.setTitle("Okno wyboru plików");
        this.setBounds(550, 400, 500, 350);

        final JFileChooser wyborPlikow = new JFileChooser();

        wyborPlikow.setCurrentDirectory(new File(System.getProperty("user.dir")));
        wyborPlikow.setMultiSelectionEnabled(true);

        wyborPlikow.setAcceptAllFileFilterUsed(true);

        wyborPlikow.setFileFilter(new FiltrRozszerzen("Pola tekstowe", ROZSZERZENIA_TEKSTOWE));
        wyborPlikow.setFileFilter(new FiltrRozszerzenPliki("Same pliki"));
        wyborPlikow.setFileFilter(new FileFilter() {

            @Override
            public boolean accept(File f) {
                return f.isDirectory();
            }

            @Override
            public String getDescription() {
                return "Katalogi";
            }
        });
        button1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int tmp = wyborPlikow.showOpenDialog(rootPane);
                if (tmp == 0)
                    stworzPlikZip(wyborPlikow.getSelectedFiles());
            }
        });

        button2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                wyborPlikow.showDialog(rootPane, "ZIP in that place");

            }
        });

        this.panelButtonow.add(button1);
        this.panelButtonow.add(button2);

        this.getContentPane().add(panelButtonow);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel panelButtonow = new JPanel();
    private JButton button1 = new JButton("Otwórz");
    private JButton button2 = new JButton("Zapisz");
    private final String[] ROZSZERZENIA_TEKSTOWE = new String[]{".txt", ".xml", ".mf"};

    public void stworzPlikZip(File[] pliki) {
        for (int i = 0; i < pliki.length; i++)
            System.out.println(pliki[i].getPath());
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }

    private class FiltrRozszerzen extends FileFilter {
        public FiltrRozszerzen(String opis, String[] rozszerzenia) {
            this.opis = opis;
            this.rozszerzenia = rozszerzenia;
        }

        @Override
        public boolean accept(File f) {
            for (int i = 0; i < this.rozszerzenia.length; i++)
                if (f.getName().toLowerCase().endsWith(this.rozszerzenia[i]) || f.isDirectory())
                    return true;
            return false;
        }

        @Override
        public String getDescription() {
            return opis;
        }
        private String opis;
        private String[] rozszerzenia;
    }
}
