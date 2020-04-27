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
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import mvc.View;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class TutorialScene extends Scene {
	static Group tutorialGroup = new Group();

	public TutorialScene() {
		super(tutorialGroup);
		createTutorial();
	}

	/**
	 * Creates the tutorial scene
	 */
	public void createTutorial() {
		Canvas tutorialCanvas = new Canvas(View.getCanvasWidth(), View.getCanvasHeight());
		GraphicsContext tutorialGC;
		tutorialGroup.getChildren().add(tutorialCanvas);
		tutorialGC = tutorialCanvas.getGraphicsContext2D();
		tutorialGC.clearRect(0, 0, View.getCanvasWidth(), View.getCanvasHeight());

		Image tutorialBackground;
		tutorialBackground = View.createImage("resources/tutorialImage.png");
		// tutorialGC.drawImage(tutorialBackground, 0, 0, View.getCanvasWidth(),
		// View.getCanvasHeight());

		BorderPane border = new BorderPane();
		HBox center = new HBox();
		Text scenetitle = new Text("Tutorial");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 24));
		border.setTop(scenetitle);
		BorderPane.setMargin(scenetitle, new Insets(50, 0, 0, 150));

		Text infoTutorial = new Text();
		infoTutorial.setText(
				"Please follow this short guide to help familiarize yourself with this program's features. \n \n Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
		infoTutorial.setFont(Font.font("Tahoma", FontWeight.NORMAL, 22));
		infoTutorial.wrappingWidthProperty().set(600);
		center.getChildren().add(infoTutorial);
		border.setCenter(center);
		tutorialGroup.getChildren().add(border);
		BorderPane.setAlignment(scenetitle, Pos.CENTER);
		BorderPane.setMargin(center, new Insets(20, 5, 5, 200));
		center.setStyle("-fx-border-color: black");
		center.setPadding(new Insets(25, 25, 25, 25));
		
		/*

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
		
		*/

		// "Main Menu" button
		Button mainMenuButton = new Button("Main Menu");
		tutorialGroup.getChildren().add(mainMenuButton);
		mainMenuButton.setTranslateX(View.getCanvasWidth() / 2 - 20);
		mainMenuButton.setTranslateY(600);

		// "Main Menu" Button event handler
		EventHandler<ActionEvent> mainMenuButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				View.getStage().setScene(View.getMainMenuScene());
			}
		};

		// "Main Menu" Button on click action
		mainMenuButton.setOnAction(mainMenuButtonAction);

	}
}
