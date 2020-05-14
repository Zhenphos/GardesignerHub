package objects;

import javafx.scene.paint.Color;

import java.io.Serializable;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Road extends GardenObject implements Serializable {
	
	public Road() {
		shape = new Shape(Color.LIGHTYELLOW);
	}
	
}
