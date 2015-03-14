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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getPpi() {
        return ppi;
    }

    public void setPpi(float ppi) {
        this.ppi = ppi;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getColorChannels() {
        return colorChannels;
    }

    public void setColorChannels(int colorChannels) {
        this.colorChannels = colorChannels;
    }

    public int getColorDepth() {
        return colorDepth;
    }

    public void setColorDepth(int colorDepth) {
        this.colorDepth = colorDepth;
    }
}
