package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import mvc.View;

/**
 * The scene that displays information about a selected plant.
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class PlantInfoScene extends Scene {
	static Group plantInfoGroup = new Group();
	
	public PlantInfoScene() {
		super(plantInfoGroup);
		createPlantInfo();
	}
	
	/**
	 * Creates the plant info scene
	 */
	public void createPlantInfo() {
		Canvas plantInfoCanvas = new Canvas(View.getCanvasWidth(), View.getCanvasHeight());
		GraphicsContext plantInfoGC;
		plantInfoGroup.getChildren().add(plantInfoCanvas);
		plantInfoGC = plantInfoCanvas.getGraphicsContext2D();
		plantInfoGC.clearRect(0, 0, View.getCanvasWidth(), View.getCanvasHeight());
		
		Image plantInfoBackground;
		// TODO replace with new background
		plantInfoBackground = View.createImage("resources/gardenInfoImage.png");
		plantInfoGC.drawImage(plantInfoBackground, 0, 0, View.getCanvasWidth(), View.getCanvasHeight());
		
		Image plantImage;
		// TODO replace with variable that gets image corresponding to selected plant
		plantImage = View.createImage("resources/commonMilkweed.png");
		plantInfoGC.drawImage(plantImage, 0, View.getCanvasHeight() / 6, View.getCanvasWidth() / 2, View.getCanvasHeight() / 2);
		
		BorderPane border = new BorderPane();
		HBox top = new HBox();
		FlowPane left = new FlowPane();
		AnchorPane center = new AnchorPane();
		
		plantInfoGroup.getChildren().add(border);
		border.setTop(top);
		border.setLeft(left);
		border.setCenter(center);
		
		// TODO replace with file of plant names and change to take corresponding plant name from file
		Text sceneTitle = new Text("\nPlant Name");
		sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		sceneTitle.setTextAlignment(TextAlignment.CENTER);
		top.getChildren().add(sceneTitle);
		top.setAlignment(Pos.CENTER);
		
		Button prevButton = new Button("prev");
		plantInfoGroup.getChildren().add(prevButton);
		prevButton.setTranslateX(View.getCanvasWidth() / 2 - View.getCanvasWidth() / 4);
		prevButton.setTranslateY(600);
		
		EventHandler<ActionEvent> prevButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				View.getStage().setScene(View.getPlantPlacementScene());
			}
		};

		prevButton.setOnAction(prevButtonAction);
	}
}
