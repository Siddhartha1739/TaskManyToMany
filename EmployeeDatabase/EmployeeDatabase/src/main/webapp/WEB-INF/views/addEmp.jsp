<%@page language="java" %>
<html>
<%--<head> <a href="style.css"/> </head>--%>
<h1>RegisterEmployee</h1>
<form action="/addedEmployee"  >

    <%--@declare id="empid"--%><%--@declare id="firstname"--%><%--@declare id="lastname"--%><%--@declare id="role"--%><%--@declare id="salary"--%><label for="empId">Enter Id : </label>
    <label for="empId">Enter Id: </label>
    <input type="number"  name="empId"><br>
    <label for="firstName">Enter Employee First Name : </label>
    <input type="text"  name="firstName"><br>
    <label for="lastName">Enter Employee Last Name : </label>
    <input type="text"  name="lastName"><br>
    <label for="role">Enter EmployeeRole: </label>
    <input type="text"  name="role"><br>
    <label for="salary">Enter Employee Salary : </label>
    <input type="number"  name="salary"><br>
    <input type="submit" value="Submit">
</form>

</html>