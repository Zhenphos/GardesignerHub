package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
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
		/*
		ArrayList<Anchor> someAnchors = new ArrayList<Anchor>();
		Color testColor = new Color(5, 5, 5, 10);
		DoubleProperty testProp = null;
		Anchor testAnchor = new Anchor(testColor, testProp, testProp);
		
		testAnchor.setCommon(someAnchors);*/
		//assertEquals(testAnchor.getAnchors(), someAnchors);
		assertEquals(5, 10);
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
	
	@Test
	public void testGetAnchors() {
		ArrayList<Anchor> someAnchors = new ArrayList<Anchor>();
		//assertEquals(, someAnchors);
	}
}
