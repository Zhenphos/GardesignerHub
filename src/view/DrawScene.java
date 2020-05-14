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

}
