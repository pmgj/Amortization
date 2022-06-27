package model;

import java.text.NumberFormat;

public class Price extends Amortizacao {

    @Override
    public void capital(Emprestimo loan) {
        System.out.println(String.format("%2s %15s %15s %15s %15s", "n", "Juros", "Amortização", "Pagamento", "Saldo Devedor"));
        double k = (loan.getTaxa() * Math.pow(1 + loan.getTaxa(), loan.getTempo())) / (Math.pow(1 + loan.getTaxa(), loan.getTempo()) - 1);
        double juros = 0, amortizacao = 0, pagamento = loan.getMontante() * k, saldo = loan.getMontante(), somaJuros = 0;
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        for (int n = 0; n < loan.getTempo(); n++) {
            /* Preenchendo a tabela */
            System.out.println(String.format("%2d %15s %15s %15s %15s", n, formatter.format(juros), formatter.format((n == 0) ? 0.0 : amortizacao), formatter.format((n == 0) ? 0 : pagamento), formatter.format(saldo)));
            /* Calculando valores */
            juros = saldo * loan.getTaxa();
            amortizacao = pagamento - juros;
            somaJuros += juros;
            saldo -= amortizacao;
        }
        System.out.println(String.format("%2d %15s %15s %15s %15s", loan.getTempo(), formatter.format(juros), formatter.format(amortizacao), formatter.format(pagamento), formatter.format(0.0)));
        System.out.println(String.format("-> %15s %15s %15s %15s", formatter.format(somaJuros), formatter.format(loan.getMontante()), formatter.format(somaJuros + loan.getMontante()), formatter.format(0.0)));
    }
}
