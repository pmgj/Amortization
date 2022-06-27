package model;

public class PagamentoUnico extends Amortizacao {

    @Override
    protected void atualizarValores(Emprestimo loan) {
        juros = saldo * loan.getTaxa();
        saldo += juros;
    }

    @Override
    protected void ultimaParcela(Emprestimo loan) {
        atualizarValores(loan);
        amortizacao = loan.getMontante();
        pagamento = saldo;
    }
}
