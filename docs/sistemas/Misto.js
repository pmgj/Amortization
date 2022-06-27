import SistemaAmortizacao from "./SistemaAmortizacao.js";

export default class Misto extends SistemaAmortizacao {
    constructor() {
        super("Sistema de Amortização Misto (SAM)");
        this.k = 0;
        this.pJuros = 0;
        this.pAmortizacao = 0;
        this.pPagamento = 0;
        this.pSaldo = 0;
        this.sJuros = 0;
        this.sAmortizacao = 0;
        this.sPagamento = 0;
        this.sSaldo = 0;
    }
    inicializarValores(montante, tempo, taxa) {
        super.inicializarValores(montante, tempo, taxa);
        let temp = Math.pow(1 + taxa, tempo);
        this.k = (taxa * temp) / (temp - 1);
        this.pAmortizacao = montante / tempo;
        this.pPagamento = montante * this.k;
        this.pSaldo = montante;
        this.sAmortizacao = montante / tempo;
        this.sSaldo = montante;
        this.juros = 0;
        this.somaJuros = 0;
        this.saldo = montante;
        this.pagamento = 0;
        this.amortizacao = 0;
    }
    atualizarValores(montante, tempo, taxa) {
        this.pJuros = this.pSaldo * taxa;
        this.pAmortizacao = this.pPagamento - this.pJuros;
        this.pSaldo -= this.pAmortizacao;
        this.sJuros = this.sSaldo * taxa;
        this.sSaldo -= this.sAmortizacao;
        this.sPagamento = this.sJuros + this.sAmortizacao;
        this.pagamento = (this.pPagamento + this.sPagamento) / 2;
        this.juros = this.saldo * taxa;
        this.amortizacao = this.pagamento - this.juros;
        this.saldo -= this.amortizacao;
    }
}
