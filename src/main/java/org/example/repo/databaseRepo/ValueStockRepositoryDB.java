package org.example.repo.databaseRepo;

import org.example.database.DBConnection;
import org.example.model.Company;
import org.example.model.GrowthStock;
import org.example.model.Market;
import org.example.model.ValueStock;
import org.example.repo.IRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ValueStockRepositoryDB implements IRepository<ValueStock> {
    private final Connection connection = DBConnection.getConnection();

    private static ValueStockRepositoryDB instance;
    private MarketRepositoryDB marketRepositoryDB;
    private CompanyRepositoryDB companyRepositoryDB;

    private ValueStockRepositoryDB() {
        this.marketRepositoryDB = MarketRepositoryDB.getInstance();
        this.companyRepositoryDB = CompanyRepositoryDB.getInstance();
    }

    public static ValueStockRepositoryDB getInstance() {
        if(instance == null) {
            instance = new ValueStockRepositoryDB();
        }
        return instance;
    }
    @Override
    public List<ValueStock> getObjects() {
        List<ValueStock> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM ValueStocks";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet results = statement.executeQuery();

            while(results.next())
            {
                int id = results.getInt("valueStockId");
                String name = results.getString("name");
                int company_id = results.getInt("CompanyId");
                int market_id = results.getInt("MarketId");
                double dividend_rate = results.getDouble("dividend_rate");

                Company company = companyRepositoryDB.searchId(company_id);
                Market market = marketRepositoryDB.searchId(market_id);
                result.add(new ValueStock(id,name,company,market,dividend_rate));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public void save(ValueStock entity) {
        int id = entity.getId();
        String name = entity.getName();
        int company = entity.getCompany().getId();
        int market = entity.getMarket().getId();
        double dividend_rate = entity.getDividend_rate();
        String query = "INSERT INTO ValueStocks (valueStockId, name, companyId, marketId, dividend_rate) VALUES (?, ?, ?, ?, ?)";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setInt(3, company);
            statement.setInt(4, market);
            statement.setDouble(5, dividend_rate);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(ValueStock entity) {
        int id = entity.getId();
        String name = entity.getName();
        int company = entity.getCompany().getId();
        int market = entity.getMarket().getId();
        double dividend_rate = entity.getDividend_rate();

        try {
            String query = "UPDATE ValueStocks SET name = ?, companyId = ?, marketId = ?, dividend_rate = ? WHERE valueStockId = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(5, id);
            statement.setString(1, name);
            statement.setInt(2, company);
            statement.setInt(3, market);
            statement.setDouble(4, dividend_rate);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(ValueStock object) {
        int id = object.getId();
        String query = "DELETE FROM ValueStocks WHERE valueStockId = ?";
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
