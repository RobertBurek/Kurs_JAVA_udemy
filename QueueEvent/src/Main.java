import javax.swing.*;
import java.awt.*;

/**
 * Created by Robert Burek
 */
public class Main extends JFrame {

    final static JComboBox combo = new JComboBox();

    public Main() {
        this.setTitle("Event Queue");
        this.setSize(300, 300);

        this.getContentPane().add(combo, BorderLayout.NORTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new Main().setVisible(true);
        new Thread(new BezpiecznyWatekSwing()).start();
    }
}


class BezpiecznyWatekSwing implements Runnable {
    int i = 0;

    public void run() {
        while (i < 1000) {
            bezpiecznaEdycjaComboBoxa();
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
            }
        }
    }

    public void bezpiecznaEdycjaComboBoxa() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Main.combo.insertItemAt("lala" + i, 0);
                i++;
            }
        });
    }
}