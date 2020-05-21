package objects;

import java.io.Serializable;
import java.util.Arrays;

import enums.PlantType;
import mvc.Controller;

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
	String[] phytoElementsCleaned;
	String botanicalName;
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
		this.botanicalName = plantBotanicalName;
		this.heightMinInches = heightMinInches;
		this.heightMaxInches = heightMaxInches;
		this.spreadMin = spreadMin;
		this.spreadMax = spreadMax;
		this.spacingMin = spacingMin;
		this.spacingMax = spacingMax;
		this.hardinessMin = hardinessMin;
		this.hardinessMax = hardinessMax;
		this.bloomColors = bloomColors;

		if (spreadMin != -1) {
			shape = new DrawShape(null, (this.spreadMin * 2));
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
		this.botanicalName = plantBotanicalName;
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
			shape = new DrawShape(null, (this.spreadMin * 2));
			shape.getCircle().setCenterX(this.spreadMin * 4);
			shape.getCircle().setCenterY(this.spreadMin * 4);
		} else {
			shape = new DrawShape(null, defaultRadius);
			shape.getCircle().setCenterX(defaultRadius * 2);
			shape.getCircle().setCenterY(defaultRadius * 2);
		}
	}

	/**
	 * @param bloomColors the colors of the plant when in bloom
	 * @param hardinessMax the maximum hardiness of the plant
	 * @param hardinessMin the minimum hardiness of the plant
	 * @param heightMaxInches the maximum height of the plant
	 * @param heightMinInches the minimum height of the plant
	 * @param plantBotanicalName the botanical name of the plant
	 * @param spacingMax the maximum required spacing for the plant
	 * @param spacingMin the minimum required spacing for the plant
	 * @param spreadMax the maximum size/spread of the plant
	 * @param spreadMin the minimum size/spread of the plant
	 * @param commonName the common name of the plant
	 * @param soilMoisturePreference the preference of soil moisture
	 * @param sunlightExposure the preference for sunlight exposure
	 * @param floweringMonths the months which it flowers in
	 * @param wildlifeAttracted the number of wild life it attracts on average
	 * @param otherAttributes extra information about the plant
	 * @param deerResistant if it is resistant to deer
	 * @param foliageColor the color of its foliage
	 * @param growthRate the growth rate
	 * @param saltTolerance the tolerance to salt
	 * @param seasonsOfInterest the seasons it prefers
	 * @param phytoremediationElementsCleaned phytoremediation elements cleaned
	 * @param type the type of plant
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
		this.botanicalName = plantBotanicalName;
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
		this.phytoElementsCleaned = phytoremediationElementsCleaned;
		this.type = type;
		
		if (spreadMin != -1) {
			shape = new DrawShape(null, (this.spreadMin * 2));
			shape.getCircle().setCenterX(this.spreadMin * 4);
			shape.getCircle().setCenterY(this.spreadMin * 4);
		} else {
			shape = new DrawShape(null, defaultRadius);
			shape.getCircle().setCenterX(defaultRadius * 2);
			shape.getCircle().setCenterY(defaultRadius * 2);
		}
	}

	/**
	 * Changes the plant's size based on how many years its aged
	 * 
	 * @param age the number of years the plant has aged
	 */
	public void changePlantSize(double age) {
		if (spreadMin != -1 && spreadMax != -1) {
			double growthRate = (spreadMax - spreadMin) * 3 / 4;
			shape.getCircle().setRadius((this.spreadMin * 2) + (growthRate * age));
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
		Plant copiedPlant = new Plant(bloomColors, hardinessMax, hardinessMin, heightMaxInches, heightMinInches,
				botanicalName, spacingMax, spacingMin, spreadMax, spreadMin, commonName, soilMoisturePreference,
				sunlightExposure, floweringMonths, wildlifeAttracted, otherAttributes, deerResistant, foliageColor,
				growthRate, saltTolerance, seasonsOfInterest, phytoElementsCleaned, type);

		return copiedPlant;
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
	public String getBotanicalName() {
		return botanicalName;
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
		return botanicalName;
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
	public String getFloweringMonths() {
		return Controller.ArrayOfStrings(floweringMonths);
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
	public String getOtherAttributes() {
		return Controller.ArrayOfStrings(otherAttributes);
	}

	/**
	 * @return the phytoremediationElementsCleaned
	 */
	public String getPhytoremediationElementsCleaned() {
		return Controller.ArrayOfStrings(phytoElementsCleaned);
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
	public String getSeasonsOfInterest() {
		return Controller.ArrayOfStrings(seasonsOfInterest);
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
	public String getWildlifeAttracted() {
		return Controller.ArrayOfStrings(wildlifeAttracted);
	}

	public String returnDetailedInfo() {
		return "Plant [bloomColors=" + bloomColors + ", commonName=" + commonName + ", deerResistant=" + deerResistant
				+ ", floweringMonths=" + Arrays.toString(floweringMonths) + ", foliageColor=" + foliageColor
				+ ", growthRate=" + growthRate + ", hardinessMax=" + hardinessMax + ", hardinessMin=" + hardinessMin
				+ ", heightMaxInches=" + heightMaxInches + ", heightMinInches=" + heightMinInches + ", otherAttributes="
				+ Arrays.toString(otherAttributes) + ", phytoremediationElementsCleaned="
				+ Arrays.toString(phytoElementsCleaned) + ", plantBotanicalName=" + botanicalName
				+ ", saltTolerance=" + saltTolerance + ", seasonsOfInterest=" + Arrays.toString(seasonsOfInterest)
				+ ", soilMoisturePreference=" + soilMoisturePreference + ", spacingMax=" + spacingMax + ", spacingMin="
				+ spacingMin + ", spreadMax=" + spreadMax + ", spreadMin=" + spreadMin + ", sunlightExposure="
				+ sunlightExposure + ", type=" + type + ", wildlifeAttracted=" + Arrays.toString(wildlifeAttracted)
				+ ", type=" + type + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((botanicalName == null) ? 0 : botanicalName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plant other = (Plant) obj;
		if (botanicalName == null) {
			if (other.botanicalName != null)
				return false;
		} else if (!botanicalName.equals(other.botanicalName))
			return false;
		return true;
	}

}
