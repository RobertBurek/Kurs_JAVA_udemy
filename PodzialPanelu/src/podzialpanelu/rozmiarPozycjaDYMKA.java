package podzialpanelu;

import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import javax.swing.JTextArea;

 class rozmiarPozycjaDYMKA {
   
   static String cos (String ddd){
      return " i co , można ---" + ddd;
   }
   
   @SuppressWarnings("null")
   static Rectangle rozmiarPozycjaDYMKA (JTextArea TextArea, JTextArea TextAreaParend, int pozX, int pozY){
      Rectangle pozycjaWymiar = TextArea.getBounds();
      FontMetrics metrics = TextArea.getFontMetrics(TextArea.getFont());
      Rectangle2D bounds = metrics.getStringBounds(TextArea.getText(), null); 
      int widthInPixels = (int) bounds.getWidth(); 
      int heightInPixels = (int) bounds.getHeight(); 
      pozycjaWymiar.width = widthInPixels + 10;
      pozycjaWymiar.height = heightInPixels + 10;
      if (widthInPixels<4) pozycjaWymiar.width = 0;
      pozycjaWymiar.x = pozX - (widthInPixels + 10)/2;
      
      if (pozY <= 25) pozycjaWymiar.y = 27; else
      pozycjaWymiar.y = pozY - 57;
      return pozycjaWymiar;
   }
   
}
