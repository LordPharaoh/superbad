import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public abstract class Character implements MovingObject, Drawable{
	protected Vector location;
	protected Vector dimension;
	protected Vector velocity;
	protected int JUMP_HEIGHT = 28;
	protected int SPEED = 15;
	protected Image img;
	public Character (Vector loc, Vector dim) {
		location = loc;
		dimension = dim;
		velocity = new Vector(0, 0);
	}
	
	public abstract void move();
	public void updateLocation(Vector newLoc) {
		location = newLoc;
	}
	public Vector getVelocity() {
		return velocity;
	}
	public Rectangle getBoundingRect() {
		//We add one so we have a bit of room at the bottom
		return new Rectangle(location.x, location.y, dimension.x, dimension.y + 1);
		//We need to have the location and Dimension variables for this.
	}
	@Override
	public Vector getLocation() {
		// TODO Auto-generated method stub
		return location;
	}
	@Override
	public boolean collision(MovingObject r) {
		/** True if two MovingObjects are colliding **/
		if(r == null || r.getBoundingRect() == null) return false;
		return (getBoundingRect()).intersects(r.getBoundingRect());
	}
	
	@Override
	public abstract void draw(Graphics g);
	@Override
	public abstract void handleCollision(MovingObject m);

}
