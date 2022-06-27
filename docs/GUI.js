/* global Intl */
import Systems from "./Amortization.js";

function GUI() {
    const formatter = new Intl.NumberFormat('pt-br', {
        style: 'currency',
        currency: 'BRL'
    });
    function limparTabela() {
        let tbody = document.querySelector("tbody");
        tbody.innerHTML = "";
    }
    function createRows(linha, texto) {
        let cell = document.createElement("td");
        let textNode = document.createTextNode(texto);
        cell.appendChild(textNode);
        linha.appendChild(cell);
    }
    function setTotais(linha) {
        let tabela = document.querySelector("table");
        let rodape = tabela.tFoot.rows[0];
        for (let i = 0; i < linha.length; i++) {
            rodape.cells[i + 1].innerHTML = formatter.format(linha[i]);
        }
    }
    function print(matrix) {
        let tbody = document.querySelector("tbody"), i;
        for (i = 0; i < matrix.length - 1; i++) {
            let row = matrix[i];
            let tr = document.createElement("tr");
            for (let j = 0; j < row.length; j++) {
                let cell = row[j];
                createRows(tr, j === 0 ? cell : formatter.format(cell));
            }
            tbody.appendChild(tr);
        }
        setTotais(matrix[i]);
    }
    function calcular() {
        let form = document.forms[0];
        let opcao = form.opcao.selectedIndex;
        let montante = parseFloat(form.montante.value);
        let tempo = parseInt(form.tempo.value, 10);
        let taxa = parseFloat(form.taxa.value) / 100;
        if (montante > 0 && tempo > 0 && taxa > 0) {
            limparTabela();
            let resultado = Systems[opcao].calcular(montante, tempo, taxa);
            print(resultado);
        }
    }
    function registerEvents() {
        let form = document.forms[0];
        let select = form.opcao;
        for (let i in Systems) {
            let option = document.createElement("option");
            option.text = Systems[i];
            option.value = i;
            select.add(option);
        }        
        form.opcao.onchange = calcular;
        form.montante.onkeyup = calcular;
        form.tempo.onkeyup = calcular;
        form.taxa.onkeyup = calcular;
        form.montante.focus();
    }

    return {registerEvents};
}
let gui = GUI();
gui.registerEvents();
