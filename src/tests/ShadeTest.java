package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import javafx.scene.paint.Color;
import objects.Shade;

/**
 * ShadeTest for Gardendesigner Hub. Tests Shade class.
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class ShadeTest {

	@Test
	public void testMakeShape() {
		Shade shade = new Shade();
		assertEquals(shade.getShape().shape.getFill(), Color.GREY);
	}

}
