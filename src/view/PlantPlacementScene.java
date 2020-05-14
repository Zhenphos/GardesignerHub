package view;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import mvc.Controller;
import mvc.View;
import objects.Plant;

/**
 * PlantPlacementScene class for Gardendesigner Hub
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class PlantPlacementScene extends Scene {
	private static final int VBOX_MIN_WIDTH = View.getCanvasWidth()-20;
	private static final int MIN_HEIGHT = 300;
	public static final String TEXT_LABEL_STYLE = "-fx-font: 14 arial;";

	static Group root = new Group();
	public Controller imc;
	public ImageView imageView01;
	public ImageView iv2;
	public ImageView imageview[] = new ImageView [10];
	public ImageView plantClicked;
	int indexOfPlant=0;
	ArrayList <ImageView> plantImages = Controller.importImages();
	ListView<Plant> plantListView = new ListView<Plant>();

	//public TilePane center = new TilePane();

	HBox imageBar = new HBox(10);
	private Pane gardenPane = new Pane();

	//HBox imageBar = new HBox(10);
	//AnchorPane center = new AnchorPane();
	
	public Image images[] = new Image[10];
	public final double WIDTH = 1000; //800;
	public final double HEIGHT = 750; //600;
	//public final double buttonYPos = 740;
	public int numCopies = 0;
	private Button btnPrev, btnNext;

	/**
	 * Gets the pane the garden is displayed in
	 * 
	 * @return the pane the garden is displayed in
	 */
	public Pane getGardenPane() {
		return this.gardenPane;
	}
	
	/**
	 * Constructor for PlantPlacementScene. Creates buttons and prepares the
	 * Controller to receive user inputs in this scene.
	 */
	public PlantPlacementScene() {
		super(root);
		this.btnNext = this.createButton(View.NEXT_BUTTON_TEXT);
		this.btnNext.setMaxWidth(Double.MAX_VALUE);
		this.btnPrev = this.createButton(View.PREV_BUTTON_TEXT);
		this.btnPrev.setMaxWidth(Double.MAX_VALUE);
		
		imageView01 = new ImageView();
		
		imc = new Controller(this);
		placePlant();
	}

	/**
	 * Creates the plant placement scene which allows the user to drag and drop
	 * plants onto the garden space they drew previously
	 */
	public void placePlant() {
		Canvas drawCanvas = new Canvas(View.getCanvasWidth(), View.getCanvasHeight());
		GraphicsContext drawGC;
		root.getChildren().add(drawCanvas);
		drawGC = drawCanvas.getGraphicsContext2D();
		drawGC.clearRect(0, 0, View.getCanvasWidth(), View.getCanvasHeight());
				
		imageView01.setPreserveRatio(true);
		imageView01.setFitHeight(100);

		BorderPane Pane = new BorderPane();
		HBox leftVbox = new HBox(5);
		VBox rightPane = new VBox(5);
		
		gardenPane.setPrefHeight(View.getCanvasHeight() * 3/5);
		gardenPane.setPrefWidth(View.getCanvasWidth() * (3/4)-20);
		gardenPane.setStyle("-fx-border-color: black");
		Pane.setMargin(gardenPane, new Insets(10,10,10,10));
		leftVbox.setMinSize(View.getCanvasWidth()-20, 150);
		
		root.getChildren().add(Pane);
		
		BorderPane.setMargin(leftVbox, new Insets(10, 10, 10, 10));
		//borderPane.setMinHeight(500);
		
		Pane.setTop(leftVbox);
		Pane.setLeft(rightPane);
		Pane.setCenter(gardenPane);
		
		GridPane grid = new GridPane();
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(10, 0, 0, 10));
	    rightPane.getChildren().add(grid);
	    rightPane.setMaxWidth(250);
	    rightPane.setMinWidth(250);
	    rightPane.setStyle("-fx-border-color: black");
	    VBox.setMargin(rightPane, new Insets(10,10,10,10));
	    GridPane.setHgrow(grid, Priority.NEVER);
		//border.setCenter(center);
		Text scenetitle = new Text("Please Choose Some Plants");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		scenetitle.setTextAlignment(TextAlignment.CENTER);
		//leftVbox.getChildren().add(scenetitle);
		leftVbox.setAlignment(Pos.CENTER);
		btnNext = createNextButton();
		btnPrev = createPrevButton();
		root.getChildren().addAll(btnPrev, btnNext);
		
		// testing plant import in here
		ArrayList<Plant> allPlants = Controller.importPlants();
		System.out.print(allPlants.size());
	
		plantListView.setMinWidth(View.getCanvasWidth()-20);
		plantListView.setMaxHeight(150);
		
		HBox.setHgrow(plantListView, Priority.NEVER);
		plantListView.setOrientation(Orientation.HORIZONTAL);
	    ObservableList<Plant> rawData = FXCollections.observableArrayList(allPlants);

	    FilteredList<Plant> filteredList= new FilteredList<>(rawData, data -> true);
	    // counter for lambda iterations
	    AtomicInteger runCount= new AtomicInteger(0);
		plantListView.setCellFactory(param -> new ListCell<Plant>() {
			private ImageView imageview = new ImageView();

			@Override
			public void updateItem(Plant plant, boolean empty) {
				super.updateItem(plant, empty);
				if (empty) {
					setText("empty");
					setGraphic(null);
				} else {

					if (runCount.get() >= plantImages.size()) {
						runCount.set(0);
					}

					imageview.setImage(plantImages.get(runCount.get()).getImage());
					// imageview.setImage(plantImages.get(allPlants.indexOf(param)).getImage());
					imageview.maxWidth(70);
					imageview.minWidth(70);
					imageview.maxHeight(70);
					imageview.minHeight(70);
					setText(allPlants.get(runCount.get()).toString());
					imageview.setFitHeight(100);
					imageview.isPreserveRatio();
					setGraphic(imageview);
					runCount.getAndIncrement();
				}
			}

		});
	    TextField searchBox = new TextField();
	    
	    // need to use textfield with filtered list
	  
	    Label label = new Label();
	    leftVbox.getChildren().addAll(plantListView, label);
        plantListView.setItems(filteredList);
    
	    //topVbox.getChildren().addAll(imageListView);
	    label.setLayoutX(10);
        label.setLayoutY(115);
	    //label.setLayoutY(300);
        label.setFont(Font.font("Verdana", 20));
       
        // Display plant information in the right pane
        
		Label name = createLabel("Name: ");
		grid.add(name, 0, 0);

		Label maxHeight = createLabel("Maximum Height: ");
		grid.add(maxHeight, 0, 1);

		Label maxSpacing = createLabel("Maximum Spacing: ");
		grid.add(maxSpacing, 0, 2);

		Label hardiness = createLabel("Hardiness Required: ");
		grid.add(hardiness, 0, 3);

		Label colors = createLabel("Bloom Colors: ");
		grid.add(colors, 0, 4);

		Label error = createLabel("");
		rightPane.getChildren().add(error);
		error.setMaxWidth(300);
		error.setWrapText(true);

		Label nameValue = createLabel("");
		Label heightValue = createLabel("");
		Label spacingValue = createLabel("");
		Label hardinessValue = createLabel("");
		Label colorsValue = createLabel("");
		nameValue.setMaxWidth(100);
		nameValue.setWrapText(true);
		grid.add(nameValue, 1, 0);
		grid.add(heightValue, 1, 1);
		grid.add(spacingValue, 1, 2);
		grid.add(hardinessValue, 1, 3);
		grid.add(colorsValue, 1, 4);

        
		plantListView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				try {
					error.setText(" ");
					System.out.println("Mouse clicked");
					// Text temp = null;
					Text plantlabel = (Text) (event.getTarget());
					error.setText(" ");
					System.out.println(event.getTarget());
					Optional<Plant> plant = allPlants.stream().filter(p -> p.toString().equals(plantlabel.getText()))
							.findAny();
					error.setText(" ");
					Plant p = plant.get();
					System.out.println(allPlants.indexOf(p));
					indexOfPlant = allPlants.indexOf(p);
					nameValue.setText(p.getPlantBotanicalName());
					if (p.getHeightMaxInches() == -1)
						heightValue.setText("No Data");
					else
						heightValue.setText(Integer.toString(p.getHeightMaxInches()));

					if (p.getSpacingMax() == -1)
						spacingValue.setText("No Data");
					else
						spacingValue.setText(Integer.toString(p.getSpacingMax()));

					if (p.getHardinessMin() == -1)
						hardinessValue.setText("No Data");
					else
						hardinessValue.setText(Integer.toString(p.getHardinessMin()));
					;
					colorsValue.setText(p.getBloomColors());
					event.consume();
				} catch (NullPointerException e) {
					error.setText("No Data found for this plant");

				} catch (ClassCastException e) {
					error.setText("Please click on plant's name instead of picture");
					System.out.println(event.getTarget().toString());

				}
			}
		});
	}
	
	/**
	 * Creates a plant label
	 * 
	 * @param text the label text
	 * @return the plant label
	 */
	private Label createLabel(String text) {
		Label label = new Label(text);
		label.setStyle(this.TEXT_LABEL_STYLE);
		return label;
	}

	/*
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
	*/

	/**
	 * Creates the next button
	 * 
	 * @return the next button
	 */
	private Button createNextButton() {
		Button nextButton = new Button("Next");
		nextButton.setTranslateX(View.getCanvasWidth() * 7 / 8);
		nextButton.setTranslateY(View.getCanvasHeight() * 7 / 8);
		return nextButton;
	}

	/**
	 * Creates the prev button
	 * 
	 * @return the prev button
	 */
	private Button createPrevButton() {
		Button prevButton = new Button("Prev");
		prevButton.setTranslateX(View.getCanvasWidth() * 1 / 8);
		prevButton.setTranslateY(View.getCanvasHeight() * 7 / 8);
		return prevButton;
	}
	
	/**
	 * Updates the x-coordinate of the dragged ImageView
	 * 
	 * @param x the x-value the mouse has dragged the image
	 */
    public void setX(double x) {
    	iv2.setTranslateX(imageView01.getLayoutX() + WIDTH / 2 + x);
    }
    
    /**
	 * Updates the y-coordinate of the dragged ImageView
	 * 
	 * @param y the y-value the mouse has dragged the image
	 */
    public void setY(double y) {
    	iv2.setTranslateY(imageView01.getLayoutY() + HEIGHT / 2 + y);
    }
    
    /**
     * Creates a button
     * 
     * @param text the text displayed on the button
     * @return the created button
     */
    private Button createButton(String text) {
		Button btn = new Button(text);
		btn.setStyle(View.BUTTON_STYLE);
		return btn;
	}
    
    /**
     * Gets the next button
     * 
     * @return the next button
     */
    public Button getNextButton() {
		return this.btnNext;
	}

    /**
     * Gets the prev button
     * 
     * @return the prev button
     */
	public Button getPrevButton() {
		return this.btnPrev;
	}
	
	/**
	 * Gets the plant that was clicked
	 * 
	 * @return the ImageView of the plant that was clicked
	 */
	public ImageView getPlantClicked() {
		return plantImages.get(indexOfPlant);
		
	}
	
	/**
	 * Gets the plantListView
	 * 
	 * @return the plantListView
	 */
	public ListView<Plant> getPlantListView() {
		return this.plantListView;
	}
}
