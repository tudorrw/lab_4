package org.example.view;


import org.example.controller.AdminController;
import org.example.controller.UserController;
import org.example.utils.PersonViewFactory;

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
        System.out.println("3 - Exit");

    }
    public void run() {
        Scanner input = new Scanner(System.in);
        int selection = 0;

        while (selection != 3) {
            displayMenu();
            try {
                selection = input.nextInt();
                PersonViewFactory viewFactory = new PersonViewFactory();
                IPersonView view = viewFactory.createView(selection, userController, adminController);
                if(view != null) {
                    view.run();
                }
                else {
                    if(selection == 3){
                        System.out.println("closing app...");
                    }
                    else {
                        throw new InputMismatchException();
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
                input.next();
            }
        }
    }

}
