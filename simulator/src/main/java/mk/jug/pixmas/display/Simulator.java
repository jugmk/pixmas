package mk.jug.pixmas.display;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Stater Application for simulator
 */
public class Simulator extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    SimulatorDisplay simulatorDisplay = new SimulatorDisplay();
    SimulatorDefaultCapabilities capabilities = simulatorDisplay.getCapabilities();
    int radius = 8;
    primaryStage.setWidth(capabilities.getWidth() * radius * 3);
    primaryStage.setHeight(capabilities.getHeight() * radius * 3);


    GridPane gridpane = new GridPane();
    for (int i = 0; i < capabilities.getWidth(); i++) {
      for (int j = 0; j < capabilities.getHeight(); j++) {
        Circle circle = new Circle(radius);
        circle.setFill(new Color(0.5, 0.0, 0.0, 1));
        gridpane.add(circle, i, j);
      }

    }

    primaryStage.setScene(new Scene(gridpane, 0, 0));
    primaryStage.setResizable(false);
    primaryStage.show();
  }

}
