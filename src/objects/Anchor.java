package objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeType;
import mvc.Controller;

public class Anchor extends Circle implements Serializable {
	
	private final DoubleProperty x, y;
    ArrayList<Anchor> anchors = new ArrayList<>();

    public void setCommon(ArrayList<Anchor> anchors) {
        this.anchors = anchors;
    }

    public void addAnchor(Anchor anchor) {
        anchors.add(anchor);
        Controller.anchorDragBehavior(this);
    }

    Anchor(Color color, DoubleProperty x, DoubleProperty y) {
        super(x.get(), y.get(), 10);
        setFill(color.deriveColor(1, 1, 1, 0.5));
        setStroke(color);
        setStrokeWidth(2);
        setStrokeType(StrokeType.OUTSIDE);

        this.x = x;
        this.y = y;

        x.bind(centerXProperty());
        y.bind(centerYProperty());
        Controller.anchorDragBehavior(this);
    }
    
	/**
	 * Adds anchors to a polygon
	 * 
	 * @param polygon The polygon which will have anchors added to it
	 * @param points The points of the polygon
	 * @return An ObservableList with all the anchors stored inside of them
	 */
    public static ObservableList<Anchor> createAnchors(Polygon shape, final ObservableList<Double> points) {
        ObservableList<Anchor> anchors = FXCollections.observableArrayList();
        
        for (int i = 0; i < points.size(); i += 2) {
        	final int idx = i;
            
        	DoubleProperty xProperty = new SimpleDoubleProperty(points.get(i));
        	DoubleProperty yProperty = new SimpleDoubleProperty(points.get(i + 1));

        	xProperty.addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> ov, Number oldX, Number x) {
                    points.set(idx, (double) x);
                }
            });

            yProperty.addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> ov, Number oldY, Number y) {
                    points.set(idx + 1, (double) y);
                }
            });
            Anchor anchor = new Anchor(Color.GOLD, xProperty, yProperty);
            
            if (shape.layoutXProperty() != null && shape.layoutYProperty() != null) {
	            anchor.layoutXProperty().bind(shape.layoutXProperty());
	            anchor.layoutYProperty().bind(shape.layoutYProperty());
            }
            
            anchors.add(anchor);
        }
        return anchors;
    }
}
