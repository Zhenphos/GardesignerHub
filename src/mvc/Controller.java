package mvc;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;

/**
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
		System.out.println("Hello");
		launch(args);
	}

	private Model gardenModel;

	private View view;
	
	public Controller() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param arg0 - the stage that the garden is displayed on
	 */
	@Override
	public void start(Stage theStage) throws Exception {
		view = new View(theStage);
		gardenModel = new Model(view.getCanvasWidth(), view.getCanvasHeight());
		theStage.show();
	}

}
