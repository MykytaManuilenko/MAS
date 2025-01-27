package associationWithAttribute;

import java.time.LocalDate;

public class Booking {
    private double pricePerNight;
    private static final int MIN_NUM_OF_NIGHTS = 1;
    private int numberOfNights = MIN_NUM_OF_NIGHTS;
    private LocalDate dateFrom;
    private double discount;

    private Hotel hotel;
    private Guest guest;

    public Booking(double pricePerNight, LocalDate dateFrom, int numberOfNights, double discount, Hotel hotel, Guest guest) {
        this.pricePerNight = pricePerNight;
        this.dateFrom = dateFrom;
        this.numberOfNights = numberOfNights;
        this.discount = discount;
        
        setHotel(hotel);
        setGuest(guest);
    }

    public Booking(double pricePerNight, LocalDate dateFrom, double discount, Hotel hotel, Guest guest) {
        this.pricePerNight = pricePerNight;
        this.dateFrom = dateFrom;
        this.discount = discount;

        setHotel(hotel);
        setGuest(guest);
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    // total price
    public double getTotalPrice() {
        double totalPrice = pricePerNight * numberOfNights;
        return totalPrice - totalPrice * (discount / 100);
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        if (this.hotel == hotel) return;

        if (this.hotel != null) {
            this.hotel.removeBooking(this);
        }

        this.hotel = hotel;

        if (hotel != null) {
            hotel.addBooking(this);
        }
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        if (this.guest == guest) return;

        if (this.guest != null) {
            this.guest.removeBooking(this);
        }

        this.guest = guest;

        if (guest != null) {
            guest.addBooking(this);
        }
    }

    @Override
    public String toString() {
        return "Guest [" + guest.getFirstName() + " " + guest.getLastName() + "] lives in Hotel [" + hotel.getName() + "]";
    }
}
