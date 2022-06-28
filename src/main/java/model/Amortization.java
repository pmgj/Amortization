package model;

import java.text.NumberFormat;

public abstract class Amortization {

    protected double interest = 0;
    protected double amortization = 0;
    protected double installment = 0;
    protected double balance = 0;
    protected double interestSum = 0;
    private final NumberFormat formatter = NumberFormat.getCurrencyInstance();

    protected final void capital(double principal, int period, double interestRate) {
        System.out.println(String.format("%2s %15s %15s %15s %15s", "n", "Juros", "Amortização", "Pagamento", "Saldo Devedor"));
        this.startValues(principal, period, interestRate);
        this.interestSum += interest;
        this.printLine(0, this.interest, this.amortization, this.installment, this.balance);
        for (int n = 1; n < period; n++) {
            /* Calculando valores */
            this.updateValues(principal, period, interestRate);
            this.interestSum += interest;
            /* Preenchendo a tabela */
            this.printLine(n, this.interest, this.amortization, this.installment, this.balance);
        }
        this.lastInstallment(principal, period, interestRate);
        this.interestSum += this.interest;
        this.printLine(period, this.interest, this.amortization, this.installment, 0);
        this.printLine(this.interestSum, principal, this.interestSum + principal, 0);
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

    private void printLine(int n, double _interest, double _amortization, double _installment, double _balance) {
        System.out.println(String.format("%2d %15s %15s %15s %15s", n, formatter.format(_interest), formatter.format(_amortization), formatter.format(_installment), formatter.format(_balance)));
    }

    private void printLine(double _interest, double _amortization, double _installment, double _balance) {
        System.out.println(String.format("-> %15s %15s %15s %15s", formatter.format(_interest), formatter.format(_amortization), formatter.format(_installment), formatter.format(_balance)));
    }
}
