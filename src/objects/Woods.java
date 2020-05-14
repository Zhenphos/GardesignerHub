package objects;

import javafx.scene.paint.Color;
import java.io.Serializable;

/**
 * Woods class for Gardendesigner Hub
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Woods extends GardenObject implements Serializable {

	/**
	 * Constructs a woods object and initializes the woods shape color
	 */
	public Woods() {
		shape = new DrawShape(Color.FORESTGREEN);
	}
}