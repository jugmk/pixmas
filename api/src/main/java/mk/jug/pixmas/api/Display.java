package mk.jug.pixmas.api;

public interface Display {
    
    DisplayCapabilities getCapabilities();
    
    DisplayColor getColor(int R, int G, int B);
    
    void setPixel(int X, int Y, DisplayColor displayColor);
    
    DisplayColor getPixel(int X, int Y);
    
    void clear();
    
    void refresh();
}
