package mvc;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;

import enums.Season;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import objects.GardenObject;
import view.*;

/**
 * View class for Garden Designer
 *
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class View {

	private Controller controller;
	private Scene gardenScene;
	private TilePane gardenTilePane;
	private HashMap<String, String> plants;

	static Rectangle2D screenBoundary = Screen.getPrimary().getVisualBounds();
	static int canvasWidth = (int) screenBoundary.getWidth() * 6 / 8;
	static int canvasHeight = (int) screenBoundary.getHeight() * 6 / 8;

	GraphicsContext mainMenuGC;
	Image mainMenuBackground;
	static Stage theStage;

	static GardenInfoScene gardenInfoScene = new GardenInfoScene();
	static MainMenuScene mainMenuScene = new MainMenuScene();
	static TutorialScene tutorialScene = new TutorialScene();
	static DrawScene drawScene = new DrawScene();
	static LoadingScene loadingScene = new LoadingScene();
	static PlantPlacementScene plantPlacementScene = new PlantPlacementScene();
	static PlantInfoScene plantInfoScene = new PlantInfoScene();
	static TimesScene timesScene = new TimesScene();
	static RatingScene ratingScene = new RatingScene();

	public final static int sGap = 5;
	public final static int mGap = 10;
	public final static int lGap = 25;

	public View(Stage stage, Controller controller) {
		theStage = stage;
		theStage.setResizable(false);
		theStage.setTitle("Garden Designer");
		theStage.setScene(mainMenuScene);
		this.controller = controller;
		this.initializeLoadingScene();
	}

	public void initializeLoadingScene() {
		loadingScene.getLoadButton().setOnMouseClicked(event -> {
			FileChooser chooser = new FileChooser();
			this.controller.loadFile(chooser.showOpenDialog(theStage));
		});
		loadingScene.getSaveButton().setOnMouseClicked(event -> {
			FileChooser chooser = new FileChooser();
			this.controller.saveFile(chooser.showSaveDialog(theStage));
		});
	}

	public static Image createImage(String pathToFile) {
		Image someImage = new Image(new File(pathToFile).toURI().toString());
		return someImage;
	}

	/**
	 * Changes to the main menu/title screen with buttons to begin the application.
	 * Should begin with this page.
	 */
	public void diplayMainMenu() {

	}

	/**
	 * Changes to the tutorial screen when a small button at the top of the page is
	 * pressed. This will also automatically pop up when first going into the
	 * application, and can be minimized. Includes all the information the user
	 * needs to know to use the application.
	 */
	void diplayTutorial() {

	}

	/**
	 * Changes to the information page where the user will be asked many questions
	 * about their plot of land, including the size of the plot, soil type, amount
	 * of rain, amount of light, and range of temperature.
	 */
	void displayInputs() {

	}

	/**
	 * Changes to the screen where the user will draw their initial map, adding
	 * Roads, Grass, Shade, Streams, Woods, and extra objects in the terrain. There
	 * will be a side bar which includes all of the types of terrain, and a tool to
	 * assist the user in drawing their item.
	 */
	void displayDraw() {

	}

	/**
	 * Changes to the garden screen where the user can drag and drop plants into the
	 * area. Will include a side bar with all the available plants, and both a
	 * search bar and filter based on plant characteristics.
	 */
	void displayGarden() {

	}

	/**
	 * Changes to the screen which displays the information of a plant, including
	 * all of its characteristics and a small image if available.
	 */
	void displayInformation() {

	}

	/**
	 * Changes to the screen where the user can change the ages of the plants, and
	 * roughly see how the garden looks in different seasons as well.
	 */
	void displayTimelapse() {

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
		return canvasWidth;
	}

	public static int getCanvasHeight() {
		return canvasHeight;
	}

	public static Stage getStage() {
		return theStage;
	}

	/**
	 * Used to move to the main menu scene
	 * 
	 * @return the main menu scene
	 */
	public static Scene getMainMenuScene() {
		return mainMenuScene;
	}

	/**
	 * Used to move to the garden info scene
	 * 
	 * @return the garden info scene
	 */
	public static GardenInfoScene getGardenInfoScene() {
		return gardenInfoScene;
	}

	/**
	 * Used to move to the tutorial scene
	 * 
	 * @return the tutorial scene
	 */
	public static TutorialScene getTutorialScene() {
		return tutorialScene;
	}

	/**
	 * Used to move to the loading scene
	 * 
	 * @return the loading scene
	 */
	public static LoadingScene getLoadingScene() {
		return loadingScene;
	}

	/**
	 * Used to move to the draw scene
	 * 
	 * @return the draw scene
	 */
	public static DrawScene getDrawScene() {
		return drawScene;
	}

	/**
	 * Used to move to plant placement scene
	 * 
	 * @return the plant placement scene
	 */
	public static PlantPlacementScene getPlantPlacementScene() {
		return plantPlacementScene;
	}

	/**
	 * Used to move to the plant info scene
	 * 
	 * @return the plant info scene
	 */
	public static PlantInfoScene getPlantInfoScene() {
		return plantInfoScene;
	}

	/**
	 * Used to move to the times scene
	 * 
	 * @return the times scene
	 */
	public static TimesScene getTimesScene() {
		return timesScene;
	}

	/**
	 * Used to move to the rating scene
	 *
	 * @return the rating scene
	 */
	public static RatingScene getRatingScene() {
		return ratingScene;
	}

}
