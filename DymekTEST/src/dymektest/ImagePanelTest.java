/*
 * Napisane 12.2018 pierwsze kroki pisanie w JAVA. 
 */
package dymektest;

import javax.swing.*;
import java.awt.*;

class DymekTEST extends JPanel {

  Image img;
  boolean loaded = false; // czy obrazek został załadowany?

  public DymekTEST(String imgFileName) {
    loadImage(imgFileName);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (img != null && loaded)
      g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    else
      g.drawString("Bez obrazka", 10, getHeight() - 10);
  }

  private void loadImage(String imgFileName) {
    img = Toolkit.getDefaultToolkit().getImage(imgFileName);
    MediaTracker mt = new MediaTracker(this);
    mt.addImage(img, 1);
    try {
      mt.waitForID(1);
    } catch (InterruptedException exc) {
    }
    int w = img.getWidth(this); // szerokość obrazka
    int h = img.getHeight(this); // wysokość obrazka
    if (w != -1 && w != 0 && h != -1 && h != 0) {
      loaded = true;
      setPreferredSize(new Dimension(w, h));
    } else
      setPreferredSize(new Dimension(200, 200));
  }

}

public class ImagePanelTest extends JFrame {

  public ImagePanelTest(String fname) {
    DymekTEST p = new DymekTEST(fname);
    p.add(new JButton("Jakiś przycisk"));
    add(p);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public static void main(String args[]) {
    new ImagePanelTest("pool2.jpg"); // argument - nazwa pliku graficznego (z
                                     // roboczego katalogu aplikacji)
  }
}
