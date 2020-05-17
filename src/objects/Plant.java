package objects;

import java.io.Serializable;
import java.util.Arrays;

import enums.PlantType;
import enums.Season;

/**
 * Plant class for Gardendesigner Hub
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Plant extends GardenObject implements Serializable {
	public static final int defaultRadius = 20;

	String bloomColors;
	String commonName;
	boolean deerResistant;
	String[] floweringMonths;
	String foliageColor;
	String growthRate;
	int hardinessMax;
	int hardinessMin;
	int heightMaxInches;
	int heightMinInches;
	String[] otherAttributes;
	String[] phytoremediationElementsCleaned;
	String plantBotanicalName;
	String saltTolerance;
	String[] seasonsOfInterest;
	String soilMoisturePreference;
	int spacingMax;
	int spacingMin;
	int spreadMax;
	int spreadMin;
	String sunlightExposure;
	PlantType type;
	String[] wildlifeAttracted;

	public Plant() {
		shape = new DrawShape(null, defaultRadius);
		shape.getCircle().setCenterX(defaultRadius * 2);
		shape.getCircle().setCenterY(defaultRadius * 2);
	}

	public Plant(String plantBotanicalName, int heightMinInches, int heightMaxInches, int spreadMin, int spreadMax,
			int spacingMin, int spacingMax, int hardinessMin, int hardinessMax, String bloomColors) {
		super();
		this.plantBotanicalName = plantBotanicalName;
		this.heightMinInches = heightMinInches;
		this.heightMaxInches = heightMaxInches;
		this.spreadMin = spreadMin;
		this.spreadMax = spreadMax;
		this.spacingMin = spacingMin;
		this.spacingMax = spacingMax;
		this.hardinessMin = hardinessMin;
		this.hardinessMax = hardinessMax;
		this.bloomColors = bloomColors;
		this.type = type;

		if (spreadMin != -1) {
			shape = new DrawShape(null, (this.spreadMin * 3));
			shape.getCircle().setCenterX(this.spreadMin * 4);
			shape.getCircle().setCenterY(this.spreadMin * 4);
		} else {
			shape = new DrawShape(null, defaultRadius);
			shape.getCircle().setCenterX(defaultRadius * 2);
			shape.getCircle().setCenterY(defaultRadius * 2);
		}
	}

	/**
	 * Constructor for Plant. Creates a plant and sets its characteristics,
	 * attributes, and requirements.
	 * 
	 * @param plantBotanicalName the string of the plant's botanical name
	 * @param heightMinInches    the plant's minimum height in inches
	 * @param heightMaxInches    the plant's maximum height in inches
	 * @param spreadMin          the plant's minimum spread in inches
	 * @param spreadMax          the plant's maximum spread in inches
	 * @param spacingMin         the plant's minimum spacing in inches
	 * @param spacingMax         the plant's maximum spacing in inches
	 * @param hardinessMin       the plant's minimum hardiness
	 * @param hardinessMax       the plant's maximum hardiness
	 * @param bloomColors        the string of the plant's bloom colors
	 * @param type               the type of plant
	 */
	public Plant(String plantBotanicalName, int heightMinInches, int heightMaxInches, int spreadMin, int spreadMax,
			int spacingMin, int spacingMax, int hardinessMin, int hardinessMax, String bloomColors, PlantType type) {
		super();
		this.plantBotanicalName = plantBotanicalName;
		this.heightMinInches = heightMinInches;
		this.heightMaxInches = heightMaxInches;
		this.spreadMin = spreadMin;
		this.spreadMax = spreadMax;
		this.spacingMin = spacingMin;
		this.spacingMax = spacingMax;
		this.hardinessMin = hardinessMin;
		this.hardinessMax = hardinessMax;
		this.bloomColors = bloomColors;
		this.type = type;

		if (spreadMin != -1) {
			shape = new DrawShape(null, (this.spreadMin * 3));
			shape.getCircle().setCenterX(this.spreadMin * 4);
			shape.getCircle().setCenterY(this.spreadMin * 4);
		} else {
			shape = new DrawShape(null, defaultRadius);
			shape.getCircle().setCenterX(defaultRadius * 2);
			shape.getCircle().setCenterY(defaultRadius * 2);
		}
	}

	/**
	 * @param bloomColors
	 * @param hardinessMax
	 * @param hardinessMin
	 * @param heightMaxInches
	 * @param heightMinInches
	 * @param plantBotanicalName
	 * @param spacingMax
	 * @param spacingMin
	 * @param spreadMax
	 * @param spreadMin
	 * @param commonName
	 * @param soilMoisturePreference
	 * @param sunlightExposure
	 * @param floweringMonths
	 * @param wildlifeAttracted
	 * @param otherAttributes
	 * @param deerResistant
	 * @param foliageColor
	 * @param growthRate
	 * @param saltTolerance
	 * @param seasonsOfInterest
	 * @param phytoremediationElementsCleaned
	 * @param type
	 */
	public Plant(String bloomColors, int hardinessMax, int hardinessMin, int heightMaxInches, int heightMinInches,
			String plantBotanicalName, int spacingMax, int spacingMin, int spreadMax, int spreadMin, String commonName,
			String soilMoisturePreference, String sunlightExposure, String[] floweringMonths,
			String[] wildlifeAttracted, String[] otherAttributes, boolean deerResistant, String foliageColor,
			String growthRate, String saltTolerance, String[] seasonsOfInterest,
			String[] phytoremediationElementsCleaned, PlantType type) {
		super();
		this.bloomColors = bloomColors;
		this.hardinessMax = hardinessMax;
		this.hardinessMin = hardinessMin;
		this.heightMaxInches = heightMaxInches;
		this.heightMinInches = heightMinInches;
		this.plantBotanicalName = plantBotanicalName;
		this.spacingMax = spacingMax;
		this.spacingMin = spacingMin;
		this.spreadMax = spreadMax;
		this.spreadMin = spreadMin;
		this.commonName = commonName;
		this.soilMoisturePreference = soilMoisturePreference;
		this.sunlightExposure = sunlightExposure;
		this.floweringMonths = floweringMonths;
		this.wildlifeAttracted = wildlifeAttracted;
		this.otherAttributes = otherAttributes;
		this.deerResistant = deerResistant;
		this.foliageColor = foliageColor;
		this.growthRate = growthRate;
		this.saltTolerance = saltTolerance;
		this.seasonsOfInterest = seasonsOfInterest;
		this.phytoremediationElementsCleaned = phytoremediationElementsCleaned;
		this.type = type;
	}

	/**
	 * Changes the plant's size based on how many years its aged
	 * 
	 * @param age the number of years the plant has aged
	 */
	public void changePlantSize(double age) {
		if (spreadMin != -1 && spreadMax != -1) {
			double growthRate = (spreadMax - spreadMin) * 3 / 4;
			shape.getCircle().setRadius((this.spreadMin * 3) + (growthRate * age));
		} else {
			double growthRate = defaultRadius / 4;
			shape.getCircle().setRadius(defaultRadius + growthRate * age);
		}
	}

	/**
	 * Returns a copy of the Plant object
	 * 
	 * @return A copy of the Plant object
	 */
	public Plant copyOfPlant() {
		Plant plant = new Plant(this.plantBotanicalName, this.heightMinInches, this.heightMaxInches, this.spreadMin,
				this.spreadMax, this.spacingMin, this.spacingMax, this.hardinessMin, this.hardinessMax,
				this.bloomColors);
		return plant;
	}

	/**
	 * Gets the bloom colors of the plant
	 * 
	 * @return the bloom colors of the plant
	 */
	public String getBloomColors() {
		return bloomColors;
	}

	/**
	 * Gets the maximum hardiness of the plant
	 * 
	 * @return the maximum hardiness of the plant
	 */
	public int getHardinessMax() {
		return hardinessMax;
	}

	/**
	 * Gets the minimum hardiness of the plant
	 * 
	 * @return the minimum hardiness of the plant
	 */
	public int getHardinessMin() {
		return hardinessMin;
	}

	/**
	 * Gets the maximum height of the plant in inches
	 * 
	 * @return the maximum height of the plant
	 */
	public int getHeightMaxInches() {
		return heightMaxInches;
	}

	/**
	 * Gets the minimum height of the plant in inches
	 * 
	 * @return the minimum height of the plant
	 */
	public int getHeightMinInches() {
		return heightMinInches;
	}

	/**
	 * Gets the botanical name of the plant
	 * 
	 * @return the botanical name of the plant
	 */
	public String getPlantBotanicalName() {
		return plantBotanicalName;
	}

	/**
	 * Gets the maximum spacing of the plant in inches
	 * 
	 * @return the maximum spacing of the plant
	 */
	public int getSpacingMax() {
		return spacingMax;
	}

	/**
	 * Gets the minimum spacing of the plant in inches
	 * 
	 * @return the minimum spread of the plant
	 */
	public int getSpacingMin() {
		return spacingMin;
	}

	/**
	 * Gets the maximum spread of the plant in inches
	 * 
	 * @return the maximum spread of the plant
	 */
	public int getSpreadMax() {
		return spreadMax;
	}

	/**
	 * Gets the minimum spread of the plant in inches
	 * 
	 * @return the minimum spread of the plant
	 */
	public int getSpreadMin() {
		return spreadMin;
	}

	/**
	 * Gets the type of plant
	 * 
	 * @return type
	 */

	public PlantType getType() {
		return type;
	}

	@Override
	/**
	 * Converts a plant to its botanical name
	 * 
	 * @return the plant's botanical name
	 */
	public String toString() {
		return plantBotanicalName;
	}

	/**
	 * @return the commonName
	 */
	public String getCommonName() {
		return commonName;
	}

	/**
	 * @return the deerResistant
	 */
	public boolean isDeerResistant() {
		return deerResistant;
	}

	/**
	 * @return the floweringMonths
	 */
	public String[] getFloweringMonths() {
		return floweringMonths;
	}

	/**
	 * @return the foliageColor
	 */
	public String getFoliageColor() {
		return foliageColor;
	}

	/**
	 * @return the growthRate
	 */
	public String getGrowthRate() {
		return growthRate;
	}

	/**
	 * @return the otherAttributes
	 */
	public String[] getOtherAttributes() {
		return otherAttributes;
	}

	/**
	 * @return the phytoremediationElementsCleaned
	 */
	public String[] getPhytoremediationElementsCleaned() {
		return phytoremediationElementsCleaned;
	}

	/**
	 * @return the saltTolerance
	 */
	public String getSaltTolerance() {
		return saltTolerance;
	}

	/**
	 * @return the seasonsOfInterest
	 */
	public String[] getSeasonsOfInterest() {
		return seasonsOfInterest;
	}

	/**
	 * @return the soilMoisturePreference
	 */
	public String getSoilMoisturePreference() {
		return soilMoisturePreference;
	}

	/**
	 * @return the sunlightExposure
	 */
	public String getSunlightExposure() {
		return sunlightExposure;
	}

	/**
	 * @return the wildlifeAttracted
	 */
	public String[] getWildlifeAttracted() {
		return wildlifeAttracted;
	}

	public String returnDetailedInfo() {
		return "Plant [bloomColors=" + bloomColors + ", commonName=" + commonName + ", deerResistant=" + deerResistant
				+ ", floweringMonths=" + Arrays.toString(floweringMonths) + ", foliageColor=" + foliageColor
				+ ", growthRate=" + growthRate + ", hardinessMax=" + hardinessMax + ", hardinessMin=" + hardinessMin
				+ ", heightMaxInches=" + heightMaxInches + ", heightMinInches=" + heightMinInches + ", otherAttributes="
				+ Arrays.toString(otherAttributes) + ", phytoremediationElementsCleaned="
				+ Arrays.toString(phytoremediationElementsCleaned) + ", plantBotanicalName=" + plantBotanicalName
				+ ", saltTolerance=" + saltTolerance + ", seasonsOfInterest=" + Arrays.toString(seasonsOfInterest)
				+ ", soilMoisturePreference=" + soilMoisturePreference + ", spacingMax=" + spacingMax + ", spacingMin="
				+ spacingMin + ", spreadMax=" + spreadMax + ", spreadMin=" + spreadMin + ", sunlightExposure="
				+ sunlightExposure + ", type=" + type + ", wildlifeAttracted=" + Arrays.toString(wildlifeAttracted)
				+ "]";
	}

}
