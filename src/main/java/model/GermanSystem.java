package model;

public class GermanSystem extends Amortization {

    private double payment = 0;

    @Override
    protected void startValues(double principal, int period, double interestRate) {
        this.interest = principal * interestRate;
        this.balance = principal;
        this.installment = this.interest;
        this.payment = (principal * interestRate) / (1 - Math.pow(1 - interestRate, period));
    }

    @Override
    protected void updateValues(double principal, int period, double interestRate) {
        this.installment = this.payment;
        if (this.amortization == 0) {
            this.amortization = this.installment * Math.pow(1 - interestRate, period - 1);
        } else {
            this.amortization = this.amortization / (1 - interestRate);
        }
        this.interest = this.installment - this.amortization;
        this.balance -= this.amortization;
    }
}
