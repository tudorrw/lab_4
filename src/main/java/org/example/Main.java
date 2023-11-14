package org.example;

import org.example.controller.AdminController;
import org.example.controller.CompanyController;
import org.example.controller.UserController;
import org.example.model.Admin;
import org.example.model.Company;
import org.example.model.User;
import org.example.repo.AdminRepository;
import org.example.repo.CompanyRepository;
import org.example.repo.IRepository;
import org.example.repo.UserRepository;
import org.example.view.View;

public class Main {
    public static void main(String[] args) {
        IRepository<User> userRepo = new UserRepository();
        IRepository<Admin> adminRepo = new AdminRepository();
        IRepository<Company> companyRepo = new CompanyRepository();
        UserController userController = new UserController(userRepo);
        AdminController adminController = new AdminController(adminRepo);
        CompanyController companyController = new CompanyController(companyRepo);
        View view = new View(userController, adminController, companyController);
        view.run();
    }
}