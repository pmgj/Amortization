package model;

public class ConstantSystem extends Amortization {

    @Override
    protected void updateValues(double principal, int period, double interestRate) {
        this.interest = this.balance * interestRate;
        this.amortization = principal / period;
        this.installment = this.interest + this.amortization;
        this.balance -= this.amortization;
    }
}
