<%@ page language="java" %>
<%
    String user = (String) session.getAttribute("user");

    if (user == null) {
%>
        <h2>Session Expired!</h2>
        <a href="index.jsp">Login Again</a>
<%
    } else {
%>
        <h2>Session Active</h2>
        <h3>Hello <%= user %>!</h3>
<%
    }
%>