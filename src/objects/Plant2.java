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
		USDAHardinessZone = usdaHardinessZone;
		this.bloomColors = bloomColors;
	}

	String plantBotanicalName;
	String height;
	String spread;
	String spacing;
	String USDAHardinessZone;
	String bloomColors;

	@Override
	public String toString() {
		return "Plant2 [plantBotanicalName=" + plantBotanicalName + ", height=" + height + ", spread=" + spread
				+ ", spacing=" + spacing + ", USDAHardinessZone=" + USDAHardinessZone + ", bloomColors=" + bloomColors
				+ "] \n";
	}

	/*
	 * HashSet<String> nativeTo; String plantCaption; String plantCommonName;
	 * HashSet<String> wildlifeAttracted; HashSet<String> plantAttributes;
	 * HashSet<String> sunlightExposure; HashSet<String> deerResistant;
	 * HashSet<String> floweringMonths; HashSet<String> foliageColor;
	 * HashSet<String> groundcoverFootTrafficTolerances; HashSet<String> growthRate;
	 * HashSet<String> saltTolerance; HashSet<String> seasonOfInterest;
	 * HashSet<String> soilMoisturePreference;
	 */

}
