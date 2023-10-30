package org.example.model;

public class Portfolio {
    private User user;
    private int cash;
    private Stock[] stocks;

    public Portfolio(User user, int cash, Stock[] stocks) {
        this.user = user;
        this.cash = cash;
        this.stocks = stocks;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public Stock[] getStocks() {
        return stocks;
    }

    public void setStocks(Stock[] stocks) {
        this.stocks = stocks;
    }
}