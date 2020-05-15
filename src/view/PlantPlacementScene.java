package view;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import javafx.geometry.*;
import enums.Names;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import mvc.Controller;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mvc.View;
import objects.Plant;
import objects.Woods;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class PlantPlacementScene extends Scene {
	private static final int TOP_MIN_WIDTH = View.getCanvasWidth()-20;
	private static final int MIN_HEIGHT = 300;
	public static final String TEXT_LABEL_STYLE = "-fx-font: 14 arial;";
	public static final int TOP_MAX_HEIGHT = 150;
	public static final int CENTER_HEIGHT = View.getCanvasHeight() * 3/5;
	public static final int CENTER_WIDTH = View.getCanvasWidth() * (3/4)-20;
	public static final Insets GRID_PADDING = new Insets(10, 0, 0, 10);
	public static final int HGAP = 10;
	public static final int VGAP = 10;

	public static final String BORDER_STYLE = "-fx-border-color: black";
	private Button btnPrev, btnNext;

	static Group root = new Group();
	public Controller imc;
	private int indexOfPlant=0;

	private ArrayList<Plant> allPlants = Controller.importPlants();
	private ArrayList<Image> plantImages = Controller.importImages();
	ListView<PlantWithImage> plantListView = new ListView<PlantWithImage>();
	private Map<Plant, ImageView> infoImageMap ;

	private Pane gardenPane = new Pane();
	
	private Label error = createLabel("");
	private Label nameValue = createLabel("");
	private Label heightValue = createLabel("");
	private Label spacingValue = createLabel("");
	private Label hardinessValue = createLabel("");
	private Label colorsValue = createLabel("");
	
	public Label getErrorLabel() {
		return error;
	}
	
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


/**
 * constructor
 */

	public PlantPlacementScene() {
		super(root);
		this.btnNext = this.createButton(View.NEXT_BUTTON_TEXT);
		this.btnNext.setMaxWidth(Double.MAX_VALUE);
		this.btnPrev = this.createButton(View.PREV_BUTTON_TEXT);
		this.btnPrev.setMaxWidth(Double.MAX_VALUE);
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

		BorderPane Pane = new BorderPane();
		HBox topPane = new HBox(5);
		VBox leftPane = new VBox(5);

		gardenPane.setPrefHeight(CENTER_HEIGHT);
		gardenPane.setPrefWidth(CENTER_WIDTH);
		gardenPane.setStyle(BORDER_STYLE);
		Pane.setMargin(gardenPane, new Insets(10,10,10,10));
		topPane.setMinSize(View.getCanvasWidth()-20, 150);

		root.getChildren().add(Pane);

		BorderPane.setMargin(topPane, new Insets(10, 10, 10, 10));
		//borderPane.setMinHeight(500);

		Pane.setTop(topPane);
		Pane.setLeft(leftPane);
		Pane.setCenter(gardenPane);
		topPane.getChildren().add(plantListView);
		plantListView.setMinWidth(TOP_MIN_WIDTH);
		plantListView.setMaxHeight(TOP_MAX_HEIGHT);
		GridPane grid = new GridPane();
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
		btnNext = createNextButton();
		btnPrev = createPrevButton();
		root.getChildren().addAll(btnPrev, btnNext);



		HBox.setHgrow(plantListView, Priority.NEVER);
		plantListView.setOrientation(Orientation.HORIZONTAL);
		//ObservableList<Plant> rawData = FXCollections.observableArrayList(allPlants);
		//FilteredList<Plant> filteredList= new FilteredList<>(rawData, data -> true);
		//plantListView.setItems(filteredList);
		System.out.println(allPlants.size());
		System.out.println(plantImages.size());

		//plantImages.sort((ImageView i1, ImageView i2)-> getIndex(i1.getImage()).compareTo(getIndex(i2.getImage())));
		for (int i = 0 ; i < allPlants.size(); i++)  {
			Image image = null ;
			if (i <plantImages.size()) {
				image = plantImages.get(i);
			}
			plantListView.getItems().add(new PlantWithImage(allPlants.get(i), image));
		}

		//PlantWithImage p= new PlantWithImage(allPlants.get(200), plantImages.get(200));
		//plantListView.getItems().setAll(allPlants);
		//plantListView((PlantWithImage p1, PlantWithImage p2) -> compare(p1.getImage(),p2.getImage()));
		//Collections.sort(plantListView, new CustomComparator());
		
		/**
		 * Defines how each cell of plantlistview will be displayed
		 */
		plantListView.setCellFactory(lv -> new ListCell<>() {

			private final ImageView imageView = new ImageView();

			{
				setPrefHeight(100);
			}

			@Override
			protected void updateItem(PlantWithImage plantWithImage, boolean empty) {
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

		// alert user when they click on image
		leftPane.getChildren().add(error);
		error.setMaxWidth(300);
		error.setWrapText(true);

		nameValue.setMaxWidth(100);
		nameValue.setWrapText(true);
		grid.add(nameValue, 1, 0);
		grid.add(heightValue, 1, 1);
		grid.add(spacingValue, 1, 2);
		grid.add(hardinessValue, 1, 3);
		grid.add(colorsValue, 1, 4);
	}


	/**
	 * Creates a plant label
	 * 
	 * @param text - the label text
	 * @return the plant label
	 */
	private Label createLabel(String text) {
		Label label = new Label(text);
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
	
	public ArrayList<Plant> getAllPlants() {
		return allPlants;
	}
	
	public int getIndexOfPlant() {
		return indexOfPlant;
	}
	
	public void setIndexOfPlant(int index) {
		indexOfPlant = index;
	}
	
	public ArrayList<Image> getPlantImages() {
		return plantImages;
	}


//	Collections.sort(plantImages, new Comparator<>() {
//	    @Override
//	    public int compare(MyObject o1, MyObject o2) {
//	        return o1.getStartDate().compareTo(o2.getStartDate());
//	    }
//	});
	
/**
 * static class to encapsulate both image and plant object in a single object
 * 
 * @author hamza
 *
 */
	private static class PlantWithImage{
		private final Plant plant ;
		private final Image image ;
		public PlantWithImage(Plant p, Image img) {
			super();
			this.plant = p;
			this.image = img;
		}
		public Plant getPlant() {
			return plant;
		}
		public Image getImage() {
			return image;
		}
		
	}
	
	
	
	
}
