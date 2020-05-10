package mvc;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import objects.Plant2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Controller class for Garden Planner
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Controller extends Application {
	/**
	 * the main method for the program
	 * 
	 * @param args - an array of strings
	 */
	public static void main(String[] args) {
		ArrayList<Plant2> allPlants = importPlants();
		launch(args);
	}

	public static ArrayList<Plant2> importPlants() {
		String csvFile = "";
		try {
			csvFile = "resources/NewMoonNurseryPlants.csv";
			System.out.println("Found CSV file");
		} catch (Exception e) {
			System.out.println("Error getting CSV file");
		}

		// should be an ArrayList of Plant2 objects
		BufferedReader bReader = null;
		String line = "";
		String splitCSVBy = ";";

		try {
			
			bReader = new BufferedReader(new FileReader(csvFile));
			while ((line = bReader.readLine()) != null) {
				// use comma as separator
				String[] lineFromCSV = line.split(splitCSVBy);
				// System.out.println("Country [code= " + lineFromCSV[4] + " , name=" +
				// lineFromCSV[5] + "]");
				System.out.println(Arrays.toString(lineFromCSV));
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

		return null;

	}

	private Model gardenModel;

	private View view;

	public Controller() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0 - the stage that the garden is displayed on
	 */
	@Override
	public void start(Stage theStage) throws Exception {
		view = new View(theStage, this);
		gardenModel = new Model(view.getCanvasWidth(), view.getCanvasHeight());
		theStage.show();
	}

	/**
	 * Saves the current garden project to a file
	 * 
	 * @param file - the file to be saved
	 */
	public void saveFile(File file) {
		System.out.println(file);
	}

	/**
	 * Loads a saved garden project from a file
	 * 
	 * @param file - the garden project to be loaded
	 */
	public void loadFile(File file) {
		System.out.println(file);
	}

}
