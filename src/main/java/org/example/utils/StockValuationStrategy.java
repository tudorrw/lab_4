package org.example.utils;

import org.example.model.Stock;

public interface StockValuationStrategy {
    double calculatePossibleProfit(Stock stock);
}
