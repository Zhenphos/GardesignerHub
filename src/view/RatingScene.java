package view;

import enums.Season;
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

	private static final String HEADER_TEXT = "Evaluation";
	private static final String RATING_TEXT = "Rating";
	private static final String RECOMMENDATIONS_TEXT = "Recommendations";

	private BorderPane container;
	private Label lblHeader;
	private Pane gardenPane;
	private Label lblRating, lblRecommendations, lblRecommendText;
	private FlowPane stars;
	private Button btnPrev, btnSave;

	public RatingScene() {
		super(new BorderPane());
		this.container = (BorderPane) this.getRoot();
		this.container.setMinSize(View.WIDTH, View.HEIGHT);
		this.lblHeader = new Label(HEADER_TEXT);
		this.lblHeader.setStyle(View.HEADER_LABEL_STYLE);
		this.lblHeader.setMaxWidth(Double.MAX_VALUE);
		this.lblHeader.setAlignment(Pos.CENTER);
		this.gardenPane = new Pane();
		this.gardenPane.setBackground(View.BACKGROUND);
		this.lblRating = new Label(RATING_TEXT);
		this.lblRating.setStyle(View.TEXT_LABEL_STYLE);
		this.lblRating.setMaxWidth(Double.MAX_VALUE);
		this.lblRating.setAlignment(Pos.CENTER);
		this.lblRecommendations = new Label(RECOMMENDATIONS_TEXT);
		this.lblRecommendations.setStyle(View.TEXT_LABEL_STYLE);
		this.lblRecommendations.setMaxWidth(Double.MAX_VALUE);
		this.lblRecommendations.setAlignment(Pos.CENTER);
		this.lblRecommendText = new Label();
		this.lblRecommendText.setStyle(View.TEXT_LABEL_STYLE);
		this.lblRecommendText.setWrapText(true);
		this.stars = new FlowPane();
		this.stars.setAlignment(Pos.CENTER);
		this.btnPrev = new Button(View.PREV_BUTTON_TEXT);
		this.btnPrev.setStyle(View.BUTTON_STYLE);
		this.btnPrev.setMaxWidth(Double.MAX_VALUE);
		this.btnSave = new Button(View.SAVE_BUTTON_TEXT);
		this.btnSave.setStyle(View.BUTTON_STYLE);
		this.btnSave.setMaxWidth(Double.MAX_VALUE);

		VBox ratings = new VBox(this.lblRating, this.stars);
		VBox recommends = new VBox(this.lblRecommendations, this.lblRecommendText);
		HBox options = new HBox(ratings, recommends);
		HBox.setHgrow(ratings, Priority.ALWAYS);
		HBox.setHgrow(recommends, Priority.ALWAYS);
		HBox buttons = new HBox(this.btnPrev, this.btnSave);
		HBox.setHgrow(this.btnPrev, Priority.ALWAYS);
		HBox.setHgrow(this.btnSave, Priority.ALWAYS);
		VBox center = new VBox(this.gardenPane, options);
		VBox.setVgrow(this.gardenPane, Priority.ALWAYS);

		this.container.setTop(this.lblHeader);
		this.container.setCenter(center);
		this.container.setBottom(buttons);
		this.setRating(5);

	}

	public void setRating(int rating) {
		this.stars.getChildren().clear();
		for (int i=0; i<rating; i++) {
			ImageView imageView = new ImageView(View.STAR_IMAGE);
			imageView.setFitHeight(View.HEIGHT / 8f);
			imageView.setPreserveRatio(true);
			this.stars.getChildren().add(imageView);
		}
	}

	public Button getPrevButton() {
		return this.btnPrev;
	}

	public Button getSaveButton() {
		return this.btnSave;
	}

}
