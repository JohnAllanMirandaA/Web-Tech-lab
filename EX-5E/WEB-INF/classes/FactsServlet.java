import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/FactsServlet")
public class FactsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html"); 
        PrintWriter out = response.getWriter(); 
        String jdbcURL = "jdbc:mysql://localhost:3306/facts_db"; 
        String dbUser = "root";
        String dbPassword = "";

        
        String stateName = request.getParameter("state");

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            String query = "SELECT * FROM facts WHERE state = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, stateName); 

        
            ResultSet rs = stmt.executeQuery();

            out.println("<html><body>");
            out.println("<h1>Facts of India</h1>");
            
            if (rs.next()) {
                
                out.println("<table border='1'>");
                out.println("<tr><th>ID</th><th>State</th><th>Fact</th></tr>");

                
                do {
                    out.println("<tr><td>" + rs.getInt("id") + "</td><td>" + rs.getString("state") + "</td><td>" + rs.getString("fact") + "</td></tr>");
                } while (rs.next());
                out.println("</table>");
            } else {
                
                out.println("<p>No facts found for the state: " + stateName + "</p>");
            }

            out.println("</body></html>");

        
            conn.close();
        } catch (Exception e) {
            
            e.printStackTrace();
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }
}
