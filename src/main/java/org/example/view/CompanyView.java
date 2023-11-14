package org.example.view;

import org.example.controller.CompanyController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CompanyView {
    private final CompanyController companyController;

    public CompanyView(CompanyController companyController) {
        this.companyController = companyController;
    }
    public void add_company() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a company name: ");
        String companyName = input.nextLine();
        if (companyName.isEmpty()) {
            System.out.println("Invalid company name!");
            return;
        }

        System.out.print("Enter company capitalization: ");
        try {
            int capitalization = input.nextInt();
            if(capitalization < 0) {
                System.out.println("Invalid capitalization!");
            }
        } catch(InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }
}
