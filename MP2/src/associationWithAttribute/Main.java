package associationWithAttribute;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // 1 Guest - * Bookings && 1 Hotel - * Bookings
        Guest guest1 = new Guest("AAA", "AAA");
        Guest guest2 = new Guest("BBB", "BBB");

        Hotel hotel1 = new Hotel("Baccarat Hotel", "New York, Fifth Avenue");
        Hotel hotel2 = new Hotel("Mandarin Oriental", "New York, Fifth Avenue");

        Booking booking1 = new Booking(2000, LocalDate.of(2020, 10, 1), 5, 10.0, hotel1, guest1);
        Booking booking2 = new Booking(3000, LocalDate.of(2020, 11, 3), 4, 0.0, hotel2, guest1);
        Booking booking3 = new Booking(5000, LocalDate.of(2020, 6, 4), 10, 0.0, hotel1, guest2);

        System.out.println(booking1 + "\n");
        System.out.println(booking2 + "\n");
        System.out.println(booking3 + "\n");
        System.out.println(hotel1 + "\n");
        System.out.println(guest1 + "\n");
    }
}
