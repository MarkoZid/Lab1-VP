package mk.finki.ukim.mk.lab.repo;

import mk.finki.ukim.mk.lab.models.EventBooking;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingRepo {

    private List<EventBooking> bookings;

    public BookingRepo(List<EventBooking> bookings) {
        this.bookings = bookings;
    }

    public void add(EventBooking eventBooking) {
        this.bookings.add(eventBooking);
    }

    public List<EventBooking> getBookings() {
        return bookings;
    }

    public List<EventBooking> getConfirm(String name) {

        return bookings.stream().filter(i->i.getAttendeeName().equals(name)).toList();
    }
}
