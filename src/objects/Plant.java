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
	 * 
	 * 
	 * @param plantBotanicalName
	 * @param heightMinInches
	 * @param heightMaxInches
	 * @param spreadMin
	 * @param spreadMax
	 * @param spacingMin
	 * @param spacingMax
	 * @param hardinessMin
	 * @param hardinessMax
	 * @param bloomColors
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
	}

	/**
	 * 
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
	 * 
	 * 
	 * @return
	 */
	public int getHardinessMin() {
		return hardinessMin;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public String getPlantBotanicalName() {
		return plantBotanicalName;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public int getHeightMaxInches() {
		return heightMaxInches;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public int getSpacingMax() {
		return spacingMax;
	}

	/**
	 * 
	 * 
	 * @param hardinessMin
	 */
	public void setHardinessMin(int hardinessMin) {
		this.hardinessMin = hardinessMin;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return plantBotanicalName;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public int getHeightMinInches() {
		return heightMinInches;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public int getSpreadMin() {
		return spreadMin;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public int getSpreadMax() {
		return spreadMax;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public int getSpacingMin() {
		return spacingMin;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public int getHardinessMax() {
		return hardinessMax;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public String getBloomColors() {
		return bloomColors;
	}

}
