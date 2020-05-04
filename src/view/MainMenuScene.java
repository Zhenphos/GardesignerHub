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
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
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

		Button newButton = createNewButton();

		mainMenuGroup.getChildren().add(newButton);
		newButton.setTranslateX(View.getCanvasWidth() / 2 - View.getCanvasWidth() / 4 - 20);
		newButton.setTranslateY(View.getCanvasHeight() * 3 / 5);

		Button saveLoadButton = createSaveLoadButton();

		mainMenuGroup.getChildren().add(saveLoadButton);
		saveLoadButton.setTranslateX(View.getCanvasWidth() / 2 + View.getCanvasWidth() / 4 - 20);
		saveLoadButton.setTranslateY(View.getCanvasHeight() * 3 / 5);

		Button tutorialButton = createTutorialButton();

		mainMenuGroup.getChildren().add(tutorialButton);
		tutorialButton.setTranslateX(View.getCanvasWidth() / 2 - 17);
		tutorialButton.setTranslateY(View.getCanvasHeight() * 3 / 5);

		Button aboutButton = createAboutButton();

		mainMenuGroup.getChildren().add(aboutButton);
	}

	private Button createAboutButton() {
		Button aboutButton = new Button();
		aboutButton.setText("About");
		aboutButton.setTranslateX(View.getCanvasWidth() / 2 - 20);
		aboutButton.setTranslateY(View.getCanvasHeight() * 7 / 10);
		aboutButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				final Stage aboutStage = new Stage();
				aboutStage.initModality(Modality.APPLICATION_MODAL);
				VBox aboutVbox = new VBox(20);
				aboutVbox.getChildren().add(new Text("    Authors:"));
				aboutVbox.getChildren()
						.add(new Text("    Jason H\n    Hamza M\n    Ntsee N\n    Haseeb S\n    Jonathan Z"));
				Scene aboutScene = new Scene(aboutVbox, 100, 150);
				aboutStage.setScene(aboutScene);
				aboutStage.show();
			}
		});
		return aboutButton;
	}

	private Button createTutorialButton() {
		Button tutorialButton = new Button("Help");

		EventHandler<ActionEvent> tutorialButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				final Stage helpStage = new Stage();
				helpStage.initModality(Modality.APPLICATION_MODAL);
				helpStage.setScene(View.getTutorialScene());
				helpStage.show();
			}
		};

		tutorialButton.setOnAction(tutorialButtonAction);
		return tutorialButton;
	}

	private Button createSaveLoadButton() {
		Button saveLoadButton = new Button("Save/Load");

		saveLoadButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				View.getStage().setScene(View.getLoadingScene());
			}
		});
		return saveLoadButton;
	}

	private Button createNewButton() {
		Button newButton = new Button("New");

		EventHandler<ActionEvent> newButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				View.getStage().setScene(View.getGardenInfoScene());
			}
		};

		newButton.setOnAction(newButtonAction);
		return newButton;
	}
}
