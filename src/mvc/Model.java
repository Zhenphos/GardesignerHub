package mvc;

import java.io.Serializable;
import java.util.Collection;

import objects.GardenObject;

/**
 * Model class for Garden Planner
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Model implements Serializable {

	private int amountOfLight;
	private int amountOfRain;
	private int temperature;
	private int canvasHeight;
	private int canvasWidth;
	private double soilPH;
	private Collection<GardenObject> myObjects;
	
	public Model(int canvasHeight, int canvasWidth) {
		this.canvasHeight = canvasHeight;
		this.canvasWidth = canvasWidth;
	}

	public void setAmountOfLight(int light) {
		this.amountOfLight = light;
	}

	public void setAmountOfRain(int rain) {
		this.amountOfRain = rain;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public void setSoilPH(double soilPH) {
		this.soilPH = soilPH;
	}

	public int getAmountOfLight() {
		return this.amountOfLight;
	}

	public int getAmountOfRain() {
		return this.amountOfRain;
	}

	public int getTemperature() {
		return this.temperature;
	}

	public double getSoilPH() {
		return this.soilPH;
	}

	public int getCanvasWidth() {
		return this.canvasWidth;
	}

	public int getCanvasHeight() {
		return this.canvasHeight;
	}
	
	/**
	 * Gets the GardenObjects in your garden
	 * 
	 * @return All of the GardenObjects in your garden map
	 */
	public Collection<GardenObject> getGardenObjects() {
		return myObjects;
	}
	
	/**
	 * Calculates each of your ratings based on your map and area details
	 * 
	 * @return the rating of your map on a scale of 1 to 5
	 */
	int calculateRating() {
		return 0;
	}
	
	/**
	 * Loads a map from your files
	 * 
	 * @param fileName the file which contains a map you wish to load in
	 * @return a collection of garden objects which creates your map
	 */
	public Collection<GardenObject> load(String fileName) {
		return myObjects;

	}
	
	/**
	 * Adds a garden object to the map being created
	 * 
	 * @param someObject the garden object you want to add
	 */
	public static void addGardenObject(GardenObject someObject) {

	}

	/**
	 * Removes an object from your garden
	 * 
	 * @param someObject The object you wish to remove from your garden
	 */
	public static void removeGardenObject(GardenObject someObject) {

	}
}
