package org.example.view;

import org.example.controller.CompanyController;
import org.example.controller.MarketController;
import org.example.controller.StockController;
import org.example.model.Company;
import org.example.model.Market;
import org.example.model.Stock;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StockView {
    private final StockController stockController;
    private final MarketController marketController;
    private final CompanyController companyController;

    public StockView(StockController stockController, MarketController marketController, CompanyController companyController) {
        this.stockController = stockController;
        this.marketController = marketController;
        this.companyController = companyController;
    }


    public void add() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a stock id: ");
        int stockid = input.nextInt();
        input.nextLine();
        System.out.print("Enter stock Name: ");
        String stockName = input.nextLine();
        if (stockName.isEmpty()) {
            System.out.println("Invalid stock name!");
        }

        System.out.print("Enter company Name: ");
        String company = input.nextLine();
        if (company.isEmpty()) {
            System.out.println("Invalid company name!");
        }

        Company company1 = companyController.searchCompany(company);

        System.out.print("Enter market Name: ");
        String market = input.nextLine();
        if (market.isEmpty()) {
            System.out.println("Invalid market name!");
        }

        Market market1 = marketController.searchMarket(market);
        if (!stockController.addStock(stockid, stockName, company1, market1)) {
            System.out.println("Invalid Stock!");
        } else {
            System.out.println("Stock added succesfully");
        }
    }

    public void getAllStocks() {
        List<Stock> companies = stockController.getAll();
        companies.stream().map(Object::toString).forEach(System.out::println);
    }
}
