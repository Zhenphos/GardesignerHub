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
		return "Plant2 [plantBotanicalName=" + plantBotanicalName + ", heightMinInches=" + heightMinInches
				+ ", heightMaxInches=" + heightMaxInches + ", spreadMin=" + spreadMin + ", spreadMax=" + spreadMax
				+ ", spacingMin=" + spacingMin + ", spacingMax=" + spacingMax + ", hardinessMin=" + hardinessMin
				+ ", hardinessMax=" + hardinessMax + ", bloomColors=" + bloomColors + "]";
	}

}
