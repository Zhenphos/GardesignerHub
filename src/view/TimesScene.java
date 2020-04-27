package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import mvc.Controller;
import mvc.View;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class TimesScene extends Scene {

	private static Group root = new Group();
	
	private BorderPane border;
	
	public TimesScene() {
		super(root);
		createTimes();
		
	}
	
	public void createTimes() {
		Canvas canvas = new Canvas(View.getCanvasWidth(), View.getCanvasHeight());
		GraphicsContext gc;
		root.getChildren().add(canvas);
		gc = canvas.getGraphicsContext2D();
		gc.clearRect(0, 0, View.getCanvasWidth(), View.getCanvasHeight());
		
		border = new BorderPane();
		border.setPadding(new Insets(10));
		
		final ToggleGroup tGroup = new ToggleGroup();
		
		HBox top = new HBox();
		Text title = new Text("Time Visualization");
		title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
		title.setTextAlignment(TextAlignment.CENTER);
		top.getChildren().add(title); 
		top.setAlignment(Pos.CENTER);
		
		border.setTop(top);
		
		
		RadioButton rb1 = new RadioButton("Spring");
		rb1.setToggleGroup(tGroup);
		rb1.setSelected(true);
		RadioButton rb2 = new RadioButton("Summer");	
		rb2.setToggleGroup(tGroup);
		RadioButton rb3 = new RadioButton("Autumn");
		rb3.setToggleGroup(tGroup);
		RadioButton rb4 = new RadioButton("Winter");
		rb4.setToggleGroup(tGroup);
		
		final Label years = new Label("Years");
		Slider slider = new Slider(0, 3, 1);
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		slider.setMajorTickUnit(1);
		
		VBox radioBox = new VBox(rb1, rb2, rb3, rb4);
		radioBox.setAlignment(Pos.CENTER);
		
		VBox sliderBox = new VBox(years, slider);
		sliderBox.setAlignment(Pos.CENTER);
		
		HBox bottom = new HBox(sliderBox, radioBox);
		bottom.setPadding(new Insets(10));
		bottom.setSpacing(300);
		bottom.setAlignment(Pos.CENTER);
        bottom.setStyle("-fx-border-color: black");
        
		border.setBottom(bottom);
		
		AnchorPane center = new AnchorPane();
		
		center.setPadding(new Insets(200, 410, 200, 410));
		BackgroundFill background_fill = new BackgroundFill(Color.FORESTGREEN, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        center.setBackground(background);
		center.setStyle("-fx-border-color: black");
		

	    BorderPane.setMargin(center, new Insets(50, 75, 50, 75));

	    
		border.setCenter(center);
				
		root.getChildren().add(border);
		
		Button prevButton = new Button("prev");
		root.getChildren().add(prevButton);
		prevButton.setTranslateX(View.getCanvasWidth() / 2 - View.getCanvasWidth() * 3/8);
		prevButton.setTranslateY(View.getCanvasHeight() - 50);

		EventHandler<ActionEvent> prevButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				View.getStage().setScene(View.getPlantPlacementScene());
			}
		};

		prevButton.setOnAction(prevButtonAction);
		
		Button nextButton = new Button("next");
		root.getChildren().add(nextButton);
		nextButton.setTranslateX(View.getCanvasWidth() / 2 + View.getCanvasWidth() * 3/8);
		nextButton.setTranslateY(View.getCanvasHeight() - 50);

		EventHandler<ActionEvent> nextButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				//View.getStage().setScene(View.getRatingsScreen());
			}
		};

		nextButton.setOnAction(nextButtonAction);
		
	}

}
