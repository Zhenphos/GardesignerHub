package tests;

import static org.junit.Assert.*;
import java.util.Collection;

import org.junit.Test;

import mvc.Model;
import mvc.View;
import objects.GardenObject;
import objects.Plant;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class ModelTest {

	@Test
	public void testAddGardenObject() {
		Plant p = new Plant();
		Model m = new Model(View.getCanvasWidth(), View.getCanvasHeight());
		Collection<GardenObject> c = m.getGardenObjects();
<<<<<<< HEAD
		m.addGardenObject(p);
=======
		Model.addGardenObject(p);
>>>>>>> master
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
		Model model = new Model(View.getCanvasWidth(), View.getCanvasHeight());
		Collection<GardenObject> c = model.load(filename);
		if (c.size() == 0)
			fail("No object loaded in the collection");

	}

	@Test
	public void testRemoveGardenObject() {
		Plant p = new Plant();
		Model m = new Model(View.getCanvasWidth(), View.getCanvasHeight());
		m.removeGardenObject(p);
		assertNull("Should be null", p);

	}

}
