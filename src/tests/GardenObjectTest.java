package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import objects.Plant;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class GardenObjectTest {

	@Test
	public void testMakeShape() {
		System.out.println("Testing makeShape()");
		Plant testObj = new Plant();
		testObj.makeShape();
		//assertEquals(); don't know how to test this right now
	}

}
