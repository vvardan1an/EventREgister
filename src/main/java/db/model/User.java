package db.model;

import db.enums.Events;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String surname;
    private String email;
    private int eventsId;

    public User(String name, String surname, String email, int eventsId) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.eventsId = eventsId;
    }
}
