package mvc;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import view.PlantInfoScene;
import view.PlantPlacementScene;
import objects.Plant2;
import objects.GardenObject;
import objects.Grass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
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

	private Model model;

	private View view;
	private PlantPlacementScene pps;
	
	private final boolean DEBUG = true;
	public ArrayList<ImageView> ivs = new ArrayList<ImageView>();
	
	public Controller() {
		
	}
	
	public Controller(PlantPlacementScene pps) {
		this.pps = pps;
		model = new Model(View.getCanvasWidth(), View.getCanvasHeight());
		if (DEBUG) System.out.println("ic created");
	}

	/**
	 * @param theStage - the stage that the garden is displayed on
	 */
	@Override
	public void start(Stage theStage) throws Exception {
		view = new View(theStage, this);
		model = new Model(view.getCanvasWidth(), view.getCanvasHeight());
		theStage.show();
	}

	/**
	 * Saves the current garden project to a file
	 * 
	 * @param file - the file to be saved
	 */
	public void saveFile(File filename) {
		// Serialization
		try {
			// Saving of object in a file
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			// Method for serialization of object
			out.writeObject(this.model);

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
	public void loadFile(File filename) {
		try
        {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file); 

            // Method for deserialization of object 
            Model model = null;
            model = (Model)in.readObject();
            System.out.println("working");
            in.close(); 
            file.close(); 
              
            System.out.println("Object has been deserialized "); 
            System.out.println("amount of light = " + model.getAmountOfLight()); 

            View.gardenInfoScene.setFields(model.getAmountOfLight(), model.getAmountOfRain(), model.getSoilPH(), model.getTemperature());

        } 
          
        catch(IOException ex) 
        {
        	ex.printStackTrace();
        } 
          
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        } 
		//System.out.println(file);
	}


	/**
	 * Uses user mouse input to move plant image around on screen
	 * 
	 * @param event - event triggered by mouse click
	 */
	public void drag(MouseEvent event) {
		Node n = (Node)event.getSource();
		if (DEBUG) System.out.println("ic mouse drag tx: " + n.getTranslateX() + ", ex: " + event.getX() );
		model.setX(model.getX() + event.getX()); //event.getX() is the amount of horiz drag
		model.setY(model.getY() + event.getY());
		pps.setX(model.getX());
		pps.setY(model.getY());
	}
	
	/**
	 * Makes a copy of an ImageView if there is user mouse input on
	 * one of the ImageViews in the dock.
	 * 
	 * @param event - event triggered by mouse click
	 */
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

	}


	/**
	 * Uses user mouse input to move plant image around on screen
	 * 
	 * @param event - event triggered by mouse click
	 */
	public void drag(MouseEvent event) {
		Node n = (Node)event.getSource();
		if (DEBUG) System.out.println("ic mouse drag tx: " + n.getTranslateX() + ", ex: " + event.getX() );
		model.setX(model.getX() + event.getX()); //event.getX() is the amount of horiz drag
		model.setY(model.getY() + event.getY());
		pps.setX(model.getX());
		pps.setY(model.getY());
	}
	
	/**
	 * Makes a copy of an ImageView if there is user mouse input on
	 * one of the ImageViews in the dock.
	 * 
	 * @param event - event triggered by mouse click
	 */
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
		return model.getX();
	}
	
	public double getStartingY() {
		return model.getY();
	}
	
	public void setGardenProperties(int light, int rain, Double soilPH, int temp) {

	public void setGardenProperties(int light, int rain, int soilPH, int temp) {

		this.model.setAmountOfLight(light);
		System.out.println("Light: " + light);
		this.model.setAmountOfRain(rain);
		System.out.println("Rain: " + rain);
		this.model.setSoilPH(soilPH);
		System.out.println("Soil pH: " + soilPH);
		this.model.setTemperature(temp);
		System.out.println("Temperature: " + temp);
	}
	
	/**
	 * Adds a garden object to the plot
	 * 
	 * @param object the object that will be loaded into the model
	 */
	public void addGardenObject(GardenObject object) {
		this.model.addGardenObject(object);
		System.out.println("Added object");
	}
}
