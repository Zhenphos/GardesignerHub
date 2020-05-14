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

public class Anchor extends Circle implements Serializable {
	
	private final DoubleProperty x, y;
    ArrayList<Anchor> anchors = new ArrayList<>();

    public void setCommon(ArrayList<Anchor> anchors) {
        this.anchors = anchors;
    }

    public void addAnchor(Anchor anchor) {
        anchors.add(anchor);
        enableDrag();
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
        enableDrag();
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

            anchor.layoutXProperty().bind(shape.layoutXProperty());
            anchor.layoutYProperty().bind(shape.layoutYProperty());

            anchors.add(anchor);
        }
        return anchors;
    }

    private void enableDrag() {
        final Delta dragDelta = new Delta();
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                dragDelta.x = getCenterX() - mouseEvent.getX();
                dragDelta.y = getCenterY() - mouseEvent.getY();
                getScene().setCursor(Cursor.MOVE);
            }
        });
        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                getScene().setCursor(Cursor.HAND);
            }
        });
        setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                double newX = mouseEvent.getX() + dragDelta.x;
                if (newX > 0 && newX < getScene().getWidth()) {
                    setCenterX(newX);
                    if (anchors != null) {
                        for (Anchor anchor : anchors) {
                            anchor.setCenterX(newX);
                            System.out.println("CALLED");
                        }
                    }
                }
                double newY = mouseEvent.getY() + dragDelta.y;
                if (newY > 0 && newY < getScene().getHeight()) {
                    setCenterY(newY);
                    if (anchors != null) {
                        for (Anchor anchor : anchors) {
                            anchor.setCenterY(newY);
                        }
                    }
                }
            }
        });
        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (!mouseEvent.isPrimaryButtonDown()) {
                    getScene().setCursor(Cursor.HAND);
                }
            }
        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (!mouseEvent.isPrimaryButtonDown()) {
                    getScene().setCursor(Cursor.DEFAULT);
                }
            }
        });
    }

    private class Delta {
        double x, y;
    }
}
