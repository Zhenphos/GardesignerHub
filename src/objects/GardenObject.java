package objects;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public abstract class GardenObject {
	Shape shape;
	double xLoc;
	double yLoc;

	/**
	 * creates a GardenObject of a specific shape
	 */
	public void makeShape() {

	}
	
	/**
	 * 
	 * @return the shape of the object
	 */
	public Shape getShape() {
		return shape;
	}
	
	public double getX() {
		return xLoc;
	}
	
	public double getY() {
		return yLoc;
	}
}
