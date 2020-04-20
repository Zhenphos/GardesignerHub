package main;

import java.util.Collection;

import objects.GardenObject;

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

	void addGardenObject(GardenObject someObject) {

	}

	int calculateRating() {
		return 0;
	}

	Collection<GardenObject> load(String fileName) {
		return myObjects;

	}

	void removeGardenObject(GardenObject someObject) {

	}
}
