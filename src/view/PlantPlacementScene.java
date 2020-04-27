package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import mvc.View;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class PlantPlacementScene extends Scene {
	static Group root = new Group();
	
	public PlantPlacementScene() {
		super(root);
		placePlant();
	}
	
	/**
	 * Creates the plant placement scene which allows the user to drag
	 * and drop plants onto the garden space they drew previously.
	 */
	public void placePlant() {
		Canvas drawCanvas = new Canvas(View.getCanvasWidth(), View.getCanvasHeight());
		GraphicsContext drawGC;
		root.getChildren().add(drawCanvas);
		drawGC = drawCanvas.getGraphicsContext2D();
		drawGC.clearRect(0, 0, View.getCanvasWidth(), View.getCanvasHeight());
		
		
		BorderPane border = new BorderPane();
		VBox top = new VBox(5);
		HBox imageBar = new HBox(10);
		root.getChildren().add(border);
		AnchorPane center = new AnchorPane();
		BorderPane.setMargin(top, new Insets( 50,12.5,50,12.5));

		border.setTop(top);
		border.setCenter(center);
		Text scenetitle = new Text("Drag and Drop Plants");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		scenetitle.setTextAlignment(TextAlignment.CENTER);
		top.getChildren().add(scenetitle); 
		top.setAlignment(Pos.CENTER);
		imageBar.minHeight(100);
		imageBar.minWidth(View.getCanvasWidth());
		imageBar.maxHeight(100);
		imageBar.setStyle("-fx-border-color: black");
		imageBar.setPadding(new Insets(50,0,50,0));
		for(int i=0; i<10; i++) {
			imageBar.getChildren().add(new Label("{Plant image " + (int)(i+1)+"}"));
			imageBar.getChildren().add(new Separator(Orientation.VERTICAL));
		}
		top.getChildren().add(imageBar);

		
		BorderPane.setMargin(center, new Insets(0,12.5,0,12.5));
		center.setPadding(new Insets(View.getCanvasHeight()/2.5,50, 0, 0));
		BackgroundFill background_fill = new BackgroundFill(Color.FORESTGREEN, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        center.setBackground(background);
		center.setStyle("-fx-border-color: black");
		
		
		Button prevButton = new Button("prev");
		root.getChildren().add(prevButton);
		prevButton.setTranslateX(View.getCanvasWidth() / 2 - View.getCanvasWidth() / 4);
		prevButton.setTranslateY(600);

		EventHandler<ActionEvent> prevButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				View.getStage().setScene(View.getDrawScene());
			}
		};

		prevButton.setOnAction(prevButtonAction);
		
		Button nextButton = new Button("next");
		root.getChildren().add(nextButton);
		nextButton.setTranslateX(View.getCanvasWidth() / 2 + View.getCanvasWidth() / 4);
		nextButton.setTranslateY(600);

		EventHandler<ActionEvent> nextButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				View.getStage().setScene(View.getTimesScene());
			}
		};

		nextButton.setOnAction(nextButtonAction);

		// TODO replace with selecting plant from image
		Button plantButton = new Button("pick a plant");
		root.getChildren().add(plantButton);
		plantButton.setTranslateX(View.getCanvasWidth() / 3 + View.getCanvasWidth() / 4);
		plantButton.setTranslateY(200);

		EventHandler<ActionEvent> plantButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				View.getStage().setScene(View.getPlantInfoScene());
			}
		};

		plantButton.setOnAction(plantButtonAction);
		
	}

}
