package Abstract;

public abstract class Device {
    private String name;
    private double price;
    private int quantity;
    private OperatingSystem operatingSystem;

    public Device(String name, double price, int quantity, OperatingSystem operatingSystem) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.operatingSystem = operatingSystem;
    }

    public abstract double getFullPrice();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(OperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        return "Device{" +
                "name=" + name  +
                ", price=" + price +
                ", quantity=" + quantity +
                ", operatingSystem=" + operatingSystem;
    }
}
