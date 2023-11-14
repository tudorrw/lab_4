package org.example.test2;

import org.example.model.GrowthStock;
import org.example.model.ValueStock;
import org.example.utils.strategy.GrowthStockValuationStrategy;
import org.example.utils.strategy.StockProfit;
import org.example.utils.strategy.ValueStockValuationStrategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;;

public class StrategyTest {
    @Test
    void calculate() {
        GrowthStock growthStock = new GrowthStock(1, "GrowthStock", 100, 1, 1, 10);
        ValueStock valueStock = new ValueStock(2, "ValueStock", 100, 2, 2, 0.2);

        StockProfit stockProfit = new StockProfit();
        stockProfit.setStrategy(new GrowthStockValuationStrategy());
        double profit = stockProfit.calculateProfit(growthStock);
        assertEquals(110.0, profit);

        stockProfit.setStrategy(new ValueStockValuationStrategy());
        profit = stockProfit.calculateProfit(valueStock);
        assertEquals(120.0, profit);
    }
}
