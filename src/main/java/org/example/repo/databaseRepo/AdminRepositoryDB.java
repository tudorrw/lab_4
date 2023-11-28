package org.example.repo.databaseRepo;

import org.example.database.DBConnection;
import org.example.model.Admin;
import org.example.model.AdminRole;
import org.example.model.User;
import org.example.repo.IRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminRepositoryDB implements IRepository<Admin> {
    public Connection connection = DBConnection.getConnection();

    public static AdminRepositoryDB instance;

    public static AdminRepositoryDB getInstance() {
        if(instance == null) {
            instance = new AdminRepositoryDB();
        }
        return instance;
    }

    @Override
    public List<Admin> getObjects() {
        List<Admin> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM Admins";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet results = statement.executeQuery();

            while(results.next())
            {
                int id = results.getInt("id");
                String username = results.getString("username");
                String password = results.getString("password");
                String adminRole = results.getString("adminRole");
                result.add(new Admin(id,username,password,adminRole));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public void save(Admin admin) {
        int id = admin.getId();
        String username = admin.getUsername();
        String password = admin.getPassword();
        String adminRole = admin.getAdminRole();
        String query = "INSERT INTO Admins (id, username, password, adminRole) VALUES (?, ?, ?, ?)";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, username);
            statement.setString(3, password);
            statement.setString(4, adminRole);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Admin entity) {
        int id = entity.getId();
        String username = entity.getUsername();
        String password = entity.getPassword();
        String adminRole = entity.getAdminRole();

        try {
            String query = "UPDATE Admins SET username = ?, password = ?, adminRole = ? WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, adminRole);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Admin object) {
        int id = object.getId();
        String query = "DELETE FROM Admins WHERE id = ?";
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
