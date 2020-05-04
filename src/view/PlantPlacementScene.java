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
import javafx.stage.Modality;
import javafx.stage.Stage;
import mvc.View;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class PlantPlacementScene extends Scene {
	static Group plantPlacementGroup = new Group();

	public PlantPlacementScene() {
		super(plantPlacementGroup);
		placePlant();
	}

	/**
	 * Creates the plant placement scene which allows the user to drag and drop
	 * plants onto the garden space they drew previously.
	 */
	public void placePlant() {
		Canvas drawCanvas = new Canvas(View.getCanvasWidth(), View.getCanvasHeight());
		GraphicsContext drawGC;
		plantPlacementGroup.getChildren().add(drawCanvas);
		drawGC = drawCanvas.getGraphicsContext2D();
		drawGC.clearRect(0, 0, View.getCanvasWidth(), View.getCanvasHeight());

		BorderPane border = new BorderPane();
		VBox top = new VBox(5);
		HBox imageBar = new HBox(10);
		plantPlacementGroup.getChildren().add(border);
		AnchorPane center = new AnchorPane();
		BorderPane.setMargin(top, new Insets(50, 12.5, 50, 12.5));

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
		imageBar.setPadding(new Insets(50, 0, 50, 0));
		for (int i = 0; i < 10; i++) {
			imageBar.getChildren().add(new Label("{Plant image " + (int) (i + 1) + "}"));
			imageBar.getChildren().add(new Separator(Orientation.VERTICAL));
		}
		top.getChildren().add(imageBar);

		BorderPane.setMargin(center, new Insets(0, 12.5, 0, 12.5));
		center.setPadding(new Insets(View.getCanvasHeight() / 2.5, 50, 0, 0));
		BackgroundFill background_fill = new BackgroundFill(Color.FORESTGREEN, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(background_fill);
		center.setBackground(background);
		center.setStyle("-fx-border-color: black");

		Button prevButton = createPrevButton();

		plantPlacementGroup.getChildren().add(prevButton);
		prevButton.setTranslateX(View.getCanvasWidth() * 1 / 8);
		prevButton.setTranslateY(View.getCanvasHeight() * 7 / 8);

		Button nextButton = createNextButton();

		plantPlacementGroup.getChildren().add(nextButton);
		nextButton.setTranslateX(View.getCanvasWidth() * 7 / 8);
		nextButton.setTranslateY(View.getCanvasHeight() * 7 / 8);

		// TODO replace with selecting plant from image
		Button choosePlantButton = createChoosePlantButton();

		plantPlacementGroup.getChildren().add(choosePlantButton);

		choosePlantButton.setTranslateX(View.getCanvasWidth() / 2 - 20);

		choosePlantButton.setTranslateX(View.getCanvasWidth() / 2 - 20);

		choosePlantButton.setTranslateY(210);

		Button mainMenuButton = createMainMenuButton();

		plantPlacementGroup.getChildren().add(mainMenuButton);

		mainMenuButton.setTranslateX(View.getCanvasWidth() * 2 / 3);
		mainMenuButton.setTranslateY(View.getCanvasHeight() * 7 / 8);

		Button tutorialButton = createTutorialButton();

		plantPlacementGroup.getChildren().add(tutorialButton);
		tutorialButton.setTranslateX(View.getCanvasWidth() * 1 / 3);
		tutorialButton.setTranslateY(View.getCanvasHeight() * 7 / 8);

	}

	private Button createTutorialButton() {
		Button tutorialButton = new Button("Help");

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

		EventHandler<ActionEvent> mainMenuButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				View.getStage().setScene(View.getMainMenuScene());
			}
		};

		mainMenuButton.setOnAction(mainMenuButtonAction);
		return mainMenuButton;
	}

	private Button createChoosePlantButton() {
		Button choosePlantButton = new Button("Choose a Plant");

		EventHandler<ActionEvent> plantButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				final Stage pInfoStage = new Stage();
				pInfoStage.initModality(Modality.APPLICATION_MODAL);
				pInfoStage.setScene(View.getPlantInfoScene());
				pInfoStage.show();
			}
		};

		choosePlantButton.setOnAction(plantButtonAction);
		return choosePlantButton;
	}

	private Button createNextButton() {
		Button nextButton = new Button("Next");

		EventHandler<ActionEvent> nextButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				View.getStage().setScene(View.getTimesScene());
			}
		};

		nextButton.setOnAction(nextButtonAction);
		return nextButton;
	}

	private Button createPrevButton() {
		Button prevButton = new Button("Prev");

		EventHandler<ActionEvent> prevButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				View.getStage().setScene(View.getDrawScene());
			}
		};

		prevButton.setOnAction(prevButtonAction);
		return prevButton;
	}

}
