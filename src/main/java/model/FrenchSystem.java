package model;

public class FrenchSystem extends Amortization {

    private double k;

    @Override
    protected void inicializarValores(double principal, int period, double interestRate) {
        super.inicializarValores(principal, period, interestRate);
        double temp = Math.pow(1 + interestRate, period);
        k = (interestRate * temp) / (temp - 1);
    }

    @Override
    protected void atualizarValores(double principal, int period, double interestRate) {
        juros = saldo * interestRate;
        pagamento = principal * k;
        amortizacao = pagamento - juros;
        saldo -= amortizacao;
    }
}
