package model;

import java.text.NumberFormat;

public abstract class Amortization {

    protected double juros = 0;
    protected double amortizacao = 0;
    protected double pagamento = 0;
    protected double saldo = 0;
    protected double somaJuros = 0;
    private final NumberFormat formatter = NumberFormat.getCurrencyInstance();

    protected final void capital(double principal, int period, double interestRate) {
        System.out.println(String.format("%2s %15s %15s %15s %15s", "n", "Juros", "Amortização", "Pagamento", "Saldo Devedor"));
        inicializarValores(principal, period, interestRate);
        somaJuros += juros;
        printLine(0, juros, amortizacao, pagamento, saldo);
        for (int n = 1; n < period; n++) {
            /* Calculando valores */
            atualizarValores(principal, period, interestRate);
            somaJuros += juros;
            /* Preenchendo a tabela */
            printLine(n, juros, amortizacao, pagamento, saldo);
        }
        ultimaParcela(principal, period, interestRate);
        somaJuros += juros;
        printLine(period, juros, amortizacao, pagamento, 0);
        printLine(somaJuros, principal, somaJuros + principal, 0);
    }

    protected void inicializarValores(double principal, int period, double interestRate) {
        juros = 0;
        amortizacao = 0;
        pagamento = 0;
        saldo = principal;
        somaJuros = 0;
    }

    protected abstract void atualizarValores(double principal, int period, double interestRate);

    protected void ultimaParcela(double principal, int period, double interestRate) {
        atualizarValores(principal, period, interestRate);
    }

    private void printLine(int n, double juros, double amortizacao, double pagamento, double saldo) {
        System.out.println(String.format("%2d %15s %15s %15s %15s", n, formatter.format(juros), formatter.format(amortizacao), formatter.format(pagamento), formatter.format(saldo)));
    }

    private void printLine(double juros, double amortizacao, double pagamento, double saldo) {
        System.out.println(String.format("-> %15s %15s %15s %15s", formatter.format(juros), formatter.format(amortizacao), formatter.format(pagamento), formatter.format(saldo)));
    }
}
