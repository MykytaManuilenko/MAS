package MultiAspect;

public class OwnCar extends Car {
    private double price;

    public OwnCar(String brand, String model, String trimLevel, int numberOfSeats, double price) {
        super(brand, model, trimLevel, numberOfSeats);
        this.price = price;
    }

    public OwnCar(String brand, String model, String trimLevel, double limitCapacity, double price) {
        super(brand, model, trimLevel, limitCapacity);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return super.toString().replace("Car", "OwnCar").replace("}", ", price=" + this.price) + "}";
    }
}
