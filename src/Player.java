import java.awt.Graphics;

public class Player extends Character{
	public static final int WIDTH = 50;
	public static final int HEIGHT = 50;
	public Player (Vector loc) {
		super(loc, new Vector(WIDTH, HEIGHT));
	}

	/*public void move(String s){
		if(s.equals("left")){
			
		}
		else if(s.equals("right")){

		}
		else if(s.equals("jump")){

		}
		else if (s.equals("crouch")) {

		}

	}
	*/
	public void moveLeft() {
		updateLocation(new Vector(this.getLocation().x - this.getVelocity().x, this.getLocation().y));
	}
	public void moveRight() {
		updateLocation(new Vector(this.getLocation().x + this.getVelocity().x, this.getLocation().y));
	}
	public void jump() {
		updateLocation(new Vector(this.getLocation().x, this.getLocation().y - this.getVelocity().x));
	}
	public void crouch() {
		//TODO crouch mech
		updateLocation(new Vector(this.getLocation().x, this.getLocation().y - this.getVelocity().x));
	}

	@Override
	public void move() {
		/**This is for all non-user input based actions like gravity */
		velocity.y -= SuperbadGameMap.GRAVITY;
		location = location.add(velocity);
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect(location.x, location.y, dimension.x, dimension.y);
	}

	@Override
	public void handleCollision(MovingObject m) {
		// TODO Auto-generated method stub
		
	}

}
