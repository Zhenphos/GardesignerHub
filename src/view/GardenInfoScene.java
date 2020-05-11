package view;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mvc.Controller;
import mvc.View;

/**
 *
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class GardenInfoScene extends Scene {
	static Group gardenInfoGroup = new Group();

	private Controller controller;

	private TextField tfLight;
	private TextField tfRain;
	private TextField tfPH;
	private TextField tfTemp;
	private Button next;


	public GardenInfoScene() {
		super(gardenInfoGroup);
		createGardenInfo();
	}

	public void setController(Controller controller) {
		this.controller = controller;
		EventHandler<ActionEvent> nextButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {

				try {
					int light = Integer.parseInt(tfLight.getText());
					int rain = Integer.parseInt(tfRain.getText());
					int ph = Integer.parseInt(tfPH.getText());
					int temp = Integer.parseInt(tfTemp.getText());
					controller.setGardenProperties(light, rain, ph, temp);
				} catch (NumberFormatException nfe) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Invalid Input");
					alert.setContentText("Please be sure you enter numeric values for your garden properties.");
					alert.showAndWait();
					return;
				}

				View.getStage().setScene(View.getDrawScene());
			}
		};
		this.next.setOnAction(nextButtonAction);
	}

	/**
	 * Creates the garden information scene
	 */
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
		rightBox.setPadding(new Insets(View.lGap));
		gardenInfoGroup.getChildren().add(border);

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(View.lGap));
		hbox.getChildren().add(grid);
		Text scenetitle = new Text("\t\tInformation Input \t\t\t\t\tHow To Get Information");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		top.getChildren().add(scenetitle);

		Label light = new Label("Hours of Sunlight :");
		grid.add(light, 0, 1); // (col,row)

		this.tfLight = new TextField();
		grid.add(this.tfLight, 1, 1);

		Label water = new Label("Amount of Rain (millimeters) :");
		grid.add(water, 0, 2);

		this.tfRain = new TextField();
		grid.add(this.tfRain, 1, 2);

		Label soil = new Label("Soil pH :");
		grid.add(soil, 0, 3);

		this.tfPH = new TextField();
		grid.add(this.tfPH, 1, 3);

		Label weather = new Label("Temperature (Fahrenheit) :");
		grid.add(weather, 0, 4);

		this.tfTemp = new TextField();
		grid.add(this.tfTemp, 1, 4);

		Text infoTutorial = new Text();
		infoTutorial.setText(
				"Please enter some information about your garden in the boxes to the left. It will help us calculate the optimal garden design for you. If you are uncertain about any of these values or do not wish to answer, simply leave the box blank and press next. \n \n The \"Hours of Sunlight\" is the hours of light your garden experiences on an average day. \n \n The \"Amount of Rain\" is how much rain your garden experiences in an average week in millimeters. \n \n The \"Soil pH\" is how acidic or basic your soil is. You may not know this, which is fine. Simply skip over it. \n \n The \"Temperature\" is the average temperature the land the garden will be on has experienced in the past week, in Fahrenheit.");
		infoTutorial.setFont(Font.font("Tahoma", FontWeight.NORMAL, 22));
		infoTutorial.wrappingWidthProperty().set(550);
		// grid.add(infoTutorial, 3, 0, 10, 10);
		rightBox.getChildren().add(infoTutorial);
		//
//		Label light = new Label("Light :");
//		grid.add(light, 0, 1);
//
//		TextField lightInput = new TextField();
//		grid.add(lightInput, 1, 1);

		Image gardenInfoBackground;
		System.out.println();
		gardenInfoBackground = View.createImage("resources/gardenInfoImage.png");
		gardenInfoGC.drawImage(gardenInfoBackground, 0, 0, View.getCanvasWidth(), View.getCanvasHeight());

		Button prevButton = createPrevButton();

		gardenInfoGroup.getChildren().add(prevButton);

		this.next = createNextButton();

		gardenInfoGroup.getChildren().add(next);

		Button mainMenuButton = createMainMenuButton();

		gardenInfoGroup.getChildren().add(mainMenuButton);

		Button tutorialButton = createTutorialButton();

		gardenInfoGroup.getChildren().add(tutorialButton);



	}

	private Button createTutorialButton() {
		Button tutorialButton = new Button("Help");

		tutorialButton.setTranslateX(View.getCanvasWidth() * 1 / 3);
		tutorialButton.setTranslateY(View.getCanvasHeight() * 7 / 8);

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

	private Button createMainMenuButton() {
		Button mainMenuButton = new Button("Main Menu");

		mainMenuButton.setTranslateX(View.getCanvasWidth() * 2 / 3);
		mainMenuButton.setTranslateY(View.getCanvasHeight() * 7 / 8);

		EventHandler<ActionEvent> mainMenuButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				View.getStage().setScene(View.getMainMenuScene());
			}
		};

		mainMenuButton.setOnAction(mainMenuButtonAction);
		return mainMenuButton;
	}

	private Button createNextButton() {
		Button nextButton = new Button("Next");

		nextButton.setTranslateX(View.getCanvasWidth() * 7 / 8);
		nextButton.setTranslateY(View.getCanvasHeight() * 7 / 8);
		return nextButton;
	}

	private Button createPrevButton() {
		Button prevButton = new Button("Prev");

		prevButton.setTranslateX(View.getCanvasWidth() * 1 / 8);
		prevButton.setTranslateY(View.getCanvasHeight() * 7 / 8);

		EventHandler<ActionEvent> prevButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				View.getStage().setScene(View.getMainMenuScene());
			}
		};

		prevButton.setOnAction(prevButtonAction);
		return prevButton;
	}

}
