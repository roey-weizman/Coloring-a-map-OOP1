/*
* class that contains constructor and methods of point
*/
public class Point {
	private int x;
	private int y;
	// creating a point
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
		
	}
	
	// method that returns x value
	public int getX() {
		return x;
		
	}
	
	// method that returns y value
	public int getY() {
		return y;
	}
	//method that checks if point are equal in value
	public boolean equals(Point other){
		return x==other.x & y==other.y;
	}
}
