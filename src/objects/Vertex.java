package objects;

public class Vertex {
	private double x;
	private double y;
	
	/**
	 * 
	 * @param x the x value of the function
	 * @param y the y value of the vertex
	 */
	public Vertex(double x, double y)  {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * 
	 * @return the x and y position in a Double array
	 */
	public Double[] getPoint() {
		return new Double[] {x, y};
	}
	
	/**
	 * 
	 * @return the x value of the function
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * 
	 * @return the y value of the function
	 */
	public double getY() {
		return y;
	}
}
