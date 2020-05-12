package mvc;

import enums.Names;
import enums.Season;
import javafx.application.Application;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import objects.*;
import view.DrawScene;
import view.GardenInfoScene;
import view.PlantPlacementScene;

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
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

/**
 * Controller class for Garden Designer
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Controller extends Application {

	/**
	 * the main method for the program
	 * 
	 * @param args - an array of strings
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		//Collection<Plant2> allPlants = importPlants();
		launch(args);
	}

	public static Collection<Plant2> importPlants() {
		Collection<Plant2> plantList = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader("resources/NewMoonNurseryPlants.csv"))) {
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

				plantList.add(new Plant2(plantBotName, minHeight, maxHeight, spreadMin, spreadMax, spacingMin,
						spacingMax, hardinessMin, hardinessMax, bloomColor));
			}
		} catch (IOException e) {
			e.printStackTrace(); // to do:: add proper error handling
		}
		return plantList;
	}

	private Model model;
	private View view;
	private PlantPlacementScene pps;

	private static final boolean DEBUG = true;
	public ArrayList<ImageView> imageViewArrayList = new ArrayList<ImageView>();

	public Controller() {

	}

	public Controller(PlantPlacementScene pps) {
		this.pps = pps;
		model = new Model();
		if (DEBUG)
			System.out.println("ic created");
	}

	/**
	 * @param theStage - the stage that the garden is displayed on
	 */
	@Override
	public void start(Stage theStage) throws Exception {
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
			this.view.setScreen(Names.MAIN_MENU);
		}
	}
	
	/**
	 * Event handler for when the user presses the next button on the GardenInfoScene
	 */
	public void onGardenInfoNext() {
		GardenInfoScene scene = (GardenInfoScene) this.view.getScene(Names.GARDEN_INFO);
		try {
			this.model.setLight(Integer.parseInt(scene.getSunlightTextfield().getText()));
			this.model.setRain(Integer.parseInt(scene.getRainTextfield().getText()));
			this.model.setSoilPH(Double.parseDouble(scene.getSoilPHTextfield().getText()));
			this.model.setTemperature(Integer.parseInt(scene.getTempTextfield().getText()));
			this.view.setScreen(Names.DRAW);
			this.view.drawMap(((DrawScene) view.getScene(Names.DRAW)).getCenter());
		} catch (NumberFormatException e) {
			this.view.showInvalidInputAlert();
		}
	}
	
	public void onPlantPlacementPrev() {
		this.view.setScreen(Names.GARDEN_INFO);
	}

	/**
	 * Event Handler for when the user presses the previous button on the
	 * Tutorialscene
	 */
	public void onTutorialPrev() {
		this.view.setScreen(Names.MAIN_MENU);
	}

	public void onDrawPrev() {
		this.view.setScreen(Names.GARDEN_INFO);
	}

	public void onDrawNext() {
		this.view.setScreen(Names.PLANT_PLACEMENT);
		this.view.drawMap(((PlantPlacementScene) view.getScene(Names.PLANT_PLACEMENT)).getCenter());
	}

	public void onDrawGrass() {
		DrawScene scene = (DrawScene) this.view.getScene(Names.DRAW);
		Grass grass = new Grass();
		scene.getCenter().getChildren().add(grass.getShape().getPolygon());
		this.model.addGardenObject(grass);
	}

	public void onDrawRoad() {
		DrawScene scene = (DrawScene) this.view.getScene(Names.DRAW);
		Road road = new Road();
		scene.getCenter().getChildren().add(road.getShape().getPolygon());
		this.model.addGardenObject(road);
	}

	public void onDrawStream() {
		DrawScene scene = (DrawScene) this.view.getScene(Names.DRAW);
		Stream stream = new Stream();
		scene.getCenter().getChildren().add(stream.getShape().getPolygon());
		this.model.addGardenObject(new Stream());
	}

	public void onDrawWoods() {
		DrawScene scene = (DrawScene) this.view.getScene(Names.DRAW);
		Woods woods = new Woods();
		scene.getCenter().getChildren().add(woods.getShape().getPolygon());
		this.model.addGardenObject(new Woods());
	}

	public void onDrawShader() {
		DrawScene scene = (DrawScene) this.view.getScene(Names.DRAW);
		Shade shade = new Shade();
		scene.getCenter().getChildren().add(shade.getShape().getPolygon());
		this.model.addGardenObject(shade);
	}

	public void onDrawDelete() {

	}

	/**
	 * Event handler for when the user presses the previous button on the TimesScene
	 */
	public void onTimesPrev() {
		this.view.setScreen(Names.PLANT_PLACEMENT);
	}

	/**
	 * Event Handler for when the user presses the next button on the TimesScene
	 */
	public void onTimesNext() {
		this.view.setScreen(Names.RATING);
	}

	/**
	 * Event handler for when the user selects a season radio button on the
	 * TimesScene
	 * 
	 * @param season the new season the garden is in
	 */
	public void onTimesSetSeason(Season season) {
		// to do: update model and update image view for garden
	}

	/**
	 * Event handler for when the user moves the age slider on the TimesScene
	 * 
	 * @param age the age in years of the garden to set to
	 */
	public void onTimesSetAge(double age) {
		// to do: update model and update image view for garden
	}

	/**
	 * Event Handler for when the user presses the previous button on the
	 * RatingScene
	 */
	public void onRatingPrev() {
		this.view.setScreen(Names.TIMES);
	}

	/**
	 * Event handler for when the user presses the save button on the RatingScene
	 */
	public void onRatingSave() {
		File file = this.view.showSaveDialog();
		if (file == null)
			return;

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
			out.writeObject(this.model);
			if (DEBUG)
				System.out.println("Object has been serialized to file: " + file.getPath());
			// to do: notify user successful save and move to load screen
		} catch (IOException ex) {
			// to do: notify user of saving error
			System.out.println("IOException is caught");
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
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
			Model model = (Model) in.readObject();
			if (DEBUG) {
				System.out.println("Object has been deserialized ");
				System.out.println("amount of light = " + model.getLight());
			}
			// to do: update the scenes with data from new model
			// load other gardens in the same directory to the loading scene
		} catch (IOException | ClassNotFoundException e) {
			// To do: add error handeling
			e.printStackTrace();
		}
	}

	public void onLoadingPrev() {
		this.view.setScreen(Names.MAIN_MENU);
	}

	public void onLoadingEdit() {
		this.view.setScreen(Names.GARDEN_INFO);
	}

	/**
	 * Uses user mouse input to move plant image around on screen
	 * 
	 * @param event - event triggered by mouse click
	 */
	public void drag(MouseEvent event) {
		Node n = (Node) event.getSource();
		if (DEBUG)
			System.out.println("ic mouse drag tx: " + n.getTranslateX() + ", ex: " + event.getX());
		model.setX(model.getX() + event.getX()); // event.getX() is the amount of horiz drag
		model.setY(model.getY() + event.getY());
		pps.setX(model.getX());
		pps.setY(model.getY());
	}

	public void makeCopy(MouseEvent event) {
		Node n = (Node) event.getSource();
		if (DEBUG)
			System.out.println("Copy made");
		ImageView iv2 = (ImageView) n;
	}

	public EventHandler<MouseEvent> getHandlerForDragEntered() {
		return event -> makeCopy((MouseEvent) event);
	}

	public EventHandler<MouseEvent> getHandlerForDrag() {
		return event -> drag((MouseEvent) event);
	}

	public double getStartingX() {
		return model.getX();
	}

	public double getStartingY() {
		return model.getY();
	}
	
	/**
	 * 
	 * @param object the object that will be loaded into the model
	 */
	public void addGardenObject(GardenObject object) {
		this.model.addGardenObject(object);
		System.out.println("Added object");
	}

	/**
	 * 
	 * @param object the object which will be stored in the Collection of GardenObjects in model, and will be placed in the universal scene
	 */
	public EventHandler<ActionEvent> createButtonAction(GardenObject object) {
		return new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Polygon polygon = object.getShape().getPolygon();
				System.out.println("Added object");
				model.addGardenObject(object);
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
	
	public Collection<GardenObject> loadMapObjects() {
		return model.getGardenObjects();
	}
}
