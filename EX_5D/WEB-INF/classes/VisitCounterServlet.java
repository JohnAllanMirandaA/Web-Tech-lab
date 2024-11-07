import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VisitCounterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Cookie[] cookies = request.getCookies();
        String userID = null;
        int visitCount = 0;
        
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userID")) {
                    userID = cookie.getValue();
                } else if (cookie.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(cookie.getValue());
                }
            }
        }
        if (userID == null) {
            userID = java.util.UUID.randomUUID().toString(); 
            visitCount = 0;
            out.println("<h2>Welcome, new user!</h2>");
        } else {
            out.println("<h2>Welcome back, user: " + userID + "!</h2>");
        }

        visitCount++;
        out.println("<p>This is your visit number: " + visitCount + "</p>");

        Cookie userCookie = new Cookie("userID", userID);
        userCookie.setMaxAge(60 * 60 * 24 * 365);  
        response.addCookie(userCookie);
        
        Cookie countCookie = new Cookie("visitCount", Integer.toString(visitCount));
        countCookie.setMaxAge(60 * 60 * 24 * 365); 
        response.addCookie(countCookie);
    }
}
