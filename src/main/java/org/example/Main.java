package org.example;

import org.example.controller.AdminController;
import org.example.controller.UserController;
import org.example.repo.AdminRepository;
import org.example.repo.UserRepository;
import org.example.view.View;
import org.example.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepo = new UserRepository();
        AdminRepository adminRepo = new AdminRepository();
        UserController userController = new UserController(userRepo);
        AdminController adminController = new AdminController(adminRepo);
        View view = new View(userController, adminController);
        User user1 = new User(1, "alex", "123");
        User user2 = new User(2, "ana", "qwerty");
        userRepo.save(user1);
        userRepo.save(user2);

        List<User> users = userRepo.getObjects();
        for(User user: users) {
            System.out.println(user.toString());
        }
        view.run();

    }
}