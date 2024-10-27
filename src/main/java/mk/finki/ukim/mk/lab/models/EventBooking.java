package mk.finki.ukim.mk.lab.models;

import lombok.Data;

@Data
public class EventBooking {

    private String eventName;
    private String attendeeName;
    private String attendeeAddres;
    private Long numOfTickets;


    public EventBooking(String eventName, String attendeeName, String attendeeAddres, Long numOfTickets) {
        this.eventName = eventName;
        this.attendeeName = attendeeName;
        this.attendeeAddres = attendeeAddres;
        this.numOfTickets = numOfTickets;
    }
}
