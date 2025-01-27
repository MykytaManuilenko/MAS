package MultiAspect;

public class Main {
    public static void main(String[] args) {
        OwnCar ownCar = new OwnCar("Honda", "Civic", "LX", 4, 15000);
        System.out.println(ownCar);

        ownCar.setNumberOfSeats(5);
        System.out.println(ownCar + "\n");

        try {
            ownCar.setLimitCapacity(15.000);
        } catch (Error error) {
            System.err.println(error);
        }
    }
}
