import javax.swing.*;
import java.awt.*;

/**
 * Created by Robert Burek
 */
public class Main extends JFrame {
    public Main() {
        this.setTitle("Rysowanie");
        this.setBounds(250, 300, 500, 550);

        this.getContentPane().add(panelDoRysowania);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }

    private PanelRysowiak panelDoRysowania = new PanelRysowiak();
}

class PanelRysowiak extends JPanel {
    public PanelRysowiak() {
        super();

        this.add(new JButton("Test") {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

            }

        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawString("Napis", 0, 40);
        for (int i =0; i<20; i++) {
            try {
                Thread.sleep(100);
                g.drawImage(new ImageIcon("kropelka.gif").getImage(), 40 + i*10, 80 + i*10, null);
                g.drawRect(40+i*10, 40+i*10, 120, 80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        g.drawRect(40, 40, 120, 80);
        g.drawLine(60, 60, 80, 20);
        Graphics2D g2 = (Graphics2D) g;
        System.out.println(i++);
    }

    public static int i = 0;
}