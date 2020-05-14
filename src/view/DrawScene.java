package view;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import mvc.Controller;
import mvc.View;
import objects.GardenObject;
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

	private static final String HEADER_TEXT = "Draw Garden";
	private static final String GRASS_TEXT = "Grass";
	private static final String ROAD_TEXT = "Road";
	private static final String STREAM_TEXT = "Stream";
	private static final String WOODS_TEXT = "Woods";
	private static final String SHADE_TEXT = "Shade";
	private static final String DELETE_TEXT = "Delete";

	private static final Image GRASS_IMAGE = View.createImage("resources/grass.png");
	private static final Image ROAD_IMAGE = View.createImage("resources/road.png");
	private static final Image STREAM_IMAGE = View.createImage("resources/stream.png");
	private static final Image WOODS_IMAGE = View.createImage("resources/forest.png");
	private static final Image SHADE_IMAGE = View.createImage("resources/shade.png");
	private static final Image DELETE_IMAGE = View.createImage("resources/delete.png");

	private static final String GARDEN_PANE_STYLE = "-fx-border-color: black;";

	private BorderPane container;
	private Label lblHeader;
	private Pane gardenPane;
	private Button grassButton, roadButton, streamButton, woodsButton, shadeButton, deleteButton, btnPrev, btnNext;

	public DrawScene() {
		super(new BorderPane());
		this.container = (BorderPane) this.getRoot();
		this.container.setMinSize(View.WIDTH, View.HEIGHT);

		this.lblHeader = new Label(HEADER_TEXT);
		this.lblHeader.setStyle(View.HEADER_LABEL_STYLE);
		this.lblHeader.setAlignment(Pos.CENTER);
		this.lblHeader.setMaxWidth(Double.MAX_VALUE);
		this.container.setTop(this.lblHeader);

		this.gardenPane = new Pane();
		this.gardenPane.setStyle(GARDEN_PANE_STYLE);

		VBox tools = new VBox();
		tools.setAlignment(Pos.CENTER);
		this.grassButton = this.createButton(tools, GRASS_TEXT, GRASS_IMAGE);
		this.roadButton = this.createButton(tools, ROAD_TEXT, ROAD_IMAGE);
		this.streamButton = this.createButton(tools, STREAM_TEXT, STREAM_IMAGE);
		this.woodsButton = this.createButton(tools, WOODS_TEXT, WOODS_IMAGE);
		this.shadeButton = this.createButton(tools, SHADE_TEXT, SHADE_IMAGE);
		this.deleteButton = this.createButton(tools, DELETE_TEXT, DELETE_IMAGE);

		HBox center = new HBox(tools, this.gardenPane);
		center.setBackground(View.BACKGROUND);
		HBox.setHgrow(this.gardenPane, Priority.ALWAYS);
		this.container.setCenter(center);

		this.btnPrev = new Button(View.PREV_BUTTON_TEXT);
		this.btnPrev.setStyle(View.BUTTON_STYLE);
		this.btnPrev.setMaxWidth(Double.MAX_VALUE);
		this.btnNext = new Button(View.NEXT_BUTTON_TEXT);
		this.btnNext.setStyle(View.BUTTON_STYLE);
		this.btnNext.setMaxWidth(Double.MAX_VALUE);
		HBox bottom = new HBox(this.btnPrev, this.btnNext);
		HBox.setHgrow(this.btnPrev, Priority.ALWAYS);
		HBox.setHgrow(this.btnNext, Priority.ALWAYS);
		this.container.setBottom(bottom);
	}

	private Button createButton(Pane pane, String text, Image image) {
		Button button = new Button(text);
		button.setMaxWidth(Double.MAX_VALUE);
		ImageView view = new ImageView(image);
		view.setPreserveRatio(true);
		view.setFitHeight(View.HEIGHT / 10f);
		VBox box = new VBox(button, view);
		box.setAlignment(Pos.CENTER);
		pane.getChildren().add(box);
		return button;
	}

	public Pane getGardenPane() {
		return this.gardenPane;
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

<<<<<<< HEAD
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
		gardenPane = new Pane();
		drawGardenGroup.getChildren().add(border);
		border.setTop(top);
		border.setLeft(left);
		border.setCenter(gardenPane);
		
		border.setMargin(gardenPane, new Insets(View.lGap));
		border.setMargin(left, new Insets(0, 0, 0, View.lGap));

		Text scenetitle = new Text("\t\t\t\tDraw Garden");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		scenetitle.setTextAlignment(TextAlignment.CENTER);
		top.getChildren().add(scenetitle);
		top.setAlignment(Pos.CENTER);
		top.setPrefHeight(100);

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
		left.setVgap(View.lGap);
		left.setHgap(View.sGap);
		left.setPrefWrapLength(150);
		left.getChildren().add(items);
		left.setPrefHeight(View.getCanvasHeight() * 3/5);

		gardenPane.setPrefHeight(View.getCanvasHeight() * 3/5);
		gardenPane.setPrefWidth(View.getCanvasWidth() * 3/4);
		gardenPane.setStyle("-fx-border-color: black");

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
				//View.getStage().setScene(View.getMainMenuScene());
			}
		};

		prevButton.setOnAction(prevButtonAction);
		return prevButton;
	}
=======
>>>>>>> master
}
