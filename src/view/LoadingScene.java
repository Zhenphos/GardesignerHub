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
import mvc.View;

import java.io.File;
import java.text.SimpleDateFormat;

/**
 * 
 * @author Jonathan, Ntsee, Hamza, Haseeb, Jason
 *
 */

public class LoadingScene extends Scene {

	private static final String HEADER_TEXT = "Load a Garden";

	private BorderPane container;
	private Label lblHeader;
	private Pane gardenPane;
	private TableView<Save> saves;
	private Button btnBrowse;
	private Button btnPrev, btnEdit;

	public LoadingScene() {
		super(new BorderPane());
		this.container = (BorderPane) this.getRoot();
		this.container.setMinSize(View.WIDTH, View.HEIGHT);
		this.lblHeader = new Label(HEADER_TEXT);
		this.lblHeader.setStyle(View.HEADER_LABEL_STYLE);
		this.lblHeader.setMaxWidth(Double.MAX_VALUE);
		this.lblHeader.setAlignment(Pos.CENTER);
		this.gardenPane = new Pane();
		this.gardenPane.setBackground(View.BACKGROUND);
		// table
		this.saves = new TableView<>();
		this.saves.setMaxHeight(Double.MAX_VALUE);
		TableColumn<Save, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		this.saves.getColumns().add(nameColumn);
		TableColumn<Save, String> dateColumn = new TableColumn<>("Date");
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
		this.saves.getColumns().add(dateColumn);
		this.container.setLeft(this.saves);

		this.btnBrowse = new Button(View.BROWSE_BUTTON_TEXT);
		this.btnBrowse.setStyle(View.BUTTON_STYLE);
		this.btnBrowse.setMaxWidth(Double.MAX_VALUE);
		this.btnPrev = new Button(View.PREV_BUTTON_TEXT);
		this.btnPrev.setStyle(View.BUTTON_STYLE);
		this.btnPrev.setMaxWidth(Double.MAX_VALUE);
		this.btnEdit = new Button(View.EDIT_BUTTON_TEXT);
		this.btnEdit.setStyle(View.BUTTON_STYLE);
		this.btnEdit.setMaxWidth(Double.MAX_VALUE);

		this.container.setTop(this.lblHeader);
		this.container.setCenter(this.gardenPane);

		VBox left = new VBox(this.btnBrowse, this.saves);
		this.container.setLeft(left);
		VBox.setVgrow(this.saves, Priority.ALWAYS);

		HBox buttons = new HBox(this.btnPrev, this.btnEdit);
		HBox.setHgrow(this.btnPrev, Priority.ALWAYS);
		HBox.setHgrow(this.btnEdit, Priority.ALWAYS);
		this.container.setBottom(buttons);
	}

	public Button getBrowseButton() { return this.btnBrowse; }

	public TableView<Save> getSaves() {
		return this.saves;
	}

	public Button getPrevButton() {
		return this.btnPrev;
	}

	public Button getEditButton() {
		return this.btnEdit;
	}

	public void addTableEntry(File file) {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Save save = new Save(file.getName(), format.format(file.lastModified()));
		this.saves.getItems().add(save);
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
}
