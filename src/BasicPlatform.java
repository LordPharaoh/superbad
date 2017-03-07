import java.awt.Graphics;


public class BasicPlatform extends Platform {

	public BasicPlatform(Vector loc, Vector dim) {
		super(loc, dim);
		// TODO Auto-generated constructor stub
	}
	
	
	public void draw(Graphics g) {
		g.drawRect(location.x, location.y, dimension.x, dimension.y);
	}

}
