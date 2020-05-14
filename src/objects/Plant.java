package objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Plant extends GardenObject implements Serializable {

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

	public int getHardinessMin() {
		return hardinessMin;
	}

	public String getPlantBotanicalName() {
		return plantBotanicalName;
	}

	public int getHeightMaxInches() {
		return heightMaxInches;
	}

	public int getSpacingMax() {
		return spacingMax;
	}



	public void setHardinessMin(int hardinessMin) {
		this.hardinessMin = hardinessMin;
	}

	@Override
	public String toString() {
		return plantBotanicalName;
	}

	

	public int getHeightMinInches() {
		return heightMinInches;
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

	



	public int getHardinessMax() {
		return hardinessMax;
	}

	public String getBloomColors() {
		return bloomColors;
	}

}
