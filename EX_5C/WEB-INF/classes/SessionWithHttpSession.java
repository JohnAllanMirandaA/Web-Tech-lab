import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SessionWithHttpSession")
public class SessionWithHttpSession extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("message", "Session Tracking with HTTP Session Object");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>" + session.getAttribute("message") + "</h3>");
        out.println("<p>Session ID: " + session.getId() + "</p>");
    }
}
