package mk.finki.ukim.mk.lab.services;

import mk.finki.ukim.mk.lab.models.Event;

import java.util.List;

public interface EventService {

    List<Event> listAll();
    List<Event> searchEvents(String text);

}
