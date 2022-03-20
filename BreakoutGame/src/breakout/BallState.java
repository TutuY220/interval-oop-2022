package breakout;

public class BallState {
	// TODO: implement
	private Point center;
	private Vector velocity;
	private int diameter;
	public BallState() {
		
	}
	public BallState(Point center,Vector velocity,int diameter) {
		this.center = center;
		this.velocity = velocity;
		this.diameter = diameter;
	}
	public Point getCenter() {
		return center;
	}
	
	public Vector getVelocity() {
		return velocity;
	}
	public void setVelocity(Vector newVelocity) {
		this.velocity = newVelocity;
	}
	public void setCenter(Point newCenter) {
		this.center = newCenter;
	}

	public Point getTopLeft() {
		Vector temp = new Vector(diameter/2,diameter/2);
		Point tl = center.minus(temp);
		return tl;
	}
	public Point getBottomRight() {
		Vector temp = new Vector(diameter/2,diameter/2);
		Point br = center.plus(temp);
		return br;
	}
	public Point getTopRight() {
		Vector temp = new Vector(-diameter/2,diameter/2);
		Point tl = center.minus(temp);
		return tl;
	}
	public Point getBottomLeft() {
		Vector temp = new Vector(-diameter/2,diameter/2);
		Point br = center.plus(temp);
		return br;
	}
	public void move() {
		this.center = this.center.plus(velocity);
	}
	public void moveTo(Point position) {
		this.center = position;
	}
	public int getDiameter() {
		return this.diameter;
	}
}
