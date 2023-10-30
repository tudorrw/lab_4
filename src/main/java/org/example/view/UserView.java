package org.example.view;

import org.example.controller.UserController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserView {
    private UserController userController;

    public UserView(UserController userController) {
        this.userController = userController;
    }

    public void displayMenu() {
        System.out.println("Welcome to the best stock app on the planet!");
        System.out.println("Please register or log in");
        System.out.println("1 - Register");
        System.out.println("2 - Log In");
        System.out.println("3 - Exit");
    }
    public void run() {
        Scanner input = new Scanner(System.in);
        int selection = 0;

        while (selection != 3) {
            displayMenu();
            try {
                selection = input.nextInt();

                switch (selection) {
                    case 1:
                        System.out.println("implement register function");
                        register();
                        break;
                    case 2:
                        System.out.println("implement log in function");
                        logIn();
                        break;
                    case 3:
                        System.exit(0);
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
    public void register() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a username: ");
        String username = input.nextLine();
        if (username.equals("")) {
            System.out.println("Invalid username!");
            return;
         }

        System.out.print("Enter a password: ");
        String password = input.nextLine();
        if(password.equals("")) {
            System.out.println("Invalid password!");
            return;
        }

        System.out.print("Enter the password again!");
        String passwordConfirmation = input.nextLine();
        if(passwordConfirmation.equals("")) {
            System.out.println("Invalid password confirmation!");
            return;
        }

        if(password.equals(passwordConfirmation) == false) {
            System.out.println("passwords given do not match");
        }
        if(userController.createUser(username, password)) {
            System.out.println("You have authenticated!");
        }
        else {
            System.out.println("This username already exists!");
        }
        userController.updateUser();;

    }
    public void logIn() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a username: ");
        String username = input.nextLine();
        if (username.equals("")) {
            System.out.println("Invalid username!");
            return;
        }

        System.out.print("Enter a password: ");
        String password = input.nextLine();
        if(password.equals("")) {
            System.out.println("Invalid password!");
            return;
        }
        userController.deleteUser(username);
        userController.updateUser();

    }
}
