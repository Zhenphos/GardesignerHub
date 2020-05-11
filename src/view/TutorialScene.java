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
		Canvas tutorialCanvas = new Canvas(View.getCanvasWidth() * 3/4, View.getCanvasHeight() * 3/4);
		GraphicsContext tutorialGC;
		tutorialGroup.getChildren().add(tutorialCanvas);
		tutorialGC = tutorialCanvas.getGraphicsContext2D();
		tutorialGC.clearRect(0, 0, View.getCanvasWidth() * 3/4, View.getCanvasHeight() * 3/4);

		Image tutorialBackground;
		tutorialBackground = View.createImage("resources/tutorialImage.png");
		// tutorialGC.drawImage(tutorialBackground, 0, 0, View.getCanvasWidth(),
		// View.getCanvasHeight());

		BorderPane border = new BorderPane();
		HBox center = new HBox();
		Text scenetitle = new Text("Tutorial");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 24));
		border.setTop(scenetitle);
		BorderPane.setMargin(scenetitle, new Insets(View.lGap));

		Text infoTutorial = new Text();
		infoTutorial.setText(
				"Please follow this short guide to help familiarize yourself with this program's features.\n \n If you already have a garden saved and want to edit it use the \"Save/Load\" button and select it with your file manager.\n \n Otherwise, select the \"New\" button to begin creating a garden.\n \n Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.");
		infoTutorial.setFont(Font.font("Tahoma", FontWeight.NORMAL, 22));
		infoTutorial.wrappingWidthProperty().set(600);
		center.getChildren().add(infoTutorial);
		border.setCenter(center);
		tutorialGroup.getChildren().add(border);
		BorderPane.setAlignment(scenetitle, Pos.CENTER);
		BorderPane.setMargin(center, new Insets(View.lGap * 2));
		center.setStyle("-fx-border-color: black");
		center.setPadding(new Insets(View.lGap));

	}
}
