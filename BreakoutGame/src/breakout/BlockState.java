package breakout;

public class BlockState {
	// TODO: implement
	//blockTL is the top left point of this block
	private Point blockTL;
	//blockBR is the bottom right point of this blocl
	private Point blockBR;
	
	public BlockState() {
		
	}
	public BlockState(Point blockTL, Point blockBR) {

		this.blockBR = blockBR;
		this.blockTL = blockTL;
	}
	public Point getBlockTL() {
		return this.blockTL;
	}
	public Point getBlockBR() {
		return this.blockBR;
	}
//	public int getBlockXSize(){
//		return this.blockBR.getX() - this.blockTL.getX();
//	}
//	public int getBlockYSize(){
//		return this.blockBR.getY() - this.blockTL.getY();
//	}
}
