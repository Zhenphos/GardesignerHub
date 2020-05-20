package tests;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;

import mvc.Model;
import objects.GardenObject;

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
		
	}
	
	@Test
	/**
	 * Tests addGardenObject(GardenObject)
	 */
	public void testAddGardenObject() {
		//Plant p = new Plant();
		Model m = new Model();
		Collection<GardenObject> c = m.getGardenObjects();
		//m.addGardenObject(p);
		assertEquals(c.size(), c.size() + 1);
	}
	
	@Test
	/**
	 * Tests removeGardenObject(GardenObject)
	 */
	public void testRemoveGardenObject() {
		//Plant p = new Plant();
		Model m = new Model();
		//m.removeGardenObject(p);
		//assertNull("Should be null", p);

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
