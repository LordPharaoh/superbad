import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;


public class Animation {
	private List<Image> images;
	private File resourceFile;
	private int frameNumber;
	
	public void reset() {
		frameNumber = 0;
	}
	public void draw(Graphics g, Vector location) {
		// TODO Auto-generated method stub
		//g.drawImage(images.get(frameNumber), location.x, location.y);
	}
	
	public Animation(String s) throws IOException {
		this(s, new Vector(1, 1));
	}
	
	public Animation(String s, Vector size) throws IOException {
		URL url = this.getClass().getResource("res");
		try {
			resourceFile = new File(url.toURI());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frameNumber = 0;
		if(!resourceFile.isDirectory()) {
			throw new IOException("Invalid Animation directory");
		}
		for(int i = 0; i < resourceFile.listFiles().length; i++) {
			Image image = ImageIO.read(url);
			images.add(image.getScaledInstance(size.x, size.y, Image.SCALE_DEFAULT));
		}
	}

}
