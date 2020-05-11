package objects;

import javafx.scene.paint.Color;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Stream extends GardenObject {
	
	public Stream() {
		shape = new Shape(Color.LIGHTBLUE);
		xLoc = this.shape.getXValue();
		yLoc = this.shape.getYValue();
	}
}
