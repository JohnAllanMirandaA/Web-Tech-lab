import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SessionWithHiddenFields")
public class SessionWithHiddenFields extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<h3>Session Tracking with Hidden Form Fields</h3>");
        out.println("<form action='SessionWithHiddenFields' method='post'>");
        out.println("<input type='hidden' name='message' value='Session Tracking with Hidden Form Fields'>");
        out.println("<button type='submit'>Submit</button>");
        out.println("</form>");
        
        String message = request.getParameter("message");
        if (message != null) {
            out.println("<p>Message: " + message + "</p>");
        }
    }
}
