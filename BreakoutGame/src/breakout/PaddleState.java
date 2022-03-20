package breakout;

public class PaddleState {
	// TODO: implement
	private Vector size;
	private Point center;
	private Vector move = new Vector(1000,0);
	public PaddleState() {
		
	}
	public PaddleState(Vector size, Point center) {
		this.size = size;
		this.center = center;
	}
	public Point getTopLeft() {
		return center.minus(size);
//		return new Point(center.getX() - size.getX(), center. getY() - size.getY());
	}
	public Point getBottomRight() {
		return center.plus(size);
//		return new Point(center.getX() + size.getX(), center. getY() + size.getY());
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public Point getCenter() {
		return this.center;
	}
	public void movePaddleLeft() {
		center = this.center.minus(move);
	}
	public void movePaddleRight() {
		center = this.center.plus(move);
	}
}
