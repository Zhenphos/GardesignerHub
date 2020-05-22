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

	/**
	 * Tests width setters and getters
	 */
	@Test
	public void testWidth() {
		
	}
	
	/**
	 * Tests length setters and getters
	 */
	@Test
	public void testLength() {
		
	}
	
	/**
	 * Tests light setters and getters
	 */
	@Test
	public void testLight() {
		
	}
	
	/**
	 * Tests rain setters and getters
	 */
	@Test
	public void testRain() {
		
	}
	
	/**
	 * Tests deer setters and getters
	 */
	@Test
	public void testDeer() {
		
	}
	
	/**
	 * Tests soil pH setters and getters
	 */
	@Test
	public void testSoilPH() {
		
	}
	
	/**
	 * Tests age setters and getters
	 */
	@Test
	public void testAge() {
		
	}
	
	/**
	 * Tests season setters and getters
	 */
	@Test
	public void testSeason() {
		
	}
	
	/**
	 * Tests getGardenObjects()
	 */
	@Test
	public void testGetGardenObjects() {
		Plant testPlant = new Plant();
		Model testModel = new Model();
		testModel.addGardenObject(testPlant);
		testModel.addGardenObject(testPlant);
		testModel.addGardenObject(testPlant);
		
		ArrayList<GardenObject> testList = testModel.getGardenObjects();
		assertEquals(testList.size(), 3);
	}
	
	/**
	 * Tests getPlantObjects()
	 */
	@Test
	public void testGetPlantObjects() {
		Plant testPlant = new Plant();
		Model testModel = new Model();
		testModel.addGardenObject(testPlant);
		testModel.addGardenObject(testPlant);
		testModel.addGardenObject(testPlant);
		
		ArrayList<Plant> testList = testModel.getPlantObjects();
		assertEquals(testList.size(), 3);
	}
	
	/**
	 * Tests addGardenObject(GardenObject)
	 */
	@Test
	public void testAddGardenObject() {
		Plant testPlant = new Plant();
		Model testModel = new Model();
		Collection<GardenObject> testCollection = testModel.getGardenObjects();
		int startSize = testCollection.size();
		testModel.addGardenObject(testPlant);
		int expectedFinishSize = startSize + 1;
				
		assertEquals(testCollection.size(), expectedFinishSize);
	}
	
	/**
	 * Tests removeGardenObject(GardenObject)
	 */
	@Test
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
	
	/**
	 * Tests x setters and getters
	 */
	@Test
	public void testX() {
		
	}
	
	/**
	 * Tests y setters and getters
	 */
	@Test
	public void testY() {
		
	}
}
