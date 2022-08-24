import db.enums.Events;
import db.manager.EventManager;
import db.manager.UserManager;
import db.model.Event;
import db.model.User;

import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

        UserManager userManager = new UserManager();
        EventManager eventManager = new EventManager();

        Event event = new Event("Concert", "Erevan", true, 50.0, Events.Concert);
        eventManager.addEvent(event);
        Event event1 = new Event("Business", "France", true, 50.0, Events.Business);
        eventManager.addEvent(event1);
        Event event2 = new Event("International", "London", true, 50.0, Events.International);
        eventManager.addEvent(event2);

        List <Event> allEvent = eventManager.getAllEvents();
        for(Event events : allEvent){
            System.out.println(events);
        }


        userManager.addUser(new User("David", "Johnson", "dav@gmail.com", 1));
        userManager.addUser(new User("Mark", "Doe", "doe@gmail.com", 3));
        userManager.addUser(new User("Frank", "Smith", "frgmail.com", 2));
        
        List<User> allUser = userManager.getAllUsers();
        for (User user : allUser) {
            System.out.println(user);

        }
    }
}
