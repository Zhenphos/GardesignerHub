package objects;

import java.util.ArrayList;
import java.util.Collection;
import javafx.scene.paint.Color;

import javafx.scene.shape.Polygon;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Shape extends GardenObject {
	Collection<Vertex> vertices = new ArrayList<Vertex>();
	Polygon shape = new Polygon();
	
	/**
	 * @param c the color of the shape
	 */
	public Shape(Color c) {
		shape.setStroke(Color.BLACK);
		shape.setFill(c);
		Vertex p1 = new Vertex(5.0, 5.0);
		Vertex p2 = new Vertex(5.0, 30.0);
		Vertex p3 = new Vertex(5.0, 55.0);
		Vertex p4 = new Vertex(30.0, 55.0);
		Vertex p5 = new Vertex(55.0, 55.0);
		Vertex p6 = new Vertex(55.0, 30.0);
		Vertex p7 = new Vertex(55.0, 5.0);
		Vertex p8 = new Vertex(30.0, 5.0);
		
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		vertices.add(p1);
		vertices.add(p2);
		vertices.add(p3);
		vertices.add(p4);
		vertices.add(p5);
		vertices.add(p6);
		vertices.add(p7);
		vertices.add(p8);
	}

	/**
	 * 
	 * @return the collection of vertexes for the polygon
	 */
	public Collection<Vertex> getVertices() {		
		return vertices;
	}
	
	/**
	 * 
	 * @return a new polygon with default size and shape
	 */
	public Polygon getPolygon() {
		return shape;
	}
}
