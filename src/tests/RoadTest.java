package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import javafx.scene.paint.Color;
import objects.Road;

/**
 * RoadTest for Gardendesigner Hub. Tests Road class.
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class RoadTest {

	@Test
	public void testMakeShape() {
		Road road = new Road();
		assertEquals(road.getShape().shape.getFill(), Color.LIGHTYELLOW);
	}

}
