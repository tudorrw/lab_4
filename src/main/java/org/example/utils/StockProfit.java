package org.example.utils;

import org.example.model.Stock;

public class StockProfit {
    private StockValuationStrategy strategy;

    public void setStrategy(StockValuationStrategy strategy) {
        this.strategy = strategy;
    }
    public double calculateProfit(Stock stock){
        return strategy.calculatePossibleProfit(stock);
    }
}
