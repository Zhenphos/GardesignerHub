package mvc;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import view.GardenInfoScene;
import view.PlantPlacementScene;
import objects.Plant2;
import objects.GardenObject;

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
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

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
		Collection<Plant2> allPlants = importPlants();
		System.out.println("allPlants is " + allPlants);
		launch(args);
	}

	public static final String PLANT_DATA_PATH = "resources/NewMoonNurseryPlants.csv";

	public static Collection<Plant2> importPlants() {
		Collection<Plant2> plantList = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(PLANT_DATA_PATH))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(";");
				plantList.add(new Plant2(data[0], data[1], data[2], data[3], data[4], data[5]));
			}
		} catch (IOException e) {
			e.printStackTrace(); // to do:: add proper error handling
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
		model = new Model(View.WIDTH, View.HEIGHT);
		if (DEBUG) System.out.println("ic created");
	}

	/**
	 * @param theStage - the stage that the garden is displayed on
	 */
	@Override
	public void start(Stage theStage) throws Exception {
		view = new View(theStage, this);
		model = new Model(View.WIDTH, View.HEIGHT);
		theStage.show();
	}

	/**
	 * Event handler for when the user presses the new button on the main menu scene
	 */
	public void onMainMenuNew() {
		this.view.setScreen(View.Screen.GARDEN_INFO);
	}

	/**
	 * Event handler for when the user presses the help button on the MainMenuScene
	 */
	public void onMainMenuHelp() {
		this.view.setScreen(View.Screen.TUTORIAL);
	}

	/**
	 * Event handler for when the user presses the load button on the MainMenuScene
	 */
	public void onMainMenuLoad() {
		this.view.setScreen(View.Screen.LOADING);
	}

	/**
	 * Event handler for when the user presses the previous button on the GardenInfoscene
	 */
	public void onGardenInfoPrev() {
		this.view.setScreen(View.Screen.MAIN_MENU);
	}

	/**
	 * Event handler for when the user presses the next button on the GardenInfoScene
	 */
	public void onGardenInfoNext() {
		GardenInfoScene scene = (GardenInfoScene) this.view.getScene(View.Screen.GARDEN_INFO);
		try {
			int light = Integer.parseInt(scene.getSunlightTextfield().getText());
			int rain = Integer.parseInt(scene.getRainTextfield().getText());
			double soilPH = Double.parseDouble(scene.getSoilPHTextfield().getText());
			int temperature = Integer.parseInt(scene.getTempTextfield().getText());
			this.model.setAmountOfLight(light);
			this.model.setAmountOfRain(rain);
			this.model.setSoilPH(soilPH);
			this.model.setTemperature(temperature);
			this.view.setScreen(View.Screen.DRAW);
		} catch (NumberFormatException e) {
			this.view.showInvalidInputAlert();
		}
	}

	/**
	 * Event Handler for when the user presses the previous button on the Tutorialscene
	 */
	public void onTutorialPrev() {
		this.view.setScreen(View.Screen.MAIN_MENU);
	}

	/**
	 * Event handler for when the user presses the previous button on the TimesScene
	 */
	public void onTimesPrev() {
		this.view.setScreen(View.Screen.PLANT_PLACEMENT);
	}

	/**
	 * Event Handler for when the user presses the next button on the TimesScene
	 */
	public void onTimesNext() {
		this.view.setScreen(View.Screen.RATING);
	}

	/**
	 * Event Handler for when the user presses the previous button on the RatingScene
	 */
	public void onRatingPrev() {
		this.view.setScreen(View.Screen.TIMES);
	}

	/**
	 * Event handler for when the user presses the save button on the RatingScene
	 */
	public void onRatingSave() {
		File file = this.view.showSaveDialog();
		if (file == null) return;

		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
			out.writeObject(this.model);
			if (DEBUG) System.out.println("Object has been serialized to file: " + file.getPath());
		} catch (IOException ex) {
			// to do: notify user of saving error
			System.out.println("IOException is caught");
		}
	}

	/**
	 * Event handler for when the user wants to select a garden to load while on the LoadingScene
	 */
	public void onLoadingOpen() {
		File file = this.view.showOpenDialog();
		if (file == null) return;

		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
			Model model = (Model) in.readObject();
			if (DEBUG) {
				System.out.println("Object has been deserialized ");
				System.out.println("amount of light = " + model.getAmountOfLight());
			}
			// to do: update the scenes with data from new model and set the scene to the garden info scene
		} catch (IOException | ClassNotFoundException e) {
			// To do: add error handeling
			e.printStackTrace();
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
	
	/**
	 * 
	 * @param object the object that will be loaded into the model
	 */
	public void addGardenObject(GardenObject object) {
		this.model.addGardenObject(object);
		System.out.println("Added object");
	}
}
