import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.imageio.ImageIO;


public class SuperbadGameMap extends GameMap{
	public final static int GRAVITY = -3;
	public SuperbadGameMap(Dimension dim) {
		super();
		createLevel(1);
		Player p = new Player(new Vector(100, 100));
		add(p);
		openBackgroundImage();
	}
	
	private void createPlatforms(int amtOfPlatforms) {
		// TODO createPlatforms
	}
	private void createLevel(int level) {
		createPlatforms(level*20);
		createCharacter();
	}
	private void createCharacter() {
		// TODO createCharacter
	}

	@Override
	public void openBackgroundImage() {
		try {
			URL url = getClass().getResource("res/background.jpg");
			//Image image = ImageIO.read(url);
			//this.backgroundImage = image;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void tick() {
		// TODO CollideBeforeMoves
		for(MovingObject currObj: movers) {
			currObj.move();
		}
	}

	@Override
	public void draw(Graphics g) {
		for(Drawable drawThis: drawers) {
			drawThis.draw(g);
		}
	}
	public void move(String s) {
		
	}

}
