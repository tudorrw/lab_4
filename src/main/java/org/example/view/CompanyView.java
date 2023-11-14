package org.example.view;

import org.example.controller.CompanyController;
import org.example.model.Company;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CompanyView {
    private final CompanyController companyController;

    public CompanyView(CompanyController companyController) {
        this.companyController = companyController;
    }
    public void add() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a company name: ");
        String companyName = input.nextLine();
        if (companyName.isEmpty()) {
            System.out.println("Invalid company name!");
            return;
        }

        System.out.print("Enter company capitalization: ");
        try {
            long capitalization = input.nextLong();
            System.out.println(capitalization);
            if (!companyController.addCompany(companyName, capitalization)) {
                System.out.println("Invalid capitalization!");
            }
            else {
                System.out.println("Company added succesfully");
            }
        } catch(InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }
    public void getAllCompanies() {
        List<Company> companies = companyController.getAll();
        companies.stream().map(Object::toString).forEach(System.out::println);
    }
    public void deleteCompany() {
        Scanner input = new Scanner(System.in);
        System.out.println("Give the name of the company you want to delete: ");
        String companyName = input.nextLine();
        if (companyName.isEmpty()) {
            System.out.println("Invalid company name!");
            return;
        }
        if(!companyController.removeCompany(companyName)){
            System.out.println("This company doesn't exist in our database!");
        }
        else {
            System.out.println("Company successfully removed!");
        }
    }
}
