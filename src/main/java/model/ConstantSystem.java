package model;

public class ConstantSystem extends Amortization {

    @Override
    protected void atualizarValores(double principal, int period, double interestRate) {
        juros = saldo * interestRate;
        amortizacao = principal / period;
        pagamento = juros + amortizacao;
        saldo -= amortizacao;
    }
}
