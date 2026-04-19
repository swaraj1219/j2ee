<%@ page import="javax.servlet.http.Cookie" %>
<%@ page language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Active Cookies</title>
</head>
<body>

<h2>Active Cookie List</h2>

<%
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
%>

<table border="1">
    <tr>
        <th>Name</th>
        <th>Value</th>
    </tr>

<%
        for (Cookie c : cookies) {
%>
    <tr>
        <td><%= c.getName() %></td>
        <td><%= c.getValue() %></td>
    </tr>
<%
        }
%>

</table>

<%
    } else {
%>
    <h3>No Active Cookies Found</h3>
<%
    }
%>

<br>
<a href="index.jsp">Back to Home</a>

</body>
</html>