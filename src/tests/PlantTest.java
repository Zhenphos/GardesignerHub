package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import enums.PlantType;
import mvc.Controller;
import objects.Plant;

/**
 * PlantTest for Gardesigner Hub. Tests Plant class.
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */
public class PlantTest { // TODO update
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
	String commonName = "name";
	String soilMoisturePreference = "";
	String sunlightExposure = "";
	String[] floweringMonths = { "July", "August" };
	String[] wildlifeAttracted = { "Bees" };
	String[] otherAttributes = { "Other" };
	boolean deerResistant = true;
	String foliageColor = "green";
	String growthRate = "1";
	String saltTolerance = "1";
	String[] seasonsOfInterest = { "July" };
	String[] phytoremediationElementsCleaned = { "element" };
	PlantType type = PlantType.ALL;
	
	/**
	 * Tests the plant constructor and, by extension, the getters.
	 */
	@Test
	public void testPlant() {	
		Plant plant = new Plant(bloomColors, hardinessMax, hardinessMin, heightMaxInches, heightMinInches,
				plantBotanicalName, spacingMax, spacingMin, spreadMax, spreadMin, commonName, soilMoisturePreference,
				sunlightExposure, floweringMonths, wildlifeAttracted, otherAttributes, deerResistant, foliageColor,
				growthRate, saltTolerance, seasonsOfInterest, phytoremediationElementsCleaned, type);
		
		assertEquals(plant.getBotanicalName(), plantBotanicalName);
		assertEquals(plant.getHeightMinInches(), heightMinInches);
		assertEquals(plant.getHeightMaxInches(), heightMaxInches);
		assertEquals(plant.getSpreadMin(), spreadMin);
		assertEquals(plant.getSpreadMax(), spreadMax);
		assertEquals(plant.getSpacingMin(), spacingMin);
		assertEquals(plant.getSpacingMax(), spacingMax);
		assertEquals(plant.getHardinessMin(), hardinessMin);
		assertEquals(plant.getHardinessMax(), hardinessMax);
		assertEquals(plant.getBloomColors(), bloomColors);
		assertEquals(plant.getCommonName(), commonName);
		assertEquals(plant.getSoilMoisturePreference(), soilMoisturePreference);
		assertEquals(plant.getSunlightExposure(), sunlightExposure);
		assertEquals(plant.getFloweringMonths(), Controller.ArrayOfStrings(floweringMonths));
		assertEquals(plant.getWildlifeAttracted(), Controller.ArrayOfStrings(wildlifeAttracted));
		assertEquals(plant.getOtherAttributes(), Controller.ArrayOfStrings(otherAttributes));
		assertEquals(plant.isDeerResistant(), deerResistant);
		assertEquals(plant.getFoliageColor(), foliageColor);
		assertEquals(plant.getGrowthRate(), growthRate);
		assertEquals(plant.getSaltTolerance(), saltTolerance);
		assertEquals(plant.getSeasonsOfInterest(), Controller.ArrayOfStrings(seasonsOfInterest));
		assertEquals(plant.getPhytoremediationElementsCleaned(),
				Controller.ArrayOfStrings(phytoremediationElementsCleaned));
		assertEquals(plant.getType(), type);
		
		Plant plant2 = new Plant(bloomColors, hardinessMax, hardinessMin, heightMaxInches, heightMinInches,
				plantBotanicalName, spacingMax, spacingMin, spreadMax, -1, commonName, soilMoisturePreference,
				sunlightExposure, floweringMonths, wildlifeAttracted, otherAttributes, deerResistant, foliageColor,
				growthRate, saltTolerance, seasonsOfInterest, phytoremediationElementsCleaned, type);
		
		assertEquals(plant2.getSpacingMin(), spacingMin);
	}
	
	@Test
	/**
	 * Tests the overridden toString()
	 */
	public void testToString() {
		Plant emptyPlant = new Plant();
		assertEquals(null, emptyPlant.toString());
		
		Plant plant = new Plant(bloomColors, hardinessMax, hardinessMin, heightMaxInches, heightMinInches,
				plantBotanicalName, spacingMax, spacingMin, spreadMax, spreadMin, commonName, soilMoisturePreference,
				sunlightExposure, floweringMonths, wildlifeAttracted, otherAttributes, deerResistant, foliageColor,
				growthRate, saltTolerance, seasonsOfInterest, phytoremediationElementsCleaned, type);
		assertEquals(plant.toString(), plantBotanicalName);
	}
	
	@Test
	/**
	 * Tests changePlantSize(double)
	 */
	public void testChangePlantSize() {
		
	}
	
	@Test
	/**
	 * Tests copyOfPlant()
	 */
	public void testCopyOfPlant() {
		Plant plant = new Plant(bloomColors, hardinessMax, hardinessMin, heightMaxInches, heightMinInches,
				plantBotanicalName, spacingMax, spacingMin, spreadMax, spreadMin, commonName, soilMoisturePreference,
				sunlightExposure, floweringMonths, wildlifeAttracted, otherAttributes, deerResistant, foliageColor,
				growthRate, saltTolerance, seasonsOfInterest, phytoremediationElementsCleaned, type);
		
		assertEquals(plant.getBotanicalName(), plant.copyOfPlant().getBotanicalName());
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
	
	@Test
	/**
	 * Tests returnDetailedInfo()
	 */
	public void testReturnDetailedInfo() {
		
	}
	
	@Test
	/**
	 * Tests overridden hashCode()
	 */
	public void testHashCode() {
		
	}
	
	@Test
	/**
	 * Tests the overridden equals(Object)
	 */
	public void testEquals() {
		
	}
}
