package basic;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionServlet9a extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");

        // Create session
        HttpSession session = request.getSession(true);

        // Set session timeout = 1 minute (60 seconds)
        session.setMaxInactiveInterval(60);

        // Visit count logic
        Integer visitCount = (Integer) session.getAttribute("count");

        if (visitCount == null) {
            visitCount = 1;
        } else {
            visitCount++;
        }

        // Store session values
        session.setAttribute("username", name);
        session.setAttribute("count", visitCount);

        // Output
        out.println("<h2>Session Tracking Information</h2>");
        out.println("Welcome: " + name + "<br><br>");

        out.println("Session ID: " + session.getId() + "<br>");
        out.println("Session Creation Time: " + new java.util.Date(session.getCreationTime()) + "<br>");
        out.println("Last Access Time: " + new java.util.Date(session.getLastAccessedTime()) + "<br>");
        out.println("Visit Count: " + visitCount + "<br>");

        out.println("<hr>");
        out.println("<p><b>Session timeout is 1 minute (60 seconds)</b></p>");
    }
}