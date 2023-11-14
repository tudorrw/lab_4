package org.example.repo;

import org.example.model.Company;

import java.util.ArrayList;
import java.util.List;

public class CompanyRepository implements IRepository<Company> {
    private List<Company> companies;
    void insert_values() {
        Company apple = new Company(1, "Apple Inc.", 2_000_000_000);
        Company boeing = new Company(2, "Boeing", 1_200_000_000);
        Company intel = new Company(3, "Intel", 250_000_000);
        companies.add(apple);
        companies.add(boeing);
        companies.add(intel);
    }
    public CompanyRepository() {

        this.companies = new ArrayList<>();
        insert_values();
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
