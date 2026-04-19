package basic;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class CookieVisitServletApp8a extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");

        int visitCount = 1;

        Cookie[] cookies = request.getCookies();
        Cookie visitCookie = null;

        // Find existing cookie
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ((name + "_visit").equals(c.getName())) {
                    visitCookie = c;
                    break;
                }
            }
        }

        // If cookie exists → increment
        if (visitCookie != null) {
            visitCount = Integer.parseInt(visitCookie.getValue()) + 1;
        }

        // Create / update cookie
        Cookie newCookie = new Cookie(name + "_visit", String.valueOf(visitCount));

        // Set expiry = 60 seconds
        newCookie.setMaxAge(60);

        response.addCookie(newCookie);

        // Output
        out.println("<html><body>");

        out.println("<h2>Welcome back " + name + "!</h2>");
        out.println("<h3>You have visited this page " + visitCount + " times</h3>");

        out.println("<h3>List of Cookies:</h3>");

        cookies = request.getCookies(); // refresh after adding cookie

        if (cookies != null) {
            out.println("<table border='1'>");
            out.println("<tr><th>Cookie Name</th><th>Value</th></tr>");

            for (Cookie c : cookies) {
                out.println("<tr><td>" + c.getName() + "</td><td>" + c.getValue() + "</td></tr>");
            }

            out.println("</table>");
        } else {
            out.println("<p>No cookies found</p>");
        }

        out.println("<br><a href='index.html'>Go Back</a>");

        out.println("</body></html>");
    }
}