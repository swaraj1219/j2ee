<%@ page language="java" %>
<%
    String name = request.getParameter("username");
    String time = request.getParameter("time");

    int minutes = Integer.parseInt(time);

    // Store in session
    session.setAttribute("user", name);

    // Set session expiry (minutes → seconds)
    session.setMaxInactiveInterval(minutes * 60);
%>

<html>
<body>

<h2>Welcome <%= name %> 👋</h2>

<p>Session created successfully.</p>

<a href="check.jsp">Click here to check session</a>

</body>
</html>