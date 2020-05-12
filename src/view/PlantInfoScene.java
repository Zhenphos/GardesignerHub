package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
		plantInfoGC.drawImage(plantImage, -20, View.getCanvasHeight() / 5.6, View.getCanvasWidth() / 2,
				View.getCanvasHeight() / 2);

		BorderPane border = new BorderPane();
		FlowPane left = new FlowPane();
		HBox center = new HBox();
		VBox right = new VBox();

		plantInfoGroup.getChildren().add(border);
		border.setLeft(left);
		border.setCenter(center);
		border.setRight(right);

		// TODO replace with file of plant names and change to take corresponding plant
		// name from file
		Text sceneTitle = new Text("\n\tPlant Name");
		sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		sceneTitle.setTextAlignment(TextAlignment.CENTER);
		center.getChildren().add(sceneTitle);
		center.setAlignment(Pos.TOP_CENTER);

		// TODO realign everything to scale with changing sizes of images, text, and
		// window
		Label light = new Label("Light info");
		Label water = new Label("Water info");
		Label bloomTime = new Label("Bloom time info");
		Label food = new Label("Food info");
		Label bloomColor = new Label("Bloom color info");
		Label soilReqs = new Label("Soil requirements info");

		right.minHeight(View.getCanvasHeight());
		right.minWidth(View.getCanvasWidth() / 2);
		right.maxHeight(View.getCanvasHeight());
		right.setPadding(new Insets(100, 200, 100, 50));
		right.setStyle("-fx-border-color: black");
		right.getChildren().addAll(light, new Label(""), water, new Label(""), bloomTime, new Label(""), food,
				new Label(""), bloomColor, new Label(""), soilReqs);
		BorderPane.setMargin(right, new Insets(View.getCanvasHeight() / 7, 50, 0, 0));
		/*
		Button backButton = createBackButton();
		plantInfoGroup.getChildren().add(backButton);
		*/

	}
	
	private Button createBackButton() {
		Button backButton = new Button("Go Back");

		backButton.setTranslateX(View.getCanvasWidth() / 2);
		backButton.setTranslateY(600);

		EventHandler<ActionEvent> backButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				View.getStage().setScene(View.getPlantPlacementScene());
			}
		};

		backButton.setOnAction(backButtonAction);
		return backButton;
	}
}
