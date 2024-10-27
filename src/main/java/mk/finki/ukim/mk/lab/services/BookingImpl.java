package mk.finki.ukim.mk.lab.services;

import mk.finki.ukim.mk.lab.models.EventBooking;
import mk.finki.ukim.mk.lab.repo.BookingRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingImpl implements EventBookingService {

    private final BookingRepo bookingRepo;

    public BookingImpl(BookingRepo bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets) {
        EventBooking a = new EventBooking(eventName, attendeeName, attendeeAddress, (long) numberOfTickets);
        this.bookingRepo.add(a);
        return a;
    }

    public List<EventBooking> bookingList(String name) {

        return bookingRepo.getConfirm(name);
    }

    public List<EventBooking> userBookingList(String name) {
        return bookingRepo.getConfirm(name);
    }


}
