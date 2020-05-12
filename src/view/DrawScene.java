package view;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
	static Group drawGardenGroup = new Group();
	private BorderPane border;
	AnchorPane center;
	private Controller controller;
	private Button grassButton;
	private Button roadButton;
	private Button streamButton;
	private Button woodsButton;
	private Button shadeButton;
	private Button deleteButton;

	public DrawScene() {
		super(drawGardenGroup);
		createDraw();
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
		
		border.setMargin(center, new Insets(View.lGap));
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

		center.setPrefHeight(View.getCanvasHeight() * 3/5);
		center.setPrefWidth(View.getCanvasWidth() * 3/4);
		BackgroundFill background_fill = new BackgroundFill(null, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(background_fill);
		center.setBackground(background);
		center.setStyle("-fx-border-color: black");

		Image drawBackground;
		drawBackground = View.createImage("resources/drawImage.png");
		//drawGC.drawImage(drawBackground, 0, 0, View.getCanvasWidth(),
		// View.getCanvasHeight());

		Button prevButton = createPrevButton();

		drawGardenGroup.getChildren().add(prevButton);

		Button nextButton = createNextButton();

		drawGardenGroup.getChildren().add(nextButton);

		Button mainMenuButton = View.createMainMenuButton();

		drawGardenGroup.getChildren().add(mainMenuButton);

		Button tutorialButton = View.createTutorialButton();

		drawGardenGroup.getChildren().add(tutorialButton);

	}

	private Button createNextButton() {
		Button nextButton = new Button("Next");

		nextButton.setTranslateX(View.getCanvasWidth() * 7 / 8);
		nextButton.setTranslateY(View.getCanvasHeight() * 7 / 8);

		EventHandler<ActionEvent> nextButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				View.getStage().setScene(View.getPlantPlacementScene());
			}
		};

		nextButton.setOnAction(nextButtonAction);
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
	
	public EventHandler<ActionEvent> createButtonAction(GardenObject object) {
		return new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Polygon polygon = object.getShape().getPolygon();
				center.getChildren().add(polygon);
				controller.addGardenObject(object);
				final ObjectProperty<Point2D> mousePosition = new SimpleObjectProperty<>();
				polygon.setOnMousePressed(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						mousePosition.set(new Point2D(event.getSceneX(), event.getSceneY()));
				    }
				});
				polygon.setOnMouseDragged(new EventHandler<MouseEvent>() {
			        @Override
			        public void handle(MouseEvent event) {
			            double changeX = event.getSceneX() - mousePosition.get().getX();
			            double changeY = event.getSceneY() - mousePosition.get().getY();
			            
			            if (polygon.getLayoutX() < 0) {
			            	polygon.setLayoutX(0);
			            } else { 
				        	polygon.setLayoutX(polygon.getLayoutX() + changeX);
			            }
			            
			            if (polygon.getLayoutY() < 0) {
			            	polygon.setLayoutY(0);
			            } else {
				            polygon.setLayoutY(polygon.getLayoutY() + changeY);
			            }
			            mousePosition.set(new Point2D(event.getSceneX(), event.getSceneY()));
			        }
			    });
			}
		};
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
		
		this.grassButton.setOnAction(createButtonAction(new Grass()));

		this.roadButton.setOnAction(createButtonAction(new Road()));

		this.streamButton.setOnAction(createButtonAction(new Stream()));
		
		this.woodsButton.setOnAction(createButtonAction(new Woods()));

		this.shadeButton.setOnAction(createButtonAction(new Shade()));
		
		EventHandler<ActionEvent> deleteButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
			}
		};
		this.deleteButton.setOnAction(deleteButtonAction);
	}
}
