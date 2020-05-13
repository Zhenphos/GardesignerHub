package objects;

import java.util.ArrayList;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Shape {
	private static final double defaultSize = 100;
	
	Polygon shape = new Polygon();
	
	/**
	 * @param c the color of the shape
	 */
	public Shape(Color c) {
		shape.setFill(c);

		shape.getPoints().addAll(new Double[] {				
			1.0, 1.0,
			1.0, defaultSize/2 + 1,
			1.0, defaultSize + 1,
			defaultSize/2 + 1, defaultSize + 1,
			defaultSize + 1, defaultSize + 1,
			defaultSize + 1, defaultSize/2 + 1,
			defaultSize + 1, 1.0,
			defaultSize/2 + 1, 1.0
			});
	}
	
	/**
	 * 
	 * @return a new polygon with default size and shape
	 */
	public Polygon getPolygon() {
		return shape;
	}
}
