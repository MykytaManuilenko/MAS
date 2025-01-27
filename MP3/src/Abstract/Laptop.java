package Abstract;

public class Laptop extends Device {
    private boolean touchScreen;

    public Laptop(String name, double price, int quantity, OperatingSystem operatingSystem, boolean touchScreen) {
        super(name, price, quantity, operatingSystem);
        this.touchScreen = touchScreen;
    }

    public boolean isTouchScreen() {
        return touchScreen;
    }

    public void setTouchScreen(boolean touchScreen) {
        this.touchScreen = touchScreen;
    }

    @Override
    public double getFullPrice() {
        return super.getPrice() * super.getQuantity() + (this.touchScreen ? 1000 : 0);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + (this.touchScreen ? "there is" : "no") + " touch screen" + '}';
    }
}
