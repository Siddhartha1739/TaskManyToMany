<%@page language="java" %>
<html>
<%--<head> <a href="style.css"/> </head>--%>
<form action="deleteEmployee">
    <%--@declare id="empid"--%>
    <label for="empId">Enter Id to delete the employee : </label>
    <input type="number"  name="employeeId"><br>
    <input type="submit" value="Submit">
</form>
</html>