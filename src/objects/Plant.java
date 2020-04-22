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
	 * 
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
	 * 
	 */
	public void incrementSize() {
		size++;
	}

	/**
	 * 
	 * @return
	 */
	public boolean meetsRequirements() {
		return false;
	}

	/**
	 * 
	 * @return
	 */
	public int getSize() {
		return size;
	}
}
