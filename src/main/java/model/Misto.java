package model;

public class Misto extends Amortizacao {

    private double k;
    private double pJuros = 0;
    private double pAmortizacao = 0;
    private double pPagamento = 0;
    private double pSaldo = 0;

    private double sJuros = 0;
    private double sAmortizacao = 0;
    private double sPagamento = 0;
    private double sSaldo = 0;

    @Override
    protected void inicializarValores(Emprestimo loan) {
        super.inicializarValores(loan);
        double temp = Math.pow(1 + loan.getTaxa(), loan.getTempo());
        k = (loan.getTaxa() * temp) / (temp - 1);

        pAmortizacao = loan.getMontante() / loan.getTempo();
        pPagamento = loan.getMontante() * k;
        pSaldo = loan.getMontante();

        sAmortizacao = loan.getMontante() / loan.getTempo();
        sSaldo = loan.getMontante();

        juros = 0;
        somaJuros = 0;
        saldo = loan.getMontante();
        pagamento = 0;
        amortizacao = 0;
    }

    @Override
    protected void atualizarValores(Emprestimo loan) {
        pJuros = pSaldo * loan.getTaxa();
        pAmortizacao = pPagamento - pJuros;
        pSaldo -= pAmortizacao;

        sJuros = sSaldo * loan.getTaxa();
        sSaldo -= sAmortizacao;
        sPagamento = sJuros + sAmortizacao;

        pagamento = (pPagamento + sPagamento) / 2;
        juros = saldo * loan.getTaxa();
        amortizacao = pagamento - juros;
        saldo -= amortizacao;
    }
}
