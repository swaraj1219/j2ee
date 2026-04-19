<%@ page language="java" %>
<html>
<head>

<script>
function validateForm() {

    let fields = ["roll", "name", "s1", "s2", "s3", "s4", "s5"];

    for (let i = 0; i < fields.length; i++) {
        let val = document.forms["stuForm"][fields[i]].value;
        if (val == "") {
            alert("All fields are required!");
            return false;
        }
    }

    // check marks range (0–100)
    for (let i = 2; i <= 6; i++) {
        let mark = document.forms["stuForm"][fields[i]].value;
        if (mark < 0 || mark > 100) {
            alert("Marks must be between 0 and 100");
            return false;
        }
    }

    return true;
}
</script>

</head>

<body>

<h2>Student Result Form</h2>

<form name="stuForm" action="ResultServlet" method="post"
      onsubmit="return validateForm()">

Roll No: <input type="text" name="roll"><br><br>
Name: <input type="text" name="name"><br><br>

Sub1: <input type="number" name="s1"><br><br>
Sub2: <input type="number" name="s2"><br><br>
Sub3: <input type="number" name="s3"><br><br>
Sub4: <input type="number" name="s4"><br><br>
Sub5: <input type="number" name="s5"><br><br>

<input type="submit" value="Submit">

</form>

</body>
</html>