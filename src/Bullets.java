import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.net.URL;

import javax.imageio.ImageIO;


public class Bullets implements MovingObject, Drawable{
	public final static  int WIDTH= 20;
	public final static  int HEIGHT= 20;
	private Image bullet;
	private GameMap gm;
	private Vector velocity;
	private Vector location;
	public Bullets(Vector location, Vector velocity, GameMap gm){
		this.location= location;
		this.gm= gm;
		this.velocity= velocity;
	}
	@Override
	public void move() {
		location= location.add(velocity);
	}

	@Override
	public Rectangle getBoundingRect() {
		return new Rectangle(location.x, location.y,WIDTH,HEIGHT);
	}

	@Override
	public Vector getLocation() {
		
		return location;
	}

	@Override
	public void handleCollision(MovingObject m) {
		gm.remove(this);
		
	}

	@Override
	public boolean collision(MovingObject r) {
		if(r == null || r.getBoundingRect() == null) return false;
		return (getBoundingRect()).intersects(r.getBoundingRect());
	}
	@Override
	public void draw(Graphics g) {
		g.drawOval(location.x, location.y,WIDTH, HEIGHT);
	}
	
	

}
