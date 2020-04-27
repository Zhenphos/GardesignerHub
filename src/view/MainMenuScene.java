package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import mvc.View;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class MainMenuScene extends Scene {
	static Group mainMenuGroup = new Group();

	public MainMenuScene() {
		super(mainMenuGroup);
		createMainMenu();
	}

	/**
	 * Creates the main menu scene
	 */
	public void createMainMenu() {
		// TODO split this up into different functions

		Canvas mainMenuCanvas = new Canvas(View.getCanvasWidth(), View.getCanvasHeight());
		GraphicsContext mainMenuGC;
		mainMenuGroup.getChildren().add(mainMenuCanvas);
		mainMenuGC = mainMenuCanvas.getGraphicsContext2D();

		mainMenuGC.clearRect(0, 0, View.getCanvasWidth(), View.getCanvasHeight());

		Image mainMenuBackground;
		mainMenuBackground = View.createImage("resources/mainMenuImage.png");
		mainMenuGC.drawImage(mainMenuBackground, 0, 0, View.getCanvasWidth(), View.getCanvasHeight());

		// "New" button
		Button newButton = new Button("New");
		mainMenuGroup.getChildren().add(newButton);
		newButton.setTranslateX(View.getCanvasWidth() / 2 - View.getCanvasWidth() / 4);
		newButton.setTranslateY(500);

		// "New" Button event handler
		EventHandler<ActionEvent> newButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				View.getStage().setScene(View.getGardenInfoScene());
			}
		};

		// "New" Button on click action
		newButton.setOnAction(newButtonAction);

		// "Save/Load" button
		Button saveLoadButton = new Button("Save/Load");
		mainMenuGroup.getChildren().add(saveLoadButton);
		saveLoadButton.setTranslateX(View.getCanvasWidth() / 2 + 230);
		saveLoadButton.setTranslateY(500);
		saveLoadButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				View.getStage().setScene(View.getLoadingScene());
			}
		});

		// "Tutorial" button
		Button tutorialButton = new Button("Tutorial");
		mainMenuGroup.getChildren().add(tutorialButton);
		tutorialButton.setTranslateX(View.getCanvasWidth() / 2 - 20);
		tutorialButton.setTranslateY(500);

		// "Tutorial" Button event handler
		EventHandler<ActionEvent> tutorialButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				View.getStage().setScene(View.getTutorialScene());
			}
		};

		// "Tutorial" Button on click action
		tutorialButton.setOnAction(tutorialButtonAction);
	}
}
