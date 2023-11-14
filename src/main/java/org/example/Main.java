package org.example;

import org.example.controller.AdminController;
import org.example.controller.CompanyController;
import org.example.controller.MarketController;
import org.example.controller.UserController;
import org.example.model.Admin;
import org.example.model.Company;
import org.example.model.Market;
import org.example.model.User;
import org.example.repo.*;
import org.example.view.View;

public class Main {
    public static void main(String[] args) {
        IRepository<User> userRepo = UserRepository.getInstance();
        IRepository<Admin> adminRepo = AdminRepository.getInstance();
        IRepository<Company> companyRepo = CompanyRepository.getInstance();
        IRepository<Market> marketRepo = MarketRepository.getInstance();
        UserController userController = new UserController(userRepo);
        AdminController adminController = new AdminController(adminRepo);
        CompanyController companyController = new CompanyController(CompanyRepository.getInstance());
        MarketController marketController = new MarketController(marketRepo);
        View view = new View(userController, adminController, companyController, marketController);
        view.run();
    }
}