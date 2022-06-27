package model;

import java.text.NumberFormat;

public class Alemao extends Amortizacao {

    
    @Override
    public void capital(Emprestimo loan) {
        System.out.println(String.format("%2s %15s %15s %15s %15s", "n", "Juros", "Amortização", "Pagamento", "Saldo Devedor"));
        double juros = loan.getMontante() * loan.getTaxa(), amortizacao = 0;
        double pagamento = (loan.getMontante() * loan.getTaxa()) / (1 - Math.pow(1 - loan.getTaxa(), loan.getTempo()));
        double saldo = loan.getMontante(), somaJuros = 0;
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        for (int n = 0; n < loan.getTempo(); n++) {
            /* Preenchendo a tabela */
            System.out.println(String.format("%2d %15s %15s %15s %15s", n, formatter.format(juros), formatter.format((n == 0) ? 0 : amortizacao), formatter.format((n == 0) ? juros : pagamento), formatter.format(saldo)));
            /* Calculando valores */
            amortizacao = (n == 0) ? pagamento * Math.pow(1 - loan.getTaxa(), loan.getTempo() - 1) : amortizacao / (1 - loan.getTaxa());
            somaJuros += juros;
            juros = pagamento - amortizacao;
            saldo -= amortizacao;
        }
        System.out.println(String.format("%2d %15s %15s %15s %15s", loan.getTempo(), formatter.format(juros), formatter.format(amortizacao), formatter.format(pagamento), formatter.format(0.0)));
        System.out.println(String.format("-> %15s %15s %15s %15s", formatter.format(somaJuros), formatter.format(loan.getMontante()), formatter.format(somaJuros + loan.getMontante()), formatter.format(0.0)));
    }
}
