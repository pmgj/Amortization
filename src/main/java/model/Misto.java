package model;

import java.text.NumberFormat;

public class Misto extends Amortizacao {

    @Override
    public void capital(Emprestimo loan) {
        System.out.println(String.format("%2s %15s %15s %15s %15s", "n", "Juros", "Amortização", "Pagamento", "Saldo Devedor"));
        double k = (loan.getTaxa() * Math.pow(1 + loan.getTaxa(), loan.getTempo())) / (Math.pow(1 + loan.getTaxa(), loan.getTempo()) - 1);
        double pJuros, pAmortizacao, pPagamento = loan.getMontante() * k;
        double pSaldo = loan.getMontante(), sJuros, sAmortizacao = loan.getMontante() / loan.getTempo();
        double sPagamento, sSaldo = loan.getMontante(), juros = 0, somaJuros = 0;
        double saldo = loan.getMontante(), pagamento = 0, amortizacao = 0;
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        for (int n = 0; n < loan.getTempo(); n++) {
            /* Preenchendo a tabela */
            System.out.println(String.format("%2d %15s %15s %15s %15s", n, formatter.format(juros), formatter.format((n == 0) ? 0.0 : amortizacao), formatter.format((n == 0) ? 0 : pagamento), formatter.format(saldo)));
            /* Calculando valores */
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
            somaJuros += juros;
        }
        System.out.println(String.format("%2d %15s %15s %15s %15s", loan.getTempo(), formatter.format(juros), formatter.format(amortizacao), formatter.format(pagamento), formatter.format(0.0)));
        System.out.println(String.format("-> %15s %15s %15s %15s", formatter.format(somaJuros), formatter.format(loan.getMontante()), formatter.format(somaJuros + loan.getMontante()), formatter.format(0.0)));
    }
}
