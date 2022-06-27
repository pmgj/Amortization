import AmortizationSystem from "./AmortizationSystem.js";

export default class PagamentoUnico extends AmortizationSystem {
    constructor() {
        super("Sistema de Pagamento Único");
    }
    atualizarValores(montante, tempo, taxa) {
        this.juros = this.saldo * taxa;
        this.saldo += this.juros;
    }
    ultimaParcela(montante, tempo, taxa) {
        this.atualizarValores(montante, tempo, taxa);
        this.amortizacao = montante;
        this.pagamento = this.saldo;
    }
}
