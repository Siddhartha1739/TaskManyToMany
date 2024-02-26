<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.example.EmployeeDatabase.Entity.Employee"%> <!-- Change the import path to match your Employee class -->

<!DOCTYPE html>
<html>
<head>
    <title>Employee Details</title>
    <%--    <a href="style.css"/>--%>
</head>
<body>
<h1>Employee Details</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Role</th>
        <th>Salary</th>
    </tr>
    <tr>
        <td>${empId}</td>
        <td>${name}</td>
        <td>${role}</td>
        <td>${salary}</td>
    </tr>
</table>
<a href="first">First Page</a>
</body>
</html>
