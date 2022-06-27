package model;

public class SAC extends Amortizacao {

    @Override
    protected void atualizarValores(Emprestimo loan) {
        juros = saldo * loan.getTaxa();
        amortizacao = loan.getMontante() / loan.getTempo();
        pagamento = juros + amortizacao;
        saldo -= amortizacao;
    }
}
