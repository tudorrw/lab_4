package org.example.view;

import org.example.controller.AdminController;
import org.example.controller.UserController;

public class PersonViewFactory {
    public static IPersonView createView(int selection, UserController userController, AdminController adminController) {
        return switch (selection) {
            case 1 -> new UserView(userController);
            case 2 -> new AdminView(adminController);
            default -> null;
        };
    }
}
