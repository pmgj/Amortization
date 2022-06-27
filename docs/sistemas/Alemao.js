import AmortizationSystem from "./AmortizationSystem.js";

export default class Alemao extends AmortizationSystem {
    constructor() {
        super("Sistema Alemão");
        this.payment = 0;
    }
    inicializarValores(montante, tempo, taxa) {
        super.inicializarValores(montante, tempo, taxa);
        this.juros = montante * taxa;
        this.saldo = montante;
        this.pagamento = this.juros;
        this.payment = (montante * taxa) / (1 - Math.pow(1 - taxa, tempo));
    }
    atualizarValores(montante, tempo, taxa) {
        this.pagamento = this.payment;
        if (this.amortizacao === 0) {
            this.amortizacao = this.pagamento * Math.pow(1 - taxa, tempo - 1);
        } else {
            this.amortizacao = this.amortizacao / (1 - taxa);
        }
        this.juros = this.pagamento - this.amortizacao;
        this.saldo -= this.amortizacao;
    }
}
