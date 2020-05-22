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
		
	}
	
	/**
	 * Tests getPlantObjects()
	 */
	@Test
	public void testGetPlantObjects() {
		
	}
	
	/**
	 * Tests addGardenObject(GardenObject)
	 */
	@Test
	public void testAddGardenObject() {
		//Plant p = new Plant();
		Model m = new Model();
		Collection<GardenObject> c = m.getGardenObjects();
		//m.addGardenObject(p);
		assertEquals(c.size(), c.size() + 1);
	}
	
	/**
	 * Tests removeGardenObject(GardenObject)
	 */
	@Test
	public void testRemoveGardenObject() {
		//Plant p = new Plant();
		Model m = new Model();
		//m.removeGardenObject(p);
		//assertNull("Should be null", p);

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
