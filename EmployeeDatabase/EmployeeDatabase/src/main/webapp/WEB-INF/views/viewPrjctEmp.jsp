<%@ page import="java.util.List" %>
<%@ page import="com.example.EmployeeDatabase.Entity.Employee"%>
<%@ page import="com.example.EmployeeDatabase.Model.EmployeeModel" %>
<!-- Change the import path to match your Employee class -->

<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
    <%--    <a href="style.css"/>--%>
</head>
<body>
<h1>Employee List</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Role</th>
        <th>Salary</th>
        <th>Update</th>
        <th>Delete</th>
        <th>Add Project</th>
        <th>View Projects</th>
    </tr>
    <%
        List<EmployeeModel> employeeList = (List<EmployeeModel>) request.getAttribute("EmployeeList");
        for (EmployeeModel employee : employeeList) {
    %>
    <tr>
        <td><%= employee.getEmpId() %></td>
        <td><%= employee.getFirstName() + " " + employee.getLastName() %></td>
        <td><%= employee.getRole() %></td>
        <td><%= employee.getSalary() %></td>

        <td>
            <form action="updateEmployee" style="background-color:darkgreen">
                <input type="hidden" name="empId" value="<%= employee.getEmpId() %>">
                <input type="submit" value="Update">
            </form>
        </td>
        <td>
            <form action="RemoveEmployee" style="background-color:crimson">
                <input type="hidden" name="empId" value="<%= employee.getEmpId() %>">
                <input type="hidden" name="prjctid" value=${prjctid}>
                <input type="submit" value="Remove">
            </form>
        </td>
        <td>
            <form action="assigningPrjct" >
                <input type="hidden" name="empId" value="<%= employee.getEmpId() %>">
                <input type="submit" value="assigningPrjct">
            </form>
        </td>
        <td>
            <form action="viewEmpPrjct" >
                <input type="hidden" name="empId" value="<%= employee.getEmpId() %>">
                <input type="submit" value="View Projects">
            </form>
        </td>
    </tr>
    <% } %>
</table>

<a href="first">First Page</a>
</body>
</html>
