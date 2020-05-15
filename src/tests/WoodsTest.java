package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import javafx.scene.paint.Color;
import objects.Woods;

/**
 * WoodsTest for Gardendesigner Hub. Tests Woods class.
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class WoodsTest {

	@Test
	public void testMakeShape() {
		Woods woods = new Woods();
		assertEquals(woods.getShape().shape.getFill(), Color.FORESTGREEN);
	}

}
