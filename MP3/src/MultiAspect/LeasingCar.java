package MultiAspect;

public class LeasingCar extends Car {
    private double leasingInstallment;

    public LeasingCar(String brand, String model, String trimLevel, int numberOfSeats) {
        super(brand, model, trimLevel, numberOfSeats);
    }

    public LeasingCar(String brand, String model, String trimLevel, double limitCapacity) {
        super(brand, model, trimLevel, limitCapacity);
    }

    public double getLeasingInstallment() {
        return leasingInstallment;
    }

    public void setLeasingInstallment(double leasingInstallment) {
        this.leasingInstallment = leasingInstallment;
    }

    @Override
    public String toString() {
        return super.toString().replace("Car", "LeasingCar").replace("}", ", leasing installment=" + this.leasingInstallment) + "}";
    }
}
