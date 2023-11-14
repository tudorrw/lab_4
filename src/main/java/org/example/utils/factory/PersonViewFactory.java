package org.example.utils.factory;

import org.example.controller.*;
import org.example.view.AdminView;
import org.example.view.IPersonView;
import org.example.view.UserView;

public class PersonViewFactory {
    public static IPersonView createView(int selection, UserController userController, AdminController adminController, StockController stockController,CompanyController companyController, MarketController marketController) {
        return switch (selection) {
            case 1 -> new UserView(userController);
            case 2 -> new AdminView(adminController, userController, stockController, companyController, marketController);
            default -> null;
        };
    }
}
