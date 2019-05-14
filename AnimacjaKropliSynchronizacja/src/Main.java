import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Robert Burek
 */
public class Main extends JFrame {

    private JPanel panelButtonow = new JPanel();
    private PanelAnimacji panelAnimacji = new PanelAnimacji();
    int speed = 5;

    public static void main(String[] args) {
        new Main().setVisible(true);
    }

    public Main() {
        this.setTitle("Animacja kropelki");
        this.setBounds(1350, 100, 500, 450);
        panelAnimacji.setBackground(Color.GRAY);
        JButton bStart = (JButton) panelButtonow.add(new JButton("Start"));
        bStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startAnimation();
            }
        });

        JButton bStop = (JButton) panelButtonow.add(new JButton("Stop"));
        bStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopAnimation();
            }
        });

        JButton bDodaj = (JButton) panelButtonow.add(new JButton("Dodaj"));
        bDodaj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dodajAnimation();
            }
        });

        JButton bPlus = (JButton) panelButtonow.add(new JButton("+"));
        bPlus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Plus();
            }
        });

        JButton bMinus = (JButton) panelButtonow.add(new JButton("-"));
        bMinus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Minus();
            }
        });

        this.getContentPane().add(panelAnimacji);
        this.getContentPane().add(panelButtonow, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void startAnimation() {
        panelAnimacji.start();
    }

    public void stopAnimation() {
        panelAnimacji.stop();
    }

    public void dodajAnimation() {
        panelAnimacji.addKropelka();
    }

    private void Plus() {
        ++speed;
        System.out.println(speed);
    }

    private void Minus() {
        if (speed > 0)
            --speed;
        System.out.println(speed);
    }


    class PanelAnimacji extends JPanel {

        private volatile boolean zatrzymany = false;
        private Object lock = new Object();
        ArrayList listaKropelek = new ArrayList();
        JPanel ten = this;
        Thread watek;
        ThreadGroup grupaWatkow = new ThreadGroup("Grupa Kropelek");

        public void addKropelka() {
            listaKropelek.add(new Kropelka());
            watek = new Thread(grupaWatkow, new KropelkaRunnable((Kropelka) listaKropelek.get(listaKropelek.size() - 1)));
            watek.start();

            grupaWatkow.list();
        }

        public void stop() {
            zatrzymany = true;
        }

        public void start() {
            if (zatrzymany) {
                zatrzymany = false;
                synchronized (lock) {
                    lock.notifyAll();
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

        public class KropelkaRunnable implements Runnable {

            Kropelka kropelka;

            public KropelkaRunnable(Kropelka kropelka) {
                this.kropelka = kropelka;
            }

            public void run() {
                while (true) {
                    synchronized (lock) {
                        while (zatrzymany) {
                            try {
                                lock.wait();
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                    this.kropelka.ruszKropelka(ten);
                    repaint();
                    try {
                        Thread.sleep(speed);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}


class Kropelka {

    public static Image kropelka = new ImageIcon("kropelka.gif").getImage();

    int x = new Random().nextInt(400);
    int y = new Random().nextInt(400);
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