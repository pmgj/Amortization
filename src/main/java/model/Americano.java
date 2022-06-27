package model;

import java.text.NumberFormat;

public class Americano extends Amortizacao {

    @Override
    public void capital(Emprestimo loan) {
        System.out.println(String.format("%2s %15s %15s %15s %15s", "n", "Juros", "Amortização", "Pagamento", "Saldo Devedor"));
        double juros = 0, saldo = loan.getMontante(), somaJuros = 0;
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        for (int n = 0; n < loan.getTempo(); n++) {
            /* Preenchendo a tabela */
            System.out.println(String.format("%2d %15s %15s %15s %15s", n, formatter.format(juros), formatter.format(0.0), formatter.format(juros), formatter.format(saldo)));
            /* Calculando valores */
            juros = saldo * loan.getTaxa();
            somaJuros += juros;
        }
        System.out.println(String.format("%2d %15s %15s %15s %15s", loan.getTempo(), formatter.format(juros), formatter.format(saldo), formatter.format(juros + saldo), formatter.format(0.0)));
        System.out.println(String.format("-> %15s %15s %15s %15s", formatter.format(somaJuros), formatter.format(loan.getMontante()), formatter.format(somaJuros + loan.getMontante()), formatter.format(0.0)));        
    }
}
