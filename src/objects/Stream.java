package objects;

import javafx.scene.paint.Color;
import java.io.Serializable;

/**
 * Stream class for Gardendesigner Hub
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Stream extends GardenObject implements Serializable {

	/**
	 * Constructs a stream object and initializes the stream shape color
	 */
	public Stream() {
		shape = new Shape(Color.LIGHTBLUE);
	}
}