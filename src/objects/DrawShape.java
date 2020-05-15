package objects;

import java.io.Serializable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

/**
 * Shape class for Gardendesigner Hub
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class DrawShape implements Serializable {
	private static final double defaultSize = 100;

	public SerializablePolygon shape = new SerializablePolygon();
	Circle circle = new Circle();

	/**
	 * Constructor for shape which configures the default shape
	 * 
	 * @param c the color of the shape
	 */
	public DrawShape(Color c) {
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
	
	public DrawShape(Color c, double radi) {
		circle.setFill(c);
		circle.setRadius(radi);
		
	}
	
	/**
	 * Gets a default polygon
	 * 
	 * @return a new polygon with default size and shape
	 */
	public Polygon getPolygon() {
		return shape;
	}
	
	/**
	 * Gets a circle
	 * 
	 * @return a new cirlce with radius.
	 */
	public Circle getCircle() {
		return circle;
	}
}