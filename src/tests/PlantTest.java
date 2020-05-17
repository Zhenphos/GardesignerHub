package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import objects.Plant;

/**
 * PlantTest for Gardendesigner Hub. Tests Plant class.
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class PlantTest {
	String plantBotanicalName = "name";
	int heightMinInches = 0;
	int heightMaxInches = 0;
	int spreadMin = 0;
	int spreadMax = 0;
	int spacingMin = 0;
	int spacingMax = 0;
	int hardinessMin = 0;
	int hardinessMax = 0;
	String bloomColors = "red";
	
	/**
	 * Tests the plant constructor and, by extension, the getters
	 */
	@Test
	public void constructorTest() {	
		Plant plant = new Plant(plantBotanicalName, heightMinInches, heightMaxInches, spreadMin, spreadMax, spacingMin,
				spacingMax, hardinessMin, hardinessMax, bloomColors);
		
		assertEquals(plant.getPlantBotanicalName(), plantBotanicalName);
		assertEquals(plant.getHeightMinInches(), heightMinInches);
		assertEquals(plant.getHeightMaxInches(), heightMaxInches);
		assertEquals(plant.getSpreadMin(), spreadMin);
		assertEquals(plant.getSpreadMax(), spreadMax);
		assertEquals(plant.getSpacingMin(), spacingMin);
		assertEquals(plant.getSpacingMax(), spacingMax);
		assertEquals(plant.getHardinessMin(), hardinessMin);
		assertEquals(plant.getHardinessMax(), hardinessMax);
		assertEquals(plant.getBloomColors(), bloomColors);
		
		Plant plant2 = new Plant(plantBotanicalName, heightMinInches, heightMaxInches, -1, spreadMax, spacingMin,
				spacingMax, hardinessMin, hardinessMax, bloomColors);
		
		assertEquals(plant2.getSpacingMin(), spacingMin);
	}
	
	@Test
	public void toStringTest() {
		Plant emptyPlant = new Plant();
		assertEquals(null, emptyPlant.toString());
		
		Plant plant = new Plant(plantBotanicalName, heightMinInches, heightMaxInches, spreadMin, spreadMax, spacingMin,
				spacingMax, hardinessMin, hardinessMax, bloomColors);
		assertEquals(plant.toString(), plantBotanicalName);
	}
	
	@Test
	public void copyOfPlantTest() {
		Plant plant = new Plant(plantBotanicalName, heightMinInches, heightMaxInches, spreadMin, spreadMax, spacingMin,
				spacingMax, hardinessMin, hardinessMax, bloomColors);
		
		assertEquals(plant.getPlantBotanicalName(), plant.copyOfPlant().getPlantBotanicalName());
		assertEquals(plant.getHeightMinInches(), plant.copyOfPlant().getHeightMinInches());
		assertEquals(plant.getHeightMaxInches(), plant.copyOfPlant().getHeightMaxInches());
		assertEquals(plant.getSpreadMin(), plant.copyOfPlant().getSpreadMin());
		assertEquals(plant.getSpreadMax(), plant.copyOfPlant().getSpreadMax());
		assertEquals(plant.getSpacingMin(), plant.copyOfPlant().getSpacingMin());
		assertEquals(plant.getSpacingMax(), plant.copyOfPlant().getSpacingMax());
		assertEquals(plant.getHardinessMin(), plant.copyOfPlant().getHardinessMin());
		assertEquals(plant.getHardinessMax(), plant.copyOfPlant().getHardinessMax());
		assertEquals(plant.getBloomColors(), plant.copyOfPlant().getBloomColors());
	}
}
