package breakout;
import java.util.Arrays;
import java.util.HashMap;

// TODO: implement, document
public class BreakoutState {

	private static BallState[] balls;
	private static BlockState[] blocks;
	private static Point bottomRight;
	private static PaddleState paddle;
	private HashMap<Integer, Integer> topMargin = new HashMap<Integer, Integer>();
	private static int blockXSize;
	private static int blockYSize;
	//经过GmaeMap的create游戏函数，我们可以得到balls, blocks, botoomRight(地图的右下角，第一个变量为横向x的大小，第二个变量为纵向y的大小), paddle是那个paddle的状态
	public BreakoutState(BallState[] balls, BlockState[] blocks, Point bottomRight, PaddleState paddle) {
		this.balls = balls;
		this.blocks = blocks;
		this.bottomRight = bottomRight;
		this.paddle = paddle;
		if(this.blocks!=null) {
			blockXSize = blocks[0].getBlockBR().getX() - blocks[0].getBlockTL().getX() + 70;
			blockYSize = blocks[0].getBlockBR().getY() - blocks[0].getBlockTL().getY() + 70;
		}
		for(int i = 0; i < 9; i++) {
			topMargin.put(i, 0);
		}
		for(BlockState block:blocks) {
			//if this column does not have any blocks, create a new map of key and value
			if(!topMargin.containsKey(block.getBlockTL().getX()/blockXSize)) {
				topMargin.put(block.getBlockTL().getX()/blockXSize, 1);
			}else{
				int y = topMargin.get(block.getBlockTL().getX()/blockXSize) + 1;
				topMargin.put(block.getBlockTL().getX()/blockXSize, y);
			}
//			System.out.println(block.getBlockTL().getX()/blockXSize);
		}
//		for(int i = 0; i < 9; i++) {
//			System.out.println(topMargin.get(i));
//			
//		}
//		System.out.println(balls[0].getBottomRight().getY());
	}
	
	public BallState[] getBalls() {
		return balls;
	}

	public BlockState[] getBlocks() {
		return blocks;
	}

	public PaddleState getPaddle() {
		return paddle;
	}

	public Point getBottomRight() {
		return bottomRight;
	}

	//	This method must do the following (in this order):
	//	- Move all balls one step forward according to their current velocity.
	//	- Check whether any balls hit the walls on the left, right and top side of the game area, in which case they must bounce back.
	//	- Check whether any balls hit the bottom of the field, in which case they must be removed from the game.
	//	- Check whether any ball hit any block, in which case the block must be removed from the game and the ball must bounce back.
	//	- Check whether any ball hit the paddle, in which case it must bounce back.
	//	  Additionally, the ball must speed up by one fifth of the current velocity of the paddle.
	public void tick(int paddleDir) {
		for(BallState ball:balls) {
			ball.move();
			//			- Check whether any balls hit the walls on the left, right and top side of the game area, in which case they must bounce back.
			if(ball.getBottomLeft().getX()<=0) {
				Vector temp = new Vector(ball.getDiameter()/2, ball.getDiameter()/2);
				ball.moveTo(ball.getTopLeft().reflectVertical(0).plus(temp));
				ball.setVelocity(ball.getVelocity().mirrorOver(new Vector(-1,0)));
			}
			else if(ball.getBottomRight().getX()>=bottomRight.getX()) {
				Vector temp = new Vector(-ball.getDiameter()/2, -ball.getDiameter()/2);
				ball.moveTo(ball.getBottomRight().reflectVertical(bottomRight.getX()).plus(temp));
				ball.setVelocity(ball.getVelocity().mirrorOver(new Vector(-1,0)));
			}
			else if(ball.getTopLeft().getY()<=0) {
				Vector temp = new Vector(ball.getDiameter()/2, ball.getDiameter()/2);
				ball.moveTo(ball.getTopLeft().reflectHorizontal(0).plus(temp));
				ball.setVelocity(ball.getVelocity().mirrorOver(new Vector(0,1)));
			}
			// Check if the ball hit any blocks
			for(BlockState block : blocks) {
				if(ball.getBottomRight().isUpAndLeftFrom(block.getBlockBR()) && block.getBlockTL().isUpAndLeftFrom(ball.getBottomRight())) {
					if(ball.getTopRight().isUpAndLeftFrom(block.getBlockBR()) && block.getBlockTL().isUpAndLeftFrom(ball.getTopRight())) {
						Vector temp = new Vector(-ball.getDiameter()/2, -ball.getDiameter()/2);
						ball.moveTo(ball.getBottomRight().reflectVertical(block.getBlockTL().getX()).plus(temp));
						ball.setVelocity(ball.getVelocity().mirrorOver(new Vector(-1,0)));
					}
					else if(ball.getBottomLeft().isUpAndLeftFrom(block.getBlockBR()) && block.getBlockTL().isUpAndLeftFrom(ball.getBottomLeft())){
						Vector temp = new Vector(-ball.getDiameter()/2, -ball.getDiameter()/2);
						ball.moveTo(ball.getBottomRight().reflectVertical(block.getBlockTL().getY()).plus(temp));
						ball.setVelocity(ball.getVelocity().mirrorOver(new Vector(0,1)));
					}else {
						ball.setVelocity(ball.getVelocity().mirrorOver(new Vector(1,1)));
					}
					block = null;
				}
				else if(ball.getTopLeft().isUpAndLeftFrom(block.getBlockBR()) && block.getBlockTL().isUpAndLeftFrom(ball.getTopLeft())) {
					if(ball.getTopRight().isUpAndLeftFrom(block.getBlockBR()) && block.getBlockTL().isUpAndLeftFrom(ball.getTopRight())) {
						Vector temp = new Vector(ball.getDiameter()/2, ball.getDiameter()/2);
						ball.moveTo(ball.getTopLeft().reflectHorizontal(block.getBlockBR().getY()).plus(temp));
						ball.setVelocity(ball.getVelocity().mirrorOver(new Vector(0,1)));
					}else if(ball.getBottomLeft().isUpAndLeftFrom(block.getBlockBR()) && block.getBlockTL().isUpAndLeftFrom(ball.getBottomLeft())) {
						Vector temp = new Vector(ball.getDiameter()/2, ball.getDiameter()/2);
						ball.moveTo(ball.getTopLeft().reflectVertical(block.getBlockBR().getX()).plus(temp));
						ball.setVelocity(ball.getVelocity().mirrorOver(Vector.LEFT));
					}else {
						ball.setVelocity(ball.getVelocity().mirrorOver(new Vector(1,1)));
					}

					block=null;
				}
				else if(ball.getBottomLeft().isUpAndLeftFrom(block.getBlockBR()) && block.getBlockTL().isUpAndLeftFrom(ball.getBottomLeft())) {
					ball.setVelocity(ball.getVelocity().mirrorOver(new Vector(1,1)));
					block=null;
				}else if(ball.getTopRight().isUpAndLeftFrom(block.getBlockBR()) && block.getBlockTL().isUpAndLeftFrom(ball.getTopRight())) {
					ball.setVelocity(ball.getVelocity().mirrorOver(new Vector(1,1)));
					block=null;
				}
				}
			//check paddle
			if(ball.getBottomLeft().getY()>=paddle.getTopLeft().getY() && ball.getBottomLeft().getX()>=paddle.getTopLeft().getX() && ball.getBottomRight().getX()<=paddle.getBottomRight().getX()
					&& ball.getTopLeft().getY()<=paddle.getTopLeft().getY()) {
				Vector temp = new Vector(-ball.getDiameter()/2, -ball.getDiameter()/2);
				ball.moveTo(ball.getBottomRight().reflectHorizontal(paddle.getTopLeft().getY()).plus(temp));
				ball.setVelocity(ball.getVelocity().mirrorOver(new Vector(0,1)));
			}
			}

	}

	
	public void movePaddleRight() {
		paddle.movePaddleRight();
	}

	public void movePaddleLeft() {
		paddle.movePaddleLeft();
	}
	
	public boolean isWon() {
		for(BlockState block:blocks ) {
			if(block != null)	return false;
		}
		return true;
	}

	public boolean isDead() {
		boolean flag = true;
		if(balls[0] == null)	return false;
		for(BallState ball:balls) {
			if(ball.getBottomRight().getY() < bottomRight.getY()) {
				flag = false;
				System.out.println(ball.getTopLeft().getX()+" "+ball.getTopLeft().getY());
				System.out.println(ball.getVelocity().getX()+" "+ball.getVelocity().getY());
			}
				
		}
		return flag;
	}
	private int bounceCase(Point oldPosition, Point newPosition, int left_x, int midlle_x, int right_x, int left_y, int right_y ) {
		int bounceCase = 0;
		return bounceCase;
	}
}
