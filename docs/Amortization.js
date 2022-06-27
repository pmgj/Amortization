import AmericanSystem from "./sistemas/AmericanSystem.js";
import ConstantSystem from "./sistemas/ConstantSystem.js";
import FrenchSystem from "./sistemas/FrenchSystem.js";
import GermanSystem from "./sistemas/GermanSystem.js";
import LoanSystem from "./sistemas/LoanSystem.js";
import SinglePaymentSystem from "./sistemas/SinglePaymentSystem.js";

export let Sistemas = [new AmericanSystem(), new ConstantSystem(), new FrenchSystem(), new GermanSystem(), new LoanSystem(), new SinglePaymentSystem()];