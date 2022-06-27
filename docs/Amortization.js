import PagamentoUnico from "./sistemas/PagamentoUnico.js";
import Americano from "./sistemas/Americano.js";
import SAC from "./sistemas/SAC.js";
import Price from "./sistemas/Price.js";
import Misto from "./sistemas/Misto.js";
import Alemao from "./sistemas/Alemao.js";

export let Sistemas = [new PagamentoUnico(), new Americano(), new SAC(), new Price(), new Misto(), new Alemao()];