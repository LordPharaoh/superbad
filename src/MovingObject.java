import java.awt.Graphics;
import java.awt.Rectangle;


public interface MovingObject {

	void move();
	Rectangle getBoundingRect();
	Vector getLocation();
	void handleCollision(MovingObject m);
	boolean collision(MovingObject r);
	
}
