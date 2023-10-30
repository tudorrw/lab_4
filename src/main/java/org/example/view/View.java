package org.example.view;


import org.example.controller.AdminController;
import org.example.controller.UserController;
import org.example.model.Admin;
import org.example.model.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
    UserController userController;
    AdminController adminController;

    public View(UserController userController, AdminController adminController) {
        this.userController = userController;
        this.adminController = adminController;
    }

    public void displayMenu() {
        System.out.println("Choose a role");
        System.out.println("1 - User");
        System.out.println("2 - Admin");

    }
    public void displayMenuForUser() {
        System.out.println("Welcome to the best stock app on the planet!");
        System.out.println("Please register or log in");
        System.out.println("1 - Register");
        System.out.println("2 - Log In");
        System.out.println("3 - Exit");
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        int selection = -1;

        while (selection != 0) {
            displayMenu();
            try {
                selection = input.nextInt();

                switch (selection) {
                    case 0:
                        System.exit(0);
                        break;
                    case 1:
                        System.out.println("do stuff for user");
                        UserView userView = new UserView(userController);
                        break;
                    case 2:
                        System.out.println("do stuff for admin");
                        AdminView adminView = new AdminView(adminController);
                        break;
                    default:
                        System.out.println("Invalid selection. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.next();
            }
        }
    }

}
