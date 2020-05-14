package objects;

import javafx.scene.paint.Color;
import java.io.Serializable;

/**
 * Shade class for Gardendesigner Hub
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Shade extends GardenObject implements Serializable {
	double darknessLevel;
	String direction;

	/**
	 * Constructs a shade object and initializes the shade shape color
	 */
	public Shade() {
		shape = new Shape(Color.GREY);
		shape.getPolygon().setStyle("--fx-opacity:0.3;");
	}
}
