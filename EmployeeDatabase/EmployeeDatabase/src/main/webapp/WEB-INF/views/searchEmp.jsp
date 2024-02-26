<%@ page import="jakarta.persistence.Id" %>
<%@page language="java" %>
<html>
<%--<head> <a href="style.css"/> </head>--%>
<form action="searchEmployee">
    <%--@declare id="empid"--%>
        <label for="empId">Enter Id to get employee details: </label>
        <input type="number"  name="employeeId"><br>
        <input type="submit" value="Submit">
</form>
</html>