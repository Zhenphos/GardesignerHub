package objects;

import javafx.scene.paint.Color;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Shade extends GardenObject {
	double darknessLevel;
	String direction;
	Shape shape;
	
	public Shade() {
		shape = new Shape(Color.GREY);
	}

}
