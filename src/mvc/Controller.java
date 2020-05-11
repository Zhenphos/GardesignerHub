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
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import com.opencsv.CSVReader;

/**
 * Controller class for Garden Designer
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Controller extends Application {
	// My eclipse has some problems with relative paths so I've to use absolute path to my resources folder, please ignore this
	// You can change the path to your resource folder and it will work fine
	public static String pathToResourceFolder = "/Users/hamza/Developer/CSC275/team-11-2/resources";
	/**
	 * the main method for the program
	 * 
	 * @param args - an array of strings
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Plant2> allPlants = importPlants();
		// System.out.println("allPlants is " + allPlants);
		launch(args);
	}

	public static ArrayList<Plant2> importPlants() throws FileNotFoundException {
		ArrayList<Plant2> plantList = new ArrayList<>();
		
		String csvFile = "";
		try {
			csvFile = pathToResourceFolder + "/NewMoonNurseryPlants.csv";
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
				plantList.add(new Plant2(csvLine[0], csvLine[1], csvLine[2], csvLine[3], csvLine[4], csvLine[5]));
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
	public void saveFile() {
		String filename = pathToResourceFolder + "/garden.ser"; 
        
        // Serialization  
        try
        {    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(filename); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            out.writeObject(this.gardenModel); 
              
            out.close(); 
            file.close(); 
              
            System.out.println("Object has been serialized"); 
  
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
  
  
      

		//System.out.println(file);
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
