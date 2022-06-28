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
    protected void inicializarValores(double principal, int period, double interestRate) {
        super.inicializarValores(principal, period, interestRate);
        double temp = Math.pow(1 + interestRate, period);
        k = (interestRate * temp) / (temp - 1);

        pAmortizacao = principal / period;
        pPagamento = principal * k;
        pSaldo = principal;

        sAmortizacao = principal / period;
        sSaldo = principal;

        juros = 0;
        somaJuros = 0;
        saldo = principal;
        pagamento = 0;
        amortizacao = 0;
    }

    @Override
    protected void atualizarValores(double principal, int period, double interestRate) {
        pJuros = pSaldo * interestRate;
        pAmortizacao = pPagamento - pJuros;
        pSaldo -= pAmortizacao;

        sJuros = sSaldo * interestRate;
        sSaldo -= sAmortizacao;
        sPagamento = sJuros + sAmortizacao;

        pagamento = (pPagamento + sPagamento) / 2;
        juros = saldo * interestRate;
        amortizacao = pagamento - juros;
        saldo -= amortizacao;
    }
}
