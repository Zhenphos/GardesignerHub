package enums;

/**
 * Enumeration of plant types for garden designer
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public enum PlantType {
	ALL,
	ALKALINE_SOIL_TOLERANT,
	BIRD_BUTTERFLY_BUG_GARDENS,
	DROUGHT_TOLERANT,
	GRASSES,
	GROUNDHOG_RESISTANT,
	LANDSCAPE_ORNAMENTALS,
	MEADOW,
	NO_ADVANCE_ORDER,
	NORTH_AMERICAN_NATIVE,
	PERENNIALS,
	PHYTOREMEDIATION,
	RABBIT_RESISTANT,
	RAIN_GARDENS,
	RESTORATION_CONSERVATION,
	ROOFTOP_GARDEN_PLANT,
	SHRUB,
	SOIL_STABILIZATION,
	STORMWATER_MANAGEMENT,
	VINES,
	WETLANDS,
	WOODLAND;	
	
	public static PlantType get(int ord) {
        for (PlantType m : PlantType.values()) {
            if (m.ordinal() == ord) {
                return m;
            }
        }
        return null;
    }
}
