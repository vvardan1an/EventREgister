package db.model;

import db.enums.Events;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private int id;
    private String name;
    private String place;
    private boolean isOnline;
    private double price;
    private Events evenType;

    public Event(String name, String place, boolean isOnline, double price, Events evenType) {
        this.name = name;
        this.place = place;
        this.isOnline = isOnline;
        this.price = price;
        this.evenType = evenType;
    }
}
