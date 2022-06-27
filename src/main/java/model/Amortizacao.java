package model;

import java.text.NumberFormat;

public abstract class Amortizacao {

    protected double juros = 0;
    protected double amortizacao = 0;
    protected double pagamento = 0;
    protected double saldo = 0;
    protected double somaJuros = 0;
    private final NumberFormat formatter = NumberFormat.getCurrencyInstance();

    protected final void capital(Emprestimo loan) {
        System.out.println(String.format("%2s %15s %15s %15s %15s", "n", "Juros", "Amortização", "Pagamento", "Saldo Devedor"));
        inicializarValores(loan);
        somaJuros += juros;
        printLine(0, juros, amortizacao, pagamento, saldo);
        for (int n = 1; n < loan.getTempo(); n++) {
            /* Calculando valores */
            atualizarValores(loan);
            somaJuros += juros;
            /* Preenchendo a tabela */
            printLine(n, juros, amortizacao, pagamento, saldo);
        }
        ultimaParcela(loan);
        somaJuros += juros;
        printLine(loan.getTempo(), juros, amortizacao, pagamento, 0);
        printLine(somaJuros, loan.getMontante(), somaJuros + loan.getMontante(), 0);
    }

    protected void inicializarValores(Emprestimo loan) {
        juros = 0;
        amortizacao = 0;
        pagamento = 0;
        saldo = loan.getMontante();
        somaJuros = 0;
    }

    protected abstract void atualizarValores(Emprestimo loan);

    protected void ultimaParcela(Emprestimo loan) {
        atualizarValores(loan);
    }

    private void printLine(int n, double juros, double amortizacao, double pagamento, double saldo) {
        System.out.println(String.format("%2d %15s %15s %15s %15s", n, formatter.format(juros), formatter.format(amortizacao), formatter.format(pagamento), formatter.format(saldo)));
    }

    private void printLine(double juros, double amortizacao, double pagamento, double saldo) {
        System.out.println(String.format("-> %15s %15s %15s %15s", formatter.format(juros), formatter.format(amortizacao), formatter.format(pagamento), formatter.format(saldo)));
    }
}
