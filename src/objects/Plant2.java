package objects;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Plant2 extends GardenObject {

	public Plant2(String plantBotanicalName, int heightMinInches, int heightMaxInches, int spreadMin, int spreadMax,
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

	@Override
	public String toString() {
		return plantBotanicalName;
	}

	public String getPlantBotanicalName() {
		return plantBotanicalName;
	}

	public int getHeightMinInches() {
		return heightMinInches;
	}

	public int getHeightMaxInches() {
		return heightMaxInches;
	}

	public int getSpreadMin() {
		return spreadMin;
	}

	public int getSpreadMax() {
		return spreadMax;
	}

	public int getSpacingMin() {
		return spacingMin;
	}

	public int getSpacingMax() {
		return spacingMax;
	}

	public int getHardinessMin() {
		return hardinessMin;
	}

	public int getHardinessMax() {
		return hardinessMax;
	}

	public String getBloomColors() {
		return bloomColors;
	}

}
