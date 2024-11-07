import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/SessionWithCookies")
public class SessionWithCookies extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Encode the cookie value to avoid invalid characters
        String cookieValue = URLEncoder.encode("Tracking with Cookies", StandardCharsets.UTF_8.toString());
        Cookie cookie = new Cookie("message", cookieValue);
        cookie.setMaxAge(60 * 60); // Cookie expires in 1 hour
        response.addCookie(cookie);

        out.println("<html><body>");
        out.println("<h3>Tracking with Cookies: A cookie has been set.</h3>");
        out.println("</body></html>");
    }
}
