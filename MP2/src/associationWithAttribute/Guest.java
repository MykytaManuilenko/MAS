package associationWithAttribute;

import java.util.ArrayList;
import java.util.List;

public class Guest {
    private String firstName;
    private String lastName;

    private List<Booking> bookings = new ArrayList<>();

    public Guest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking newBooking) {
        if (newBooking == null) {
            throw new NullPointerException("Booking can not be null");
        } else if (!this.bookings.contains(newBooking)) {
            this.bookings.add(newBooking);
            newBooking.setGuest(this);;
        }
    }

    public void removeBooking(Booking booking) {
        if (bookings.contains(booking)) {
            bookings.remove(booking);
            booking.setGuest(null);
        }
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("Guest " + this.firstName + " " + this.lastName + " has booked such hotels as:\n");

        for (Booking b : bookings) {
            info.append(" ").append(b.getHotel().getName()).append(" and paid: ").append(b.getTotalPrice()).append("\n");
        }

        return info.toString();
    }
}
