import AmortizationSystem from "./AmortizationSystem.js";

export default class ConstantSystem extends AmortizationSystem {
    constructor() {
        super("Constant System");
    }
    atualizarValores(montante, tempo, taxa) {
        this.juros = this.saldo * taxa;
        this.amortizacao = montante / tempo;
        this.pagamento = this.juros + this.amortizacao;
        this.saldo -= this.amortizacao;
    }
}
