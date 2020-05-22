package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import enums.PlantType;
import objects.Plant;

/**
 * ControllerTest for Gardesigner Hub. Tests Controller class.
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */
public class ControllerTest { // TODO update - not sure if most of these are needed
	
	@Test
	public void onMainMenuNewTest() {
		
	}
	
	@Test
	public void onMainMenuHelpTest() {
		
	}
	
	@Test
	public void onMainMenuLoadTest() {
		
	}
	
	@Test
	public void onGardenInfoPrevTest() {
		
	}
	
	@Test
	public void onGardenInfoNextTest() {
		
	}
	
	@Test
	public void onPlantPlacementPrevTest() {
		
	}
	
	@Test
	public void onPlantPlacementNextTest() {
		
	}
	
	@Test
	public void onTutorialPrevTest() {
		
	}
	
	@Test
	public void onDrawPrevTest() {
		
	}
	
	@Test
	public void onDrawNextTest() {
		
	}
	
	@Test
	public void onDrawGrassTest() {
		
	}
	
	@Test
	public void onDrawRoadTest() {
		
	}
	
	@Test
	public void onDrawStreamTest() {
		
	}
	
	@Test
	public void onDrawWoodsTest() {
		
	}
	
	@Test
	public void importPlantsTest() {
		ArrayList<Plant> invalidList1 = mvc.Controller.importPlants("invalid", PlantType.ALKALINE_SOIL_TOLERANT);
		ArrayList<Plant> invalidList2 = mvc.Controller.importPlants("also invalid", PlantType.ALKALINE_SOIL_TOLERANT);
		assertEquals(invalidList1, invalidList2);
		ArrayList<Plant> validList = mvc.Controller.importPlants("resources/PlantData/PlantList_00.csv", PlantType.ALL);
		ArrayList<Plant> validList2 = mvc.Controller.importPlants("resources/PlantData/PlantList_00.csv", PlantType.ALL);
		assertEquals(validList, validList2);
	}
}
