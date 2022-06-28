package model;

public class Client {

    public static void main(String[] args) {
        Amortization c = new AmericanSystem();
        c.capital(100000, 10, 0.01);
    }
}
