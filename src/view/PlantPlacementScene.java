package view;
import java.io.File;
import java.util.ArrayList;

import enums.PlantType;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import mvc.Controller;
import mvc.Model;
import mvc.View;
import objects.Plant;

/**
 * PlantPlacementScene class for Gardendesigner Hub
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class PlantPlacementScene extends Scene {
	static Group root = new Group();
	BorderPane Pane = new BorderPane();
	HBox topPane = new HBox(5);
	VBox leftPane = new VBox(5);
	Pane gardenPane = new Pane();
	private BorderPane container;
	private GridPane grid = new GridPane();


	private static final int TOP_MIN_WIDTH = View.getCanvasWidth()-20;
	private static final int MIN_HEIGHT = 300;
	public static final String TEXT_LABEL_STYLE = "-fx-font: 14 arial;";
	public static final String UNDO_BUTTON_TEXT = "Undo";
	public static final String SELECT_TYPE = "Select Plant Type";
	public static final int TOP_MAX_HEIGHT = 150;
	public static final int CENTER_HEIGHT = View.getCanvasHeight() * 3/5;
	public static final int CENTER_WIDTH = View.getCanvasWidth() * (3/4)-20;
	public static final Insets GRID_PADDING = new Insets(10, 10, 10, 10);
	public static final int HGAP = 5;
	public static final int VGAP = 10;
	public static final String BORDER_STYLE = "-fx-border-color: black";
	public static final int CHOICEBOX_WIDTH = 175;
	private Button btnPrev, btnNext, btnUndo;

	public Controller imc;
	private int indexOfPlant=0;
	
	private ArrayList<Plant> list00 = Controller.importPlants("resources/PlantData/PlantList_00.csv", PlantType.ALL);
	private ArrayList<Plant> list01 = Controller.importPlants("resources/PlantData/PlantList_01.csv", PlantType.ALKALINE_SOIL_TOLERANT);
	private ArrayList<Plant> list02 = Controller.importPlants("resources/PlantData/PlantList_02.csv", PlantType.BIRD_BUTTERFLY_BUG_GARDENS);
	private ArrayList<Plant> list03 = Controller.importPlants("resources/PlantData/PlantList_03.csv", PlantType.DROUGHT_TOLERANT);
	private ArrayList<Plant> list04 = Controller.importPlants("resources/PlantData/PlantList_04.csv", PlantType.GRASSES);
	private ArrayList<Plant> list05 = Controller.importPlants("resources/PlantData/PlantList_05.csv", PlantType.GROUNDHOG_RESISTANT);
	private ArrayList<Plant> list06 = Controller.importPlants("resources/PlantData/PlantList_06.csv", PlantType.LANDSCAPE_ORNAMENTALS);
	private ArrayList<Plant> list07 = Controller.importPlants("resources/PlantData/PlantList_07.csv", PlantType.MEADOW);
	private ArrayList<Plant> list08 = Controller.importPlants("resources/PlantData/PlantList_08.csv", PlantType.NORTH_AMERICAN_NATIVE);
	private ArrayList<Plant> list09 = Controller.importPlants("resources/PlantData/PlantList_09.csv", PlantType.PERENNIALS);
	private ArrayList<Plant> list10 = Controller.importPlants("resources/PlantData/PlantList_10.csv", PlantType.PHYTOREMEDIATION);
	private ArrayList<Plant> list11 = Controller.importPlants("resources/PlantData/PlantList_11.csv", PlantType.RABBIT_RESISTANT);
	private ArrayList<Plant> list12 = Controller.importPlants("resources/PlantData/PlantList_12.csv", PlantType.RAIN_GARDENS);
	private ArrayList<Plant> list13 = Controller.importPlants("resources/PlantData/PlantList_13.csv", PlantType.RESTORATION_CONSERVATION);
	private ArrayList<Plant> list14 = Controller.importPlants("resources/PlantData/PlantList_14.csv", PlantType.ROOFTOP_GARDEN_PLANT);
	private ArrayList<Plant> list15 = Controller.importPlants("resources/PlantData/PlantList_15.csv", PlantType.SHRUB);
	private ArrayList<Plant> list16 = Controller.importPlants("resources/PlantData/PlantList_16.csv", PlantType.SOIL_STABILIZATION);
	private ArrayList<Plant> list17 = Controller.importPlants("resources/PlantData/PlantList_17.csv", PlantType.STORMWATER_MANAGEMENT);
	private ArrayList<Plant> list18 = Controller.importPlants("resources/PlantData/PlantList_18.csv", PlantType.VINES);
	private ArrayList<Plant> list19 = Controller.importPlants("resources/PlantData/PlantList_19.csv", PlantType.WETLANDS);
	private ArrayList<Plant> list20 = Controller.importPlants("resources/PlantData/PlantList_20.csv", PlantType.WOODLAND);
	
	private ArrayList<Plant> masterList = new ArrayList<>();
	
	private ArrayList<Image> plantImages = Controller.importImages();
	ListView<PlantWithImage> plantListView = new ListView<PlantWithImage>();


	private Label error = createLabel("");
	private Label nameValue = createLabel("");
	private Label heightValue = createLabel("");
	private Label spacingValue = createLabel("");
	private Label hardinessValue = createLabel("");
	private Label colorsValue = createLabel("");
	private Label attributeValue  = createLabel("");
	private Label selectPlant = createLabel(SELECT_TYPE);

	public Label getNameValue() {
		return nameValue;
	}

	public Label getHeightValue() {
		return heightValue;
	}

	public Label getSpacingValue() {
		return spacingValue;
	}

	public Label getHardinessValue() {
		return hardinessValue;
	}

	public Label getColorsValue() {
		return colorsValue;
	}
	
	public Label getAttributesValue() {
		return attributeValue;
	}

	/**
	 * Constructor for PlantPlacementScene. Formats the panes and buttons and
	 * prepares the Controller to handle user mouse inputs.
	 */
	public PlantPlacementScene() {
		super(new BorderPane());
		this.container = (BorderPane) this.getRoot();
		this.btnNext = this.createButton(View.NEXT_BUTTON_TEXT);
		this.btnNext.setMaxWidth(Double.MAX_VALUE);
		this.btnPrev = this.createButton(View.PREV_BUTTON_TEXT);
		this.btnPrev.setMaxWidth(Double.MAX_VALUE);
		//this.btnUndo = this.createButton(leftPane, "Undo", UNDO_IMAGE);
		this.btnUndo = new Button("Undo");
		grid.add(btnUndo, 0, 6);
		
		imc = new Controller(this);
		placePlant();

		this.container.setMinSize(View.WIDTH, View.HEIGHT);
		this.container.setTop(this.plantListView);

		HBox center = new HBox(this.grid, this.gardenPane);
		center.setBackground(View.BACKGROUND);
		HBox.setHgrow(this.gardenPane, Priority.ALWAYS);
		this.container.setCenter(center);

		HBox buttons = new HBox(this.btnPrev, this.btnNext);
		HBox.setHgrow(this.btnPrev, Priority.ALWAYS);
		HBox.setHgrow(this.btnNext, Priority.ALWAYS);
		this.container.setBottom(buttons);
	}

	/**
	 * Creates the plant placement scene which allows the user to drag and drop
	 * plants onto the garden space they drew previously.
	 */
	public void placePlant() {
		masterList.addAll(list00);
		masterList.addAll(list01);
		masterList.addAll(list02);
		masterList.addAll(list03);
		masterList.addAll(list04);
		masterList.addAll(list05);
		masterList.addAll(list06);
		masterList.addAll(list07);
		masterList.addAll(list08);
		masterList.addAll(list09);
		masterList.addAll(list10);
		masterList.addAll(list11);
		masterList.addAll(list12);
		masterList.addAll(list13);
		masterList.addAll(list14);
		masterList.addAll(list15);
		masterList.addAll(list16);
		masterList.addAll(list17);
		masterList.addAll(list18);
		masterList.addAll(list19);
		masterList.addAll(list20);
		
		Canvas drawCanvas = new Canvas(View.getCanvasWidth(), View.getCanvasHeight());
		GraphicsContext drawGC;
		root.getChildren().add(drawCanvas);
		drawGC = drawCanvas.getGraphicsContext2D();
		drawGC.clearRect(0, 0, View.getCanvasWidth(), View.getCanvasHeight());

		gardenPane.setPrefHeight(CENTER_HEIGHT);
		gardenPane.setPrefWidth(CENTER_WIDTH);
		gardenPane.setStyle(BORDER_STYLE);
		Pane.setMargin(gardenPane, new Insets(10,10,10,10));
		topPane.setMinSize(View.getCanvasWidth()-20, 150);

		root.getChildren().add(Pane);

		BorderPane.setMargin(topPane, new Insets(10, 10, 10, 10));

		Pane.setTop(topPane);
		Pane.setLeft(leftPane);
		Pane.setCenter(gardenPane);
		topPane.getChildren().add(plantListView);
		plantListView.setMinWidth(TOP_MIN_WIDTH);
		plantListView.setMaxHeight(TOP_MAX_HEIGHT);

		grid.setHgap(HGAP);
		grid.setVgap(VGAP);
		grid.setPadding(GRID_PADDING);
		leftPane.getChildren().add(grid);
		leftPane.setMaxWidth(250);
		leftPane.setMinWidth(250);
		leftPane.setStyle(BORDER_STYLE);
		VBox.setMargin(leftPane, new Insets(10,10,10,10));
		GridPane.setHgrow(grid, Priority.NEVER);
		Text scenetitle = new Text("Please Choose Some Plants");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		scenetitle.setTextAlignment(TextAlignment.CENTER);
		topPane.setAlignment(Pos.CENTER);

		HBox.setHgrow(plantListView, Priority.NEVER);
		plantListView.setOrientation(Orientation.HORIZONTAL);
		
		reloadPlantList(PlantType.ALL);
		
		// create a choiceBox
		ChoiceBox choiceBox = new ChoiceBox(FXCollections.observableArrayList(Model.plantTypesStr));
		// add a listener
		choiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			// if the item of the list is changed
			PlantType plantType = PlantType.ALL;

			public void changed(ObservableValue ov, Number value, Number new_value) {
				plantType = PlantType.get((int) new_value);
				reloadPlantList(plantType);
			}
		});
		choiceBox.setMaxWidth(CHOICEBOX_WIDTH);
		choiceBox.setStyle(TEXT_LABEL_STYLE);

		

		// Display plant information in the left pane

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
		
		Label attributes = createLabel("Attributes: ");
		grid.add(attributes, 0, 5);

		nameValue.setMaxWidth(100);
		nameValue.setWrapText(true);
		grid.add(nameValue, 1, 0);
		grid.add(heightValue, 1, 1);
		grid.add(spacingValue, 1, 2);
		grid.add(hardinessValue, 1, 3);
		grid.add(colorsValue, 1, 4);
		grid.add(attributeValue, 1, 5);
		grid.add(selectPlant, 0, 7);
		grid.add(choiceBox, 0, 8);
	}


	/**
	 * Creates a plant label
	 * 
	 * @param text - the label text
	 * @return the plant label
	 */
	private Label createLabel(String text) {
		Label label = new Label(text);
		label.setTextFill(Color.BLACK);
		label.setStyle(this.TEXT_LABEL_STYLE);
		return label;
	}

	/**
	 * Creates the "next" button
	 * 
	 * @return the "next" button
	 */
	private Button createNextButton() {
		Button nextButton = new Button("Next");
		nextButton.setTranslateX(View.getCanvasWidth() * 7 / 8);
		nextButton.setTranslateY(View.getCanvasHeight() * 7 / 8);
		return nextButton;
	}

	/**
	 * Creates the "previous" button
	 * 
	 * @return the "previous" button
	 */
	private Button createPrevButton() {
		Button prevButton = new Button("Prev");
		prevButton.setTranslateX(View.getCanvasWidth() * 1 / 8);
		prevButton.setTranslateY(View.getCanvasHeight() * 7 / 8);
		return prevButton;
	}


	/**
	 * Creates a button
	 * 
	 * @param text - the text displayed on the button
	 * @return the created button
	 */
	private Button createButton(String text) {
		Button btn = new Button(text);
		btn.setStyle(View.BUTTON_STYLE);
		return btn;
	}

	/**
	 * overloaded method of createButton, takes the container to put, name and image
	 * @param pane
	 * @param text
	 * @param image
	 * @return button
	 */
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
	
	
	/**
	 * reloads the plantListView according to given plant type
	 * @param plant type
	 */
	private void reloadPlantList(PlantType plantType) {
		plantListView.getItems().clear();
		
		File errorFile = new File("resources/NO_IMAGE_AVAILABLE.png");
		Image errorImage = new Image(errorFile.toURI().toString());
	    Image plantImage = errorImage;
		
		for (Plant somePlant : masterList) {
			try {
				if (somePlant.getType() == plantType) {
					File imageFile = new File("resources/PlantImages/" + somePlant.getPlantBotanicalName() + ".jpg");
					plantImage = new Image(imageFile.toURI().toString(),100,100,true,true);
					plantListView.getItems().add(new PlantWithImage(somePlant, plantImage));
				} 
			} catch (Exception e) {
				System.out.println("Error getting plant image for " + somePlant.toString());
				plantListView.getItems().add(new PlantWithImage(somePlant, errorImage));
			}
		}

		plantListView.setCellFactory(lv -> new ListCell<PlantPlacementScene.PlantWithImage>() {
			private final ImageView imageView = new ImageView();
			{
				setPrefHeight(100);
			}

			@Override
			protected void updateItem(PlantWithImage plantWithImage, boolean empty) {
				lv.setStyle(TEXT_LABEL_STYLE);
				super.updateItem(plantWithImage, empty);
				if (empty) {
					setText(null);
					setGraphic(null);
				} else {
					setText(plantWithImage.getPlant().toString());
					imageView.setImage(plantWithImage.getImage());
					setGraphic(imageView);
				}
			}
		});
	}
	
	/**
	 * static class to encapsulate both image and plant object in a single object
	 */
	public static class PlantWithImage {
		private final Plant plant;
		private final Image image;

		public PlantWithImage(Plant p, Image plantImage) {
			super();
			this.plant = p;
			this.image = plantImage;
		}

		public Plant getPlant() {
			return plant;
		}

		public Image getImage() {
			return image;
		}
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
	 * Gets the delete button
	 * 
	 * @return the delete button
	 */
	public Button getUndoButton() {
		return this.btnUndo;
	}

	/**
	 * Gets the plantListView
	 * 
	 * @return the plantListView
	 */
	public ListView<PlantWithImage> getPlantListView() {
		return this.plantListView;
	}

	/**
	 * gets the center of scene, i.e garden container
	 * @return the center
	 */

	public Pane getGardenPane() {
		return this.gardenPane;
	}
	/**
	 * get the list of all plant objects
	 * @return allPlants
	 */
	public ArrayList<Plant> getAllPlants() {
		return masterList;
	}

	/**
	 * get the index of plant clicked
	 * @return indexOfPlant
	 */

	public int getIndexOfPlant() {
		return indexOfPlant;
	}

	/**
	 * set the index of plant clicked
	 * @param index
	 */
	public void setIndexOfPlant(int index) {
		indexOfPlant = index;
	}

	/**
	 * get the list of all plant images
	 * @return plantImages
	 */
	public ArrayList<Image> getPlantImages() {
		return plantImages;
	}
}
