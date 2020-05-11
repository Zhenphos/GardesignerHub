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

public class Shape {
	ArrayList<Vertex> vertices = new ArrayList<Vertex>(8);
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
	public ArrayList<Vertex> getVertices() {		
		return vertices;
	}
	
	/**
	 * 
	 * @return a new polygon with default size and shape
	 */
	public Polygon getPolygon() {
		for (Vertex vertex : vertices) {
            shape.getPoints().addAll(vertex.getPoint());
        }
		return shape;
	}
	
	/**
	 * 
	 * @return the x position of the shape
	 */
	public double getXValue() {
		double min;
		double max;
		if (vertices.get(0) != null) {
			min = vertices.get(0).getX();
			max = vertices.get(0).getX();
			for (Vertex vertex:vertices) {
				if (vertex.getX() < min) {
					min = vertex.getX();
				}
				if (vertex.getX() > max) {
					max = vertex.getX();
				}
			}
			return (min + max)/2;
		} else {
			return 0;
		}
	}
	
	/**
	 * 
	 * @return the y position of the shape
	 */
	public double getYValue() {
		double min;
		double max;
		if (vertices.get(0) != null) {
			min = vertices.get(0).getY();
			max = vertices.get(0).getY();
			for (Vertex vertex:vertices) {
				if (vertex.getY() < min) {
					min = vertex.getY();
				}
				if (vertex.getY() > max) {
					max = vertex.getY();
				}
			}
			return (min + max)/2;
		} else {
			return 0;
		}
	}
}
