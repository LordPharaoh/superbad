import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;


public class Animation {
	public static final String[] IMG_EXTENSIONS = {"jpg", "png", "bmp" };
	private List<Image> images;
	private File resourceFile;
	private int frameNumber;
	
	public boolean isImage(File f) {
		for(String s : IMG_EXTENSIONS) {
			if(f.getName().indexOf("."+s) != -1) return true;
		}
		return false;
	}
	
	public void reset() {
		frameNumber = 0;
	}
	public void draw(Graphics g, Vector location) {
		// TODO Auto-generated method stub
		g.drawImage(images.get(frameNumber), location.x, location.y, null);
		frameNumber++;
		if(frameNumber >= images.size()) frameNumber = 0;
	}
	
	public Animation(String s) throws InvalidAnimationDirectoryException {
		this(s, new Vector(1, 1));
	}
	
	public Animation(String s, Vector size) throws InvalidAnimationDirectoryException {
		URL url = this.getClass().getResource(s);
		try {
			resourceFile = new File(url.toURI());
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(!resourceFile.isDirectory()) {
			//TODO custom exception
			throw new InvalidAnimationDirectoryException("Expected a directory; given a file");
		}
		
		File[] dir = resourceFile.listFiles();
		
		List<File> imageFiles = new ArrayList<File>();
		images = new ArrayList<Image>();
		for (File f : dir) {
			//System.out.println(f);
			if(isImage(f)) {
				imageFiles.add(f);
				//System.out.println(f);
			}

		}
		for (File imgf : imageFiles) {
			try {
				images.add(ImageIO.read(imgf));//.getScaledInstance(size.x, size.y, Image.SCALE_DEFAULT));
				System.out.println(imgf);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
