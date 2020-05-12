package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import mvc.View;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class TutorialScene extends Scene {

	private static final String HEADER_TEXT = "Tutorial";
	private static final String TUTORIAL_TEXT = "Please follow this short guide to help familiarize yourself with this program's features. If you already have a garden saved and want to edit it use the \"Save/Load\" button and select it with your file manager. Otherwise, select the \"New\" button to begin creating a garden.";

	private VBox container;
	private Label lblHeader;
	private Label lblText;
	private Button btnPrev;

	public TutorialScene() {
		super(new VBox());
		this.container = (VBox) this.getRoot();
		this.container.setMinWidth(View.WIDTH);
		this.container.setMinHeight(View.HEIGHT);
		this.lblHeader = new Label(HEADER_TEXT);
		this.lblHeader.setStyle(View.HEADER_LABEL_STYLE);
		this.lblHeader.setAlignment(Pos.CENTER);
		this.lblHeader.setMaxWidth(View.WIDTH);
		this.lblText = new Label(TUTORIAL_TEXT);
		this.lblText.setStyle(View.TEXT_LABEL_STYLE);
		this.lblText.setMaxWidth(View.WIDTH);
		this.lblText.setMaxHeight(View.HEIGHT);
		this.lblText.setTextAlignment(TextAlignment.CENTER);
		this.lblText.setWrapText(true);
		this.lblText.setBackground(View.BACKGROUND);
		this.lblText.setPadding(new Insets(View.SPACING));
		this.btnPrev = new Button(View.PREV_BUTTON_TEXT);
		this.btnPrev.setStyle(View.BUTTON_STYLE);
		this.btnPrev.setMaxWidth(Double.MAX_VALUE);
		this.btnPrev.setAlignment(Pos.CENTER);
		this.container.getChildren().addAll(this.lblHeader, this.lblText, this.btnPrev);
		VBox.setVgrow(this.lblText, Priority.ALWAYS);
	}

	public Label getTextLabel() {
		return this.lblText;
	}

	public Button getPrevButton() {
		return this.btnPrev;
	}
}
