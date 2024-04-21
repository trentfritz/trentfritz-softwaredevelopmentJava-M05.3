import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ColorSelector extends Application {
    private ScrollBar redBar = new ScrollBar();
    private ScrollBar greenBar = new ScrollBar();
    private ScrollBar blueBar = new ScrollBar();
    private ScrollBar opacityBar = new ScrollBar();
    private Text text = new Text("JavaFX Color Selector");

    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(5);

        // Initialize scroll bars
        redBar.setMin(0);
        redBar.setMax(255);
        greenBar.setMin(0);
        greenBar.setMax(255);
        blueBar.setMin(0);
        blueBar.setMax(255);
        opacityBar.setMin(0);
        opacityBar.setMax(100);

        // Set default values for bars
        redBar.setValue(0);
        greenBar.setValue(0);
        blueBar.setValue(0);
        opacityBar.setValue(100);

        // Set up text
        text.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        // Event handling for scroll bars
        redBar.valueProperty().addListener((observable, oldValue, newValue) -> updateColor());
        greenBar.valueProperty().addListener((observable, oldValue, newValue) -> updateColor());
        blueBar.valueProperty().addListener((observable, oldValue, newValue) -> updateColor());
        opacityBar.valueProperty().addListener((observable, oldValue, newValue) -> updateColor());

        // Add components to the pane
        pane.add(new Label("Red:"), 0, 0);
        pane.add(redBar, 1, 0);
        pane.add(new Label("Green:"), 0, 1);
        pane.add(greenBar, 1, 1);
        pane.add(new Label("Blue:"), 0, 2);
        pane.add(blueBar, 1, 2);
        pane.add(new Label("Opacity:"), 0, 3);
        pane.add(opacityBar, 1, 3);
        pane.add(text, 0, 4, 2, 1);

        // Set up scene and stage
        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("Color Selector");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Update text color based on scroll bar values
    private void updateColor() {
        double red = redBar.getValue() / 255;
        double green = greenBar.getValue() / 255;
        double blue = blueBar.getValue() / 255;
        double opacity = opacityBar.getValue() / 100;
        text.setFill(new Color(red, green, blue, opacity));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
