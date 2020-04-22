package objects;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Plant extends GardenObject {
	String color;
	int monthsUntilGrown;
	String name;
	int size;

	/**
	 * the constructor for Plant
	 */
	public Plant() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param color
	 * @param monthsUntilGrown
	 * @param name
	 * @param size
	 */
	public Plant(String color, int monthsUntilGrown, String name, int size) {
		super();
		this.color = color;
		this.monthsUntilGrown = monthsUntilGrown;
		this.name = name;
		this.size = size;
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
