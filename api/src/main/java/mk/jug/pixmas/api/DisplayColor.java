package mk.jug.pixmas.api;

public class DisplayColor {
    
    private int[] colors;
    
    public DisplayColor(int channels) {
        colors = new int[channels];
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
