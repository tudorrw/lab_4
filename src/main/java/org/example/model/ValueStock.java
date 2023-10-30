package org.example.model;

public class ValueStock extends Stock{
    private int dividend_rate;

    public ValueStock(int id, String name, int price, Company company, Market market, int dividend_rate) {
        super(id, name, price, company, market);
        this.dividend_rate = dividend_rate;
    }

    public int getDividend_rate() {
        return dividend_rate;
    }

    public void setDividend_rate(int dividend_rate) {
        this.dividend_rate = dividend_rate;
    }
}
