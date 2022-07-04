package model;

public class Item {
    private int period;
    private double interest;
    private double installment;
    private double amortization;
    private double balance;

    public Item(int period, double interest, double amortization, double installment, double balance) {
        this.period = period;
        this.interest = interest;
        this.amortization = amortization;
        this.installment = installment;
        this.balance = balance;
    }

    public double getAmortization() {
        return amortization;
    }

    public double getBalance() {
        return balance;
    }

    public double getInstallment() {
        return installment;
    }

    public double getInterest() {
        return interest;
    }

    public int getPeriod() {
        return period;
    }

    public void setAmortization(double amortization) {
        this.amortization = amortization;
    }
}
