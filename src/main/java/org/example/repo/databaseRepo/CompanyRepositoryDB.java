package org.example.repo.databaseRepo;

import org.example.database.DBConnection;
import org.example.model.Company;
import org.example.repo.IRepository;

import java.sql.Connection;
import java.util.List;

public class CompanyRepositoryDB implements IRepository<Company> {
    public Connection connection = DBConnection.getConnection();
    @Override
    public List<Company> getObjects() {
        return null;
    }

    @Override
    public void save(Company entity) {

    }

    @Override
    public void update(Company entity) {

    }

    @Override
    public void delete(Company object) {

    }
}
