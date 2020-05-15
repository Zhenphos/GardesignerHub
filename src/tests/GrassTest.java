package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import javafx.scene.paint.Color;
import objects.Grass;

/**
 * GrassTest for Gardendesigner Hub. Tests Grass class.
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class GrassTest {
	
	@Test
	public void testMakeShape() {
		Grass grass = new Grass();
		assertEquals(grass.getShape().shape.getFill(), Color.LAWNGREEN);
	}
	
}
