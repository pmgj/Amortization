export default class SistemaAmortizacao {
    constructor(name) {
        this.name = name;
        this.juros = 0;
        this.amortizacao = 0;
        this.pagamento = 0;
        this.saldo = 0;
        this.somaJuros = 0;
    }
    calcular(montante, tempo, taxa) {
        let ret = [];
        this.inicializarValores(montante, tempo, taxa);
        this.somaJuros += this.juros;
        ret.push([0, this.juros, this.amortizacao, this.pagamento, this.saldo]);
        for (let n = 1; n < tempo; n++) {
            /* Calculando valores */
            this.atualizarValores(montante, tempo, taxa);
            this.somaJuros += this.juros;
            /* Preenchendo a tabela */
            ret.push([n, this.juros, this.amortizacao, this.pagamento, this.saldo]);
        }
        this.ultimaParcela(montante, tempo, taxa);
        this.somaJuros += this.juros;
        ret.push([tempo, this.juros, this.amortizacao, this.pagamento, 0]);
        ret.push([this.somaJuros, montante, this.somaJuros + montante, 0]);
        return ret;
    }
    inicializarValores(montante, tempo, taxa) {
        this.juros = 0;
        this.amortizacao = 0;
        this.pagamento = 0;
        this.saldo = montante;
        this.somaJuros = 0;
    }
    ultimaParcela(montante, tempo, taxa) {
        this.atualizarValores(montante, tempo, taxa);
    }
    toString() {
        return this.name;
    }
}
