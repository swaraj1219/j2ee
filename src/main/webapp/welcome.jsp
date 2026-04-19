<%@ page language="java" %>
<%
    // Create session
    String name = request.getParameter("username");

    session.setAttribute("user", name);

    // Set session expiry time = 60 seconds (1 minute)
    session.setMaxInactiveInterval(60);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>

<h2>
    Hello <%= name %>!
</h2>

<a href="check.jsp">Check Session Status</a>

</body>
</html>