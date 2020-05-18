package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import javafx.scene.paint.Color;
import objects.Stream;

/**
 * StreamTest for Gardendesigner Hub. Tests Stream class.
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class StreamTest {

	@Test
	public void testMakeShape() {
		Stream stream = new Stream();
		assertEquals(stream.getShape().getPolygon().getFill(), Color.LIGHTBLUE);
	}

}
