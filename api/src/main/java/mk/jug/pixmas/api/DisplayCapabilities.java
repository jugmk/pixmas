package mk.jug.pixmas.api;

/**
 * Created by tdelev on 14.3.15.
 */
public class DisplayCapabilities {

  private int width;

  private int height;

  private float ppi;

  private float speed;

  private int colorChannels;

  private int colorDepth;

  public DisplayCapabilities(int width, int height, float ppi, float speed, int colorChannels, int colorDepth) {
    this.width = width;
    this.height = height;
    this.ppi = ppi;
    this.speed = speed;
    this.colorChannels = colorChannels;
    this.colorDepth = colorDepth;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public float getPpi() {
    return ppi;
  }

  public float getSpeed() {
    return speed;
  }

  public int getColorChannels() {
    return colorChannels;
  }

  public int getColorDepth() {
    return colorDepth;
  }

}
