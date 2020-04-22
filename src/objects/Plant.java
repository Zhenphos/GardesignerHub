package objects;

import enums.PlantType;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Plant extends GardenObject {
	PlantType plantType;
	String color;
	double growTime;
	String name;
	int minLight;
	int maxLight;
	String[] soilTypes;
	int minTemp;
	int maxTemp;
	int minRain;
	int maxRain;
	int size;
	
	/**
	 * the constructor for Plant
	 */
	public Plant() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param plantType
	 * @param color
	 * @param growTime
	 * @param name
	 * @param size
	 * @param name
	 * @param minLight
	 * @param maxLight
	 * @param soilTypes
	 * @param minTemp
	 * @param maxTemp
	 * @param minRain
	 * @param maxRain
	 */
	public Plant(PlantType plantType, String color, double growTime, String name, int size, int minLight, 
			int maxLight, String[] soilTypes, int minTemp, int maxTemp, int minRain, 
			int maxRain) {
		super();
		this.plantType = plantType;
		this.color = color;
		this.growTime = growTime;
		this.name = name;
		this.size = size;
		this.minLight = minLight;
		this.maxLight = maxLight;
		this.soilTypes = soilTypes;
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
		this.minRain = minRain;
		this.maxRain = maxRain;
	}
	
	/**
	 * 
	 * @return what type of plant this is
	 */
	public PlantType getPlantType() {
		return plantType;
	}
	
	/**
	 * 
	 * @return The color of the plant
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * 
	 * @return the amount of time in months it takes for the plant to be fully grown
	 */
	public double getGrowTime() {
		return growTime;
	}
	
	/**
	 * 
	 * @return the minimum amount of light the plant needs
	 */
	public int getMinLight() {
		return minLight;
	}
	
	/**
	 * 
	 * @return the maximum amount of light the plant needs 
	 */
	public int getMaxLight() {
		return maxLight;
	}
	
	/**
	 * 
	 * @return the types of soil the plant can grow in
	 */
	public String[] getSoilTypes() { 
		return soilTypes;
	}
	
	/**
	 * 
	 * @return the minimum temperature the plant can survive in
	 */
	public int getMinTemp() {
		return minTemp;
	}
	
	/**
	 * 
	 * @return the maximum temperature the plant can survive in
	 */
	public int getMaxTemp() {
		return maxTemp;
	}
	
	/**
	 * 
	 * @return the minimum amount of rain the plant needs to survive
	 */
	public int getMinRain() {
		return minRain;
	}
	
	/**
	 * 
	 * @return the maximum amount of rain the plant can survive with
	 */
	public int getMaxRain() {
		return maxRain;
	}

	/**
	 * Increments the size of the plant by 1
	 */
	public void incrementSize() {
		size++;
	}

	/**
	 * Checks if the plant meets minimum specified requirements.
	 * 
	 * @return whether the plant meets the minimum specified requirements
	 */
	public boolean meetsRequirements() {
		return false;
	}

	/**
	 * Gets the size of the plant.
	 * 
	 * @return the size of the plant
	 */
	public int getSize() {
		return size;
	}
}
