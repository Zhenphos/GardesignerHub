package mvc;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class MovingImageView extends Application {

	private Controller imc;
	private ImageView iv1;
	private final double WIDTH = 800;
	private final double HEIGHT = 600;
	
	public MovingImageView(){
    	iv1 = new ImageView();
		imc = new Controller(this);
	}
		
    @Override
    public void start(Stage stage) {
 
    	Image im1 = new Image(getClass().getResourceAsStream("/img/commonMilkweed.png"));
    	iv1.setImage(im1);
    	iv1.setPreserveRatio(true);
    	iv1.setFitHeight(100);
    	iv1.setOnMouseDragged(imc.getHandlerForDrag());
    	//iv1.setOnMouseDragReleased(imc.getHandlerForRelease());

    	//StackPane stackPane = new StackPane(iv1);
    	BorderPane borderPane = new BorderPane(iv1);
    	TilePane tilePane = new TilePane();
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
    	
    	borderPane.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: black;");
    	
    	Scene scene = new Scene(borderPane, WIDTH, HEIGHT);
    	
        stage.setScene(scene);
        
		iv1.setTranslateX(iv1.getLayoutX() - WIDTH/2 + imc.getStartingX());
		iv1.setTranslateY(iv1.getLayoutY() - HEIGHT/2 + imc.getStartingY());

        stage.show();
    }
    public void setX(double x) {
    	iv1.setTranslateX(iv1.getLayoutX() - WIDTH/2 + x);
    }
    public void setY(double y) {
    	iv1.setTranslateY(iv1.getLayoutY() - HEIGHT/2 + y);
    }
    public static void main(String[] args) {
        launch();
    }
    public ImageView makeCopy() {
    	ImageView iv2 = iv1;
    	return iv2;
    }

}