package Abstract;

public class Main {
    public static void main(String[] args) {
        Device laptop1 = new Laptop("Surface Laptop 4", 1000, 1, OperatingSystem.MICROSOFT_WINDOWS, false);
        System.out.println(laptop1);
        System.out.println(laptop1.getFullPrice());

        System.out.println();

        Device laptop2 = new Laptop("Surface Laptop 4", 1000, 1, OperatingSystem.MICROSOFT_WINDOWS, true);
        System.out.println(laptop2);
        System.out.println(laptop2.getFullPrice());
    }
}
