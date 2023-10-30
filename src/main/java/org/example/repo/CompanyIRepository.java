package org.example.repo;

import org.example.model.Company;

import java.util.ArrayList;
import java.util.List;

public class CompanyIRepository implements IRepository<Company> {
    private List<Company> companies;

    public CompanyIRepository() {
        this.companies = new ArrayList<>();
    }

    @Override
    public List<Company> getObjects() {
        return companies;
    }

    @Override
    public void save(Company entity) {
        companies.add(entity);
    }

    @Override
    public void delete(Company object) {
        companies.remove(object);
    }
}