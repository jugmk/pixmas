package mk.jug.pixmas.api;

import java.util.Arrays;

public class DisplayColor {
    
    private double[] colors;
       
    public DisplayColor(int channels) {
        colors = new double[channels];
    }
    
    public DisplayColor(double... colors) {
        this.colors = Arrays.copyOf(colors, colors.length);
    }

    public double[] getColors() {
        return colors;
    }

    public void setColors(double[] colors) {
        this.colors = colors;
    }
    
    public void setChannelColor(int channel, double color) {
        colors[channel] = color;
    }
}
