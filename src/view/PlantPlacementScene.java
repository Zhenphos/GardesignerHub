package view;

import java.io.File;
import java.util.List;



import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import mvc.Controller;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mvc.View;
import objects.Plant;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class PlantPlacementScene extends Scene {
	static Group root = new Group();
	public Controller imc;
	public ImageView iv1;
	public ImageView iv2;
	public ImageView imageview[] = new ImageView [10];
	HBox imageBar = new HBox(10);
	private Pane center = new Pane();

	public Image images[] = new Image[10];
	public final double WIDTH = 1000; //800;
	public final double HEIGHT = 750; //600;
	//public final double buttonYPos = 740;
	public int numCopies = 0;

	public Pane getCenter() {
		return this.center;
	}
	
	public PlantPlacementScene() {
		super(root);
		
		//iv1 = new ImageView[10];
		iv1 = new ImageView();
		//iv2 = new ImageView();
		for(int i=0; i<10;i++) {
			
		}
		
		imc = new Controller(this);
		placePlant();
	}

	/**
	 * Creates the plant placement scene which allows the user to drag and drop
	 * plants onto the garden space they drew previously.
	 */
	public void placePlant() {
		Canvas drawCanvas = new Canvas(View.getCanvasWidth(), View.getCanvasHeight());
		GraphicsContext drawGC;
		root.getChildren().add(drawCanvas);
		drawGC = drawCanvas.getGraphicsContext2D();
		drawGC.clearRect(0, 0, View.getCanvasWidth(), View.getCanvasHeight());
				
		iv1.setPreserveRatio(true);
		iv1.setFitHeight(100);
		
		

		BorderPane border = new BorderPane();
		VBox top = new VBox(5);
		root.getChildren().add(border);
		
		BorderPane.setMargin(top, new Insets(50, 12.5, 50, 12.5));
		
		border.setTop(top);
		border.setCenter(center);
		Text scenetitle = new Text("Drag and Drop Plants");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		scenetitle.setTextAlignment(TextAlignment.CENTER);
		top.getChildren().add(scenetitle);
		top.setAlignment(Pos.CENTER);
		top.getChildren().add(imageBar);
		imageBar.minHeight(100);
		imageBar.minWidth(View.getCanvasWidth());
		imageBar.maxHeight(100);
		imageBar.setStyle("-fx-border-color: black");
		imageBar.setPadding(new Insets(50, 0, 50, 0));

		for (int i = 0,j=0; j < 20; j++) {
			i=j%10;
			System.out.println(i);
			images[i] = View.createImage("resources/plant"+Integer.toString((i+1))+".jpg");

			//images[i] = View.createImage("/Users/hamza/Developer/CSC275/team-11-2/resources/plant"+Integer.toString((i+1))+".jpg");
			imageview[i]= new ImageView();
			imageview[i].setImage(images[i]);
			imageview[i].setPreserveRatio(true);
			imageview[i].setFitHeight(100);
			imageBar.getChildren().addAll(imageview[i]);
			imageBar.getChildren().add(new Separator(Orientation.VERTICAL));
		}
		
	
		
		imageBar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("Mouse clicked");
				//View.getStage().setScene(View.getPlantInfoScene());
			}
		});
		
		imageBar.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("Mouse dragged");
				final ImageView iv = (ImageView) (event.getTarget());
				iv2 = new ImageView();
				iv2.setImage(iv.getImage());
				center.getChildren().add(iv2);
				//iv2.setImage(im1);
				iv2.setPreserveRatio(true);
				iv2.setFitHeight(100);
				iv2.setOnMouseDragged(imc.getHandlerForDrag());
				imc.ivs.add(iv2);
				StackPane sp = new StackPane(imc.ivs.get(numCopies));
				center.getChildren().add(sp);
				numCopies++;
			}
		});

		BorderPane.setMargin(center, new Insets(0, 12.5, 0, 12.5));
		center.setPadding(new Insets(View.getCanvasHeight() / 2.5, 50, 0, 0));
		
		center.setStyle("-fx-border-color: black");

		Button prevButton = createPrevButton();

		root.getChildren().add(prevButton);

		Button nextButton = createNextButton();

		root.getChildren().add(nextButton);

		// TODO replace with selecting plant from image
		Button choosePlantButton = createChoosePlantButton();

		root.getChildren().add(choosePlantButton);

		Button mainMenuButton = createMainMenuButton();

		root.getChildren().add(mainMenuButton);

		Button tutorialButton = createTutorialButton();

		root.getChildren().add(tutorialButton);

	}
	
	private Button createScrollLeftButton() {
		Button btn = new Button("<<<");
		btn.setTranslateX(View.getCanvasWidth()*1/20);
		btn.setTranslateY(View.getCanvasHeight()*1/10);
		
		EventHandler<ActionEvent> scrollLeftAction = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				//imageBar.getChildren().get(10).get
				
				
			}};
		return btn;
	}

	private Button createTutorialButton() {
		Button tutorialButton = new Button("Help");

		tutorialButton.setTranslateX(View.getCanvasWidth() * 1 / 3);
		tutorialButton.setTranslateY(View.getCanvasHeight() * 7 / 8);

		EventHandler<ActionEvent> tutorialButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				final Stage helpStage = new Stage();
				helpStage.initModality(Modality.APPLICATION_MODAL);
				//helpStage.setScene(View.getTutorialScene());
				helpStage.show();
			}
		};

		tutorialButton.setOnAction(tutorialButtonAction);
		return tutorialButton;
	}

	private Button createMainMenuButton() {
		Button mainMenuButton = new Button("Main Menu");

		mainMenuButton.setTranslateX(View.getCanvasWidth() * 2 / 3);
		mainMenuButton.setTranslateY(View.getCanvasHeight() * 7 / 8);

		EventHandler<ActionEvent> mainMenuButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				//View.getStage().setScene(View.getMainMenuScene());
			}
		};

		mainMenuButton.setOnAction(mainMenuButtonAction);
		return mainMenuButton;
	}

	private Button createChoosePlantButton() {
		Button choosePlantButton = new Button("Choose a Plant");

		choosePlantButton.setTranslateX(View.getCanvasWidth() / 2 - 20);
		choosePlantButton.setTranslateY(230);

		EventHandler<ActionEvent> plantButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				final Stage pInfoStage = new Stage();
				pInfoStage.initModality(Modality.APPLICATION_MODAL);
				//pInfoStage.setScene(View.getPlantInfoScene());
				pInfoStage.show();
			}
		};

		choosePlantButton.setOnAction(plantButtonAction);
		return choosePlantButton;
	}

	private Button createNextButton() {
		Button nextButton = new Button("Next");
		nextButton.setTranslateX(View.getCanvasWidth() * 7 / 8);
		nextButton.setTranslateY(View.getCanvasHeight() * 7 / 8);

		EventHandler<ActionEvent> nextButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				//View.getStage().setScene(View.getTimesScene());
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
				//View.getStage().setScene(View.getDrawScene());
			}
		};

		prevButton.setOnAction(prevButtonAction);
		return prevButton;
	}
	
    public void setX(double x) {
    	iv2.setTranslateX(iv1.getLayoutX() + WIDTH / 2 + x);
    }
    
    public void setY(double y) {
    	iv2.setTranslateY(iv1.getLayoutY() + HEIGHT / 2 + y);
    }
    
    // experimental
    public ImageView makeCopy(ImageView iv) {
    	ImageView newImageView = iv;
    	imc.ivs.add(newImageView);
    	return newImageView;
    }

}
