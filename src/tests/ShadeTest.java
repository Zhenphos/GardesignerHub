package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import javafx.scene.paint.Color;
import objects.Shade;

/**
 * ShadeTest for Gardesigner Hub. Tests Shade class.
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */
public class ShadeTest {

	@Test
	/**
	 * Tests Shade constructor
	 */
	public void testMakeShape() {
		Shade shade = new Shade();
		assertEquals(shade.getShape().getPolygon().getFill(), Color.GREY);
	}

	@Test
	/**
	 * Tests getX
	 */
	public void getXTest() {
		Shade shade = new Shade();
		assertEquals(shade.getX(), 0, .1);
	}
	
	@Test
	/**
	 * Tests getY
	 */
	public void getYTest() {
		Shade shade = new Shade();
		assertEquals(shade.getY(), 0, .1);
	}
}
