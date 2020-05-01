package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import mvc.Controller;
import mvc.View;

import java.io.File;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class LoadingScene extends Scene {

	private static Group loadingSceneGroup = new Group();

	private BorderPane container;
	private Button btnSave;
	private Button btnLoad;
	private Button backButton;
	private TableView<Save> saves;

	private Canvas canvas;
	private FlowPane infoBox;

	public LoadingScene() {
		super(loadingSceneGroup);
		this.container = new BorderPane();
		this.container.setPadding(new Insets(View.mGap));
		this.container.setMinWidth(View.getCanvasWidth());
		this.container.setMinHeight(View.getCanvasHeight());
		loadingSceneGroup.getChildren().add(this.container);

		this.btnSave = new Button("Save");
		this.btnSave.setMaxWidth(Double.MAX_VALUE);

		this.btnLoad = new Button("Load");
		this.btnLoad.setMaxWidth(Double.MAX_VALUE);

		this.backButton = new Button("BACK");
		this.backButton.setMaxWidth(Double.MAX_VALUE);

		HBox buttonGroup = new HBox(this.backButton, this.btnSave, this.btnLoad);
		HBox.setHgrow(this.backButton, Priority.ALWAYS);
		HBox.setHgrow(this.btnSave, Priority.ALWAYS);
		HBox.setHgrow(this.btnLoad, Priority.ALWAYS);

		buttonGroup.setAlignment(Pos.CENTER);
		buttonGroup.setSpacing(10);

		// "BACK" Button event handler
		EventHandler<ActionEvent> backButtonAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				View.getStage().setScene(View.getMainMenuScene());
			}
		};

		// "BACK" Button on click action
		backButton.setOnAction(backButtonAction);

		this.saves = new TableView<>();
		TableColumn<Save, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		this.saves.getColumns().add(nameColumn);
		TableColumn<Save, String> dateColumn = new TableColumn<>("Date");
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
		this.saves.getColumns().add(dateColumn);
		this.container.setLeft(this.saves);

		VBox left = new VBox();
		left.setPadding(new Insets(10));
		left.setSpacing(10);
		left.getChildren().addAll(buttonGroup, this.saves);
		left.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.container.setLeft(left);
		this.container.setMargin(left, new Insets(0, View.mGap, 0, 0));

		Pane canvasContainer = new Pane();
		this.canvas = new Canvas(400, 400);
		canvasContainer.getChildren().add(this.canvas);
		canvasContainer.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		this.infoBox = new FlowPane();
		VBox fileInfoGroup = new VBox();
		fileInfoGroup.getChildren().addAll(new Label("File Info: "), this.infoBox);
		fileInfoGroup.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.infoBox.getChildren().add(new Label("Use the buttons on the left and either load or save a file."));

		// TODO move the save/load to a Pane at the top so users can save/load anytime

		VBox center = new VBox();
		center.getChildren().addAll(canvasContainer, fileInfoGroup);
		center.setSpacing(View.mGap);
		VBox.setVgrow(fileInfoGroup, Priority.ALWAYS);
		this.container.setCenter(center);

	}

	public Button getSaveButton() {
		return this.btnSave;
	}

	public Button getLoadButton() {
		return this.btnLoad;
	}

	public static class Save {

		private SimpleStringProperty name;
		private SimpleStringProperty date;

		public Save(String name, String date) {
			this.name = new SimpleStringProperty(name);
			this.date = new SimpleStringProperty(date);
		}

		public String getName() {
			return this.name.get();
		}

		public String getDate() {
			return this.date.get();
		}
	}

	public Button getBackButton() {
		return backButton;
	}
}
