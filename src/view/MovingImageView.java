package view;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import mvc.Controller;
import mvc.View;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class MovingImageView extends Scene {

	static Group root = new Group();
	public Controller imc;
	public ImageView iv1;
	public final double WIDTH = 1000; //800;
	public final double HEIGHT = 750; //600;
	
	public MovingImageView(){
		super(root);
		iv1 = new ImageView();
		//imc = new Controller(this);
    	movePlants();
	}
	
	public void movePlants() {
		Canvas canvas = new Canvas(WIDTH, HEIGHT);
		GraphicsContext gc;
		root.getChildren().add(canvas);
		gc = canvas.getGraphicsContext2D();
		gc.clearRect(0, 0, View.getCanvasWidth(), View.getCanvasHeight());
		
		Image im1 = new Image(getClass().getClassLoader().getResourceAsStream("resources/commonMilkweed.png"));
    	//Image im1 = new Image(getClass().getResourceAsStream("resources/commonMilkweed.png"));
    	iv1.setImage(im1);
    	iv1.setPreserveRatio(true);
    	iv1.setFitHeight(100);
    	iv1.setOnMouseDragged(imc.getHandlerForDrag());
    	//iv1.setOnMouseDragReleased(imc.getHandlerForRelease());

    	StackPane stackPane = new StackPane(iv1);
    	//BorderPane borderPane = new BorderPane(iv1);
    	/*TilePane tilePane = new TilePane();
    	FlowPane flowPane = new FlowPane();
        
    	tilePane.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: red;");
    	
    	flowPane.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
    	
    	//borderPane.setTop(tilePane);
    	//borderPane.setCenter(flowPane);
    	
    	stackPane.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: black;");*/
    	
    	//scene = new Scene(borderPane, WIDTH, HEIGHT);
    	root.getChildren().add(stackPane);
    	
        //stage.setScene(scene);
        
		//iv1.setTranslateX(iv1.getLayoutX() - WIDTH/2 + imc.getStartingX());
		//iv1.setTranslateY(iv1.getLayoutY() - HEIGHT/2 + imc.getStartingY());
    	iv1.setTranslateX(100);
    	iv1.setTranslateY(100);

        //stage.show();
    }
	
    public void setX(double x) {
    	//iv1.setTranslateX(iv1.getLayoutX() - WIDTH/2 + x);
    	iv1.setTranslateX(iv1.getLayoutX() + WIDTH / 2 + x);
    }
    
    public void setY(double y) {
    	//iv1.setTranslateY(iv1.getLayoutY() - HEIGHT/2 + y);
    	iv1.setTranslateY(iv1.getLayoutY() + HEIGHT / 2 + y);
    }
    
    public ImageView makeCopy() {
    	ImageView iv2 = iv1;
    	return iv2;
    }

}