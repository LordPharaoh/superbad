import java.awt.Graphics;

public class Enemy extends Character{
	public static final int WIDTH = 50;
	public static final int HEIGHT = 50;

	public boolean falling;

	public Enemy(Vector loc) {
		super(loc, new Vector(WIDTH, HEIGHT));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
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
