package tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import enums.PlantType;
import mvc.Controller;
import objects.Plant;
import objects.Shade;

/**
 * PlantTest for Gardesigner Hub. Tests Plant class.
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */
public class PlantTest { // TODO update
	String botanicalName = "name";
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
	String[] elementsCleaned = { "element" };
	PlantType type = PlantType.ALL;
	
	/**
	 * Tests the plant constructor and, by extension, the getters.
	 */
	@Test
	public void testPlant() {	
		Plant plant = new Plant(bloomColors, hardinessMax, hardinessMin, heightMaxInches, heightMinInches,
				botanicalName, spacingMax, spacingMin, spreadMax, spreadMin, commonName, soilMoisturePreference,
				sunlightExposure, floweringMonths, wildlifeAttracted, otherAttributes, deerResistant, foliageColor,
				growthRate, saltTolerance, seasonsOfInterest, elementsCleaned, type);
		
		assertEquals(plant.getBotanicalName(), botanicalName);
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
				Controller.ArrayOfStrings(elementsCleaned));
		assertEquals(plant.getType(), type);
		
		Plant plant2 = new Plant(bloomColors, hardinessMax, hardinessMin, heightMaxInches, heightMinInches,
				botanicalName, spacingMax, spacingMin, spreadMax, -1, commonName, soilMoisturePreference,
				sunlightExposure, floweringMonths, wildlifeAttracted, otherAttributes, deerResistant, foliageColor,
				growthRate, saltTolerance, seasonsOfInterest, elementsCleaned, type);
		
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
				botanicalName, spacingMax, spacingMin, spreadMax, spreadMin, commonName, soilMoisturePreference,
				sunlightExposure, floweringMonths, wildlifeAttracted, otherAttributes, deerResistant, foliageColor,
				growthRate, saltTolerance, seasonsOfInterest, elementsCleaned, type);
		assertEquals(plant.toString(), botanicalName);
	}
	
	@Test
	/**
	 * Tests changePlantSize(double)
	 */
	public void testChangePlantSize() {
		Plant testPlant = new Plant();
		testPlant.changePlantSize(10);
		assertEquals(5, 20);
	}
	
	@Test
	/**
	 * Tests copyOfPlant()
	 */
	public void testCopyOfPlant() {
		Plant plant = new Plant(bloomColors, hardinessMax, hardinessMin, heightMaxInches, heightMinInches,
				botanicalName, spacingMax, spacingMin, spreadMax, spreadMin, commonName, soilMoisturePreference,
				sunlightExposure, floweringMonths, wildlifeAttracted, otherAttributes, deerResistant, foliageColor,
				growthRate, saltTolerance, seasonsOfInterest, elementsCleaned, type);
		
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
		Plant plant = new Plant(bloomColors, hardinessMax, hardinessMin, heightMaxInches, heightMinInches,
				botanicalName, spacingMax, spacingMin, spreadMax, spreadMin, commonName, soilMoisturePreference,
				sunlightExposure, floweringMonths, wildlifeAttracted, otherAttributes, deerResistant, foliageColor,
				growthRate, saltTolerance, seasonsOfInterest, elementsCleaned, type);
		
		String info = "Plant [bloomColors=" + bloomColors + ", commonName=" + commonName + ", deerResistant=" + deerResistant
				+ ", floweringMonths=" + Arrays.toString(floweringMonths) + ", foliageColor=" + foliageColor
				+ ", growthRate=" + growthRate + ", hardinessMax=" + hardinessMax + ", hardinessMin=" + hardinessMin
				+ ", heightMaxInches=" + heightMaxInches + ", heightMinInches=" + heightMinInches + ", otherAttributes="
				+ Arrays.toString(otherAttributes) + ", phytoremediationElementsCleaned="
				+ Arrays.toString(elementsCleaned) + ", plantBotanicalName=" + botanicalName + ", saltTolerance="
				+ saltTolerance + ", seasonsOfInterest=" + Arrays.toString(seasonsOfInterest)
				+ ", soilMoisturePreference=" + soilMoisturePreference + ", spacingMax=" + spacingMax + ", spacingMin="
				+ spacingMin + ", spreadMax=" + spreadMax + ", spreadMin=" + spreadMin + ", sunlightExposure="
				+ sunlightExposure + ", type=" + type + ", wildlifeAttracted=" + Arrays.toString(wildlifeAttracted)
				+ ", type=" + type + "]";
		
		assertEquals(plant.returnDetailedInfo(), info);
	}
	
	@Test
	/**
	 * Tests overridden hashCode()
	 */
	public void testHashCode() {
		Plant plant = new Plant(bloomColors, hardinessMax, hardinessMin, heightMaxInches, heightMinInches,
				botanicalName, spacingMax, spacingMin, spreadMax, spreadMin, commonName, soilMoisturePreference,
				sunlightExposure, floweringMonths, wildlifeAttracted, otherAttributes, deerResistant, foliageColor,
				growthRate, saltTolerance, seasonsOfInterest, elementsCleaned, type);
		
		Plant plant2 = new Plant(bloomColors, hardinessMax, hardinessMin, heightMaxInches, heightMinInches,
				botanicalName, spacingMax, spacingMin, spreadMax, spreadMin, commonName, soilMoisturePreference,
				sunlightExposure, floweringMonths, wildlifeAttracted, otherAttributes, deerResistant, foliageColor,
				growthRate, saltTolerance, seasonsOfInterest, elementsCleaned, type);
		
		int testCode = plant.hashCode();
		int testCode2 = plant2.hashCode();
		
		assertEquals(testCode, testCode2);
	}
	
	@Test
	/**
	 * Tests the overridden equals(Object)
	 */
	public void testEquals() {
		Plant plant = new Plant(bloomColors, hardinessMax, hardinessMin, heightMaxInches, heightMinInches,
				botanicalName, spacingMax, spacingMin, spreadMax, spreadMin, commonName, soilMoisturePreference,
				sunlightExposure, floweringMonths, wildlifeAttracted, otherAttributes, deerResistant, foliageColor,
				growthRate, saltTolerance, seasonsOfInterest, elementsCleaned, type);
		
		Plant plant2 = new Plant(bloomColors, hardinessMax, hardinessMin, heightMaxInches, heightMinInches,
				botanicalName, spacingMax, spacingMin, spreadMax, spreadMin, commonName, soilMoisturePreference,
				sunlightExposure, floweringMonths, wildlifeAttracted, otherAttributes, deerResistant, foliageColor,
				growthRate, saltTolerance, seasonsOfInterest, elementsCleaned, type);
		
		boolean equals = plant.equals(plant2);
		
		assertEquals(equals, true);
		
		Plant plant3 = new Plant(bloomColors, hardinessMax, hardinessMin, heightMaxInches, heightMinInches,
				botanicalName, spacingMax, spacingMin, spreadMax, spreadMin, commonName, soilMoisturePreference,
				sunlightExposure, floweringMonths, wildlifeAttracted, otherAttributes, deerResistant, foliageColor,
				growthRate, saltTolerance, seasonsOfInterest, elementsCleaned, type);
		
		Plant plant4 = new Plant(bloomColors, hardinessMax, hardinessMin, heightMaxInches, heightMinInches,
				"asdsadsadsada", spacingMax, spacingMin, spreadMax, spreadMin, commonName, soilMoisturePreference,
				sunlightExposure, floweringMonths, wildlifeAttracted, otherAttributes, deerResistant, foliageColor,
				growthRate, saltTolerance, seasonsOfInterest, elementsCleaned, type);
		
		boolean equals2 = plant3.equals(plant4);
		
		assertEquals(equals2, false);
		
		Plant nullPlant = null;
		boolean equals3 = plant4.equals(nullPlant);
		assertEquals(equals3, false);
		
		boolean equals4 = plant4.equals(plant4);
		assertEquals(equals4, true);
		
		boolean equals5 = plant4.equals(new Shade());
		assertEquals(equals5, false);
	}
}
