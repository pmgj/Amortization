package model;

public class FrenchSystem extends Amortization {

    private double k;

    public FrenchSystem() {
        super("French System");
    }

    @Override
    protected void startValues(double principal, int period, double interestRate) {
        super.startValues(principal, period, interestRate);
        double temp = Math.pow(1 + interestRate, period);
        this.k = (interestRate * temp) / (temp - 1);
    }

    @Override
    protected void updateValues(double principal, int period, double interestRate) {
        this.interest = this.balance * interestRate;
        this.installment = principal * this.k;
        this.amortization = this.installment - this.interest;
        this.balance -= this.amortization;
    }
}
