package objects;

import javafx.scene.paint.Color;

import java.io.Serializable;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Grass extends GardenObject implements Serializable {
	
	public Grass() {
		shape = new Shape(Color.LAWNGREEN);
	}
}
