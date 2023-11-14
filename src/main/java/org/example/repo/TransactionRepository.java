package org.example.repo;

import org.example.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository implements IRepository<Transaction>{
    private List<Transaction> transactions;
    private static TransactionRepository instance;


    private TransactionRepository() {
        this.transactions = new ArrayList<>();
    }

    @Override
    public List<Transaction> getObjects() {
        return transactions;
    }

    @Override
    public void save(Transaction entity) {
        transactions.add(entity);
    }

    @Override
    public void delete(Transaction object) {
        transactions.remove(object);
    }


    public static TransactionRepository getInstance() {
        if (instance == null) {
            instance = new TransactionRepository();
        }
        return instance;
    }
}
