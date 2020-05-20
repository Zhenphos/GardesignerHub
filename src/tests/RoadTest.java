package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import javafx.scene.paint.Color;
import objects.Road;

/**
 * RoadTest for Gardesigner Hub. Tests Road class.
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */
public class RoadTest {

	@Test
	/**
	 * Tests Road constructor
	 */
	public void testMakeShape() {
		Road road = new Road();
		assertEquals(road.getShape().getPolygon().getFill(), Color.LIGHTYELLOW);
	}

}
