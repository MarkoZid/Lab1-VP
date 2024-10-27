package mk.finki.ukim.mk.lab.services;

import mk.finki.ukim.mk.lab.models.Event;
import mk.finki.ukim.mk.lab.repository.EventRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements EventService {

    private final EventRepo eventRepo;

    public ServiceImpl(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    @Override
    public List<Event> listAll() {
        return eventRepo.getEvents();
    }

    @Override
    public List<Event> searchEvents(String text) {
        return eventRepo.search(text);
    }


}
