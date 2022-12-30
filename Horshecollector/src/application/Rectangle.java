package application;

public class Rectangle {
	public double x;
	public double y;
	public double width;
	public double height;

	public Rectangle(double x, double y, double z, double v) {
		this.x = x;
		this.y = y;
		this.width = z;
		this.height = v;
	}

	public boolean overlaps(Rectangle other) {
		boolean noover = this.x + this.width < other.x || other.x + other.width < this.x
				|| this.y + this.height < other.y || other.y + other.height < this.y;
		return !noover;

	}
}
