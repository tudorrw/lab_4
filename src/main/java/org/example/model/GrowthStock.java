package org.example.model;

public class GrowthStock extends Stock{
    private int growth_rate;

    public GrowthStock(int id, String name, int price, int companyId, int marketId, int growth_rate) {
        super(id, name, price, companyId, marketId);
        this.growth_rate = growth_rate;
    }

    public int getGrowth_rate() {
        return growth_rate;
    }

    public void setGrowth_rate(int growth_rate) {
        this.growth_rate = growth_rate;
    }
}

