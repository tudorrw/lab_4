package org.example.model;

public class Stock {
    private int id;
    private String name;
    private int price;
    private Company company;
    private Market market;

    public Stock(int id, String name, int price, Company company_, Market market_) {
        this.id = id;
        this.name = name;
        this.price = price;
        company = company_;
        market = market_;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company_) {
        company = company_;
    }

    public Market getmarket() {
        return market;
    }

    public void setMarket(Market market_) {
        market = market_;
    }
}
