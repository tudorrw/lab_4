package org.example.model;

public class PremiumUser extends User{
    private String payment_plan;



    public PremiumUser(int id, String username, String password, String payment_plan) {
        super(id, username, password);
        this.payment_plan = payment_plan;
    }


    public String getPayment_plan() {
        return payment_plan;
    }

    public void setPayment_plan(String payment_plan) {
        this.payment_plan = payment_plan;
    }
}
