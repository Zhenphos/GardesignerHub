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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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

public class DrawScene extends Scene {
	static Group drawGroup = new Group();

	public DrawScene() {
		super(drawGroup);
		createDraw();
	}

	/**
	 * Creates the draw scene which allows the user to draw their garden space.
	 */
	public void createDraw() {
		Canvas drawCanvas = new Canvas(View.getCanvasWidth(), View.getCanvasHeight());
		GraphicsContext drawGC;
		drawGroup.getChildren().add(drawCanvas);
		drawGC = drawCanvas.getGraphicsContext2D();
		drawGC.clearRect(0, 0, View.getCanvasWidth(), View.getCanvasHeight());
		
		BorderPane border = new BorderPane();
		FlowPane left = new FlowPane();
		HBox top = new HBox();
		AnchorPane center = new AnchorPane();
		drawGroup.getChildren().add(border);
		border.setTop(top);
		border.setLeft(left);
		border.setCenter(center);
		
		Text scenetitle = new Text("\t\t\t\tDraw Garden");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		scenetitle.setTextAlignment(TextAlignment.CENTER);
		top.getChildren().add(scenetitle); 
		top.setAlignment(Pos.CENTER);
		

		Label plant = new Label("Plant \t {Plant Image}") ;
		Label road = new Label("road \t {Road Image}");
		Label stream = new Label("Stream \t {Stream Image}");
		Label shade = new Label("Shade \t {Label Image}");
		Label object = new Label("Object \t {Object Image}");
		
	    left.setPadding(new Insets(25, 25, 25, 25)); //(top, right. bottom, left)
	    left.setStyle("-fx-border-color: black");
	    left.setVgap(4);
	    left.setHgap(4);
	    left.setPrefWrapLength(150);
	    BorderPane.setMargin(left, new Insets(100,25,25,25));
		left.getChildren().addAll(plant, road, stream, shade, object);
		
		
		center.setPadding(new Insets(150,450, 150, 150));
		BackgroundFill background_fill = new BackgroundFill(Color.FORESTGREEN, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        center.setBackground(background);
		center.setStyle("-fx-border-color: black");

	    BorderPane.setMargin(center, new Insets(100,0,0,100));

		Image drawBackground;
		drawBackground = View.createImage("resources/drawImage.png");
		//drawGC.drawImage(drawBackground, 0, 0, View.getCanvasWidth(), View.getCanvasHeight());
		
		Button prevButton = new Button("prev");
		drawGroup.getChildren().add(prevButton);
		prevButton.setTranslateX(View.getCanvasWidth() / 2 - View.getCanvasWidth() / 4);
		prevButton.setTranslateY(600);

		EventHandler<ActionEvent> prevButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				View.getStage().setScene(View.getMainMenuScene());
			}
		};

		prevButton.setOnAction(prevButtonAction);
		
		Button nextButton = new Button("next");
		drawGroup.getChildren().add(nextButton);
		nextButton.setTranslateX(View.getCanvasWidth() / 2 + View.getCanvasWidth() / 4);
		nextButton.setTranslateY(600);

		EventHandler<ActionEvent> nextButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				View.getStage().setScene(View.getPlantPlacementScene());
			}
		};

		nextButton.setOnAction(nextButtonAction);
		
	}
}
