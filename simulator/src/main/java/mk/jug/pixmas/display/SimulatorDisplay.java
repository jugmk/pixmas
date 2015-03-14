package mk.jug.pixmas.display;


import javafx.scene.paint.Color;

import java.awt.*;

/**
 * Simulated display of screen.
 */
public class SimulatorDisplay {

  public SimulatorDefaultCapabilities getCapabilities() {
    return new SimulatorDefaultCapabilities(15, 15);
  }

  public void setColor(Color color) {

  }

  public void setPixel(Color color, Point point) {

  }

  public Color getPixel(Point point) {

    return null;
  }

  public void clear() {

  }

  public void refresh() {

  }


}
