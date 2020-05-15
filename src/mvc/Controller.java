package mvc;

import enums.Names;
import enums.Season;
import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import objects.*;
import view.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;

/**
 * Controller class for Gardendesigner Hub
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Controller extends Application {

	/**
	 * the main method for the program
	 * 
	 * @param args an array of strings
	 * @throws FileNotFoundException if an image file or csv file is not found
	 */
	public static void main(String[] args) throws FileNotFoundException {
		launch(args);
	}

	/**
	 * Imports plant images into an ArrayList
	 * 
	 * @return an ArrayList of plant ImageViews
	 */
	public static ArrayList<Image> importImages() {
		ArrayList<Image> images = new ArrayList<>();
		File directory = new File("resources/plant-images");
		//File directory = new File("/Users/hamza/Developer/CSC275/team-11-2/resources/plant-images");

		File[] f = directory.listFiles();
		for (File file : f) {
			if (file != null && file.getName().toLowerCase().endsWith(".jpg")) {
				images.add(View.createImage("resources/plant-images/" + file.getName(), 100, 100, true, true));
		//		images.add(View.createImage("/Users/hamza/Developer/CSC275/team-11-2/resources/plant-images/" + file.getName(), 100, 100, true, true));

			}
		}
		Collections.sort(images, new CustomComparator());
		for(int i=0; i<images.size(); i++) {
			System.out.print(getIndex(images.get(i))+ " ");
		}
		return images;
	}


	/**
	 * Imports plant data
	 * 
	 * @return an ArrayList of plants
	 */
	public static ArrayList<Plant> importPlants() {
		ArrayList<Plant> plantList = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader("resources/NewMoonNurseryPlants.csv"))) {
		//try (BufferedReader reader = new BufferedReader(new FileReader("/Users/hamza/Developer/CSC275/team-11-2/resources/NewMoonNurseryPlants.csv"))) {

			String line;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(";");
				String plantBotName = data[0];
				String bloomColor = data[5];

				int minHeight = 0;
				int maxHeight = 0;
				String[] splittingArray = data[1].split("-", 2);

				try {
					minHeight = Integer.parseInt(splittingArray[0]);
				} catch (Exception e) {
					minHeight = -1;
				}

				try {
					maxHeight = Integer.parseInt(splittingArray[1]);
				} catch (Exception e) {
					maxHeight = -1;
				}

				int spreadMin = 0;
				int spreadMax = 0;
				splittingArray = data[2].split("-", 2);

				try {
					spreadMin = Integer.parseInt(splittingArray[0]);
				} catch (Exception e) {
					spreadMin = -1;
				}

				try {
					spreadMax = Integer.parseInt(splittingArray[1]);
				} catch (Exception e) {
					spreadMax = -1;
				}

				int spacingMin = 0;
				int spacingMax = 0;
				splittingArray = data[3].split("-", 2);

				try {
					spacingMin = Integer.parseInt(splittingArray[0]);
				} catch (Exception e) {
					spacingMin = -1;
				}

				try {
					spacingMax = Integer.parseInt(splittingArray[1]);
				} catch (Exception e) {
					spacingMax = -1;
				}

				int hardinessMin = 0;
				int hardinessMax = 0;
				splittingArray = data[4].split("-", 2);

				try {
					hardinessMin = Integer.parseInt(splittingArray[0]);
				} catch (Exception e) {
					hardinessMin = -1;
				}

				try {
					hardinessMax = Integer.parseInt(splittingArray[1]);
				} catch (Exception e) {
					hardinessMax = -1;
				}

				plantList.add(new Plant(plantBotName, minHeight, maxHeight, spreadMin, spreadMax, spacingMin,
						spacingMax, hardinessMin, hardinessMax, bloomColor));
			}
		} catch (IOException e) {
			e.printStackTrace(); // TODO add proper error handling
		}
		return plantList;
	}

	private Model model;
	private View view;
	private PlantPlacementScene pps;

	private static final boolean DEBUG = true;
	public ArrayList<ImageView> imageViewArrayList = new ArrayList<ImageView>();

	/**
	 * Default constructor for Controller
	 */
	public Controller() {

	}

	/**
	 * Controller constructor for plant placement scene
	 * 
	 * @param pps a plant placement scene
	 */
	public Controller(PlantPlacementScene pps) {
		this.pps = pps;
		model = new Model();
		if (DEBUG)
			System.out.println("ic created");
	}

	/**
	 * Starts the program and the stage
	 * 
	 * @param theStage the stage that the garden is displayed on
	 */
	@Override
	public void start(Stage theStage) throws Exception {
		System.out.println(theStage);
		view = new View(theStage, this);
		model = new Model();
		theStage.show();
	}

	/**
	 * Event handler for when the user presses the new button on the main menu scene
	 */
	public void onMainMenuNew() {
		this.view.setScreen(Names.GARDEN_INFO);
	}

	/**
	 * Event handler for when the user presses the help button on the MainMenuScene
	 */
	public void onMainMenuHelp() {
		this.view.setScreen(Names.TUTORIAL);
	}

	/**
	 * Event handler for when the user presses the load button on the MainMenuScene
	 */
	public void onMainMenuLoad() {
		this.view.setScreen(Names.LOADING);
	}

	/**
	 * Event handler for when the user presses the previous button on the
	 * GardenInfoscene
	 */
	public void onGardenInfoPrev() {
		Optional<ButtonType> response = this.view.showDiscardDialog();
		if (response.isPresent() && response.get() == ButtonType.OK) {
			GardenInfoScene scene = (GardenInfoScene) this.view.getScene(Names.GARDEN_INFO);
			scene.clearTextFields();
			this.view.setScreen(Names.MAIN_MENU);
		}
	}

	/**
	 * Event handler for when the user presses the next button on the
	 * GardenInfoScene
	 */
	public void onGardenInfoNext() {
		GardenInfoScene scene = (GardenInfoScene) this.view.getScene(Names.GARDEN_INFO);
		try {
			this.model.setWidth((int) Double.parseDouble(scene.getWidthTextfield().getText()));
			this.model.setLength((int) Double.parseDouble(scene.getHeightTextfield().getText()));
			if (scene.getSunlightTextfield().getText().isEmpty()) {
				this.model.setLight(-1);
			} else {
				this.model.setLight((int) Double.parseDouble(scene.getSunlightTextfield().getText()));
			}
			if (scene.getRainTextfield().getText().isEmpty()) {
				this.model.setRain(-1);
			} else {
				this.model.setRain((int) Double.parseDouble(scene.getRainTextfield().getText()));
			}
			if (scene.getSoilPHTextfield().getText().isEmpty()) {
				this.model.setSoilPH(-1);
			} else {
				this.model.setSoilPH(Double.parseDouble(scene.getSoilPHTextfield().getText()));
			}
			if (scene.getTempTextfield().getText().isEmpty()) {
				this.model.setTemperature(-1);
			} else {
				this.model.setTemperature(Double.parseDouble(scene.getTempTextfield().getText()));
			}
			this.view.setScreen(Names.DRAW);
			this.view.drawEditMap(((DrawScene) view.getScene(Names.DRAW)).getGardenPane());
		} catch (NumberFormatException e) {
			this.view.showInvalidInputAlert();
		}
	}

	/**
	 * Event handler for when the user presses the previous button on the
	 * PlantPlacementScene
	 */
	public void onPlantPlacementPrev() {
		this.view.setScreen(Names.DRAW);
		this.view.drawEditMap(((DrawScene) view.getScene(Names.DRAW)).getGardenPane());
	}

	/**
	 * Event handler for when the user presses the next button on the
	 * PlantPlacementScene
	 */
	public void onPlantPlacementNext() {
		this.view.setScreen(Names.TIMES);
		this.view.drawMap(((TimesScene) view.getScene(Names.TIMES)).getGardenPane());
	}

	/**
	 * Event Handler for when the user presses the previous button on the
	 * TutorialScene
	 */
	public void onTutorialPrev() {
		this.view.setScreen(Names.MAIN_MENU);
	}

	/**
	 * Event handler for when the user presses the previous button on the DrawScene
	 */
	public void onDrawPrev() {
		this.view.setScreen(Names.GARDEN_INFO);
	}

	/**
	 * Event handler for when the user presses the next button on the DrawScene
	 */
	public void onDrawNext() {
		this.view.setScreen(Names.PLANT_PLACEMENT);
		this.view.showInformationAlert();
		this.view.drawMap(((PlantPlacementScene) view.getScene(Names.PLANT_PLACEMENT)).getGardenPane());
	}

	/**
	 * Creates a polygon for grass and adds it to the garden model
	 * 
	 * @author Ntsee, Jason
	 */
	public void onDrawGrass() {
		DrawScene scene = (DrawScene) this.view.getScene(Names.DRAW);
		Grass grass = new Grass();
		Polygon polygon = grass.getShape().getPolygon();
		this.model.addGardenObject(grass);
		createDrawPolyDraggable(scene, polygon);
	}

	/**
	 * Creates a polygon for a road and adds it to the garden model
	 * 
	 * @author Ntsee, Jason
	 */
	public void onDrawRoad() {
		DrawScene scene = (DrawScene) this.view.getScene(Names.DRAW);
		Road road = new Road();
		Polygon polygon = road.getShape().getPolygon();
		this.model.addGardenObject(road);
		createDrawPolyDraggable(scene, polygon);
	}

	/**
	 * Creates a polygon for a stream and adds it to the garden model
	 * 
	 * @author Ntsee, Jason
	 */
	public void onDrawStream() {
		DrawScene scene = (DrawScene) this.view.getScene(Names.DRAW);
		Stream stream = new Stream();
		Polygon polygon = stream.getShape().getPolygon();
		this.model.addGardenObject(stream);
		createDrawPolyDraggable(scene, polygon);
	}

	/**
	 * Creates a polygon for woods and adds it to the garden model
	 * 
	 * @author Ntsee, Jason
	 */
	public void onDrawWoods() {
		System.out.println(this.view);
		DrawScene scene = (DrawScene) this.view.getScene(Names.DRAW);
		Woods woods = new Woods();
		Polygon polygon = woods.getShape().getPolygon();
		this.model.addGardenObject(woods);
		createDrawPolyDraggable(scene, polygon);
	}

	/**
	 * Handles the click events, single click on plant name displays the information in right panel
	 * double click puts the plant image on the garden
	 * 
	 * @param event The MouseEvent on the plant
	 */
	public void onDragPlant(MouseEvent event) {
		PlantPlacementScene scene = (PlantPlacementScene) view.getScene(Names.PLANT_PLACEMENT);
		try {
			scene.getErrorLabel().setText(" ");
			System.out.println("Mouse clicked");
			// Text temp = null;
			Text plantlabel = (Text) (event.getTarget());
			scene.getErrorLabel().setText(" ");
			Optional<Plant> plant = scene.getAllPlants().stream().filter(p -> p.toString().equals(plantlabel.getText())).findAny();
			scene.getErrorLabel().setText(" ");
			Plant p = plant.get();
			System.out.println(scene.getAllPlants().indexOf(p));
			if(event.getClickCount()==2) {
				scene.setIndexOfPlant(scene.getAllPlants().indexOf(p));
				Plant plant2 = p.copyOfPlant();
				Circle circle = plant2.getShape().getCircle();
				circle.setFill(new ImagePattern(scene.getPlantImages().get(scene.getIndexOfPlant())));
				scene.getGardenPane().getChildren().add(circle);
				model.addGardenObject(plant2);
				System.out.println(model.getGardenObjects());
				giveShapeDragBehavior(circle);
			}
			scene.getNameValue().setText(p.getPlantBotanicalName());

			if (p.getHeightMaxInches() == -1)
				scene.getHeightValue().setText("No Data");
			else
				scene.getHeightValue().setText(Integer.toString(p.getHeightMaxInches()));

			if (p.getSpacingMax() == -1)
				scene.getSpacingValue().setText("No Data");
			else
				scene.getSpacingValue().setText(Integer.toString(p.getSpacingMax()));

			if (p.getHardinessMin() == -1)
				scene.getHardinessValue().setText("No Data");
			else
				scene.getHardinessValue().setText(Integer.toString(p.getHardinessMin()));
			scene.getColorsValue().setText(p.getBloomColors());
			event.consume();
		} catch (NullPointerException e) {
			scene.getErrorLabel().setText("No Data found for this plant");

		} catch (ClassCastException e) {
			scene.getErrorLabel().setText("Please click on plant's name instead of picture");
			System.out.println(event.getTarget().toString());
		}
	}



	/**
	 * Creates a polygon for shade and adds it to the garden model
	 */
	public void onDrawShader() {
		DrawScene scene = (DrawScene) this.view.getScene(Names.DRAW);
		Shade shade = new Shade();
		Polygon polygon = shade.getShape().getPolygon();
		this.model.addGardenObject(shade);
		createDrawPolyDraggable(scene, polygon);
	}

	public void onDrawUndo() {
		DrawScene scene = (DrawScene) this.view.getScene(Names.DRAW);
		if (!(scene.getGardenPane().getChildren().isEmpty())) {
			for (int i = 0; i < 9; i++) {
				scene.getGardenPane().getChildren().remove(scene.getGardenPane().getChildren().size() - 1);
			}
			int i = this.model.getGardenObjects().size() - 1;
			while (removeLastObject(i)) {
				i--;
			}
		}
	}

	public void onPlantPlacementUndo() {
		PlantPlacementScene scene = (PlantPlacementScene) this.view.getScene(Names.PLANT_PLACEMENT);
		if (!(scene.getGardenPane().getChildren().isEmpty())) {

			scene.getGardenPane().getChildren().remove(scene.getGardenPane().getChildren().size() - 1);

			int i = this.model.getGardenObjects().size() - 1;
			while (removeLastObject(i)) {
				i--;
			}
		}
	}

	/**
	 * 
	 * @param i the index of the object that will be removed from the model
	 * @return the boolean determining whether or not the last object that is not a plant has been removed
	 * 
	 * @author Jason
	 */
	public boolean removeLastObject(int i) {
		if (i < 0) {
			return false;
		}
		GardenObject object = model.getGardenObjects().get(i);
		if (!(object instanceof Plant)) {
			model.removeGardenObject(object);
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Event handler for when the user presses the previous button on the TimesScene
	 */
	public void onTimesPrev() {
		this.view.setScreen(Names.PLANT_PLACEMENT);
		this.view.drawMap(((PlantPlacementScene) view.getScene(Names.PLANT_PLACEMENT)).getGardenPane());
	}

	/**
	 * Event Handler for when the user presses the next button on the TimesScene
	 */
	public void onTimesNext() {
		this.view.setScreen(Names.RATING);
		this.view.drawMap(((RatingScene) view.getScene(Names.RATING)).getGardenPane());
	}

	/**
	 * Event handler for when the user selects a season radio button on the
	 * TimesScene
	 * 
	 * @param season the new season the garden is in
	 */
	public void onTimesSetSeason(Season season) {
		this.model.setSeason(season);
		PlantPlacementScene scene = (PlantPlacementScene) view.getScene(Names.PLANT_PLACEMENT);
		System.out.println(season.name());
		for (Plant plant : model.getPlantObjects()) {
			plant.getShape().getCircle().setFill(view.generateImage(scene.getPlantImages().get(scene.getIndexOfPlant()), season));
		}
	}

	/**
	 * Event handler for when the user moves the age slider on the TimesScene
	 * 
	 * @param age the age in years to set the garden to
	 */
	public void onTimesSetAge(double age) {
		this.model.setAge(age);
		System.out.println(age);
		for (Plant plant : model.getPlantObjects()) {
			plant.changePlantSize(age);
		}
	}

	/**
	 * Event handler to change the appearance of the circles based on time and season
	 */
	public void changePlantStatus(Plant plant) {
		plant.changePlantSize(this.model.getAge());
		//this.model.getSeason();

	}

	/**
	 * Event Handler for when the user presses the previous button on the
	 * RatingScene
	 */
	public void onRatingPrev() {
		this.view.setScreen(Names.TIMES);
		this.view.drawMap(((TimesScene) view.getScene(Names.TIMES)).getGardenPane());
	}

	/**
	 * Event handler for when the user presses the save button on the RatingScene
	 */
	public void onRatingSave() {
		LoadingScene scene = (LoadingScene) this.view.getScene(Names.LOADING);
		File file = this.view.showSaveDialog();
		if (file == null)
			return;

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
			out.writeObject(this.model);
			if (DEBUG)
				System.out.println("Object has been serialized to file: " + file.getPath());
			this.view.showDialog(Alert.AlertType.INFORMATION, "Garden Saved", "Your garden has been saved!");
			this.view.setScreen(Names.LOADING);
			scene.addTableEntry(file);

		} catch (IOException ex) {
			this.view.showDialog(Alert.AlertType.ERROR, "Save Error", "Your garden was unable to be saved.");
		}
	}

	/**
	 * Event handler for when the user wants to select a garden to load while on the
	 * LoadingScene
	 */
	public void onLoadingBrowse() {
		File file = this.view.showOpenDialog();
		if (file == null)
			return;

		LoadingScene scene = (LoadingScene) this.view.getScene(Names.LOADING);
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
			this.model = (Model) in.readObject();
			if (DEBUG) {
				System.out.println("Object has been deserialized ");
				System.out.println("amount of light = " + model.getLight());
			}
			scene.addTableEntry(file);
		} catch (IOException | ClassNotFoundException e) {
			this.view.showDialog(Alert.AlertType.ERROR, "Load Error", "There was an error loading your garden.");
		}
	}

	/**
	 * Event handler for when the user presses the previous button on the
	 * LoadingScene
	 */
	public void onLoadingPrev() {
		this.view.setScreen(Names.MAIN_MENU);
	}

	/**
	 * Event handler for when the user presses the edit button on the LoadingScene
	 */
	public void onLoadingEdit() {
		this.view.setScreen(Names.GARDEN_INFO);
	}

	/**
	 * Adds a garden object to Model
	 * 
	 * @param object the object that will be loaded into the model
	 */
	public void addGardenObject(GardenObject object) {
		this.model.addGardenObject(object);
		System.out.println("Added object");
	}

	/**
	 * Gives a polygon the drag behavior in the given DrawScene
	 * 
	 * @param scene  	the scene which will contain the draggable polygon
	 * @param polygon	the polygon will be created in a given DrawScene and become draggable
	 * 
	 * @author Jason
	 */
	public void createDrawPolyDraggable(DrawScene scene, Polygon polygon) {
		scene.getGardenPane().getChildren().add(polygon);
		giveShapeDragBehavior(polygon);
		scene.getGardenPane().getChildren().addAll(Anchor.createAnchors(polygon, polygon.getPoints()));
	}

	/**
	 * Gives any shape a simple drag behavior
	 * 
	 * @param shape the shape which will become draggable
	 * 
	 * @author Jason
	 */
	public void giveShapeDragBehavior(Shape shape) {
		final ObjectProperty<Point2D> mousePosition = new SimpleObjectProperty<>();
		shape.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				mousePosition.set(new Point2D(event.getSceneX(), event.getSceneY()));
			}
		});
		shape.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				double changeX = event.getSceneX() - mousePosition.get().getX();
				double changeY = event.getSceneY() - mousePosition.get().getY();

				if (shape.getLayoutX() < 0) {
					shape.setLayoutX(0);
				} else {
					shape.setLayoutX(shape.getLayoutX() + changeX);
				}

				if (shape.getLayoutY() < 0) {
					shape.setLayoutY(0);
				} else {
					shape.setLayoutY(shape.getLayoutY() + changeY);
				}
				mousePosition.set(new Point2D(event.getSceneX(), event.getSceneY()));
			}
		});
	}

	/**
	 * Gives an Anchor object drag behavior
	 * 
	 * @param anchor the anchor which will receive the drag behavior
	 * 
	 * @author Jason
	 */
	public static void anchorDragBehavior(Anchor anchor) {
		final ObjectProperty<Point2D> mousePosition = new SimpleObjectProperty<>();
		anchor.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				mousePosition.set(new Point2D(event.getSceneX(), event.getSceneY()));
			}
		});
		anchor.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				double changeX = event.getSceneX() - mousePosition.get().getX();
				double changeY = event.getSceneY() - mousePosition.get().getY();

				anchor.setCenterX(anchor.getCenterX() + changeX);
				anchor.setCenterY(anchor.getCenterY() + changeY);

				mousePosition.set(new Point2D(event.getSceneX(), event.getSceneY()));
			}
		});
	}

	/**
	 * Loads the objects on the map
	 * 
	 * @return the GardenObjects stored inside of model
	 */
	public Collection<GardenObject> loadMapObjects() {
		return model.getGardenObjects();
	}

	/**
	 * Loads the plant objects on the map
	 * 
	 * @return the Plants stored inside of model
	 */
	public ArrayList<Plant> loadPlantObjects() {
		return model.getPlantObjects();
	}

	/**
	 * method to extract the index of images from its name. To be used in sorting
	 * @param image
	 * @return the index of image, extracted from its file path.
	 */
	public static int getIndex(Image image) {
		String indexString = null;

		String path = image.getUrl();
		String [] s = path.split(".jp");
		String [] s2 = s[0].split("images/");

		int index = Integer.parseInt(s2[1]);
		return index;
	}


	public static  class CustomComparator implements Comparator<Image> {

		@Override
		public int compare(Image img, Image img2) {

			if(getIndex(img) > getIndex(img2)) {
				return 1;
			}else if(getIndex(img) < getIndex(img2)) {
				return -1;
			}else return 0;
		}
	}
}
