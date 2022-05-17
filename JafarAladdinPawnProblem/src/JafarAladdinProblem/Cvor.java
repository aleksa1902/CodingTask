package JafarAladdinProblem;

public class Cvor {
	private int x;
	private int y;
	private int jump;
	private Cvor left, right;
	
	public Cvor(int x, int y, int jump) {
		this.x = x;
		this.y = y;
		this.jump = jump;
		this.left = null;
		this.right = null;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getJump() {
		return this.jump;
	}
	
	public Cvor getLeft() {
		return this.left;
	}
	
	public Cvor getRight() {
		return this.right;
	}
	
	public void setLeft(Cvor left) {
		this.left = left;
	}
	
	public void setRight(Cvor right) {
		this.right = right;
	}
}
