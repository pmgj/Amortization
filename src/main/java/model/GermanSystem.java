package model;

public class GermanSystem extends Amortization {

    private double payment = 0;

    @Override
    protected void inicializarValores(double principal, int period, double interestRate) {
        juros = principal * interestRate;
        saldo = principal;
        pagamento = juros;
        payment = (principal * interestRate) / (1 - Math.pow(1 - interestRate, period));
    }

    @Override
    protected void atualizarValores(double principal, int period, double interestRate) {
        pagamento = payment;
        if (amortizacao == 0) {
            amortizacao = pagamento * Math.pow(1 - interestRate, period - 1);
        } else {
            amortizacao = amortizacao / (1 - interestRate);
        }
        juros = pagamento - amortizacao;
        saldo -= amortizacao;
    }
}
