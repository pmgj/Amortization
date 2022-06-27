import AmortizationSystem from "./AmortizationSystem.js";

export default class Americano extends AmortizationSystem {
    constructor() {
        super("Sistema Americano");
    }
    atualizarValores(montante, tempo, taxa) {
        this.juros = this.pagamento = this.saldo * taxa;
    }
    ultimaParcela(montante, tempo, taxa) {
        this.amortizacao = montante;
        this.pagamento = this.amortizacao + this.juros;
    }
}
