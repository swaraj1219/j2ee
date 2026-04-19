<%@ page language="java" %>
<html>
<body>

<h2>User Details</h2>

<%
    String name = (String) request.getAttribute("name");
    String email = (String) request.getAttribute("email");
    String desig = (String) request.getAttribute("desig");
%>

<p><b>Username:</b> <%= name %></p>
<p><b>Email:</b> <%= email %></p>
<p><b>Designation:</b> <%= desig %></p>

<br>

<a href="index.jsp">🔙 Go Back to Client Side Form</a>

</body>
</html>