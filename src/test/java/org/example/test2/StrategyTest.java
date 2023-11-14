package org.example.test2;

import org.example.model.GrowthStock;
import org.example.model.ValueStock;
import org.example.utils.GrowthStockValuationStrategy;
import org.example.utils.StockProfit;
import org.example.utils.StockValuationStrategy;
import org.example.utils.ValueStockValuationStrategy;

public class StrategyTest {
    public static void main(String[] args) {
        GrowthStock growthStock = new GrowthStock(1, "GrowthStock", 100, 1, 1, 10);
        ValueStock valueStock = new ValueStock(2, "ValueStock", 100, 2, 2, 2);

        StockProfit stockProfit = new StockProfit();
        stockProfit.setStrategy(new GrowthStockValuationStrategy());
        double profit = stockProfit.calculateProfit(growthStock);
        System.out.println(profit);

        stockProfit.setStrategy(new ValueStockValuationStrategy());
        profit = stockProfit.calculateProfit(valueStock);
        System.out.println(profit);
    }
}
