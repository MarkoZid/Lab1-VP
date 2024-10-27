package mk.finki.ukim.mk.lab.web;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.services.BookingImpl;
import mk.finki.ukim.mk.lab.services.ServiceImpl;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "woow", urlPatterns = "/w")
public class EventListServlet extends HttpServlet {

  private final ServiceImpl service;
  private final SpringTemplateEngine templateEngine;
  private final BookingImpl booking;

  public EventListServlet(ServiceImpl service, SpringTemplateEngine templateEngine
  , BookingImpl booking)
  {
      this.service = service;
      this.templateEngine = templateEngine;
      this.booking = booking;
  }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);

        context.setVariable("ip", req.getRemoteAddr());
        context.setVariable("cate", this.service.listAll());

        this.templateEngine.process("eventList.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("userName");
        String userAddress = req.getParameter("userAddress");
        String selectedEvent = req.getParameter("selectedEvent");
        int numTickets = Integer.parseInt(req.getParameter("numTickets"));

        this.booking.placeBooking(userName, userAddress, selectedEvent, numTickets);

        String redirectUrl = String.format("/w/booking?userName=%s&userAddress=%s&selectedEvent=%s&numTickets=%d",
                URLEncoder.encode(userName, "UTF-8"),
                URLEncoder.encode(userAddress, "UTF-8"),
                URLEncoder.encode(selectedEvent, "UTF-8"),
                numTickets);

        resp.sendRedirect(req.getContextPath() + redirectUrl);

    }
}
