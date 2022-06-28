package model;

public class LoanSystem extends Amortization {

    private double k;
    private double pJuros = 0;
    private double pAmortizacao = 0;
    private double pPagamento = 0;
    private double pSaldo = 0;

    private double sJuros = 0;
    private double sAmortizacao = 0;
    private double sPagamento = 0;
    private double sSaldo = 0;

    @Override
    protected void startValues(double principal, int period, double interestRate) {
        super.startValues(principal, period, interestRate);
        double temp = Math.pow(1 + interestRate, period);
        this.k = (interestRate * temp) / (temp - 1);

        this.pAmortizacao = principal / period;
        this.pPagamento = principal * this.k;
        this.pSaldo = principal;

        this.sAmortizacao = principal / period;
        this.sSaldo = principal;

        this.interest = 0;
        this.interestSum = 0;
        this.balance = principal;
        this.installment = 0;
        this.amortization = 0;
    }

    @Override
    protected void updateValues(double principal, int period, double interestRate) {
        this.pJuros = this.pSaldo * interestRate;
        this.pAmortizacao = this.pPagamento - this.pJuros;
        this.pSaldo -= this.pAmortizacao;

        this.sJuros = this.sSaldo * interestRate;
        this.sSaldo -= this.sAmortizacao;
        this.sPagamento = this.sJuros + this.sAmortizacao;

        this.installment = (this.pPagamento + this.sPagamento) / 2;
        this.interest = this.balance * interestRate;
        this.amortization = this.installment - this.interest;
        this.balance -= this.amortization;
    }
}
