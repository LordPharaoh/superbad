import java.awt.Rectangle;

public abstract class Character implements MovingObject, Drawable{

public abstract Character (int x, int y, int width, int height) {
  super(x,y,width,height);
}
  public abstract void move() {
    //TODO
  }

  public Rectangle getBoundingRect() {
    return new Rectangle(location.x, location.y, dimension.x, dimension.y);
    //We need to have the location and Dimension variables for this.
  }
}
