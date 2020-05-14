package objects;

import java.io.Serializable;

/**
 * GardenObject class for Gardendesigner Hub
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public abstract class GardenObject implements Serializable {
	Shape shape;
	double xLoc;
	double yLoc;

	/**
	 * Creates a GardenObject of a specific shape
	 */
	public void makeShape() {

	}
	
	/**
	 * 
	 * 
	 * @return the shape of the object
	 */
	public Shape getShape() {
		return shape;
	}
	
	/**
	 * 
	 * 
	 * @return
	 */
	public double getX() {
		return xLoc;
	}
	
	/**
	 * 
	 * 
	 * @return
	 */
	public double getY() {
		return yLoc;
	}
}
