import SistemaAmortizacao from "./SistemaAmortizacao.js";

export default class Americano extends SistemaAmortizacao {
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
