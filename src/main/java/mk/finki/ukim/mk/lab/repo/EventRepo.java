package mk.finki.ukim.mk.lab.repository;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.models.Event;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EventRepo {

    private List<Event> events = new ArrayList<>();

    @PostConstruct
    public void init()
    {
        this.events.add(new Event("Marko", 10.2, "gas"));
        this.events.add(new Event("Zidar", 14.3, "gas"));
        this.events.add(new Event("finki", 10.12, "gas"));
        this.events.add(new Event("ukim", 3.2, "gas"));
        this.events.add(new Event("swsw", 2.1, "gas"));
        this.events.add(new Event("wddqwecfwe", 1.1, "gas"));
        this.events.add(new Event("Madwd", 3.2, "gas"));
        this.events.add(new Event("Madwd", 2.1, "gas"));
        this.events.add(new Event("dw", 10.1, "gas"));
        this.events.add(new Event("Marko", 1.3, "gas"));

    }

    public List<Event> getEvents() {
        return events;
    }

    public List<Event> search(String name) {

        return events.stream().filter(i->i.getName().contains(name) ||
                i.getDescription().contains(name)).toList();

    }

    public List<Event> search2(String name, double amount) {

        return events.stream().filter(i->i.getName().contains(name) ||
                i.getDescription().contains(name) && i.getPopularityScore() >= amount).toList();

    }








}
