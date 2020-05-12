package view;

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
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mvc.Controller;
import mvc.View;
import objects.Grass;
import objects.Road;
import objects.Shade;
import objects.Stream;
import objects.Woods;

/**
 *
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class DrawScene extends Scene {
	static Group drawGardenGroup = new Group();

	private BorderPane border;
	private AnchorPane center;
	private Button grassButton;
	private Button roadButton;
	private Button streamButton;
	private Button woodsButton;
	private Button shadeButton;
	private Button deleteButton;
	private Button btnPrev, btnNext;

	public DrawScene() {
		super(drawGardenGroup);
		createDraw();
	}

	public AnchorPane getCenter() {
		return this.center;
	}

	public Button getGrassButton() {
		return this.grassButton;
	}

	public Button getRoadbutton() {
		return this.roadButton;
	}

	public Button getStreamButton() {
		return this.streamButton;
	}

	public Button getWoodsButton() {
		return this.woodsButton;
	}

	public Button getShadeButton() {
		return this.shadeButton;
	}

	public Button getDeleteButton() {
		return this.deleteButton;
	}

	public Button getPrevButton() {
		return this.btnPrev;
	}

	public Button getNextButton() {
		return this.btnNext;
	}

	/**
	 * Creates the draw scene which allows the user to draw their garden space.
	 */
	public void createDraw() {
		Canvas drawCanvas = new Canvas(View.getCanvasWidth(), View.getCanvasHeight());
		GraphicsContext drawGC;
		drawGardenGroup.getChildren().add(drawCanvas);
		drawGC = drawCanvas.getGraphicsContext2D();
		drawGC.clearRect(0, 0, View.getCanvasWidth(), View.getCanvasHeight());

		border = new BorderPane();
		FlowPane left = new FlowPane();
		HBox top = new HBox();
		center = new AnchorPane();
		drawGardenGroup.getChildren().add(border);
		border.setTop(top);
		border.setLeft(left);
		border.setCenter(center);

		Text scenetitle = new Text("\t\t\t\tDraw Garden");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		scenetitle.setTextAlignment(TextAlignment.CENTER);
		top.getChildren().add(scenetitle);
		top.setAlignment(Pos.CENTER);

		Label grass = new Label("Grass \t\t");
		Label road = new Label("Road \t\t");
		Label stream = new Label("Stream \t\t");
		Label woods = new Label("Woods \t\t");
		Label shade = new Label("Shade \t\t");
		Label delete = new Label("Delete \t \t");

		grassButton = new Button("Grass");
		roadButton = new Button("Road");
		streamButton = new Button("Stream");
		woodsButton = new Button("Woods");
		shadeButton = new Button("Shade");
		deleteButton = new Button("Delete");

		HBox grassBox = new HBox(grass, grassButton);
		HBox roadBox = new HBox(road, roadButton);
		HBox streamBox = new HBox(stream, streamButton);
		HBox woodsBox = new HBox(woods, woodsButton);
		HBox shadeBox = new HBox(shade, shadeButton);
		HBox deleteBox = new HBox(delete, deleteButton);

		GridPane items = new GridPane();

		items.add(grassBox, 0, 0);
		items.add(roadBox, 0, 1);
		items.add(streamBox, 0, 2);
		items.add(woodsBox, 0, 3);
		items.add(shadeBox, 0, 4);
		items.add(deleteBox, 0, 5);
		items.setVgap(View.sGap);
		items.setHgap(View.mGap);

		left.setPadding(new Insets(View.lGap)); // (top, right, bottom, left)
		left.setStyle("-fx-border-color: black");
		left.setVgap(4);
		left.setHgap(4);
		left.setPrefWrapLength(150);
		BorderPane.setMargin(left, new Insets(100, View.lGap, View.lGap, View.lGap));
		left.getChildren().add(items);

		center.setPadding(new Insets(150, 300, 150, 300));
		BackgroundFill background_fill = new BackgroundFill(null, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(background_fill);
		center.setBackground(background);
		center.setStyle("-fx-border-color: black");

		BorderPane.setMargin(center, new Insets(100, 0, 0, 100));

		Image drawBackground;
		drawBackground = View.createImage("resources/drawImage.png");
		//drawGC.drawImage(drawBackground, 0, 0, View.getCanvasWidth(),
		// View.getCanvasHeight());

		btnPrev = createPrevButton();

		drawGardenGroup.getChildren().add(btnPrev);

		btnNext = createNextButton();

		drawGardenGroup.getChildren().add(btnNext);

		//Button mainMenuButton = View.createMainMenuButton();

		//drawGardenGroup.getChildren().add(mainMenuButton);

		//Button tutorialButton = View.createTutorialButton();

		//drawGardenGroup.getChildren().add(tutorialButton);

	}

	private Button createNextButton() {
		Button nextButton = new Button("Next");

		nextButton.setTranslateX(View.getCanvasWidth() * 7 / 8);
		nextButton.setTranslateY(View.getCanvasHeight() * 7 / 8);

		/*EventHandler<ActionEvent> nextButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				View.getStage().setScene(View.getPlantPlacementScene());
			}
		};*/

		//nextButton.setOnAction(nextButtonAction);
		return nextButton;
	}

	private Button createPrevButton() {
		Button prevButton = new Button("Prev");

		prevButton.setTranslateX(View.getCanvasWidth() * 1 / 8);
		prevButton.setTranslateY(View.getCanvasHeight() * 7 / 8);

		EventHandler<ActionEvent> prevButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				//View.getStage().setScene(View.getMainMenuScene());
			}
		};

		prevButton.setOnAction(prevButtonAction);
		return prevButton;
	}
}
