package objects;

import javafx.scene.paint.Color;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Woods extends GardenObject {
	
	public Woods() {
		shape = new Shape(Color.FORESTGREEN);
		xLoc = this.shape.getXValue();
		yLoc = this.shape.getYValue();
	}
}
