package basic;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UserDataServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");
        String email = request.getParameter("email");
        String desig = request.getParameter("designation");

        // SERVER-SIDE VALIDATION
        if (name == null || name.equals("") ||
            email == null || email.equals("") ||
            desig == null || desig.equals("")) {

            out.println("<h2>❌ All fields are required (Server Validation Failed)</h2>");
            return;
        }

        // email check
        if (!email.contains("@")) {
            out.println("<h2>❌ Invalid Email Format</h2>");
            return;
        }

        // pass data to JSP
        request.setAttribute("name", name);
        request.setAttribute("email", email);
        request.setAttribute("desig", desig);

        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
}