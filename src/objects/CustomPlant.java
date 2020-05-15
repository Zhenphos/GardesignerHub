package objects;

import javafx.scene.paint.Color;
import java.io.Serializable;

/**
 * CustomPlant class for Gardendesigner Hub
 * Lets the user enter their own plants
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class CustomPlant extends Plant implements Serializable {
	

	/**
	 * Constructs a CustomPlant object and initializes the shade shape color
	 */
	public CustomPlant() {
		super();
		shape = new DrawShape(Color.WHITE);
		shape.getPolygon().setStyle("--fx-opacity:0.3;");
	}
}
