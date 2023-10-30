package org.example.repo;

import org.example.model.GrowthStock;

import java.util.ArrayList;
import java.util.List;

public class GrowthStockIRepository implements IRepository<GrowthStock> {
    private List<GrowthStock> growthStocks;

    public GrowthStockIRepository() {
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
}
