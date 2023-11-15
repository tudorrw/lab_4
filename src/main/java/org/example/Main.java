package org.example;

import org.example.controller.*;
import org.example.model.*;
import org.example.repo.*;
import org.example.view.StockView;
import org.example.view.View;

public class Main {
    public static void main(String[] args) {
        IRepository<User> userRepo = UserRepository.getInstance();
        IRepository<Admin> adminRepo = AdminRepository.getInstance();
        IRepository<Company> companyRepo = CompanyRepository.getInstance();
        IRepository<Market> marketRepo = MarketRepository.getInstance();
        IRepository<Stock> stockRepo = StockRepository.getInstance();
        UserController userController = new UserController(userRepo);
        AdminController adminController = new AdminController(adminRepo);
        CompanyController companyController = new CompanyController(CompanyRepository.getInstance());
        MarketController marketController = new MarketController(marketRepo);
        StockController stockController = new StockController(stockRepo);
        View view = new View(userController, adminController, stockController, companyController, marketController);
        view.run();
    }
}