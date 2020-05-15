package mvc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import enums.Season;
import objects.GardenObject;
import objects.Plant;

/**
 * Model class for Gardendesigner Hub
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Model implements Serializable {

	private int width;
	private int length;
	private int light;
	private int rain;
	private double temperature;
	private double soilPH;
	private double age;
	private Season season = Season.SUMMER;
	private ArrayList<GardenObject> myObjects;

	private double x = 100;
	private double y = 200;
	private final double BOTTOM = 200;

	/**
	 * Constructor for Model. Sets the initial numerical attributes of the garden to
	 * 0 and the season to spring.
	 */
	public Model() {
		this.width = 0;
		this.length = 0;
		this.light = 0;
		this.rain = 0;
		this.temperature = 0;
		this.soilPH = 0.0;
		this.age = 0.0;
		this.season = Season.SPRING;
		this.myObjects = new ArrayList<>();
	}

	/**
	 * Sets the width of the garden
	 * 
	 * @param width the width to set the garden to
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Sets the length of the garden
	 * 
	 * @param length the length to set the garden to
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * Sets the average amount of time of sun exposure for the garden
	 * 
	 * @param light the light value to set the garden to
	 */
	public void setLight(int light) {
		this.light = light;
	}

	/**
	 * Sets the average amount of rain value for the garden in millimeters
	 * 
	 * @param rain the rain value to set the garden to
	 */
	public void setRain(int rain) {
		this.rain = rain;
	}

	/**
	 * Sets the temperature in degrees Fahrenheit of the garden
	 * 
	 * @param temperature the garden's average temperature in degrees Fahrenheit
	 *                    over the last week
	 */
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	/**
	 * Sets the soil pH value of the garden
	 * 
	 * @param soilPH the garden soil's pH
	 */
	public void setSoilPH(double soilPH) {
		this.soilPH = soilPH;
	}

	/**
	 * Sets the age of the selected plants in years
	 * 
	 * @param age the age to set the plants to
	 */
	public void setAge(double age) {
		this.age = age;
	}

	/**
	 * Sets the season to display the plants in
	 * 
	 * @param season the season to display the plants in
	 */
	public void setSeason(Season season) {
		this.season = season;
	}

	/**
	 * Gets the width of the garden
	 * 
	 * @return the width of the garden
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Gets the height of the garden
	 * 
	 * @return the height of the garden
	 */
	public int getHeight() {
		return this.length;
	}

	/**
	 * Gets the average amount of time of sun exposure of the garden in hours
	 * 
	 * @return the amount of time of sun exposure in hours
	 */
	public int getLight() {
		return this.light;
	}

	/**
	 * Gets the average amount of rain in millimeters
	 * 
	 * @return the amount of rain in millimeters
	 */
	public int getRain() {
		return this.rain;
	}

	/**
	 * Gets the average temperature of the garden in degrees Fahrenheit
	 * 
	 * @return the average temperature of the garden
	 */
	public double getTemperature() {
		return this.temperature;
	}

	/**
	 * Gets the garden's soil pH
	 * 
	 * @return the garden's soil pH
	 */
	public double getSoilPH() {
		return this.soilPH;
	}

	/**
	 * Gets the age of the plants in years
	 * 
	 * @return the age of the plants in years
	 */
	public double getAge() {
		return this.age;
	}

	/**
	 * Gets the season currently used to display the plants
	 * 
	 * @return the season currently used to display the plants
	 */
	public Season getSeason() {
		return this.season;
	}

	/**
	 * Gets the GardenObjects in the garden
	 * 
	 * @return all of the GardenObjects in the garden map
	 */
	public ArrayList<GardenObject> getGardenObjects() {
		return myObjects;
	}
	
	/**
	 * Gets all the plants in GardenObject
	 * 
	 * @return an ArrayList of Plants that are within GardenObjects
	 */
	public ArrayList<Plant> getPlantObjects() {
		ArrayList<Plant> plants = new ArrayList<Plant>();
		for (int i = 0; i < myObjects.size(); i++) {
			if (myObjects.get(i) instanceof Plant) {
				plants.add((Plant) myObjects.get(i));
			}
		}
		return plants;
	}

	/**
	 * Calculates each of your ratings based on your map and area details
	 * 
	 * @return the rating of your map on a scale of 1 to 5
	 */
	public int getRating() {
		return 0;
	}

	/**
	 * Adds a garden object to the map being created
	 * 
	 * @param someObject the garden object to be added
	 */
	public void addGardenObject(GardenObject someObject) {
		myObjects.add(someObject);
		System.out.println("Added object");
	}

	/**
	 * Removes an object from the garden
	 * 
	 * @param someObject the object to be removed
	 */
	public void removeGardenObject(GardenObject someObject) {
		myObjects.remove(someObject);
		System.out.println("Removed object");
	}

	/**
	 * Gets the x value
	 * 
	 * @return the x value
	 */
	public double getX() {
		return x;
	}

	/**
	 * Sets the x value
	 * 
	 * @param d the x value to be set
	 */
	public void setX(double d) {
		this.x = d;
	}

	/**
	 * Gets the y value
	 * 
	 * @return the y value
	 */
	public double getY() {
		return y;
	}

	/**
	 * Sets the y value
	 * 
	 * @param y the y value to be set
	 */
	public void setY(double y) {
		this.y = Math.min(y, BOTTOM);
	}
}
