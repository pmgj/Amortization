package model;

public class Cliente {

    public static void main(String[] args) {
        Amortizacao c = new PagamentoUnico();
        c.capital(new Emprestimo());
    }
}
