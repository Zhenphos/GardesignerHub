package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import mvc.View;

/**
 *
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class GardenInfoScene extends Scene {

	private static final String INPUT_HEADER_TEXT = "Information Input";
	private static final String INPUT_DESCRIPTION_HEADER_TEXT = "Description";
	private static final String WIDTH_TEXT = "Width (ft):";
	private static final String LENGTH_TEXT = "LENGTH (ft):";
	private static final String SUNLIGHT_LABEL_TEXT = "Hours of Sunlight: ";
	private static final String RAIN_LABEL_TEXT = "Amount of Rain (millimeters):";
	private static final String SOIL_LABEL_TEXT = "Soil pH:";
	private static final String TEMP_LABEL_TEXT = "Temperature (Fahrenheit):";

	private static final String DEFAULT_INFO = "Please enter some information about your garden in the boxes to the left. It will help us calculate the optimal garden design for you.";
	private static final String WIDTH_INFO = "The \"Width\" is the total width of your garden in feet. This must be entered to continue. If you're not sure, a good starting value is 10.";
	private static final String LENGTH_INFO = "The \"Length\" is the total length of your garden in feet. This must be entered to continue. If you're not sure, a good starting value is 10.";
	private static final String SUNLIGHT_INFO = "The \"Hours of Sunlight\" is the hours of light your garden experiences on an average day.";
	private static final String RAIN_INFO = "The \"Amount of Rain\" is how much rain your garden experiences in an average week in millimeters.";
	private static final String SOIL_INFO = "The \"Soil pH\" is how acidic or basic your soil is on the pH scale. " + "The ideal pH of your soil is 6.5.";
	private static final String TEMPERATURE_INFO = "The \"Temperature\" is the average temperature the land the land the garden will be on has experienced in the past week, in Fahrenheit.";

	private HBox container;
	private Label lblInputHeader, lblWidth, lblLength, lblSunlight, lblRain, lblTemp, lblSoilPH;
	private Label lblDescriptionHeader, lblDescription;
	private TextField tfWidth, tfLength, tfSunlight, tfRain, tfSoilPH, tfTemp;
	private Button btnNext, btnPrev;

	public GardenInfoScene() {
		super(new HBox());
		this.container = (HBox) this.getRoot();
		this.container.setMinWidth(View.WIDTH);
		this.container.setMinHeight(View.HEIGHT);
		this.lblInputHeader = this.createHeader(INPUT_HEADER_TEXT);
		this.lblInputHeader.setMaxWidth(Double.MAX_VALUE);
		this.lblWidth = this.createLabel(WIDTH_TEXT);
		this.lblLength = this.createLabel(LENGTH_TEXT);
		this.lblSunlight = this.createLabel(SUNLIGHT_LABEL_TEXT);
		this.lblRain = this.createLabel(RAIN_LABEL_TEXT);
		this.lblSoilPH = this.createLabel(SOIL_LABEL_TEXT);
		this.lblTemp = this.createLabel(TEMP_LABEL_TEXT);
		this.lblDescriptionHeader = this.createHeader(INPUT_DESCRIPTION_HEADER_TEXT);
		this.lblDescriptionHeader.setMaxWidth(Double.MAX_VALUE);
		this.lblDescription = this.createLabel(DEFAULT_INFO);
		this.lblDescription.setWrapText(true);
		this.lblDescription.setMaxHeight(Double.MAX_VALUE);
		this.lblDescription.setTextAlignment(TextAlignment.CENTER);
		this.lblDescription.setBackground(View.BACKGROUND);
		this.lblDescription.setPadding(new Insets(View.SPACING));
		this.tfWidth = this.createTextField(WIDTH_INFO);
		this.tfLength = this.createTextField(LENGTH_INFO);
		this.tfSunlight = this.createTextField(SUNLIGHT_INFO);
		this.tfRain = this.createTextField(RAIN_INFO);
		this.tfSoilPH = this.createTextField(SOIL_INFO);
		this.tfTemp = this.createTextField(TEMPERATURE_INFO);
		this.btnNext = this.createButton(View.NEXT_BUTTON_TEXT);
		this.btnNext.setMaxWidth(Double.MAX_VALUE);
		this.btnPrev = this.createButton(View.PREV_BUTTON_TEXT);
		this.btnPrev.setMaxWidth(Double.MAX_VALUE);

		VBox inputs = new VBox();
		inputs.getChildren().addAll(this.lblWidth, this.tfWidth, this.lblLength, this.tfLength, this.lblSunlight, this.tfSunlight, this.lblRain, this.tfRain, this.lblSoilPH, this.tfSoilPH, this.lblTemp, this.tfTemp);
		inputs.setAlignment(Pos.CENTER);
		inputs.setSpacing(View.SPACING);
		inputs.setBackground(View.BACKGROUND);
		inputs.setPadding(new Insets(View.SPACING));
		VBox leftSide = new VBox(this.lblInputHeader, inputs, this.btnPrev);
		leftSide.setMaxWidth(View.WIDTH / 2f);
		VBox.setVgrow(inputs, Priority.ALWAYS);

		VBox rightSide = new VBox(this.lblDescriptionHeader, this.lblDescription, this.btnNext);
		rightSide.setMaxWidth(View.WIDTH / 2f);
		VBox.setVgrow(this.lblDescription, Priority.ALWAYS);
		this.container.getChildren().addAll(leftSide, rightSide);

		HBox.setHgrow(leftSide, Priority.ALWAYS);
		HBox.setHgrow(rightSide, Priority.ALWAYS);
	}

	private Label createHeader(String text) {
		Label label = new Label(text);
		label.setStyle(View.HEADER_LABEL_STYLE);
		label.setAlignment(Pos.CENTER);
		return label;
	}

	private Label createLabel(String text) {
		Label label = new Label(text);
		label.setStyle(View.TEXT_LABEL_STYLE);
		return label;
	}

	private TextField createTextField(String description) {
		TextField textField = new TextField();
		textField.setStyle(View.TEXT_FIELD_STYLE);
		textField.focusedProperty().addListener(((observable, oldValue, newValue) -> {
			if (!newValue) {
				lblDescription.setText(DEFAULT_INFO);
				return;
			}
			lblDescription.setText(description);
		}));
		return textField;
	}

	private Button createButton(String text) {
		Button btn = new Button(text);
		btn.setStyle(View.BUTTON_STYLE);
		return btn;
	}

	public Label getDescriptionLabel() {
		return this.lblDescription;
	}

	public TextField getWidthTextfield() {
		return this.tfWidth;
	}

	public TextField getHeightTextfield() {
		return this.tfLength;
	}

	public TextField getSunlightTextfield() {
		return this.tfSunlight;
	}

	public TextField getRainTextfield() {
		return this.tfRain;
	}

	public TextField getSoilPHTextfield() {
		return this.tfSoilPH;
	}

	public TextField getTempTextfield() {
		return this.tfTemp;
	}

	public Button getNextButton() {
		return this.btnNext;
	}

	public Button getPrevButton() {
		return this.btnPrev;
	}

	public void clearTextFields() {
		this.tfWidth.clear();
		this.tfHeight.clear();
		this.tfSunlight.clear();
		this.tfRain.clear();
		this.tfSoilPH.clear();
		this.tfTemp.clear();
	}
}
