package basic;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class VisitServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");

        int visitCount = 1;

        Cookie[] cookies = request.getCookies();

        Cookie nameCookie = null;
        Cookie countCookie = null;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("username")) {
                    nameCookie = c;
                }
                if (c.getName().equals("visits")) {
                    countCookie = c;
                }
            }
        }

        if (nameCookie != null && countCookie != null) {
            visitCount = Integer.parseInt(countCookie.getValue());
            visitCount++;

            countCookie.setValue(String.valueOf(visitCount));
        } else {
            nameCookie = new Cookie("username", name);
            countCookie = new Cookie("visits", "1");
        }

        // Cookie expiry (example: 1 minute = 60 seconds)
        nameCookie.setMaxAge(60);
        countCookie.setMaxAge(60);

        response.addCookie(nameCookie);
        response.addCookie(countCookie);

        // Output
        out.println("<html><body>");

        out.println("<h2>Welcome back " + name + "!</h2>");
        out.println("<h3>You have visited this page " + visitCount + " times</h3>");

        out.println("<h3>List of Cookies:</h3>");

        Cookie[] allCookies = request.getCookies();
        if (allCookies != null) {
            for (Cookie c : allCookies) {
                out.println(c.getName() + " : " + c.getValue() + "<br>");
            }
        }

        out.println("<br><b>Note:</b> Cookies will expire in 60 seconds.");

        out.println("</body></html>");
    }
}