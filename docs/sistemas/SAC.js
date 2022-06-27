import SistemaAmortizacao from "./SistemaAmortizacao.js";

export default class SAC extends SistemaAmortizacao {
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
