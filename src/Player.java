import java.awt.Graphics;

public class Player extends Character{
	public static final int WIDTH = 50;
	public static final int HEIGHT = 50;
	private boolean falling;
	public Player (Vector loc) {
		super(loc, new Vector(WIDTH, HEIGHT));
		falling = true;
	}

	public void moveLeft() {
		updateLocation(new Vector(this.getLocation().x - SPEED, this.getLocation().y));
		this.location = this.location.add(new Vector(-SPEED, this.location.y));
		
	}
	public void moveRight() {
		updateLocation(new Vector(this.getLocation().x + SPEED, this.getLocation().y));
		this.location = this.location.add(new Vector(SPEED, this.location.y));
	}
	public void jump() {
		updateLocation(new Vector(this.getLocation().x, this.getLocation().y - JUMP_HEIGHT));
		if(this.velocity.y == 0) {
		this.velocity = new Vector(this.velocity.x, this.velocity.y - JUMP_HEIGHT);
		}
	}
	public void crouch() {
		//TODO crouch mech
		//updateLocation(new Vector(this.getLocation().x, this.getLocation().y - CROUCH_HEIGHT));
	}

	@Override
	public void move() {
		/**This is for all non-user input based actions like gravity */
		if(falling) velocity.y += SuperbadGameMap.GRAVITY;
		else falling = true;
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
		if(m instanceof Platform) {
			this.location.y = ((Platform) m).location.y - HEIGHT + 1;
			velocity.y = 0;
			falling = false;
		}
	}

}
