package Abstract;

public class Smartphone extends Device {
    private boolean module5G;

    public Smartphone(String name, double price, int quantity, OperatingSystem operatingSystem, boolean module5G) {
        super(name, price, quantity, operatingSystem);
        this.module5G = module5G;
    }

    public boolean isModule5G() {
        return module5G;
    }

    public void setModule5G(boolean module5G) {
        this.module5G = module5G;
    }

    @Override
    public double getFullPrice() {
        return super.getPrice() * super.getQuantity() + (this.module5G ? 500 : 0);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + (this.module5G ? "there is" : "no") + " module 5G" + '}';
    }
}
