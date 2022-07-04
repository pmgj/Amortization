package servlets;

import java.util.List;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import model.AmericanSystem;
import model.Amortization;
import model.ConstantSystem;
import model.FrenchSystem;
import model.GermanSystem;
import model.LoanSystem;
import model.SinglePaymentSystem;

@WebListener
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        List<Amortization> list = List.of(new AmericanSystem(), new ConstantSystem(), new FrenchSystem(), new GermanSystem(), new LoanSystem(), new SinglePaymentSystem());
        sce.getServletContext().setAttribute("systems", list);
    }
}
