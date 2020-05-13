package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import mvc.View;

import java.awt.*;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class MainMenuScene extends Scene {

	private static final String NEW_BUTTON_TEXT = "New";
	private static final String HELP_BUTTON_TEXT = "Help";
	private static final String LOAD_BUTTON_TEXT = "Load";
	private static final String CREDITS_TEXT = "Jason H, Hamza M, Ntsee N, Haseeb S, Jonathan Z";

	private BorderPane container;
	private Label title, credits;
	private Button btnNew, btnHelp, btnLoad;

	public MainMenuScene() {
		super(new BorderPane());
		this.container = (BorderPane) this.getRoot();
		this.container.setMinWidth(View.WIDTH);
		this.container.setMinHeight(View.HEIGHT);
		this.title = new Label(View.TITLE);
		this.title.setStyle(View.TITLE_LABEL_STYLE);
		this.btnNew = this.createButton(NEW_BUTTON_TEXT);
		this.btnHelp = this.createButton(HELP_BUTTON_TEXT);
		this.btnLoad = this.createButton(LOAD_BUTTON_TEXT);
		this.credits = new Label(CREDITS_TEXT);
		this.container.setStyle(View.TEXT_LABEL_STYLE);

		HBox buttons = new HBox();
		buttons.setBackground(View.BACKGROUND);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(View.WIDTH / 8f);
		buttons.getChildren().addAll(this.btnNew, this.btnHelp, this.btnLoad);

		this.container.setTop(this.title);
		this.container.setCenter(buttons);
		this.container.setBottom(this.credits);

		BorderPane.setAlignment(this.title, Pos.CENTER);
		BorderPane.setAlignment(buttons, Pos.CENTER);
		BorderPane.setAlignment(this.credits, Pos.CENTER);
	}

	private Button createButton(String text) {
		Button btn = new Button(text);
		btn.setStyle(View.BUTTON_STYLE);
		return btn;
	}

	public Button getNewButton() {
		return this.btnNew;
	}

	public Button getHelpButton() {
		return this.btnHelp;
	}

	public Button getLoadButton() {
		return this.btnLoad;
	}
}
