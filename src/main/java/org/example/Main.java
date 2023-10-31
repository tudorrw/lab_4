package org.example;

import org.example.controller.AdminController;
import org.example.controller.UserController;
import org.example.repo.AdminIRepository;
import org.example.repo.UserIRepository;
import org.example.view.View;


public class Main {
    public static void main(String[] args) {
        UserIRepository userRepo = new UserIRepository();
        AdminIRepository adminRepo = new AdminIRepository();
        UserController userController = new UserController(userRepo);
        AdminController adminController = new AdminController(adminRepo);
        View view = new View(userController, adminController);

        view.run();

    }
}