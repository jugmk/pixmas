package mk.jug.pixmas.display;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import mk.jug.pixmas.api.Display;
import mk.jug.pixmas.api.DisplayCapabilities;
import mk.jug.pixmas.api.DisplayColor;

/**
 * Created by mite on 3/14/15.
 */
public class SimulatorDisplay implements Display {

  private final DisplayCapabilities displayCapabilities;
  private static final int radius = 8;
  private static final Color DEFAULT_COLOR = Color.BLANCHEDALMOND;
  private final GridPane gridpane;


  public SimulatorDisplay(DisplayCapabilities displayCapabilities) {
    this.displayCapabilities = displayCapabilities;
    gridpane = initialState(displayCapabilities, radius);
  }



  public static void main(String[] args) throws InterruptedException {
    SimulatorDisplay simulatorDisplay = new SimulatorDisplay(new DisplayCapabilities(10, 4, -1, 1, 1, 1));
    simulatorDisplay.doIt();
  }

  synchronized void doIt() throws InterruptedException {
    System.out.println("before");
    new Thread(() -> startApp(null)).start();

    wait(10000);

    System.out.println("after");

    setPixel(4, 3, new DisplayColor(0.5, 0.5, 0.5));
    wait(10000);

  }

  public void startApp(String[] args ) {

    DisplayCapabilities capabilities = getCapabilities();

    Utility.launchApp((app, primaryStage) -> {



      primaryStage.setWidth(capabilities.getWidth() * radius * 2 );
      primaryStage.setHeight(capabilities.getHeight() * radius * 2);
      primaryStage.setScene(new Scene(gridpane, 0, 0));
      primaryStage.setResizable(false);
      primaryStage.show();

    }, args);
  }

  private static GridPane initialState(DisplayCapabilities capabilities, int radius) {
    GridPane gridpane = new GridPane();
    for (int j = 0; j < capabilities.getHeight(); j++) {
      for (int i = 0; i < capabilities.getWidth(); i++) {

        Circle circle = new Circle(radius);

        circle.setFill(DEFAULT_COLOR);
        gridpane.add(circle, i, j);

      }
    }
    return gridpane;
  }

  @Override
  public DisplayCapabilities getCapabilities() {
    return displayCapabilities;
  }

  @Override
  public DisplayColor getColor(double R, double G, double B) {
    DisplayColor displayColor = new DisplayColor(3);
    displayColor.setChannelColor(0, R);
    displayColor.setChannelColor(1, G);
    displayColor.setChannelColor(2, B);
    return displayColor;
  }

  @Override
  public void setPixel(int x, int y, DisplayColor displayColor) {
    Platform.runLater(() -> {
        Circle circle = findCircle(x, y);
        double[] colors = displayColor.getColors();
        circle.setFill(new Color(colors[0], colors[1], colors[2], 1));
    });
  }

  private Circle findCircle(int x, int y) {
    Node node = gridpane.getChildren().get(y * getCapabilities().getWidth() + x);
    if (node instanceof Circle) {
      return (Circle) node;
    }
    return null;
  }


  private Color findColorFromComponent(int x, int y) {
    Paint paint = findCircle(x, y).getFill();
    if (paint instanceof Color) {
      return (Color) paint;
    }
    return null;
  }

  @Override
  public DisplayColor getPixel(int x, int y) {
    Color fill = findColorFromComponent(x, y);

    return new DisplayColor(fill.getRed(), fill.getGreen(), fill.getBlue());
  }

  @Override
  public void clear() {
    gridpane.getChildren().stream().filter(node -> node instanceof Circle).forEach(node -> {
      Circle circle = (Circle) node;
      circle.setFill(DEFAULT_COLOR);
    });

  }

  @Override
  public void refresh() {
  }
}
