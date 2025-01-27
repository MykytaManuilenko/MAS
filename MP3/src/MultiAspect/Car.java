package MultiAspect;

import java.util.EnumSet;

public class Car {
    // attributes for Car
    private String brand;
    private String model;
    private String trimLevel;

    // attributes for Passenger car
    private int numberOfSeats;

    // attributes for Truck
    private double limitCapacity;

    private EnumSet<CarType> types = EnumSet.of(CarType.CAR);

    // Constructor for Passenger car
    public Car(String brand, String model, String trimLevel, int numberOfSeats) {
        this.brand = brand;
        this.model = model;
        this.trimLevel = trimLevel;
        this.numberOfSeats = numberOfSeats;

        this.types.add(CarType.PASSENGER_CAR);
    }

    // Constructor for Truck
    public Car(String brand, String model, String trimLevel, double limitCapacity) {
        this.brand = brand;
        this.model = model;
        this.trimLevel = trimLevel;
        this.limitCapacity = limitCapacity;

        this.types.add(CarType.LORRY);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTrimLevel() {
        return trimLevel;
    }

    public void setTrimLevel(String trimLevel) {
        this.trimLevel = trimLevel;
    }

    // method for Passenger car
    public int getNumberOfSeats() {
        if (types.contains(CarType.PASSENGER_CAR)) {
            return numberOfSeats;
        } else {
            throw new Error("This car is not a passenger car");
        }
    }

    // method for Passenger car
    public void setNumberOfSeats(int numberOfSeats) {
        if (types.contains(CarType.PASSENGER_CAR)) {
            this.numberOfSeats = numberOfSeats;
        } else {
            throw new Error("This car is not a passenger car");
        }
    }

    // method for Truck
    public double getLimitCapacity() {
        if (types.contains(CarType.LORRY)) {
            return limitCapacity;
        } else {
            throw new Error("This car is not a lorry");
        }
    }

    // method for Truck
    public void setLimitCapacity(double limitCapacity) {
        if (types.contains(CarType.LORRY)) {
            this.limitCapacity = limitCapacity;
        } else {
            throw new Error("This car is not a lorry");
        }
    }

    @Override
    public String toString() {
        String carInfo = "Car{brand=" + this.brand + ", model=" + this.model + ", trim level=" + this.trimLevel;

        if (types.contains(CarType.PASSENGER_CAR) && (!types.contains(CarType.LORRY))) {
            carInfo += ", (passenger car) number of seats=" + this.numberOfSeats + "}";
        }

        if (types.contains(CarType.LORRY) && (!types.contains(CarType.PASSENGER_CAR))) {
            carInfo += ", (lorry) limit capacity=" + this.limitCapacity + "}";
        }

        return carInfo;
    }
}
