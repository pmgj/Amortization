package model;

public class SinglePaymentSystem extends Amortization {

    @Override
    protected void updateValues(double principal, int period, double interestRate) {
        this.interest = this.balance * interestRate;
        this.balance += this.interest;
    }

    @Override
    protected void lastInstallment(double principal, int period, double interestRate) {
        updateValues(principal, period, interestRate);
        this.amortization = principal;
        this.installment = this.balance;
    }
}
