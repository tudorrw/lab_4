package org.example.repo.databaseRepo;

import org.example.database.DBConnection;
import org.example.model.Admin;
import org.example.model.Company;
import org.example.model.GrowthStock;
import org.example.model.Market;
import org.example.repo.IRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GrowthStockRepositoryDB implements IRepository<GrowthStock> {
    private final Connection connection = DBConnection.getConnection();

    public static GrowthStockRepositoryDB instance;
    private MarketRepositoryDB marketRepositoryDB;
    private CompanyRepositoryDB companyRepositoryDB;

    public GrowthStockRepositoryDB() {
        this.marketRepositoryDB = MarketRepositoryDB.getInstance();
        this.companyRepositoryDB = CompanyRepositoryDB.getInstance();
    }

    public static GrowthStockRepositoryDB getInstance() {
        if(instance == null) {
            instance = new GrowthStockRepositoryDB();
        }
        return instance;
    }

    @Override
    public List<GrowthStock> getObjects() {
        List<GrowthStock> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM GrowthStocks";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet results = statement.executeQuery();

            while(results.next())
            {
                int id = results.getInt("id");
                String name = results.getString("name");
                int company_id = results.getInt("CompanyId");
                int market_id = results.getInt("MarketId");
                int growth_rate = results.getInt("GrowthRate");

                Company company = companyRepositoryDB.searchId(company_id);
                Market market = marketRepositoryDB.searchId(company_id);
                result.add(new GrowthStock(id,name,company,market,growth_rate));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public void save(GrowthStock growthStock) {
        int id = growthStock.getId();
        String name = growthStock.getName();
        int company = growthStock.getCompany().getId();
        int market = growthStock.getmarket().getId();
        int growth_rate = growthStock.getGrowth_rate();
        String query = "INSERT INTO GrowthStocks (id, name, company, market, growth_rate) VALUES (?, ?, ?, ?, ?)";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setInt(3, company);
            statement.setInt(4, market);
            statement.setInt(5, growth_rate);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(GrowthStock entity) {
        int id = entity.getId();
        String name = entity.getName();
        int company = entity.getCompany().getId();
        int market = entity.getmarket().getId();
        int growth_rate = entity.getGrowth_rate();

        try {
            String query = "UPDATE GrowthStocks SET name = ?, company = ?, market = ?, growth_rate = ? WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(5, id);
            statement.setString(1, name);
            statement.setInt(2, company);
            statement.setInt(3, market);
            statement.setInt(4, growth_rate);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(GrowthStock object) {
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
