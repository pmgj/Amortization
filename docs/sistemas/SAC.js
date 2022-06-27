import AmortizationSystem from "./AmortizationSystem.js";

export default class SAC extends AmortizationSystem {
    constructor() {
        super("Sistema de Amortização Constante (SAC)");
    }
    atualizarValores(montante, tempo, taxa) {
        this.juros = this.saldo * taxa;
        this.amortizacao = montante / tempo;
        this.pagamento = this.juros + this.amortizacao;
        this.saldo -= this.amortizacao;
    }
}
