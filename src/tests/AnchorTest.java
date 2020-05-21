package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import javafx.beans.property.DoubleProperty;
import javafx.scene.paint.Color;
import objects.Anchor;

/**
 * AnchorTest for Gardesigner Hub. Tests Anchor class.
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */
public class AnchorTest { // TODO update
	
	@Test
	public void testSetCommon() {
		//ArrayList<Anchor> someAnchors = new ArrayList<Anchor>();
		//assertEquals(someAnchors., actual);
	}
	
	@Test
	public void testAddAnchor() {
		Color testColor = null;
		DoubleProperty testProp = null;
		Anchor testAnchor = new Anchor(testColor, testProp, testProp);
		
		ArrayList<Anchor> someAnchors = new ArrayList<Anchor>();
		someAnchors.add(testAnchor);
		someAnchors.add(testAnchor);
		
		testAnchor.addAnchor(testAnchor);
		
		assertEquals(testAnchor, someAnchors);
	}
	
	@Test
	public void testAnchor() {
		
	}
}
