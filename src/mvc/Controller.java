package mvc;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import view.MovingImageView;
import view.PlantInfoScene;
import view.PlantPlacementScene;

import java.io.File;
import java.util.ArrayList;

/**
 * Controller class for Garden Planner
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class Controller extends Application {
	/**
	 * the main method for the program
	 * 
	 * @param args - an array of strings
	 */
	public static void main(String[] args) {
		launch(args);
	}

	private Model gardenModel;

	private View view;
	private MovingImageView miv;
	
	private final boolean DEBUG = true;
	ArrayList<ImageView> ivs = new ArrayList<ImageView>();
	
	public Controller() {
		//TODO put something here?
	}
	
	public Controller(MovingImageView miv) {
		this.miv = miv;
		gardenModel = new Model(View.getCanvasHeight(), View.getCanvasWidth());
		if (DEBUG) System.out.println("ic created");
	}
	
	/**
	 * @param theStage - the stage that the garden is displayed on
	 */
	@Override
	public void start(Stage theStage) throws Exception {
		view = new View(theStage, this);
		gardenModel = new Model(View.getCanvasHeight(), View.getCanvasWidth());
		theStage.show();
	}

	/**
	 * Saves the current garden project to a file
	 * 
	 * @param file - the file to be saved
	 */
	public void saveFile(File file) {
		System.out.println(file);
	}

	/**
	 * Loads a saved garden project from a file
	 * 
	 * @param file - the garden project to be loaded
	 */
	public void loadFile(File file) {
		System.out.println(file);
	}

	/**
	 * Uses user mouse input to move plant image around on screen
	 * 
	 * @param event - event triggered by mouse click
	 */
	public void drag(MouseEvent event) {
		Node n = (Node)event.getSource();
		if (DEBUG) System.out.println("ic mouse drag tx: " + n.getTranslateX() + ", ex: " + event.getX() );
		gardenModel.setX(gardenModel.getX() + event.getX()); //event.getX() is the amount of horiz drag
		gardenModel.setY(gardenModel.getY() + event.getY());
		miv.setX(gardenModel.getX());
		miv.setY(gardenModel.getY());
		//n.setTranslateX(n.getTranslateX() + event.getX()); //not MVC! what problem does this create?
		//n.setTranslateY(n.getTranslateY() + event.getY());
	}
	
	public EventHandler<MouseEvent> getHandlerForDrag() {
		return event -> drag((MouseEvent) event);
	}

	public double getStartingX() {
		return gardenModel.getX();
	}
	public double getStartingY() {
		return gardenModel.getY();
	}
}
