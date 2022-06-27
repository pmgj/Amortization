package model;

public class Americano extends Amortizacao {

    @Override
    protected void atualizarValores(Emprestimo loan) {
        juros = pagamento = saldo * loan.getTaxa();
    }

    @Override
    protected void ultimaParcela(Emprestimo loan) {
        amortizacao = loan.getMontante();
        pagamento = amortizacao + juros;
    }
}
