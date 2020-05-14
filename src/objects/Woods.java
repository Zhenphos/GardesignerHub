package objects;

import javafx.scene.paint.Color;

import java.io.Serializable;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Woods extends GardenObject implements Serializable {
	
	public Woods() {
		shape = new Shape(Color.FORESTGREEN);
	}
}
