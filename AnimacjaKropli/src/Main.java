import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Robert Burek
 */
public class Main extends JFrame {
    public Main() {
        this.setTitle("Animacja kropelki");
        this.setBounds(50, 100, 700, 550);
        panelAnimacji.setBackground(Color.GRAY);
        JButton bStart = (JButton) panelButtonow.add(new JButton("Start"));

        bStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startAnimation();
            }
        });

        this.getContentPane().add(panelAnimacji);
        this.getContentPane().add(panelButtonow, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void startAnimation() {
        panelAnimacji.addKropelka();
    }

    private JPanel panelButtonow = new JPanel();
    private PanelAnimacji panelAnimacji = new PanelAnimacji();

    public static void main(String[] args) {
        new Main().setVisible(true);
    }

    class PanelAnimacji extends JPanel {

        public void addKropelka() {
            listaKropelek.add(new Kropelka());
            for (int i = 0; i < 2500; i++) {
                for (int j = 0; j < listaKropelek.size(); j++) {
                    ((Kropelka) listaKropelek.get(j)).ruszKropelka(this);
                    this.paint(this.getGraphics());
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (int i = 0; i < listaKropelek.size(); i++) {
                g.drawImage(Kropelka.getImg(), ((Kropelka) listaKropelek.get(i)).x, ((Kropelka) listaKropelek.get(i)).y, null);
            }
        }

        ArrayList listaKropelek = new ArrayList();
    }
}

class Kropelka {
    public static Image getImg() {
        return Kropelka.kropelka;
    }

    public void ruszKropelka(JPanel pojemnik) {
        Rectangle granicePanelu = pojemnik.getBounds();
        x += dx;
        y += dy;

        if (y + yKropelki >= granicePanelu.getMaxY()) {
            y = (int) (granicePanelu.getMaxY() - yKropelki);
            dy = -dy;
        }
        if (x + xKropelki >= granicePanelu.getMaxX()) {
            x = (int) (granicePanelu.getMaxX() - xKropelki);
            dx = -dx;
        }
        if (y < granicePanelu.getMinY()) {
            y = (int) granicePanelu.getMinY();
            dy = -dy;
        }

        if (x < granicePanelu.getMinX()) {
            x = (int) granicePanelu.getMinX();
            dx = -dx;
        }

    }

    public static Image kropelka = new ImageIcon("kropelka.gif").getImage();

    int x = 0;
    int y = 0;
    int dx = 1;
    int dy = 1;
    int xKropelki = kropelka.getWidth(null);
    int yKropelki = kropelka.getHeight(null);
}
