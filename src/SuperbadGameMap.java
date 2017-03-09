import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.imageio.ImageIO;


public class SuperbadGameMap extends GameMap{
	public final static int GRAVITY = 3;
	public SuperbadGameMap(Dimension dim) {
		super();
		createLevel(1);
		Player p = new Player(new Vector(50, 50));
		add(p);
		BasicPlatform bp = new BasicPlatform(new Vector(0, 200), new Vector(325, 300));
		add(bp);
		Enemy ep =  new Enemy(new Vector(300,50));
		add(ep);
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
		for(MovingObject currObj: movers) {
			currObj.move();
		}
		for(int i = 0; i < movers.size(); i++) {

			for(int h = i + 1; h < movers.size(); h++) {

				if(movers.get(i).collision(movers.get(h))) {

					movers.get(i).handleCollision(movers.get(h));

					movers.get(h).handleCollision(movers.get(i));

				}

			}

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
