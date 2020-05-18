package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
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
	public void testAddGardenObject() {
		//Plant p = new Plant();
		Model m = new Model();
		Collection<GardenObject> c = m.getGardenObjects();
		//m.addGardenObject(p);
		assertEquals(c.size(), c.size() + 1);

	}

	@Test
	public void testCalculateRating() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testLoad() {
		fail("Not yet implemented"); // TODO
		String filename = " ";
		Model model = new Model();
		Collection<GardenObject> c = new ArrayList<>();//model.load(filename);
		if (c.size() == 0)
			fail("No object loaded in the collection");

	}

	@Test
	public void testRemoveGardenObject() {
		//Plant p = new Plant();
		Model m = new Model();
		//m.removeGardenObject(p);
		//assertNull("Should be null", p);

	}

}
