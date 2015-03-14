package mk.jug.pixmas.api;

import java.util.Arrays;

public class DisplayColor {
    
    private int[] colors;
       
    public DisplayColor(int channels) {
        colors = new int[channels];
    }
    
    public DisplayColor(int ... colors) {
        this.colors = Arrays.copyOf(colors, colors.length);
    }

    public int[] getColors() {
        return colors;
    }

    public void setColors(int[] colors) {
        this.colors = colors;
    }
    
    public void setChannelColor(int channel, int color) {
        colors[channel] = color;
    }

}
