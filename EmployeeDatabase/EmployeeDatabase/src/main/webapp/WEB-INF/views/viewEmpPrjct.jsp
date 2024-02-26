<%@ page import="java.util.List" %>
<%@ page import="com.example.EmployeeDatabase.Entity.Project" %>
<%@ page import="com.example.EmployeeDatabase.Model.ProjectModel" %>
<!-- Change the import path to match your Project class -->

<!DOCTYPE html>
<html>
<head>
    <title>Project List</title>
    <%--    <a href="style.css"/>--%>
</head>
<body>
<h1>Project List</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Update</th>
        <th>Delete</th>
        <th>Add Employee</th>
        <th>View Employee</th>

    </tr>
    <%
        List<ProjectModel> projectList = (List<ProjectModel>) request.getAttribute("projectList");
        for (ProjectModel project : projectList) {
    %>
    <tr>
        <td><%= project.getPrjctid() %></td>
        <td><%= project.getName() %></td>

        <td>
            <form action="updateProject" style="background-color:darkgreen">
                <input type="hidden" name="prjctid" value="<%= project.getPrjctid() %>">
                <input type="submit" value="Update">
            </form>
        </td>
        <td>
            <form action="RemoveProject" style="background-color:crimson">
                <input type="hidden" name="prjctid" value="<%= project.getPrjctid() %>">
                <input type="hidden" name="empId" value=${empId}>
                <input type="submit" value="Remove">
            </form>
        </td>
        <td>
            <form action="assigningEmployee" style="background-color:darkgreen">
                <input type="hidden" name="prjctid" value="<%= project.getPrjctid() %>">
                <input type="submit" value="assigningEmployee">
            </form>
        </td>
        <td>
            <form action="viewPrjctEmp" >
                <input type="hidden" name="prjctid" value="<%= project.getPrjctid() %>">
                <input type="submit" value="View Employees">
            </form>
        </td>
    </tr>
    <% } %>
</table>

<a href="first">First Page</a>
</body>
</html>
