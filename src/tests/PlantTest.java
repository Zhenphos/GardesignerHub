package tests;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import mvc.GardenModel;
import objects.GardenObject;
import objects.Plant;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class PlantTest {

	@Test
	public void testIncrementSize() {
		System.out.println("Testing incrementSize()");
		Plant testPlant = new Plant(null, "green", 2, "flower", 100, 0, 0, null, 0, 0, 0, 0);
		testPlant.incrementSize();
		assertEquals(testPlant.getSize(), 101);
	}

	@Test
	public void testMeetsRequirements() {
		System.out.println("Testing meetsRequirements()");
		Plant testPlant = new Plant();
		assertEquals(testPlant.meetsRequirements(), false);
		
		Iterator<GardenObject> plantIterator1 = GardenModel.getGardenObjects().iterator();
		Iterator<GardenObject> plantIterator2 = GardenModel.getGardenObjects().iterator();
		while(plantIterator1.hasNext()) {
			if (plantIterator1.next() instanceof Plant) {
				assertEquals(((Plant) plantIterator2.next()).meetsRequirements(), true); // need to figure out what to test here
			} else {
				plantIterator2.next();
			}
		}
	}
	
}
