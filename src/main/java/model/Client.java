package model;

import java.text.NumberFormat;

public class Client {

    public static void main(String[] args) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        Amortization c = new AmericanSystem();
        Schedule schedule = c.capital(100000, 10, 0.01);
        System.out.println(
                String.format("%2s %15s %15s %15s %15s", "n", "Interest", "Amortization", "Installment", "Balance"));
        for (Item item : schedule.getItems()) {
            System.out.println(String.format("%2d %15s %15s %15s %15s", item.getPeriod(),
                    formatter.format(item.getInterest()), formatter.format(item.getAmortization()),
                    formatter.format(item.getInstallment()), formatter.format(item.getBalance())));
        }
        Item totals = schedule.getTotals();
        System.out.println(String.format("-> %15s %15s %15s %15s", formatter.format(totals.getInterest()),
                formatter.format(totals.getAmortization()), formatter.format(totals.getInstallment()),
                formatter.format(totals.getBalance())));
    }
}
