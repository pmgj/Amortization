import Systems from "./Amortization.js";

class GUI {
    constructor() {
        this.formatter = new Intl.NumberFormat('pt-br', {
            style: 'currency',
            currency: 'BRL'
        });    
    }
    cleanTable() {
        let tbody = document.querySelector("tbody");
        tbody.innerHTML = "";
    }
    setTotals(row) {
        let table = document.querySelector("table");
        let footnote = table.tFoot.rows[0];
        for (let i = 0; i < row.length; i++) {
            footnote.cells[i + 1].innerHTML = this.formatter.format(row[i]);
        }
    }
    print(matrix) {
        let tbody = document.querySelector("tbody"), i;
        let t = document.querySelector('#row');
        let tds = t.content.querySelectorAll("td");
        for (i = 0; i < matrix.length - 1; i++) {
            let row = matrix[i];
            for (let j = 0; j < row.length; j++) {
                let cell = row[j];
                tds[j].textContent = j === 0 ? cell : this.formatter.format(cell);
            }
            let clone = document.importNode(t.content, true);
            tbody.appendChild(clone);
        }
        this.setTotals(matrix[i]);
    }
    compute() {
        let form = document.forms[0];
        let option = form.option.selectedIndex;
        let principal = form.principal.valueAsNumber;
        let period = form.period.valueAsNumber;
        let interestRate = form.interestRate.valueAsNumber / 100;
        if (principal > 0 && period > 0 && interestRate > 0) {
            this.cleanTable();
            let result = Systems[option].calcular(principal, period, interestRate);
            this.print(result);
        }
    }
    registerEvents() {
        let form = document.forms[0];
        let select = form.option;
        for (let i in Systems) {
            let option = document.createElement("option");
            option.text = Systems[i];
            option.value = i;
            select.add(option);
        }
        form.option.onchange = this.compute.bind(this);
        form.principal.onkeyup = this.compute.bind(this);
        form.period.onkeyup = this.compute.bind(this);
        form.interestRate.onkeyup = this.compute.bind(this);
        form.principal.focus();
    }
}
let gui = new GUI();
gui.registerEvents();
