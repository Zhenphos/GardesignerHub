package mvc;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import enums.Names;
import enums.Season;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
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

	// Window Constants
	public static final String TITLE = "Garden Designer";
	public static final int WIDTH = (int) Screen.getPrimary().getBounds().getWidth() * 6 / 8;
	public static final int HEIGHT = (int) Screen.getPrimary().getBounds().getHeight() * 6 / 8;
	public static final int SPACING = 10;

	// GUI Styling Constants
	public static final Background BACKGROUND = new Background(new BackgroundFill(Paint.valueOf("GREEN"), CornerRadii.EMPTY, Insets.EMPTY));
	public static final String TITLE_LABEL_STYLE = "-fx-font: 64 arial;";
	public static final String HEADER_LABEL_STYLE = "-fx-font: 48 arial;";
	public static final String TEXT_LABEL_STYLE = "-fx-font: 20 arial;";
	public static final String BUTTON_STYLE = "-fx-font: 32 arial;";
	public static final String TEXT_FIELD_STYLE = "";

	// Button Texts
	public static final String PREV_BUTTON_TEXT = "Previous";
	public static final String NEXT_BUTTON_TEXT = "Next";
	public static final String SAVE_BUTTON_TEXT = "Save";
	public static final String BROWSE_BUTTON_TEXT = "Browse";
	public static final String EDIT_BUTTON_TEXT = "Edit";

	// Images
	public static final Image STAR_IMAGE = View.createImage("resources/star.png");

	// Dialog Text
	private static final String INVALID_INPUT_TITLE = "Invalid Input";
	private static final String INVALID_INPUT_TEXT = "Please ensure all the fields are filled out with numeric values.";

	private static final String DISCARD_TITLE = "Discard Changes";
	private static final String DISCARD_TEXT = "Are you sure you would like to go back to the main menu? This will discard any changes you have made.";

	private static final String GARDEN_FILE_EXTENSION = ".ser";
	private static final String GARDEN_FILE_NAME = String.format("Garden Files *(%s)", GARDEN_FILE_EXTENSION);

	private Stage stage;
	private Controller controller;
	private FileChooser chooser;
	private Map<Names, Scene> screens;

	public View(Stage stage, Controller controller) {
		this.stage = stage;
		this.controller = controller;
		this.chooser = new FileChooser();
		this.chooser.setInitialDirectory(new File(System.getProperty("user.dir")));
		this.chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(GARDEN_FILE_NAME, GARDEN_FILE_EXTENSION));
		this.screens = new HashMap<>();
		this.screens.put(Names.MAIN_MENU, new MainMenuScene());
		this.screens.put(Names.GARDEN_INFO, new GardenInfoScene());
		this.screens.put(Names.TUTORIAL, new TutorialScene());
		this.screens.put(Names.DRAW, new DrawScene());
		this.screens.put(Names.LOADING, new LoadingScene());
		this.screens.put(Names.PLANT_PLACEMENT, new PlantPlacementScene());
		this.screens.put(Names.PLANT_INFO, new PlantInfoScene());
		this.screens.put(Names.TIMES, new TimesScene());
		this.screens.put(Names.RATING, new RatingScene());
		this.initializeEvents();
		this.stage.setResizable(false);
		this.stage.setTitle(TITLE);
		this.stage.setScene(this.screens.get(Names.MAIN_MENU));
	}

	/**
	 * Sets the active scene to the associated screen
	 * @param name the key that gets the appropriate scene
	 */
	public void setScreen(Names name) {
		this.stage.setScene(this.getScene(name));
	}

	/**
	 * @param name
	 * @return the scene associated with
	 */
	public Scene getScene (Names name) {
		return this.screens.get(name);
	}

	/**
	 * Initializes events for all the scenes.
	 */
	private void initializeEvents() {
		this.initializeMainMenu();
		this.initializeGardenInfo();
		this.initializeTutorial();
		this.initializeDraw();
		this.initializeLoadingScene();
		this.initializePlantPlacement();
		this.initializePlantInfo();
		this.initializeTimes();
		this.initializeRatings();
	}

	/**
	 * Initializes event handlers for MainMenuScene
	 */
	private void initializeMainMenu() {
		MainMenuScene scene = (MainMenuScene) this.screens.get(Names.MAIN_MENU);
		scene.getNewButton().setOnAction(event -> this.controller.onMainMenuNew());
		scene.getHelpButton().setOnAction(event -> this.controller.onMainMenuHelp());
		scene.getLoadButton().setOnAction(event -> this.controller.onMainMenuLoad());
	}

	/**
	 * Initializes event handlers for GardenInfoScene
	 */
	private void initializeGardenInfo() {
		GardenInfoScene scene = (GardenInfoScene) this.screens.get(Names.GARDEN_INFO);
		scene.getPrevButton().setOnAction(event -> this.controller.onGardenInfoPrev());
		scene.getNextButton().setOnAction(event -> this.controller.onGardenInfoNext());
	}

	/**
	 * Initializes event handlers for TutorialScene
	 */
	private void initializeTutorial() {
		TutorialScene scene = (TutorialScene) this.screens.get(Names.TUTORIAL);
		scene.getPrevButton().setOnAction(event -> this.controller.onTutorialPrev());
	}

	/**
	 * Initializes event handlers for DrawScene
	 */
	private void initializeDraw() {
		DrawScene scene = (DrawScene) this.screens.get(Names.DRAW);
		scene.getPrevButton().setOnAction(event -> this.controller.onDrawPrev());
		scene.getNextButton().setOnAction(event -> this.controller.onDrawNext());
		scene.getGrassButton().setOnAction(event -> this.controller.onDrawGrass());
		scene.getRoadbutton().setOnAction(event -> this.controller.onDrawRoad());
		scene.getStreamButton().setOnAction(event -> this.controller.onDrawStream());
		scene.getWoodsButton().setOnAction(event -> this.controller.onDrawWoods());
		scene.getShadeButton().setOnAction(event -> this.controller.onDrawShader());
		scene.getDeleteButton().setOnAction(event -> this.controller.onDrawDelete());
	}

	/**
	 * Initializes event handlers for LoadingScene
	 */
	private void initializeLoadingScene() {
		LoadingScene scene = (LoadingScene) this.screens.get(Names.LOADING);
		scene.getBrowseButton().setOnAction(event -> this.controller.onLoadingBrowse());
		scene.getPrevButton().setOnAction(event -> this.controller.onLoadingPrev());
		scene.getEditButton().setOnAction(event -> this.controller.onLoadingEdit());
	}

	/**
	 * Initializes event handlers for PlantPlacementScene
	 */
	private void initializePlantPlacement() {
		PlantPlacementScene scene = (PlantPlacementScene) this.screens.get(Names.PLANT_PLACEMENT);
		scene.getPrevButton().setOnAction(event -> this.controller.onPlantPlacementPrev());
		scene.getNextButton().setOnAction(event -> this.controller.onPlantPlacementNext());
		//this.controller.onDragPlant(scene.getPlantClicked().getImage());
		// scene.getNextButton().setOnAction(event -> this.controller.onLoadingEdit());
	}

	/**
	 * Initializes event handlers for PlantInfoScene
	 */
	private void initializePlantInfo() {
		PlantInfoScene scene = (PlantInfoScene) this.screens.get(Names.PLANT_INFO);
	}

	/**
	 * Initializes event handlers for TimesScene
	 */
	private void initializeTimes() {
		TimesScene scene = (TimesScene) this.screens.get(Names.TIMES);
		scene.getPrevButton().setOnAction(event -> this.controller.onTimesPrev());
		scene.getNextButton().setOnAction(event -> this.controller.onTimesNext());
		scene.getAgeSlider().valueProperty().addListener((observable, oldValue, newValue) -> this.controller.onTimesSetAge(newValue.doubleValue()));
		scene.getSeasonGroup().selectedToggleProperty().addListener(((observable, oldValue, newValue) -> this.controller.onTimesSetSeason((Season)newValue.getUserData())));
	}

	/**
	 * Initializes event handlers for RatingsScene
	 */
	private void initializeRatings() {
		RatingScene scene = (RatingScene) this.screens.get(Names.RATING);
		scene.getPrevButton().setOnAction(event -> this.controller.onRatingPrev());
		scene.getSaveButton().setOnAction(event -> this.controller.onRatingSave());
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

	public Optional<ButtonType> showDiscardDialog() {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle(DISCARD_TITLE);
		alert.setContentText(DISCARD_TEXT);
		return alert.showAndWait();
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
	public ImageView generateMap(Collection<GardenObject> someObjects) {
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
	public ImageView generateView(String plantName, int year, Season season) {
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
	
	/**
	 * Draws anything in the map that is not already there
	 * 
	 * @param pane The pane which will contain the map
	 */
	public void drawMap(Pane pane) {
		for (GardenObject go:this.controller.loadMapObjects()) {
			if (!(pane.getChildren().contains(go.getShape().getPolygon())))
				pane.getChildren().add(go.getShape().getPolygon());
		}
	}
	
	public void drawEditMap(Pane pane) {
		for (GardenObject go:this.controller.loadMapObjects()) {
			if (!(pane.getChildren().contains(go.getShape().getPolygon())))
				pane.getChildren().add(go.getShape().getPolygon());
		}
	}
}
