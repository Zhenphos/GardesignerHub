package objects;

import javafx.scene.paint.Color;
import java.io.Serializable;

/**
 * Grass class for Gardendesigner Hub
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Grass extends GardenObject implements Serializable {
	
	/**
	 * Constructs a grass object and initializes the grass shape color
	 */
	public Grass() {
		shape = new Shape(Color.LAWNGREEN);
	}
}