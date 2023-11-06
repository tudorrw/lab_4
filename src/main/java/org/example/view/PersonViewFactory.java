package org.example.view;

import org.example.controller.AdminController;
import org.example.controller.UserController;

public class PersonViewFactory {
    public IPersonView createView(int selection, UserController userController, AdminController adminController) {
        switch (selection) {
            case 1:
                return new UserView(userController);
            case 2:
                return new AdminView(adminController);
            default:
                throw new IllegalArgumentException("Invalid selection");
        }
    }
}
