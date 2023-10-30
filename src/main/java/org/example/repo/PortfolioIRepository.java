package org.example.repo;

import org.example.model.Portfolio;

import java.util.ArrayList;
import java.util.List;

public class PortfolioIRepository implements IRepository<Portfolio> {
    private List<Portfolio> portfolios;

    public PortfolioIRepository() {
        this.portfolios = new ArrayList<>();
    }

    @Override
    public List<Portfolio> getObjects() {
        return portfolios;
    }

    @Override
    public void save(Portfolio entity) {
        portfolios.add(entity);
    }

    @Override
    public void delete(Portfolio object) {
        portfolios.remove(object);
    }
}
