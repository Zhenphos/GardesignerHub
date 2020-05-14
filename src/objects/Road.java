package objects;

import javafx.scene.paint.Color;
import java.io.Serializable;

/**
 * Road class for Gardendesigner Hub
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Road extends GardenObject implements Serializable {

	/**
	 * Constructs a road object and initializes the road shape color
	 */
	public Road() {
		shape = new DrawShape(Color.LIGHTYELLOW);
	}
}