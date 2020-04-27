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
import javafx.scene.paint.Paint;
import mvc.View;

public class TutorialScene extends Scene {
	static Group tutorialGroup = new Group();

	public TutorialScene() {
		super(tutorialGroup);
		createTutorial();
	}

	public void createTutorial() {
		Canvas tutorialCanvas = new Canvas(View.getCanvasWidth(), View.getCanvasHeight());
		GraphicsContext tutorialGC;
		tutorialGroup.getChildren().add(tutorialCanvas);
		tutorialGC = tutorialCanvas.getGraphicsContext2D();

		tutorialGC.clearRect(0, 0, View.getCanvasWidth(), View.getCanvasHeight());

		Image tutorialBackground;
		tutorialBackground = View.createImage("/resources/tutorialImage.png");
		tutorialGC.drawImage(tutorialBackground, 0, 0, View.getCanvasWidth(), View.getCanvasHeight());
		
		Button prevButton = new Button("prev");
		tutorialGroup.getChildren().add(prevButton);
		prevButton.setTranslateX(View.getCanvasWidth() / 2 - View.getCanvasWidth() / 4);
		prevButton.setTranslateY(600);

		EventHandler<ActionEvent> prevButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				View.getStage().setScene(View.getGardenInfoScene());
			}
		};

		prevButton.setOnAction(prevButtonAction);
		
		Button nextButton = new Button("next");
		tutorialGroup.getChildren().add(nextButton);
		nextButton.setTranslateX(View.getCanvasWidth() / 2 + View.getCanvasWidth() / 4);
		nextButton.setTranslateY(600);

		EventHandler<ActionEvent> nextButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				View.getStage().setScene(View.getDrawScene());
			}
		};

		nextButton.setOnAction(nextButtonAction);
		
	}
}
