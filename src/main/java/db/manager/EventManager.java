package db.manager;

import db.DataBase.DBConnectionProvider;
import db.enums.Events;
import db.model.Event;
import db.model.User;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EventManager {

    private Connection connection;

    public EventManager(){
        connection = DBConnectionProvider.getInstance().getConnection();
    }

    public void addEvent(Event event) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("Insert into Event(name,place,isOnline,price,event_type) " +
                "Values(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, event.getName());
        preparedStatement.setString(2, event.getPlace());
        preparedStatement.setBoolean(3, event.isOnline());
        preparedStatement.setDouble(4, event.getPrice());
        preparedStatement.setString(5, event.getEvenType().name());
        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();

        if(resultSet.next()){
            int anInt = resultSet.getInt(1);
            event.setId(anInt);


        }
    }
    public List<Event> getAllEvents() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Event");
        List <Event> events = new LinkedList<>();
        while (resultSet.next()){
            Event event = new Event();
            event.setId(resultSet.getInt("id"));
            event.setName(resultSet.getString("name"));
            event.setPlace(resultSet.getString("place"));
            event.isOnline();
            event.setPrice(resultSet.getDouble("price"));
            event.getEvenType();
            events.add(event);
        }
        return events;
    }
}
