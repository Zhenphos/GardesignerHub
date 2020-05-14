package objects;

import java.io.Serializable;

/**
 * Plant class for Gardendesigner Hub
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Plant extends GardenObject implements Serializable {

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
	 */
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
		
		shape = new DrawShape(null, 20);
	}

	/**
	 * Default constructor for Plant
	 */
	public Plant() {
		// TODO Auto-generated constructor stub
	}

	String plantBotanicalName;
	int heightMinInches;
	int heightMaxInches;
	int spreadMin;
	int spreadMax;
	int spacingMin;
	int spacingMax;
	int hardinessMin;
	int hardinessMax;
	String bloomColors;

	/**
	 * Gets the minimum hardiness of the plant
	 * 
	 * @return the minimum hardiness of the plant
	 */
	public int getHardinessMin() {
		return hardinessMin;
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
	 * Gets the maximum height of the plant in inches
	 * 
	 * @return the maximum height of the plant
	 */
	public int getHeightMaxInches() {
		return heightMaxInches;
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
	 * Gets the minimum hardiness of the plant
	 * 
	 * @param hardinessMin the minimum hardiness of the plant
	 */
	public void setHardinessMin(int hardinessMin) {
		this.hardinessMin = hardinessMin;
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
	 * Gets the minimum height of the plant in inches
	 * 
	 * @return the minimum height of the plant
	 */
	public int getHeightMinInches() {
		return heightMinInches;
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
	 * Gets the maximum spread of the plant in inches
	 * 
	 * @return the maximum spread of the plant
	 */
	public int getSpreadMax() {
		return spreadMax;
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
	 * Gets the maximum hardiness of the plant
	 * 
	 * @return the maximum hardiness of the plant
	 */
	public int getHardinessMax() {
		return hardinessMax;
	}

	/**
	 * Gets the bloom colors of the plant
	 * 
	 * @return the bloom colors of the plant
	 */
	public String getBloomColors() {
		return bloomColors;
	}

}
