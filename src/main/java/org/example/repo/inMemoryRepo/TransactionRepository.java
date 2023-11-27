package org.example.repo.inMemoryRepo;

import org.example.model.Transaction;
import org.example.repo.IRepository;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository implements IRepository<Transaction> {
    private ArrayList<Transaction> transactions;
    private static TransactionRepository instance;


    private TransactionRepository() {
        this.transactions = new ArrayList<>();
    }

    @Override
    public ArrayList<Transaction> getObjects() {
        return transactions;
    }

    @Override
    public void save(Transaction entity) {
        transactions.add(entity);
    }

    @Override
    public void update(Transaction entity, String action) {

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
