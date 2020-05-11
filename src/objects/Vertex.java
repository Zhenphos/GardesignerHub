package objects;

public class Vertex {
	private double x;
	private double y;
	
	public Vertex(double x, double y)  {
		this.x = x;
		this.y = y;
	}
	
	public Double[] getPoint() {
		return new Double[] {x, y};
	}
}
