package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import mvc.View;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class RatingScene extends Scene {

	static Group container = new Group();

	private BorderPane ratingSceneGroup;
	private HBox ratingbox;
	private FlowPane improveBox;

	public RatingScene() {
		super(new Group());
	}

	/**
	 * Creates the rating scene which displays a calculated rating for the user's
	 * constructed garden
	 */
	/*public RatingScene() {
		super(container);
		this.ratingSceneGroup = new BorderPane();
		this.ratingSceneGroup.setPadding(new Insets(View.mGap));
		this.ratingSceneGroup.setMinWidth(View.getCanvasWidth());
		this.ratingSceneGroup.setMinHeight(View.getCanvasHeight());
		container.getChildren().add(this.ratingSceneGroup);

		VBox left = new VBox();
		left.setAlignment(Pos.CENTER);
		left.setStyle("-fx-border-color: black");
		Text ratingText = new Text("Rating");
		ratingText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		left.getChildren().add(ratingText);
		this.ratingbox = new HBox();
		for (int i = 0; i < 5; i++) {
			ImageView iv = new ImageView(View.createImage("resources/star.png"));
			iv.setFitHeight(100);
			iv.setPreserveRatio(true);
			this.ratingbox.getChildren().add(iv);
		}
		left.getChildren().add(this.ratingbox);
		this.ratingSceneGroup.setLeft(left);

		VBox center = new VBox();
		center.setAlignment(Pos.TOP_CENTER);
		center.setStyle("-fx-border-color: black");
		Text improveText = new Text("Recommendations");
		improveText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
		center.getChildren().add(improveText);
		this.improveBox = new FlowPane();
		center.getChildren().add(this.improveBox);
		this.ratingSceneGroup.setCenter(center);

		Button saveLoadButton = createSaveLoadButton();
		
		Button mainMenuButton = createMainMenuButton();

		HBox buttonGroup = new HBox();
		buttonGroup.setAlignment(Pos.BOTTOM_CENTER);
		buttonGroup.setSpacing(View.mGap);
		
		Button prevButton = createPrevButton();
		
		buttonGroup.getChildren().add(prevButton);
		buttonGroup.getChildren().add(saveLoadButton);
		center.getChildren().add(buttonGroup);
		center.getChildren().add(saveLoadButton);
		center.getChildren().add(mainMenuButton);

		AnchorPane top = new AnchorPane();
		top.setPadding(new Insets(200, 410, 200, 410));
		Background background = new Background(new BackgroundFill(Color.FORESTGREEN, CornerRadii.EMPTY, Insets.EMPTY));
		top.setBackground(background);
		top.setStyle("-fx-border-color: black");
		this.ratingSceneGroup.setTop(top);

	}*/

	/*private Button createPrevButton() {
		Button prevButton = new Button("Prev");
		
		prevButton.setOnMouseClicked(event -> {
			View.getStage().setScene(View.getTimesScene());
		});
		return prevButton;
	}

	private Button createMainMenuButton() {
		Button mainMenuButton = new Button("Main Menu");

		EventHandler<ActionEvent> mainMenuButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				View.getStage().setScene(View.getMainMenuScene());
			}
		};

		mainMenuButton.setOnAction(mainMenuButtonAction);
		return mainMenuButton;
	}

	private Button createSaveLoadButton() {
		Button saveLoadButton = new Button("Save/Load");

		saveLoadButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				View.getStage().setScene(View.getLoadingScene());
			}
		});

		return saveLoadButton;
	}*/
}
