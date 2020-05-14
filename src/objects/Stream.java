package objects;

import javafx.scene.paint.Color;

import java.io.Serializable;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Stream extends GardenObject implements Serializable {
	
	public Stream() {
		shape = new Shape(Color.LIGHTBLUE);
	}
}
