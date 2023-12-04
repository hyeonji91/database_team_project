package utile;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageIconResize {
	
	
	
	public static ImageIcon resizeImage(ImageIcon icon, int MAX_WIDTH, int MAX_HEIGHT) {
	
		
		int width = icon.getIconHeight();
	    int height = icon.getIconHeight();
	    if (width > MAX_WIDTH) {
	        height = (int) (height * (MAX_WIDTH / (float) width));
	        width = MAX_WIDTH;
	    }
	    if (height > MAX_HEIGHT) {
	        width = (int) (width * (MAX_HEIGHT / (float) height));
	        height = MAX_HEIGHT;
	    }

	    Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
	    
	    return new ImageIcon(img);
	    
	}

}
