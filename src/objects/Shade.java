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
	
	public Shade() {
		shape = new Shape(Color.GREY);
		shape.getPolygon().setStyle("--fx-opacity:0.3;");

	}

}
