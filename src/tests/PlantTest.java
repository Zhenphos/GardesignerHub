package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import objects.Plant;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class PlantTest {

	@Test
	public void testPlant() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testIncrementSize() {
		System.out.println("Testing incrementSize()");
		Plant testPlant = new Plant("green", 2, "flower", 100);
		testPlant.incrementSize();
		assertEquals(testPlant.getSize(), 101);
	}

	@Test
	public void testMeetsRequirements() {
		fail("Not yet implemented"); // TODO
	}

}
