package model;

public class AmericanSystem extends Amortization {

    public AmericanSystem() {
        super("American System");
    }

    @Override
    protected void updateValues(double principal, int period, double interestRate) {
        this.interest = this.installment = this.balance * interestRate;
    }

    @Override
    protected void lastInstallment(double principal, int period, double interestRate) {
        this.amortization = principal;
        this.installment = this.amortization + this.interest;
    }
}
