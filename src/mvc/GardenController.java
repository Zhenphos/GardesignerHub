package mvc;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class GardenController extends Application {
	/**
	 * the main method for the program
	 * 
	 * @param args - an array of strings
	 */
	public static void main(String[] args) {
		System.out.println("Hello");
		launch(args);
	}

	private GardenModel model;

	private View view;
	
	public GardenController() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param arg0 - the stage that the garden is displayed on
	 */
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub

	}

}
