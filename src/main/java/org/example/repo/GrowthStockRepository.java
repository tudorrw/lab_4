package org.example.repo;

import org.example.model.GrowthStock;
import org.example.model.ValueStock;

import java.util.ArrayList;
import java.util.List;

public class GrowthStockRepository implements IRepository<GrowthStock> {
    private List<GrowthStock> growthStocks;
    private static GrowthStockRepository instance;

    private GrowthStockRepository() {
        this.growthStocks = new ArrayList<>();
    }

    @Override
    public List<GrowthStock> getObjects() {
        return growthStocks;
    }

    @Override
    public void save(GrowthStock entity) {
        growthStocks.add(entity);
    }

    @Override
    public void delete(GrowthStock object) {
        growthStocks.remove(object);
    }

    public static GrowthStockRepository getInstance() {
        if (instance == null) {
            instance = new GrowthStockRepository();
        }
        return instance;
    }
}
