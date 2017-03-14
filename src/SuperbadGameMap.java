import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.imageio.ImageIO;


public class SuperbadGameMap extends GameMap{
	public final static int GRAVITY = 6;
	public SuperbadGameMap(Dimension dim) {
		super();
		createLevel(1);
		openBackgroundImage();
	}
	
	private void createPlatforms(int amtOfPlatforms) {
		// TODO createPlatforms
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int xincrement = (int) (d.getWidth() / amtOfPlatforms);
		int yincrement = (int) (d.getHeight() / amtOfPlatforms);
		for(int i = 0; i < amtOfPlatforms + 1; i++) {
			add(new BasicPlatform(new Vector(i * xincrement, i*yincrement), new Vector(50, 50)));
		}
		add(new BasicPlatform(new Vector(0, d.height - 100), new Vector(d.width, 1)));
	}
	private void createLevel(int level) {
		createPlatforms(level*20);
		createCharacter();
	}
	private void createCharacter() {
		add(new Player(new Vector(100, 100)));
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

	public void draw(Graphics g) {
		for(Drawable drawThis: drawers) {
			drawThis.draw(g);
		}
	}
	public void move(String s) {
		Player truePlayer = null;
		for(MovingObject player: movers) {
			if(player instanceof Player) {
				truePlayer = (Player) player;
			}
		}
		if(truePlayer != null) {
		switch(s) {
		case "right":
			truePlayer.moveRight();
			break;
		case "left":
			truePlayer.moveLeft();
			break;
		case "crouch":
			truePlayer.teleport();
			break;
		case "jump":
			truePlayer.jump();
			break;
		case "shoot":
			truePlayer.shoot();
		default:
			break;
		}
		}
	}

}
