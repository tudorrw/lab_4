package org.example.repo.databaseRepo;

import org.example.database.DBConnection;
import org.example.model.Market;
import org.example.model.User;
import org.example.repo.IRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarketRepositoryDB implements IRepository<Market> {

    public Connection connection = DBConnection.getConnection();

    public static MarketRepositoryDB instance;

    public static MarketRepositoryDB getInstance() {
        if(instance == null) {
            instance = new MarketRepositoryDB();
        }
        return instance;
    }

    @Override
    public List<Market> getObjects() {
        List<Market> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM Markets";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet results = statement.executeQuery();

            while(results.next())
            {
                int id = results.getInt("marketId");
                String name = results.getString("name");
                String location = results.getString("location");
                result.add(new Market(id,name,location));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public void save(Market market) {
        int id = market.getId();
        String name = market.getName();
        String location = market.getLocation();
        String query = "INSERT INTO Markets (marketId, name, location) VALUES (?, ?, ?)";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, location);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Market entity) {
        int id = entity.getId();
        String name = entity.getName();
        String location = entity.getLocation();

        try {
            String query = "UPDATE Markets SET name = ?, location = ? WHERE marketId = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, location);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Market object) {
        int id = object.getId();
        String query = "DELETE FROM Markets WHERE marketId = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Market searchId(int id){
        try {
            String query = "SELECT * FROM Markets WHERE marketId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet results = statement.executeQuery();
            if (results.next())
            {
                Market market = new Market(id,"","");
                market.setName(results.getString("name"));
                return market;
            }
        }  catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
