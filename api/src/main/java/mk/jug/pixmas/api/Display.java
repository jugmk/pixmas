package mk.jug.pixmas.api;

public interface Display {

  DisplayCapabilities getCapabilities();

  DisplayColor getColor(double R, double G, double B);

  void setPixel(int X, int Y, DisplayColor displayColor);

  DisplayColor getPixel(int X, int Y);

  void clear();

}
