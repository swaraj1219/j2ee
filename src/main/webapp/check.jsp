<%@ page language="java" %>
<%
    String name = (String) session.getAttribute("user");
%>

<html>
<body>

<%
if (name == null) {
%>

    <h2>❌ Session Expired!</h2>
    <p>Your session time is over.</p>
    <a href="index.jsp">Start Again</a>

<%
} else {
%>

    <h2>Hello <%= name %> 👋</h2>
    <p>Session is still active.</p>

    <p>Wait for expiry time to test session timeout.</p>

    <a href="check.jsp">Refresh Check</a>

<%
}
%>

</body>
</html>