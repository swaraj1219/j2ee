<%@ page language="java" %>
<%
    String name = request.getParameter("username");

    // Create session
    session.setAttribute("user", name);

    // Set session expiry time = 1 minute (60 seconds)
    session.setMaxInactiveInterval(60);
%>

<html>
<body>

<h2>Session Created Successfully!</h2>

<a href="result.jsp">Click here to see Greeting</a>

</body>
</html>