package mk.finki.ukim.mk.lab.models;

import lombok.Data;

@Data
public class Event {

    private String name;
    private String description;
    private Double popularityScore;


    public Event(String name, Double popularityScore, String description) {
        this.name = name;
        this.popularityScore = popularityScore;
        this.description = description;
    }
}
