package model;

public abstract class Amortization {

    protected String name;
    protected double interest = 0;
    protected double amortization = 0;
    protected double installment = 0;
    protected double balance = 0;
    protected double interestSum = 0;

    public Amortization(String name) {
        this.name = name;
    }

    public final Schedule capital(double principal, int period, double interestRate) {
        Schedule schedule = new Schedule();
        this.startValues(principal, period, interestRate);
        this.interestSum += interest;
        schedule.addItem(new Item(0, this.interest, this.amortization, this.installment, this.balance));
        for (int n = 1; n < period; n++) {
            this.updateValues(principal, period, interestRate);
            this.interestSum += interest;
            schedule.addItem(new Item(n, this.interest, this.amortization, this.installment, this.balance));
        }
        this.lastInstallment(principal, period, interestRate);
        this.interestSum += this.interest;
        schedule.addItem(new Item(period, this.interest, this.amortization, this.installment, 0));
        schedule.setTotals(new Item(0, this.interestSum, principal, this.interestSum + principal, 0));
        return schedule;
    }

    protected void startValues(double principal, int period, double interestRate) {
        this.interest = 0;
        this.amortization = 0;
        this.installment = 0;
        this.balance = principal;
        this.interestSum = 0;
    }

    protected abstract void updateValues(double principal, int period, double interestRate);

    protected void lastInstallment(double principal, int period, double interestRate) {
        updateValues(principal, period, interestRate);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
