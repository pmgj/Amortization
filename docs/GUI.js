/* global Intl */
import Systems from "./Amortization.js";

function GUI() {
    const formatter = new Intl.NumberFormat('pt-br', {
        style: 'currency',
        currency: 'BRL'
    });
    function cleanTable() {
        let tbody = document.querySelector("tbody");
        tbody.innerHTML = "";
    }
    function createRows(row, text) {
        let cell = document.createElement("td");
        let textNode = document.createTextNode(text);
        cell.appendChild(textNode);
        row.appendChild(cell);
    }
    function setTotals(row) {
        let table = document.querySelector("table");
        let footnote = table.tFoot.rows[0];
        for (let i = 0; i < row.length; i++) {
            footnote.cells[i + 1].innerHTML = formatter.format(row[i]);
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
        setTotals(matrix[i]);
    }
    function compute() {
        let form = document.forms[0];
        let option = form.option.selectedIndex;
        let principal = parseFloat(form.principal.value);
        let period = parseInt(form.period.value, 10);
        let interestRate = parseFloat(form.interestRate.value) / 100;
        if (principal > 0 && period > 0 && interestRate > 0) {
            cleanTable();
            let result = Systems[option].calcular(principal, period, interestRate);
            print(result);
        }
    }
    function registerEvents() {
        let form = document.forms[0];
        let select = form.option;
        for (let i in Systems) {
            let option = document.createElement("option");
            option.text = Systems[i];
            option.value = i;
            select.add(option);
        }        
        form.option.onchange = compute;
        form.principal.onkeyup = compute;
        form.period.onkeyup = compute;
        form.interestRate.onkeyup = compute;
        form.principal.focus();
    }

    return {registerEvents};
}
let gui = GUI();
gui.registerEvents();
