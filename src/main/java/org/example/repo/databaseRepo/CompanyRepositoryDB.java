package org.example.repo.databaseRepo;

import org.example.database.DBConnection;
import org.example.model.Company;
import org.example.model.Market;
import org.example.model.User;
import org.example.repo.IRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyRepositoryDB implements IRepository<Company> {
    public Connection connection = DBConnection.getConnection();

    public static CompanyRepositoryDB instance;

    public static CompanyRepositoryDB getInstance() {
        if(instance == null) {
            instance = new CompanyRepositoryDB();
        }
        return instance;
    }

    @Override
    public List<Company> getObjects() {
        List<Company> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM Companies";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet results = statement.executeQuery();

            while(results.next())
            {
                int id = results.getInt("companyId");
                String name = results.getString("name");
                long capitalization = results.getLong("capitalization");
                long numberShares = results.getLong("numberShares");
                result.add(new Company(id,name,capitalization,numberShares));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public void save(Company company) {
        int id = company.getId();
        String name = company.getName();
        long capitalization = company.getCapitalization();
        long numberShares =  company.getNumberShares();
        String query = "INSERT INTO Companies (companyId, name, capitalization, numberShares) VALUES (?, ?, ?, ?)";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setLong(3, capitalization);
            statement.setLong(4, numberShares);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Company entity) {
        int id = entity.getId();
        String name = entity.getName();
        long capitalization = entity.getCapitalization();
        long numberShares =  entity.getNumberShares();

        try {
            String query = "UPDATE Companies SET name = ?, capitalization = ?, numberShares = ?  WHERE companyId = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setLong(3, capitalization);
            statement.setLong(4, numberShares);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Company object) {
        int id = object.getId();
        String query = "DELETE FROM Companies WHERE companyId = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Company searchId(int id) {
        try {
            String query = "SELECT * FROM Companies WHERE companyId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet results = statement.executeQuery();
            if (results.next())
            {
                Company company = new Company(id,"",0,0);
                company.setName(results.getString("name"));
                company.setCapitalization(results.getLong("capitalization"));
                company.setNumberShares(results.getLong("numberShares"));
                return company;
            }
        }  catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
