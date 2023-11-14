package org.example.repo;

import org.example.model.ValueStock;

import java.util.ArrayList;
import java.util.List;

public class ValueStockRepository implements IRepository<ValueStock>{
    private List<ValueStock> valueStocks;
    private static ValueStockRepository instance;

    private ValueStockRepository() {
        this.valueStocks = new ArrayList<>();
    }

    @Override
    public List<ValueStock> getObjects() {
        return valueStocks;
    }

    @Override
    public void save(ValueStock entity) {
        valueStocks.add(entity);
    }

    @Override
    public void delete(ValueStock object) {
        valueStocks.remove(object);
    }


    public static ValueStockRepository getInstance() {
        if (instance == null) {
            instance = new ValueStockRepository();
        }
        return instance;
    }
}
