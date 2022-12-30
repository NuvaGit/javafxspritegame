package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite {
public Vector position;
public Vector velocity;
public Image image;
public Rectangle boundry;

public Sprite() {
	position = new Vector(0,0);
	velocity = new Vector(0,0);
	boundry = new Rectangle(0,0,0,0);
}
public void setPosition(double x, double y) {
	position.set(x,y);
}
public void setImage(String filename) {
	image = new Image(filename);
	boundry.width = image.getWidth();
	boundry.height = image.getHeight();
}
public Rectangle getBoundry() {
	boundry.x = position.x;
	boundry.y = position.y;
	return new Rectangle(position.x,position.y,image.getWidth(),image.getHeight());
	
}
public boolean overlaps(Sprite other) {
	return getBoundry().overlaps(other.getBoundry());
}
public void render(GraphicsContext context) {
	context.drawImage(image, position.x, position.y);
}
}
