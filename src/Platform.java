import java.awt.Graphics;
import java.awt.Rectangle;


public abstract class Platform implements Drawable, MovingObject{
	/**RigidBody 
		framework for things like platforms and boxes
		that you jump and run into in game**/
	protected Vector location, dimension;
	public Platform(Vector loc, Vector dim) {
		location = loc;
		dimension = dim;
	}
	@Override
	public void move() {
		/** Empty because these things should be stationary **/
	}

	@Override
	public Rectangle getBoundingRect() {
		// TODO Auto-generated method stub
		return new Rectangle(location.x, location.y, dimension.x, dimension.y);

	}

	@Override
	public Vector getLocation() {
		return location;
	}

	@Override
	public void handleCollision(MovingObject m) {
		/** empty because these shouldn't be affected by collisions **/
	}

	@Override
	public boolean collision(MovingObject r) {
		/** True if two MovingObjects are colliding **/
		if(r == null || r.getBoundingRect() == null) return false;
		return (getBoundingRect()).intersects(r.getBoundingRect());
	}

	@Override
	/** To be implemented by child **/
	public abstract void draw(Graphics g);
	
}
