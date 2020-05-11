package mvc;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import view.PlantInfoScene;
import view.PlantPlacementScene;
import objects.Plant2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Controller class for Garden Designer
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Controller extends Application {

	/**
	 * the main method for the program
	 * 
	 * @param args - an array of strings
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Plant2> allPlants = importPlants();
		System.out.println("allPlants is " + allPlants);
		launch(args);
	}

	public static ArrayList<Plant2> importPlants() throws FileNotFoundException {
		ArrayList<Plant2> plantList = new ArrayList<>();

		String csvFile = "";
		try {
			csvFile = "resources/NewMoonNurseryPlants.csv";
			System.out.println("Found CSV file");
		} catch (Exception e) {
			System.out.println("Error getting CSV file");
		}

		BufferedReader bReader = null;
		String line = "";
		String charToSplitBy = ";";
		String[] csvLine = null;

		try {
			bReader = new BufferedReader(new FileReader(csvFile));
			System.out.println("Found CSV file");

			while ((line = bReader.readLine()) != null) {
				csvLine = line.split(charToSplitBy);
				/*
				Pattern searchPattern = Pattern.compile("\\d+");
				Matcher matcher = searchPattern.matcher(csvLine[1]);
				while (matcher.find()) {
					int testInt = Integer.parseInt(matcher.group());
					System.out.println("int is " + testInt);
				}
				*/
				plantList.add(new Plant2(csvLine[0], csvLine[1], csvLine[2], csvLine[3], csvLine[4], csvLine[5]));
				//System.out.println("break");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bReader != null) {
				try {
					bReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return plantList;

	}

	private Model gardenModel;

	private View view;
	private PlantPlacementScene pps;
	
	private final boolean DEBUG = true;
	public ArrayList<ImageView> ivs = new ArrayList<ImageView>();
	
	public Controller() {
		
	}
	
	public Controller(PlantPlacementScene pps) {
		this.pps = pps;
		gardenModel = new Model(View.getCanvasWidth(), View.getCanvasHeight());
		if (DEBUG) System.out.println("ic created");
	}

	/**
	 * @param theStage - the stage that the garden is displayed on
	 */
	@Override
	public void start(Stage theStage) throws Exception {
		view = new View(theStage, this);
		gardenModel = new Model(View.getCanvasWidth(), View.getCanvasHeight());
		theStage.show();
	}

	/**
	 * Saves the current garden project to a file
	 * 
	 * @param file - the file to be saved
	 */
	public void saveFile() {
		String filename = "resources/garden.ser";

		// Serialization
		try {
			// Saving of object in a file
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			// Method for serialization of object
			out.writeObject(this.gardenModel);

			out.close();
			file.close();

			System.out.println("Object has been serialized");

		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}

		// System.out.println(file);
	}

	/**
	 * Loads a saved garden project from a file
	 * 
	 * @param file - the garden project to be loaded
	 */
	public void loadFile(File file) {
		System.out.println(file);
	}

	/**
	 * Uses user mouse input to move plant image around on screen
	 * 
	 * @param event - event triggered by mouse click
	 */
	public void drag(MouseEvent event) {
		Node n = (Node)event.getSource();
		if (DEBUG) System.out.println("ic mouse drag tx: " + n.getTranslateX() + ", ex: " + event.getX() );
		gardenModel.setX(gardenModel.getX() + event.getX()); //event.getX() is the amount of horiz drag
		gardenModel.setY(gardenModel.getY() + event.getY());
		pps.setX(gardenModel.getX());
		pps.setY(gardenModel.getY());
	}
	
    public void makeCopy(MouseEvent event) {
    	Node n = (Node)event.getSource();
    	if (DEBUG) System.out.println("Copy made");
    	ImageView iv2 = (ImageView) n;
    }
	
	public EventHandler<MouseEvent> getHandlerForDragEntered() {
		return event -> makeCopy((MouseEvent) event);
	}
	
	public EventHandler<MouseEvent> getHandlerForDrag() {
		return event -> drag((MouseEvent) event);
	}

	public double getStartingX() {
		return gardenModel.getX();
	}
	
	public double getStartingY() {
		return gardenModel.getY();
	}
	
	public void setGardenProperties(int light, int rain, int soilPH, int temp) {
		this.gardenModel.setAmountOfLight(light);
		this.gardenModel.setAmountOfRain(rain);
		this.gardenModel.setSoilPH(soilPH);
		this.gardenModel.setTemperature(temp);
	}
}
