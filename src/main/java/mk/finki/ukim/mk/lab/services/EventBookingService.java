package mk.finki.ukim.mk.lab.services;

import mk.finki.ukim.mk.lab.models.EventBooking;

public interface EventBookingService {

    EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets);


}
