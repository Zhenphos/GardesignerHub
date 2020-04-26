package mvc;

import java.util.Collection;
import java.util.HashMap;

import enums.Season;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
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

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class View {
	private Scene gardenScene;
	private TilePane gardenTilePane;
	private HashMap<String, String> plants;

	int canvasWidth = 1000;
	int canvasHeight = 750;
	GraphicsContext mainMenuGC;
	Image mainMenuBackground;

	public View(Stage theStage) {
		theStage.setTitle("Garden Planner Alpha");
		Group mainMenuGroup = new Group();
		Scene mainMenuScene = new Scene(mainMenuGroup);
		theStage.setScene(mainMenuScene);
		Canvas mainMenuCanvas = new Canvas(canvasWidth, canvasHeight);
		mainMenuGroup.getChildren().add(mainMenuCanvas);
		mainMenuGC = mainMenuCanvas.getGraphicsContext2D();
		setMainMenuBackground();
		diplayMainMenu();
		
		// TODO we should probably add a borderpane at the
		// top where we can stick buttons and stuff so we don't
		// have to redraw them, or something like that

		// TODO remove "magic numbers"

		// "New" button
		Button newButton = new Button("New");
		mainMenuGroup.getChildren().add(newButton);
		newButton.setTranslateX(canvasWidth / 2 - canvasWidth / 4);
		newButton.setTranslateY(500);

		// "Import" button
		Button importButton = new Button("Import");
		mainMenuGroup.getChildren().add(importButton);
		importButton.setTranslateX(canvasWidth / 2);
		importButton.setTranslateY(500);

		// "Load" button
		Button loadButton = new Button("Load");
		mainMenuGroup.getChildren().add(loadButton);
		loadButton.setTranslateX(canvasWidth / 2 + canvasWidth / 4);
		loadButton.setTranslateY(500);

		// TODO below are test buttons for screen flipping
		// they can probably be removed or modified when
		// the other buttons are implemented

		// "previous screen" button
		Button previousButton = new Button("prev");
		mainMenuGroup.getChildren().add(previousButton);
		previousButton.setTranslateX(canvasWidth / 2 - canvasWidth / 4);
		previousButton.setTranslateY(600);

		// "next screen" button
		Button nextButton = new Button("next");
		mainMenuGroup.getChildren().add(nextButton);
		nextButton.setTranslateX(canvasWidth / 2 + canvasWidth / 4);
		nextButton.setTranslateY(600);

		// TODO I don't understand how groups works
		// TODO should probably split this into another function
		Group gardenInfoGroup = new Group();
		
		Scene gardenInfoScene = new Scene(gardenInfoGroup);
		
		Canvas gardenInfoCanvas = new Canvas(canvasWidth, canvasHeight);
		GraphicsContext gardenInfoGC;
		gardenInfoGroup.getChildren().add(gardenInfoCanvas);
		gardenInfoGC = gardenInfoCanvas.getGraphicsContext2D();

		EventHandler<ActionEvent> nextButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				// TODO there is a high chance that this isn't
				// the correct way to do multiple scenes
				System.out.println("next button triggered");
				gardenInfoGC.clearRect(0, 0, canvasWidth, canvasHeight);
				Image gardenInfoBackground;
				gardenInfoBackground = createImage("resources\\gardenInfoImage.png");
				theStage.setScene(gardenInfoScene);
				gardenInfoGC.drawImage(gardenInfoBackground, 0, 0, canvasWidth, canvasHeight);
				
				Button testButton = new Button("test");
				gardenInfoGroup.getChildren().add(testButton);
				testButton.setTranslateX(canvasWidth / 2 + canvasWidth / 4);
				testButton.setTranslateY(600);
			}
		};

		nextButton.setOnAction(nextButtonAction);
		
		// some BorderPane testing for a toolbar at the bottom
		
		BorderPane bottomPane = new BorderPane();
	}

	private void setMainMenuBackground() {
		// TODO this function might not need to exist
		mainMenuBackground = createImage("resources\\mainMenuImage.png");
	}

	private Image createImage(String file) {
		Image someImage = new Image(file);
		return someImage;
	}
	
	

	/**
	 * Changes to the main menu/title screen with buttons to begin the application.
	 * Should begin with this page.
	 */
	public void diplayMainMenu() {
		// Clear the canvas
		mainMenuGC.clearRect(0, 0, canvasWidth, canvasHeight);
		// draw background
		mainMenuGC.drawImage(mainMenuBackground, 0, 0, canvasWidth, canvasHeight);

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
	 * @param the       season in which the plant is shown
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

	public int getCanvasWidth() {
		return canvasWidth;
	}

	public int getCanvasHeight() {
		return canvasHeight;
	}
}
