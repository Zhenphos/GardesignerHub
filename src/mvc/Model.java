package mvc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import enums.Season;
import objects.GardenObject;

/**
 * Model class for Garden Planner
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Model implements Serializable {

	private int width;
	private int height;
	private int light;
	private int rain;
	private double temperature;
	private double soilPH;
	private double age;
	private Season season;
	private Collection<GardenObject> myObjects;

	
	private double x = 100;
	private double y = 200;
	private final double BOTTOM = 200;
	
	
	public Model() {
		this.width = 0;
		this.height = 0;
		this.light = 0;
		this.rain = 0;
		this.temperature = 0;
		this.soilPH = 0.0;
		this.age = 0.0;
		this.season = Season.SPRING;
		this.myObjects = new ArrayList<>();
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setLight(int light) {
		this.light = light;
	}

	public void setRain(int rain) {
		this.rain = rain;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public void setSoilPH(double soilPH) {
		this.soilPH = soilPH;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public int getLight() {
		return this.light;
	}

	public int getRain() {
		return this.rain;
	}

	public double getTemperature() {
		return this.temperature;
	}

	public double getSoilPH() {
		return this.soilPH;
	}

	public double getAge() {
		return this.age;
	}

	public Season getSeason() {
		return this.season;
	}

	/**
	 * Gets the GardenObjects in your garden
	 * @return All of the GardenObjects in your garden map
	 */
	public Collection<GardenObject> getGardenObjects() {
		return myObjects;
	}
	
	/**
	 * Calculates each of your ratings based on your map and area details
	 * @return the rating of your map on a scale of 1 to 5
	 */

	public int getRating() {
		return 0;
	}
	
	/**
	 * Adds a garden object to the map being created
	 * 
	 * @param someObject the garden object you want to add
	 */
	public void addGardenObject(GardenObject someObject) {
		myObjects.add(someObject);
	}

	/**
	 * Removes an object from your garden
	 * 
	 * @param someObject The object you wish to remove from your garden
	 */
	public void removeGardenObject(GardenObject someObject) {

	}
	
	public double getX() {
		return x;
	}

	public void setX(double d) {
		this.x = d;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = Math.min(y, BOTTOM);
	}
}
