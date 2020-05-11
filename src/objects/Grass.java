package objects;

import javafx.scene.paint.Color;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Grass extends GardenObject {
	
	public Grass() {
		shape = new Shape(Color.LAWNGREEN);
		xLoc = this.shape.getXValue();
		yLoc = this.shape.getYValue();
	}
}
