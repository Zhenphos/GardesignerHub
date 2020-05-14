package objects;

import java.io.Serializable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 * Shape class for Gardendesigner Hub
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Shape implements Serializable {
	private static final double defaultSize = 100;

	SerializablePolygon shape = new SerializablePolygon();

	/**
	 * Constructor for shape which configures the default shape
	 * 
	 * @param c - the color of the shape
	 */
	public Shape(Color c) {
		shape.setFill(c);

		shape.getPoints().addAll(new Double[] {				
			1.0, 1.0,
			1.0, defaultSize/2 + 1,
			1.0, defaultSize + 1,
			defaultSize/2 + 1, defaultSize + 1,
			defaultSize + 1, defaultSize + 1,
			defaultSize + 1, defaultSize/2 + 1,
			defaultSize + 1, 1.0,
			defaultSize/2 + 1, 1.0
			});
	}
	
	/**
	 * Gets a default polygon
	 * 
	 * @return a new polygon with default size and shape
	 */
	public Polygon getPolygon() {
		return shape;
	}
}