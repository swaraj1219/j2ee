<%@ page language="java" %>
<html>
<head>

<script>
function validateForm() {

    let name = document.forms["userForm"]["username"].value;
    let email = document.forms["userForm"]["email"].value;
    let desig = document.forms["userForm"]["designation"].value;

    if (name == "" || email == "" || desig == "") {
        alert("All fields are required!");
        return false;
    }

    // simple email validation
    let emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;

    if (!email.match(emailPattern)) {
        alert("Enter valid email!");
        return false;
    }

    return true;
}
</script>

</head>

<body>

<h2>User Registration Form</h2>

<form name="userForm" action="UserDataServlet" method="post"
      onsubmit="return validateForm()">

    Username:
    <input type="text" name="username"><br><br>

    Email:
    <input type="text" name="email"><br><br>

    Designation:
    <input type="text" name="designation"><br><br>

    <input type="submit" value="Submit">

</form>

</body>
</html>