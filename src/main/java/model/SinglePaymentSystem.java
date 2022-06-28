package model;

public class SinglePaymentSystem extends Amortization {

    @Override
    protected void atualizarValores(double principal, int period, double interestRate) {
        juros = saldo * interestRate;
        saldo += juros;
    }

    @Override
    protected void ultimaParcela(double principal, int period, double interestRate) {
        atualizarValores(principal, period, interestRate);
        amortizacao = principal;
        pagamento = saldo;
    }
}
