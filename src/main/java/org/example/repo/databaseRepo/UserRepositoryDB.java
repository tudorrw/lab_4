package org.example.repo.databaseRepo;

import org.example.database.DBConnection;
import org.example.model.User;
import org.example.repo.IRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryDB implements IRepository<User> {

    public Connection connection = DBConnection.getConnection();

    private static UserRepositoryDB instance;

    public static UserRepositoryDB getInstance() {
        if(instance == null) {
            instance = new UserRepositoryDB();
        }
        return instance;
    }

    @Override
    public List<User> getObjects() {
        List<User> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM USERS";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet results = statement.executeQuery();

            while(results.next())
            {
                int id = results.getInt("userId");
                String username = results.getString("username");
                String password = results.getString("password");
                result.add(new User(id,username,password));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public void save(User user) {
        int id = user.getId();
        String username = user.getUsername();
        String password = user.getPassword();
        String query = "INSERT INTO Users (userId, username, password) VALUES (?, ?, ?)";
        try{
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        statement.setString(2, username);
        statement.setString(3, password);
        statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User entity) {
        int id = entity.getId();
        String username = entity.getUsername();
        String password = entity.getPassword();

        try {
            String query = "UPDATE Users SET username = ?, password = ? WHERE userId = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(User object) {
        int id = object.getId();
        String query = "DELETE FROM Users WHERE userId = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
