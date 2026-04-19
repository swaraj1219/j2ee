package basic;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class CookieVisitApp8b extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");

        Cookie[] cookies = request.getCookies();

        int visitCount = 1;

        Cookie nameCookie = null;
        Cookie countCookie = null;

        // Check existing cookies
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("username")) {
                    nameCookie = c;
                }
                if (c.getName().equals("visitCount")) {
                    countCookie = c;
                }
            }
        }

        // Update visit count
        if (countCookie != null) {
            visitCount = Integer.parseInt(countCookie.getValue()) + 1;
        }

        // Create cookies
        Cookie c1 = new Cookie("username", name);
        Cookie c2 = new Cookie("visitCount", String.valueOf(visitCount));

        // Expiry (60 seconds demo)
        c1.setMaxAge(60);
        c2.setMaxAge(60);

        response.addCookie(c1);
        response.addCookie(c2);

        // Output
        out.println("<h2>Welcome back " + name + "!</h2>");
        out.println("<h3>You have visited this page " + visitCount + " times</h3>");

        out.println("<hr><h3>Cookie List:</h3>");

        Cookie[] allCookies = request.getCookies();

        if (allCookies != null) {
            for (Cookie c : allCookies) {
                out.println(c.getName() + " = " + c.getValue() + "<br>");
            }
        }

        out.println("<hr>");
        out.println("<p>Cookies will expire in 60 seconds.</p>");
    }
}