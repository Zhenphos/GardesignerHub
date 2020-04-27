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

public class DrawScene extends Scene {
	static Group drawGroup = new Group();

	public DrawScene() {
		super(drawGroup);
		createDraw();
	}

	public void createDraw() {
		Canvas drawCanvas = new Canvas(View.getCanvasWidth(), View.getCanvasHeight());
		GraphicsContext drawGC;
		drawGroup.getChildren().add(drawCanvas);
		drawGC = drawCanvas.getGraphicsContext2D();

		drawGC.clearRect(0, 0, View.getCanvasWidth(), View.getCanvasHeight());
		
		Image drawBackground;
		drawBackground = View.createImage("resources/drawImage.png");
		drawGC.drawImage(drawBackground, 0, 0, View.getCanvasWidth(), View.getCanvasHeight());
		
		Button prevButton = new Button("prev");
		drawGroup.getChildren().add(prevButton);
		prevButton.setTranslateX(View.getCanvasWidth() / 2 - View.getCanvasWidth() / 4);
		prevButton.setTranslateY(600);

		EventHandler<ActionEvent> prevButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				View.getStage().setScene(View.getTutorialScene());
			}
		};

		prevButton.setOnAction(prevButtonAction);
		
		Button nextButton = new Button("next");
		drawGroup.getChildren().add(nextButton);
		nextButton.setTranslateX(View.getCanvasWidth() / 2 + View.getCanvasWidth() / 4);
		nextButton.setTranslateY(600);

		EventHandler<ActionEvent> nextButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				//View.getStage().setScene(View.getDrawScene());
			}
		};

		nextButton.setOnAction(nextButtonAction);
		
	}
}
