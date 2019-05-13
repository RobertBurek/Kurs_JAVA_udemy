import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Robert Burek
 */
public class Main extends JFrame {

    public static Boolean isPauza = false;

    public Main() {
        this.setTitle("Animacja kropelki");
        this.setBounds(250, 300, 300, 250);
        panelAnimacji.setBackground(Color.GRAY);
        JButton bStart = (JButton) panelButtonow.add(new JButton("Start"));
        bStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startAnimation();
            }
        });

        JButton bUsun = (JButton) panelButtonow.add(new JButton("Usuń"));
        bUsun.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopAnimation();
            }
        });

        JButton bPauza = (JButton) panelButtonow.add(new JButton("Pauza"));
        bPauza.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!isPauza) bPauza.setText("Wznów");
                else bPauza.setText("Pauza");
                pauzaAnimation();
            }
        });

        this.getContentPane().add(panelAnimacji);
        this.getContentPane().add(panelButtonow, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void pauzaAnimation() {
        panelAnimacji.pauza();
    }

    public void startAnimation() {
        panelAnimacji.addKropelka();
    }

    public void stopAnimation() {
        panelAnimacji.stop();
    }

    private JPanel panelButtonow = new JPanel();
    private PanelAnimacji panelAnimacji = new PanelAnimacji();

    public static void main(String[] args) {
        new Main().setVisible(true);
    }

    class PanelAnimacji extends JPanel {

        public void addKropelka() {
            listaKropelek.add(new Kropelka());
            watek = new Thread(grupaWatkow, new KropelkaRunnable((Kropelka) listaKropelek.get(listaKropelek.size() - 1)));
            watek.start();
            grupaWatkow.list();
        }

        public void stop() {
            grupaWatkow.interrupt();
        }

        public void pauza() {
            if (Main.isPauza) Main.isPauza = false;
            else Main.isPauza = true;
            System.out.println("Pauza -" + Main.isPauza.toString());
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int i = 0; i < listaKropelek.size(); i++) {
                g.drawImage(Kropelka.getImg(), ((Kropelka) listaKropelek.get(i)).x, ((Kropelka) listaKropelek.get(i)).y, null);
            }
        }

        ArrayList listaKropelek = new ArrayList();
        JPanel ten = this;
        Thread watek;
        ThreadGroup grupaWatkow = new ThreadGroup("Grupa Kropelek");


        public class KropelkaRunnable implements Runnable {

            Kropelka kropelka;

            public KropelkaRunnable(Kropelka kropelka) {
                this.kropelka = kropelka;
            }

            public void run() {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        if (!Main.isPauza) {
                            this.kropelka.ruszKropelka(ten);
                            repaint();
                            Thread.sleep(1);
                        }
                    }
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                    listaKropelek.clear();
                    repaint();
                }
            }
        }
    }
}

class Kropelka {

    public static Image kropelka = new ImageIcon("kropelka.gif").getImage();

    int x = 0;
    int y = 0;
    int dx = 1;
    int dy = 1;
    int xKropelki = kropelka.getWidth(null);
    int yKropelki = kropelka.getHeight(null);

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
}
