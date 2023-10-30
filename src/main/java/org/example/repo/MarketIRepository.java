package org.example.repo;

import org.example.model.Market;

import java.util.ArrayList;
import java.util.List;

public class MarketIRepository implements IRepository<Market> {
    private List<Market> markets;

    public MarketIRepository() {
        this.markets = new ArrayList<>();
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
