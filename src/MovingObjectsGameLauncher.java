import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Map;

import javax.swing.JFrame;


public class MovingObjectsGameLauncher {
	public static final int DEFAULT_SIZE = 800;
	public static void main(String[] args) {
	    System.setProperty("sun.java2d.opengl", "true");
		JFrame gameFrame = new JFrame();
		gameFrame.setSize(DEFAULT_SIZE, DEFAULT_SIZE);
		
		//Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		
		MovingObjectsPanel mop = new MovingObjectsPanel(new Dimension(DEFAULT_SIZE, DEFAULT_SIZE));
		gameFrame.add(mop);
		gameFrame.pack();
		gameFrame.setVisible(true);
		gameFrame.setDefaultCloseOperation(gameFrame.EXIT_ON_CLOSE);
	}

}
