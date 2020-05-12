package objects;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Plant2 extends GardenObject {

	public Plant2(String plantBotanicalName, String height, String spread, String spacing, String usdaHardinessZone,
			String bloomColors) {
		super();
		this.plantBotanicalName = plantBotanicalName;
		this.height = height;
		this.spread = spread;
		this.spacing = spacing;
		this.USDAHardinessZone = usdaHardinessZone;
		this.bloomColors = bloomColors;
	}

	String plantBotanicalName;
	String height;
	String spread;
	String spacing;
	String USDAHardinessZone;
	String bloomColors;
	
	int heightMinInches;
	int heightMaxInches;
	int spreadMin;
	int spreadMax;
	int spacingMin;
	int spacingMax;
	int hardinessMin;
	int hardinessMax;

	@Override
	public String toString() {
		return "Plant2 [plantBotanicalName=" + plantBotanicalName + ", height=" + height + ", spread=" + spread
				+ ", spacing=" + spacing + ", USDAHardinessZone=" + USDAHardinessZone + ", bloomColors=" + bloomColors
				+ "] \n";
	}


}
