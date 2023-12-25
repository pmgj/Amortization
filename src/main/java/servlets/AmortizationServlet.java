package servlets;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Amortization;
import model.Schedule;

@WebServlet(name = "AmortizationServlet", urlPatterns = {"/AmortizationServlet"})
public class AmortizationServlet extends HttpServlet {

    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> names = req.getParameterNames();
        int option = 0, period = 0;
        double principal = 0, rate = 0;
        if (names.hasMoreElements()) {
            option = Integer.parseInt(req.getParameter("option"));
            principal = Double.parseDouble(req.getParameter("principal"));
            period = Integer.parseInt(req.getParameter("period"));
            rate = Double.parseDouble(req.getParameter("rate"));
            var list = (List<Amortization>) req.getServletContext().getAttribute("systems");
            var am = list.get(option);
            Schedule schedule = am.capital(principal, period, rate / 100.0);
            req.setAttribute("schedule", schedule);
        }
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
    
}
