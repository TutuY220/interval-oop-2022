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
		for(int i = 0; i < 9; i++) {
			System.out.println(topMargin.get(i));
			
		}
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
//	- Check whether any balls 
//	hit the bottom of the field, in which case they must be removed from the game.
//	- Check whether any ball hit any block, in which case the block must be removed from the game and the ball must bounce back.
//	- Check whether any ball hit the paddle, in which case it must bounce back.
//	  Additionally, the ball must speed up by one fifth of the current velocity of the paddle.
	public void tick(int paddleDir) {
		Point oldPosition, newPosition;
		for(BallState ball:balls) {
//			- Check whether any balls hit the walls on the left, right and top side of the game area, in which case they must bounce back.
			if(ball.getVelocity().getX()>=0 && ball.getVelocity().getY()>=0) {
				oldPosition = ball.getCenter();
				newPosition = ball.getCenter().plus(ball.getVelocity());
				// xiang you xia yi dong zhi neng peng dao 
				if(newPosition.getX() >= bottomRight.getX()) {
					Point bounceBack = new Point(bottomRight.getX()*2-newPosition.getX(),ball.getCenter().getY()+ball.getVelocity().getY());
					ball.moveTo(bounceBack);
					ball.setVelocity(ball.getVelocity().mirrorOver(Vector.RIGHT));
				}
				else if(newPosition.getY() >= paddle.getCenter().getY() 
						&& (paddle.getTopLeft().getX()-newPosition.getX())*ball.getVelocity().getY() <= (paddle.getCenter().getY()-newPosition.getY())*ball.getVelocity().getX()) {
					Point bounceBack = new Point(newPosition.getX(),paddle.getCenter().getY()*2 - newPosition.getY());
					ball.moveTo(bounceBack);
					ball.setVelocity(ball.getVelocity().mirrorOver(Vector.UP));
				}
//				if(newPosition.getX()/blockXSize < oldPosition.getX()/blockXSize) {
//					
//				}
				else
					ball.move();
				

			}else if(ball.getVelocity().getX() < 0 && ball.getVelocity().getY()>=0) {
				oldPosition = ball.getBottomLeft();
				newPosition = ball.getBottomLeft().plus(ball.getVelocity());
				if(newPosition.getX() <= 0) {
					Point bounceBack = new Point(-newPosition.getX(),ball.getCenter().getY()+ball.getVelocity().getY());
					ball.moveTo(bounceBack);
					ball.setVelocity(ball.getVelocity().mirrorOver(Vector.LEFT));
				}
				ball.move();
			}else if(ball.getVelocity().getX() >= 0 && ball.getVelocity().getY() < 0) {
				oldPosition = ball.getTopRight();
				newPosition = ball.getTopRight().plus(ball.getVelocity());
				ball.move();
			}else {
				ball.move();
			}
			
		}
//		blocks = Arrays.stream(blocks).filter(x -> x != null).toArray(BlockState[]::new);
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
				System.out.println(ball.getBottomRight().getX()+" "+ball.getBottomRight().getY());
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
