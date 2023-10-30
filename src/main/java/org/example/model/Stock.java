package org.example.model;

public class Stock {
    private int id;
    private String name;
    private int price;
    private int CompanyId;
    private int MarketId;

    public Stock(int id, String name, int price, int companyId, int marketId) {
        this.id = id;
        this.name = name;
        this.price = price;
        CompanyId = companyId;
        MarketId = marketId;
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

    public int getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(int companyId) {
        CompanyId = companyId;
    }

    public int getMarketId() {
        return MarketId;
    }

    public void setMarketId(int marketId) {
        MarketId = marketId;
    }
}
