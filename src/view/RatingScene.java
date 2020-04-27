package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import mvc.View;

public class RatingScene extends Scene {

    static Group container = new Group();

    private BorderPane root;
    private HBox ratingbox;
    private FlowPane improveBox;

    public RatingScene() {
        super(container);
        this.root = new BorderPane();
        this.root.setPadding(new Insets(10));
        container.getChildren().add(this.root);

        VBox left = new VBox();
        left.setAlignment(Pos.CENTER);
        left.setStyle("-fx-border-color: black");
        Text ratingText = new Text("Rating");
        ratingText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        left.getChildren().add(ratingText);
        this.ratingbox = new HBox();
        for (int i=0; i<5; i++) {
            ImageView iv = new ImageView(new Image("resources/star.png"));
            iv.setFitHeight(100);
            iv.setPreserveRatio(true);
            this.ratingbox.getChildren().add(iv);
        }
        left.getChildren().add(this.ratingbox);
        this.root.setLeft(left);

        VBox center = new VBox();
        center.setAlignment(Pos.CENTER);
        center.setStyle("-fx-border-color: black");
        Text improveText = new Text("How to Improve");
        improveText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        center.getChildren().add(improveText);
        this.improveBox = new FlowPane();
        center.getChildren().add(this.improveBox);
        this.root.setCenter(center);

        HBox buttonGroup = new HBox();
        buttonGroup.setAlignment(Pos.CENTER);
        buttonGroup.setSpacing(10);
        Button btnPrev = new Button("Previous");
        btnPrev.setOnMouseClicked(event -> {
            View.getStage().setScene(View.getTimesScene());
        });
        buttonGroup.getChildren().add(btnPrev);
        center.getChildren().add(buttonGroup);


        AnchorPane top = new AnchorPane();
        top.setPadding(new Insets(200, 410, 200, 410));
        Background background = new Background(new BackgroundFill(Color.FORESTGREEN, CornerRadii.EMPTY, Insets.EMPTY));
        top.setBackground(background);
        top.setStyle("-fx-border-color: black");
        this.root.setTop(top);

    }
}
