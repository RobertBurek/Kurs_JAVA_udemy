/*
 * Napisane 12.2018 pierwsze kroki pisanie w JAVA. 
 */
package nictakiego;

import java.awt.Dimension;
import java.awt.FlowLayout;
 
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
 
public class NicTakiego {
 
    private static void createAndShowGUI() {
 
        // Create and set up the window.
        final JFrame frame = new JFrame("Split Pane Example");
 
        // Display the window.
        frame.setSize(1500, 800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        // set flow layout for the frame
        frame.getContentPane().setLayout(new FlowLayout());
 
        String[] options1 = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
        JList list1 = new JList(options1);
        //list1.setSize(150, 150);
 
        String[] options2 = { "Car", "Motorcycle", "Airplane", "Boat" };
        JList list2 = new JList(options2);
 
        JScrollPane scrollPane1 = new JScrollPane(list1);
        JScrollPane scrollPane2 = new JScrollPane(list2);
 
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane1, scrollPane2);
        splitPane.setPreferredSize(new Dimension(800, 300));
        JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane1, scrollPane2);
        splitPane.setBounds(110, 110, 800, 300);
 
        // get the current divider size (pixels)
        int dividerLocation = splitPane.getDividerSize();
 
        System.out.println("Divider Size before: " + dividerLocation);
 
        // set new divider size
        splitPane.setDividerSize(5);
        //System.out.println(scrollPane1.getHeight()+"   "+scrollPane1.getWidth());
        //System.out.println(scrollPane2.getSize());
 
        System.out.println("Divider Size after: " + splitPane.getDividerSize());
 
        frame.getContentPane().add(splitPane);
        frame.getContentPane().add(splitPane2);

    }
 
    public static void main(String[] args) {
 
  //Schedule a job for the event-dispatching thread:
 
  //creating and showing this application's GUI.
 
  javax.swing.SwingUtilities.invokeLater(new Runnable() {
 
public void run() {
 
    createAndShowGUI(); 
 
}
 
  });
  
    }
 
}