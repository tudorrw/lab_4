package org.example.repo;

import org.example.model.Market;

import java.util.ArrayList;
import java.util.List;

public class MarketRepository implements IRepository<Market> {
    private List<Market> markets;

    void insert_values() {
        Market usMarket = new Market(1, "US Stock Market", "New York");
        Market euMarket = new Market(2, "EU Stock Market", "London");
        markets.add(usMarket);
        markets.add(euMarket);
    }
    public MarketRepository() {

        this.markets = new ArrayList<>();
        insert_values();
    }

    @Override
    public List<Market> getObjects() {
        return markets;
    }

    @Override
    public void save(Market entity) {
        markets.add(entity);
    }

    @Override
    public void delete(Market object) {
        markets.remove(object);
    }
}
