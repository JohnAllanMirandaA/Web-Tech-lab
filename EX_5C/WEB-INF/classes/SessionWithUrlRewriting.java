import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SessionWithUrlRewriting")
public class SessionWithUrlRewriting extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = response.encodeURL("SessionWithUrlRewriting?message=Session+Tracking+with+URL+Rewriting");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Session Tracking with URL Rewriting</h3>");
        out.println("<a href='" + url + "'>Continue Session with URL Rewriting</a>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter("message");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>" + message + "</h3>");
    }
}
