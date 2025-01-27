package associationWithAttribute;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private String address;

    private List<Booking> bookings = new ArrayList<>();

    public Hotel(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking newBooking) {
        if (newBooking == null) {
            throw new NullPointerException("Booking can not be null");
        } else if (!this.bookings.contains(newBooking)) {
            this.bookings.add(newBooking);
            newBooking.setHotel(this);
        }
    }

    public void removeBooking(Booking booking) {
        if (bookings.contains(booking)) {
            bookings.remove(booking);
            booking.setHotel(null);
        }
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("Hotel " + this.name + " has been booked by:\n");

        for (Booking b : bookings) {
            info.append(" ").append(b.getGuest().getLastName()).append("\n");
        }

        return info.toString();
    }
}
