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

	public Plant() {
		// TODO Auto-generated constructor stub
	}

	public Plant(String color, int monthsUntilGrown, String name, int size) {
		super();
		this.color = color;
		this.monthsUntilGrown = monthsUntilGrown;
		this.name = name;
		this.size = size;
	}

	/**
	 * 
	 * @param args
	 * @return 
	 */
	public void incrementSize() {
		size++;
	}

	/**
	 * 
	 * @param args
	 * @return 
	 */
	public boolean meetsRequirements() {
		return false;
	}

	/**
	 * 
	 * @param args
	 * @return 
	 */
	public int getSize() {
		return size;
	}
}
