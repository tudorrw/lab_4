package org.example.model;

public class TransactionHistory {
    private Transaction[] transactions;

    public TransactionHistory(Transaction[] transactions) {
        this.transactions = transactions;
    }

    public Transaction[] getTransactions() {
        return transactions;
    }

    public void setTransactions(Transaction[] transactions) {
        this.transactions = transactions;
    }
}
