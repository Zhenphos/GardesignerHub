package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import javafx.scene.paint.Color;
import objects.Woods;

/**
 * WoodsTest for Gardesigner Hub. Tests Woods class.
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */
public class WoodsTest {

	/**
	 * Tests Woods constructor
	 */
	@Test
	public void testMakeShape() {
		Woods woods = new Woods();
		assertEquals(woods.getShape().getPolygon().getFill(), Color.FORESTGREEN);
	}

}
