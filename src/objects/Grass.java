package objects;

import java.io.Serializable;

import javafx.scene.paint.Color;

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
		shape = new DrawShape(Color.LAWNGREEN);
	}
}