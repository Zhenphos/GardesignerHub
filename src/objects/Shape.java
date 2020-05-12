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
	private static final double defaultSize = 50;
	
	ArrayList<Vertex> vertices = new ArrayList<Vertex>();
	Polygon shape = new Polygon();
	
	/**
	 * @param c the color of the shape
	 */
	public Shape(Color c) {
		shape.setFill(c);
		Vertex p1 = new Vertex(1, 1);
		Vertex p2 = new Vertex(1, defaultSize + 1);
		Vertex p3 = new Vertex(1, defaultSize * 2 + 1);
		Vertex p4 = new Vertex(defaultSize + 1, defaultSize * 2 + 1);
		Vertex p5 = new Vertex(defaultSize * 2 + 1, defaultSize * 2 + 1);
		Vertex p6 = new Vertex(defaultSize * 2 + 1, defaultSize + 1);
		Vertex p7 = new Vertex(defaultSize * 2 + 1, 1);
		Vertex p8 = new Vertex(defaultSize + 1, 1);
		
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		vertices.add(p1);
		vertices.add(p2);
		vertices.add(p3);
		vertices.add(p4);
		vertices.add(p5);
		vertices.add(p6);
		vertices.add(p7);
		vertices.add(p8);
		
		for (Vertex vertex : vertices) {
            shape.getPoints().addAll(vertex.getPoint());
        }
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
		return shape;
	}
	
	/**
	 * 
	 * @return the x position of the shape
	 */
	public double getXValue() {
		double min;
		double max;
		if (vertices.size() != 0) {
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
		if (vertices.size() != 0) {
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
