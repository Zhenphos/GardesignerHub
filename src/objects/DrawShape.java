package objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

/**
 * Shape class for Gardendesigner Hub
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class DrawShape implements Serializable {
	private static final double defaultSize = 100;

	private String color;
	private double x;
	private double y;
	private double radius;
	private List<Double> points;
	private Polygon shape;
	private Circle circle;

	/**
	 * Constructor for shape which configures the default shape
	 * 
	 * @param c the color of the shape
	 */
	public DrawShape(Color c) {
		this.shape = new SerializablePolygon();
		this.shape.setFill(c);
		this.shape.getPoints().addAll(new Double[] {
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
	
	public DrawShape(Color c, double radi) {
		this.circle = new SerializableCircle();
		this.circle.setFill(c);
		this.circle.setRadius(radi);
	}
	
	/**
	 * Gets a default polygon
	 * 
	 * @return a new polygon with default size and shape
	 */
	public Polygon getPolygon() {
		return shape;
	}
	
	/**
	 * Gets a circle
	 * 
	 * @return a new cirlce with radius.
	 */
	public Circle getCircle() {
		return circle;
	}

	public void save() {
		this.color = this.shape == null ? this.circle.getFill().toString() : this.shape.getFill().toString();
		this.points = new ArrayList<>();
		if (this.shape != null)
			this.points.addAll(this.shape.getPoints());
		this.x = this.shape == null ? this.circle.getLayoutX() : this.shape.getLayoutX();
		this.y = this.shape == null ? this.circle.getLayoutY() : this.shape.getLayoutY();
		if (this.circle != null)
			this.radius = this.circle.getRadius();
	}

	public void load() {
		this.shape = new SerializablePolygon();
		this.shape.setFill(Paint.valueOf(this.color));
		this.shape.getPoints().addAll(this.points);
		this.shape.setLayoutX(this.x);
		this.shape.setLayoutY(this.y);
		this.circle = new SerializableCircle();
		this.circle.setRadius(this.radius);
		this.circle.setFill(Paint.valueOf(this.color));
		this.circle.setLayoutX(this.x);
		this.circle.setLayoutY(this.y);
	}
}