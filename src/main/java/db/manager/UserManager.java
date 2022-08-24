package db.manager;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import db.DataBase.DBConnectionProvider;
import db.model.User;

public class UserManager {

    private Connection connection;

    public UserManager(){
        connection = DBConnectionProvider.getInstance().getConnection();
    }

    public void addUser(User user) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("Insert into User(name,surname,email,event_id) Values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1,user.getName());
        preparedStatement.setString(2,user.getSurname());
        preparedStatement.setString(3,user.getEmail());
        preparedStatement.setInt(4, user.getEventsId());
        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();

        if(resultSet.next()){
            int anInt = resultSet.getInt(1);
            user.setId(anInt);


        }

    }
    public List<User> getAllUsers() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM User");
        List <User> users = new LinkedList<>();
        while (resultSet.next()){
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));
            user.setEmail(resultSet.getString("email"));
            user.setEventsId(resultSet.getInt("event_id"));
            users.add(user);
        }
        return users;
    }
}
