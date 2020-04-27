package view;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
	
		BorderPane border = new BorderPane();
		HBox hbox = new HBox();
		HBox top = new HBox();
		border.setTop(top);
		border.setLeft(hbox);
		HBox rightBox = new HBox();
		border.setRight(rightBox);
		rightBox.setStyle("-fx-border-color: black");
		rightBox.setPadding(new Insets(25,25,25,25));
		gardenInfoGroup.getChildren().add(border);

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		hbox.getChildren().add(grid);
		Text scenetitle = new Text("\t\tInformatoin Input \t\t\t\t\tHow To Get Information");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		top.getChildren().add(scenetitle); 
		
		Label light = new Label("Light :");
		grid.add(light, 0, 1);     //(col,row)

		TextField lightInput = new TextField();
		grid.add(lightInput, 1, 1);
		
		Label water = new Label("Water :");
		grid.add(water, 0, 2);

		TextField waterInput = new TextField();
		grid.add(waterInput, 1, 2);
		
		Label soil = new Label("Soil :");
		grid.add(soil, 0, 3);

		TextField soilInput = new TextField();
		grid.add(soilInput, 1, 3);
		
		Label weather = new Label("Weather :");
		grid.add(weather, 0, 4);

		TextField weatherInput = new TextField();
		grid.add(weatherInput, 1, 4);
		
		
		Text rightBoxTitle = new Text("How To Get Information");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		rightBox.getChildren().add(rightBoxTitle);
		
		
		Text infoTutorial = new Text();
		infoTutorial.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
		infoTutorial.wrappingWidthProperty().set(500);
		//grid.add(infoTutorial, 3, 0, 10, 10);
		rightBox.getChildren().add(infoTutorial);
		//		
//		Label light = new Label("Light :");
//		grid.add(light, 0, 1);
//
//		TextField lightInput = new TextField();
//		grid.add(lightInput, 1, 1);
		
		Image gardenInfoBackground;
		gardenInfoBackground = View.createImage("resources/gardenInfoImage.png");
		//gardenInfoGC.drawImage(gardenInfoBackground, 0, 0, View.getCanvasWidth(), View.getCanvasHeight());
		
		Button prevButton = new Button("prev");
		gardenInfoGroup.getChildren().add(prevButton);
		prevButton.setTranslateX(View.getCanvasWidth() / 2 - View.getCanvasWidth() / 4);
		prevButton.setTranslateY(600);

		EventHandler<ActionEvent> prevButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				View.getStage().setScene(View.getMainMenuScene());
			}
		};

		prevButton.setOnAction(prevButtonAction);
		
		Button nextButton = new Button("next");
		gardenInfoGroup.getChildren().add(nextButton);
		nextButton.setTranslateX(View.getCanvasWidth() / 2 + View.getCanvasWidth() / 4);
		nextButton.setTranslateY(600);
		
		EventHandler<ActionEvent> nextButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				View.getStage().setScene(View.getTutorialScene());
			}
		};

		nextButton.setOnAction(nextButtonAction);
	}

}
