package org.example.utils;

import org.example.controller.AdminController;
import org.example.controller.UserController;
import org.example.view.AdminView;
import org.example.view.IPersonView;
import org.example.view.UserView;

public class PersonViewFactory {
    public static IPersonView createView(int selection, UserController userController, AdminController adminController) {
        return switch (selection) {
            case 1 -> new UserView(userController);
            case 2 -> new AdminView(adminController);
            default -> null;
        };
    }
}
