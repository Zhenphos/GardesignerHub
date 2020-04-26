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

public class GardenInfoScene extends Scene {
	static Group gardenInfoGroup = new Group();

	public GardenInfoScene() {
		super(gardenInfoGroup);
		createGardenInfo();
	}

	public void createGardenInfo() {
		Canvas gardenInfoCanvas = new Canvas(View.getCanvasWidth(), View.getCanvasHeight());
		GraphicsContext gardenInfoGC;
		gardenInfoGroup.getChildren().add(gardenInfoCanvas);
		gardenInfoGC = gardenInfoCanvas.getGraphicsContext2D();

		gardenInfoGC.clearRect(0, 0, View.getCanvasWidth(), View.getCanvasHeight());

		Image gardenInfoBackground;
		gardenInfoBackground = View.createImage("resources\\gardenInfoImage.png");
		gardenInfoGC.drawImage(gardenInfoBackground, 0, 0, View.getCanvasWidth(), View.getCanvasHeight());
		
		Button prevButton = new Button("prev");
		gardenInfoGroup.getChildren().add(prevButton);
		prevButton.setTranslateX(View.getCanvasWidth() / 2 - View.getCanvasWidth() / 4);
		prevButton.setTranslateY(600);

		EventHandler<ActionEvent> prevButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				System.out.println("prev button triggered");
				View.getStage().setScene(View.getMainMenuScene());
			}
		};

		prevButton.setOnAction(prevButtonAction);
	}

}
