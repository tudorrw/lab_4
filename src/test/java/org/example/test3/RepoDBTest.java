package org.example.test3;
import org.example.database.DBConnection;
import org.example.model.Company;
import org.example.repo.IRepository;
import org.example.repo.databaseRepo.CompanyRepositoryDB;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RepoDBTest {

    private IRepository<Company> companyIRepository;
    @BeforeEach
    void setUp() {
        setConnection();
        companyIRepository = CompanyRepositoryDB.getInstance();
    }

    void setConnection() {
        try {
            DBConnection.setConnection("jdbc:mysql://localhost:3306/stockApp", "dev", "MAPstockDB123");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void addCompany() {

        Company company = new Company(100,"Tesla", 100, 1);
        companyIRepository.save(company);
        Company company1 = ((CompanyRepositoryDB) companyIRepository).searchIdCache(100);
        assertEquals(company1, company, "equal objects");
    }
    @Test
    void deleteCompany() {

        Company company1 = ((CompanyRepositoryDB) companyIRepository).searchIdCache(100);
        if(company1 != null) {
            companyIRepository.delete(company1);
        }
        Company deletedCompany = ((CompanyRepositoryDB) companyIRepository).searchIdCache(100);
        assertNull(deletedCompany, "Company should be deleted");
    }
}
