package org.example.model;

import java.util.List;

public class Portfolio {
    private int id;
    private int userId;
    private double cash;
    private List<Integer> idStocks;

    public Portfolio(int id, int userId, double cash, List<Integer> idStocks) {
        this.id = id;
        this.userId = userId;
        this.cash = cash;
        this.idStocks = idStocks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public List<Integer> getIdStocks() {
        return idStocks;
    }

    public void setIdStocks(List<Integer> idStocks) {
        this.idStocks = idStocks;
    }
}