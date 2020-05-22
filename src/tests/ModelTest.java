package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import mvc.Model;
import objects.GardenObject;
import objects.Plant;

/**
 * ModelTest for Gardesigner Hub. Tests Model class.
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */
public class ModelTest { // TODO update

	@Test
	/**
	 * Tests width setters and getters
	 */
	public void testWidth() {
		
	}
	
	@Test
	/**
	 * Tests length setters and getters
	 */
	public void testLength() {
		
	}
	
	@Test
	/**
	 * Tests light setters and getters
	 */
	public void testLight() {
		
	}
	
	@Test
	/**
	 * Tests rain setters and getters
	 */
	public void testRain() {
		
	}
	
	@Test
	/**
	 * Tests deer setters and getters
	 */
	public void testDeer() {
		
	}
	
	@Test
	/**
	 * Tests soil pH setters and getters
	 */
	public void testSoilPH() {
		
	}
	
	@Test
	/**
	 * Tests age setters and getters
	 */
	public void testAge() {
		
	}
	
	@Test
	/**
	 * Tests season setters and getters
	 */
	public void testSeason() {
		
	}
	
	@Test
	/**
	 * Tests getGardenObjects()
	 */
	public void testGetGardenObjects() {
		
	}
	
	@Test
	/**
	 * Tests getPlantObjects()
	 */
	public void testGetPlantObjects() {
		Plant testPlant = new Plant();
		Model testModel = new Model();
		testModel.addGardenObject(testPlant);
		testModel.addGardenObject(testPlant);
		testModel.addGardenObject(testPlant);
		
		ArrayList<Plant> testList = testModel.getPlantObjects();
		assertEquals(testList.size(), 3);
	}
	
	@Test
	/**
	 * Tests addGardenObject(GardenObject)
	 */
	public void testAddGardenObject() {
		Plant testPlant = new Plant();
		Model testModel = new Model();
		Collection<GardenObject> testCollection = testModel.getGardenObjects();
		int startSize = testCollection.size();
		testModel.addGardenObject(testPlant);
		int expectedFinishSize = startSize + 1;
				
		assertEquals(testCollection.size(), expectedFinishSize);
	}
	
	@Test
	/**
	 * Tests removeGardenObject(GardenObject)
	 */
	public void testRemoveGardenObject() {
		Plant testPlant = new Plant();
		Model testModel = new Model();
		Collection<GardenObject> testCollection = testModel.getGardenObjects();
		testModel.addGardenObject(testPlant);
		int startSize = testCollection.size();
		testModel.removeGardenObject(testPlant);
		int expectedFinishSize = startSize - 1;
				
		assertEquals(testCollection.size(), expectedFinishSize);
	}
	
	@Test
	/**
	 * Tests x setters and getters
	 */
	public void testX() {
		
	}
	
	@Test
	/**
	 * Tests y setters and getters
	 */
	public void testY() {
		
	}
}
