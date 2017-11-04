/******************************************************************************

   Basic setup to make a window you can draw things in in Java using Swing.
   Written by Matthew Jenkin.

   14 July 2003

******************************************************************************/


import java.awt.*;
import javax.swing.*;


public class SwingDraw extends JFrame {
   class MySurface extends JPanel {
      public void paint(Graphics g) {
         g.setColor(Color.RED);
         g.drawLine(10, 10, 50, 50);
      }
   }

   public SwingDraw() {
      super("Code Skeleton");
      setSize(300, 300);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      MySurface m = new MySurface();
      getContentPane().add(m);
      setVisible(true);
   }

   public static void main(String [] args) {
      SwingDraw s = new SwingDraw();
   }
}
