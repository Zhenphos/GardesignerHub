package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import mvc.View;

public class MainMenuScene extends Scene {
	static Group mainMenuGroup = new Group();

	public MainMenuScene() {
		super(mainMenuGroup);
		createMainMenu();
	}

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

		// "Import" button
		Button importButton = new Button("Import");
		mainMenuGroup.getChildren().add(importButton);
		importButton.setTranslateX(View.getCanvasWidth() / 2);
		importButton.setTranslateY(500);

		// "Load" button
		Button loadButton = new Button("Load");
		mainMenuGroup.getChildren().add(loadButton);
		loadButton.setTranslateX(View.getCanvasWidth() / 2 + View.getCanvasWidth() / 4);
		loadButton.setTranslateY(500);
		loadButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				View.getStage().setScene(View.loadingScene);
			}
		});

		// TODO below are test buttons for screen flipping
		// they can probably be removed or modified when
		// the other buttons are implemented

		// "next screen" button
		Button nextButton = new Button("next");
		mainMenuGroup.getChildren().add(nextButton);
		nextButton.setTranslateX(View.getCanvasWidth() / 2 + View.getCanvasWidth() / 4);
		nextButton.setTranslateY(600);

		// nextButton event handler
		EventHandler<ActionEvent> nextButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				System.out.println("next button triggered");
				View.getStage().setScene(View.getGardenInfoScene());
			}
		};

		// nextButton on click action
		nextButton.setOnAction(nextButtonAction);

	}

}
