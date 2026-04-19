<%@ page import="javax.servlet.http.Cookie" %>
<%@ page language="java" %>

<%
    String name = request.getParameter("name");
    String domain = request.getParameter("domain");
    int age = Integer.parseInt(request.getParameter("age"));

    // Create cookie (name = value = domain for simplicity)
    Cookie cookie = new Cookie(name, domain);

    cookie.setMaxAge(age);

    // Set domain if provided
    if(domain != null && !domain.equals("")) {
        cookie.setDomain(domain);
    }

    response.addCookie(cookie);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Cookie Added</title>
</head>
<body>

<h2>Cookie Added Successfully!</h2>

<p><b>Name:</b> <%= name %></p>
<p><b>Domain:</b> <%= domain %></p>
<p><b>Max Age:</b> <%= age %> seconds</p>

<br>

<a href="showCookies.jsp">Go to Active Cookie List</a>

</body>
</html>