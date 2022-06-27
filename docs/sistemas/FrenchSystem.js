import AmortizationSystem from "./AmortizationSystem.js";

export default class FrenchSystem extends AmortizationSystem {
    constructor() {
        super("French System");
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
