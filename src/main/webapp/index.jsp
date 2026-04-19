<%@ page language="java" %>
<html>
<body>

<h2>Session Management JSP (9c)</h2>

<form action="welcome.jsp" method="post">

    Enter Your Name:
    <input type="text" name="username" required>
    <br><br>

    Session Expiry Time (in minutes):
    <input type="number" name="time" required>

    <br><br>

    <input type="submit" value="Submit">

</form>

</body>
</html>