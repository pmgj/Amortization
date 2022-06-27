package model;

public class Alemao extends Amortizacao {

    private double payment = 0;

    @Override
    protected void inicializarValores(Emprestimo loan) {
        juros = loan.getMontante() * loan.getTaxa();
        saldo = loan.getMontante();
        pagamento = juros;
        payment = (loan.getMontante() * loan.getTaxa()) / (1 - Math.pow(1 - loan.getTaxa(), loan.getTempo()));
    }

    @Override
    protected void atualizarValores(Emprestimo loan) {
        pagamento = payment;
        if (amortizacao == 0) {
            amortizacao = pagamento * Math.pow(1 - loan.getTaxa(), loan.getTempo() - 1);
        } else {
            amortizacao = amortizacao / (1 - loan.getTaxa());
        }
        juros = pagamento - amortizacao;
        saldo -= amortizacao;
    }
}
