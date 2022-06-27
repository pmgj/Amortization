import SistemaAmortizacao from "./SistemaAmortizacao.js";

export default class Price extends SistemaAmortizacao {
    constructor() {
        super("Sistema Francês (PRICE)");
        this.k = 0;
    }
    inicializarValores(montante, tempo, taxa) {
        super.inicializarValores(montante, tempo, taxa);
        let temp = Math.pow(1 + taxa, tempo);
        this.k = (taxa * temp) / (temp - 1);
    }
    atualizarValores(montante, tempo, taxa) {
        this.juros = this.saldo * taxa;
        this.pagamento = montante * this.k;
        this.amortizacao = this.pagamento - this.juros;
        this.saldo -= this.amortizacao;
    }
}
