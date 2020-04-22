package tests;

import static org.junit.Assert.*;
import java.util.Collection;

import org.junit.Test;

import mvc.GardenModel;
import objects.GardenObject;
import objects.Plant;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class GardenModelTest {

	@Test
	public void testAddGardenObject() {
		Plant p = new Plant();
		Collection<GardenObject> c = GardenModel.getGardenObjects();
		GardenModel.addGardenObject(p);
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
		Collection<GardenObject> c = GardenModel.load(filename);
		if (c.size() == 0)
			fail("No object loaded in the collection");

	}

	@Test
	public void testRemoveGardenObject() {
		Plant p = new Plant();
		GardenModel.removeGardenObject(p);
		assertNull("Should be null", p);

	}

}
