package org.example.repo.inMemoryRepo;

import org.example.model.Portfolio;
import org.example.repo.IRepository;

import java.util.ArrayList;

public class PortfolioRepository implements IRepository<Portfolio> {
    private ArrayList<Portfolio> portfolios;
    private static PortfolioRepository instance;

    private PortfolioRepository() {
        this.portfolios = new ArrayList<>();
    }

    @Override
    public ArrayList<Portfolio> getObjects() {
        return portfolios;
    }

    @Override
    public void save(Portfolio entity) {
        portfolios.add(entity);
    }

    @Override
    public void update(Portfolio entity) {

    }

    @Override
    public void delete(Portfolio object) {
        portfolios.remove(object);
    }


    public static PortfolioRepository getInstance() {
        if (instance == null) {
            instance = new PortfolioRepository();
        }
        return instance;
    }
}
