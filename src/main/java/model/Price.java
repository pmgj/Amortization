package model;

public class Price extends Amortizacao {

    private double k;

    @Override
    protected void inicializarValores(Emprestimo loan) {
        super.inicializarValores(loan);
        double temp = Math.pow(1 + loan.getTaxa(), loan.getTempo());
        k = (loan.getTaxa() * temp) / (temp - 1);
    }

    @Override
    protected void atualizarValores(Emprestimo loan) {
        juros = saldo * loan.getTaxa();
        pagamento = loan.getMontante() * k;
        amortizacao = pagamento - juros;
        saldo -= amortizacao;
    }
}
