package mvc;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import enums.Season;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import objects.GardenObject;
import view.*;

/**
 * View class for Garden Designer
 *
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class View {

	public final static int sGap = 5;
	public final static int mGap = 10;
	public final static int lGap = 25;

	public static final String TITLE = "Garden Designer";
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final int SPACING = 10;

	public static final Background BACKGROUND = new Background(new BackgroundFill(Paint.valueOf("GREEN"), CornerRadii.EMPTY, Insets.EMPTY));
	public static final String TITLE_LABEL_STYLE = "-fx-font: 64 arial;";
	public static final String HEADER_LABEL_STYLE = "-fx-font: 48 arial;";
	public static final String TEXT_LABEL_STYLE = "-fx-font: 24 arial;";
	public static final String BUTTON_STYLE = "-fx-font: 32 arial;";
	public static final String TEXT_FIELD_STYLE = "";

	private static final String INVALID_INPUT_TITLE = "Invalid Input";
	private static final String INVALID_INPUT_TEXT = "Please ensure all the fields are filled out with numeric values.";

	public static final String PREV_BUTTON_TEXT = "Previous";
	public static final String NEXT_BUTTON_TEXT = "Next";

	private Stage stage;
	private Controller controller;
	private FileChooser chooser;
	private Map<Screen, Scene> screens;

	public View(Stage stage, Controller controller) {
		this.stage = stage;
		this.controller = controller;
		this.chooser = new FileChooser();
		this.chooser.setInitialDirectory(new File(System.getProperty("user.dir")));
		this.screens = new HashMap<>();
		this.screens.put(Screen.MAIN_MENU, new MainMenuScene());
		this.screens.put(Screen.GARDEN_INFO, new GardenInfoScene());
		this.screens.put(Screen.TUTORIAL, new TutorialScene());
		this.screens.put(Screen.DRAW, new DrawScene());
		this.screens.put(Screen.LOADING, new LoadingScene());
		this.screens.put(Screen.PLANT_PLACEMENT, new PlantPlacementScene());
		this.screens.put(Screen.PLANT_INFO, new PlantInfoScene());
		this.screens.put(Screen.TIMES, new TimesScene());
		this.screens.put(Screen.RATING, new RatingScene());
		this.initializeMainMenu();
		this.initializeGardenInfo();
		this.initializeTutorial();
		this.initializeDraw();
		this.initializeLoadingScene();
		this.initializePlantPlacement();
		this.initializePlantInfo();
		this.initializeTimes();
		this.initializeRatings();
		this.stage.setResizable(false);
		this.stage.setTitle(TITLE);
		this.stage.setScene(this.screens.get(Screen.MAIN_MENU));
	}

	/**
	 * Sets the active scene to the associated screen
	 * @param screen the key that gets the appropiate scene
	 */
	public void setScreen(Screen screen) {
		this.stage.setScene(this.getScene(screen));
	}

	public Scene getScene (Screen screen) {
		return this.screens.get(screen);
	}

	/**
	 * Initializes event handlers for MainMenuScene
	 */
	private void initializeMainMenu() {
		MainMenuScene scene = (MainMenuScene)this.screens.get(Screen.MAIN_MENU);
		scene.getNewButton().setOnAction(event -> this.controller.onMainMenuNew());
		scene.getHelpButton().setOnAction(event -> this.controller.onMainMenuHelp());
		scene.getLoadButton().setOnAction(event -> this.controller.onMainMenuLoad());
	}

	/**
	 * Initializes event handlers for GardenInfoScene
	 */
	private void initializeGardenInfo() {
		GardenInfoScene scene = (GardenInfoScene) this.screens.get(Screen.GARDEN_INFO);
		scene.getPrevButton().setOnAction(event -> this.controller.onGardenInfoPrev());
		scene.getNextButton().setOnAction(event -> this.controller.onGardenInfoNext());
	}

	/**
	 * Initializes event handlers for TutorialScene
	 */
	private void initializeTutorial() {
		TutorialScene scene = (TutorialScene) this.screens.get(Screen.TUTORIAL);
		scene.getPrevButton().setOnAction(event -> this.controller.onTutorialPrev());
	}

	/**
	 * Initializes event handlers for DrawScene
	 */
	private void initializeDraw() {
		DrawScene scene = (DrawScene) this.screens.get(Screen.DRAW);
	}

	/**
	 * Initializes event handlers for LoadingScene
	 */
	private void initializeLoadingScene() {
		LoadingScene scene = (LoadingScene) this.screens.get(Screen.LOADING);
	}

	/**
	 * Initializes event handlers for PlantPlacementScene
	 */
	private void initializePlantPlacement() {
		PlantPlacementScene scene = (PlantPlacementScene) this.screens.get(Screen.PLANT_PLACEMENT);
	}

	/**
	 * Initializes event handlers for PlantInfoScene
	 */
	private void initializePlantInfo() {
		PlantInfoScene scene = (PlantInfoScene) this.screens.get(Screen.PLANT_INFO);
	}

	/**
	 * Initializes event handlers for TimesScene
	 */
	private void initializeTimes() {
		TimesScene scene = (TimesScene) this.screens.get(Screen.TIMES);
	}

	/**
	 * Initializes event handlers for RatingsScene
	 */
	private void initializeRatings() {
		RatingScene scene = (RatingScene) this.screens.get(Screen.RATING);
	}

	/**
	 * Creates and shows an alert dialog, notifying the user of invalid input
	 */
	public void showInvalidInputAlert() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle(INVALID_INPUT_TITLE);
		alert.setContentText(INVALID_INPUT_TEXT);
		alert.show();
	}

	/**
	 * Opens a file chooser for the user to select a file to save to
	 * @return the file selected by the user
	 */
	public File showSaveDialog() {
		return this.chooser.showSaveDialog(this.stage);
	}

	/**
	 * Opens a file chooser for the user to select a file to open
	 * @return the file selected by the user
	 */
	public File showOpenDialog() {
		return this.chooser.showOpenDialog(this.stage);
	}

	public static Image createImage(String pathToFile) {
		Image someImage = new Image(new File(pathToFile).toURI().toString());
		return someImage;
	}

	/**
	 * Draws the map out for the user to see.
	 *
	 * @param someObjects a collection of garden objects which make up the map
	 * @return an ImageView of the map so the user can see the map.
	 */
	ImageView generateMap(Collection<GardenObject> someObjects) {
		return null;
	}

	/**
	 * Finds the correct image for a plant
	 *
	 * @param plantName the plant that will be shown in the image
	 * @param year      the amount of years after the plant has been planted
	 * @param season    the season in which the plant is shown
	 * @return an ImageView of the plant
	 */
	ImageView generateView(String plantName, int year, Season season) {
		return null;

	}

	/**
	 * Takes in the rating of a map and gives a message to tell the user how to
	 * improve their map and their rating.
	 *
	 * @param someRating the rating of the map on a scale from 1 to 5
	 * @return Text which will tell the user what they can do to improve based on
	 *         the ratings
	 */
	String howToImprove(int someRating) {
		return null;
	}

	public static int getCanvasWidth() {
		return WIDTH;
	}

	public static int getCanvasHeight() {
		return HEIGHT;
	}

	public enum Screen {
		MAIN_MENU,
		GARDEN_INFO,
		TUTORIAL,
		DRAW,
		LOADING,
		PLANT_PLACEMENT,
		PLANT_INFO,
		TIMES,
		RATING,
	}
}
