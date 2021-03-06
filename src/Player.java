import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Player extends Character{
	public static final int WIDTH = 25;
	public static final int HEIGHT = 100;
	private boolean falling;
	private Animation animation;
	private ArrayList<String> moveDir = new ArrayList<>();
	
	public Player (Vector loc) {
		super(loc, new Vector(WIDTH, HEIGHT));
		falling = true;
		try {
			URL url = getClass().getResource("res/player2.png");
			Image image = ImageIO.read(url);
			this.img = image;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void moveLeft() {
		this.location = this.location.add(new Vector(-SPEED, 0));
		moveDir.add("Left");
		
	}
	public void moveRight() {
		this.location = this.location.add(new Vector(SPEED, 0));
		moveDir.add("Right");
	}
	public void jump() {

		if(this.velocity.y == 0) {
			if(moveDir.size() == 0){
				this.velocity = new Vector(this.velocity.x, this.velocity.y - JUMP_HEIGHT);
			}
			else if(moveDir.get(moveDir.size() - 1) != null && (moveDir.get(moveDir.size() - 1).equalsIgnoreCase("right"))){
				this.velocity = new Vector(this.velocity.x + SPEED, this.velocity.y - JUMP_HEIGHT);
				
			}
			else if(moveDir.get(moveDir.size() - 1) != null && (moveDir.get(moveDir.size() - 1).equalsIgnoreCase("left"))){
				this.velocity = new Vector(this.velocity.x - SPEED, this.velocity.y - JUMP_HEIGHT);
				
			}
		
//		if(colliding){
//			this.velocity.x = 0;
//		}
		}
	}
	
	public void teleport(){
		//TODO crouch mech
		moveDir.clear();
		this.location.y = this.dimension.y  / 2;
		
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
		g.drawRect(location.x, location.y, dimension.x, dimension.y);
		g.drawImage(this.img, location.x - 40, location.y, dimension.x * 4, dimension.y, null);
		//animation.draw(g, location.add(new Vector((int)(-WIDTH * 1.5), 0)));
	}

	@Override
	public void handleCollision(MovingObject m) {
		if(m instanceof Platform) {
			//Rectangle intersection = m.getBoundingRect().intersection(this.getBoundingRect());
			if(location.y - velocity.y + HEIGHT - 1 < m.getLocation().y) {
				this.location.y = ((Platform) m).location.y - HEIGHT;
				this.velocity.y = 0;
				falling = false;
				if(IsKeyPressed.isAPressed()) {
					this.velocity.add(new Vector(SPEED, 0));
				}
				else if(IsKeyPressed.isDPressed()) {
					this.velocity.add(new Vector(-SPEED, 0));
				}
				else {
				this.velocity.x = 0;
				}
//				colliding = true;
			}
			else {
				velocity.x = 0;
			}
		}
	}

	public void shoot() {
		
		
	}



}
