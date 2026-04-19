<%@ page language="java" %>
<%
    String name = (String) session.getAttribute("user");

    if (name == null) {
%>
        <h2>Session Expired ❌ (After 1 minute)</h2>
        <a href="index.jsp">Go Back</a>
<%
    } else {
%>
        <h2>Hello <%= name %> 👋</h2>
        <p>Your session is active.</p>
<%
    }
%>