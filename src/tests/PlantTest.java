package tests;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import enums.PlantType;
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
		Plant testPlant = new Plant(); // TODO add dummy qualities for test plant
		testPlant.incrementSize();
		assertEquals(testPlant.getSize(), 101);
	}

	@Test
	public void testMeetsRequirements() {
		System.out.println("Testing meetsRequirements()");
		Plant testPlant = new Plant();
		assertEquals(testPlant.meetsRequirements(), false);
		
		GardenModel testGM = new GardenModel(500, 500);
		
		Iterator<GardenObject> plantIterator1 = testGM.getGardenObjects().iterator();
		Iterator<GardenObject> plantIterator2 = testGM.getGardenObjects().iterator();
		while(plantIterator1.hasNext()) {
			if (plantIterator1.next() instanceof Plant) {
				assertEquals(((Plant) plantIterator2.next()).meetsRequirements(), true);
				// TODO add requirements to check against
			} else {
				plantIterator2.next();
			}
		}
	}
	
}
