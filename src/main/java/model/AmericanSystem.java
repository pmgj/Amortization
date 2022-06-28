package model;

public class AmericanSystem extends Amortization {

    @Override
    protected void atualizarValores(double principal, int period, double interestRate) {
        juros = pagamento = saldo * interestRate;
    }

    @Override
    protected void ultimaParcela(double principal, int period, double interestRate) {
        amortizacao = principal;
        pagamento = amortizacao + juros;
    }
}
