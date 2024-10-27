package mk.finki.ukim.mk.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.services.BookingImpl;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "booking", urlPatterns = "/w/booking")
public class EventBookingServlet extends HttpServlet {

    private final SpringTemplateEngine templateEngine;
    private final BookingImpl booking;

    // Constructor for dependency injection
    public EventBookingServlet(SpringTemplateEngine templateEngine, BookingImpl booking) {
        this.templateEngine = templateEngine;
        this.booking = booking;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);

        String userName = req.getParameter("userName");
        String userAddress = req.getParameter("userAddress");
        String selectedEvent = req.getParameter("selectedEvent");
        String numTickets = req.getParameter("numTickets");

        context.setVariable("userName", userName);
        context.setVariable("userAddress", req.getRemoteAddr());
        context.setVariable("selectedEvent", selectedEvent);
        context.setVariable("numTickets", numTickets);

        this.templateEngine.process("bookingConfirmation.html", context, resp.getWriter());
    }




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // You can implement any post logic here if needed, or keep it empty.
        super.doPost(req, resp);
    }
}
