import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Map;

import javax.swing.JFrame;


public class MovingObjectsGameLauncher {
	public static final int DEFAULT_SIZE = 800;
	public static void main(String[] args) {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	    System.setProperty("sun.java2d.opengl", "true");
		JFrame gameFrame = new JFrame();
		gameFrame.setSize(d.width, d.height);
		
		//Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		
		MovingObjectsPanel mop = new MovingObjectsPanel(new Dimension(d.width, d.height));
		gameFrame.add(mop);
		gameFrame.pack();
		gameFrame.setVisible(true);
		gameFrame.setDefaultCloseOperation(gameFrame.EXIT_ON_CLOSE);
	}

}
