package mvc;

import java.util.Collection;

import objects.GardenObject;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class GardenModel {
	private int amountOfLight;
	private int amountOfRain;
	private int canvasHeight;
	private int canvasWidth;
	private Collection<GardenObject> myObjects;
	private String soilType;
	
	public GardenModel(int canvasHeight, int canvasWidth) {
		this.canvasHeight = canvasHeight;
		this.canvasWidth = canvasWidth;
	}
	
	/**
	 * 
	 * @param args
	 * @return 
	 */
	void addGardenObject(GardenObject someObject) {

	}
	
	/**
	 * 
	 * @param args
	 * @return 
	 */
	int calculateRating() {
		return 0;
	}
	
	/**
	 * 
	 * @param args
	 * @return 
	 */
	Collection<GardenObject> load(String fileName) {
		return myObjects;

	}

	/**
	 * 
	 * @param args
	 * @return 
	 */
	void removeGardenObject(GardenObject someObject) {

	}
}
