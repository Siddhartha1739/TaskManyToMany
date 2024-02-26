<%@page language="java" %>
<html>
<%--<head> <a href="style.css"/> </head>--%>
<h1>RegisterEmployee</h1>
<form action="/updatedP" >

    <%--@declare id="empid"--%><%--@declare id="firstname"--%><%--@declare id="lastname"--%><%--@declare id="role"--%><%--@declare id="salary"--%><%--@declare id="name"--%><%--@declare id="id"--%><%--@declare id="prjctid"--%><label for="empId">Enter Id : </label>
    <label for="prjctid">Enter Id: </label>
    <input type="number"  name="prjctid" value="${prjctid}"><br>
    <label for="Name">Enter Project Name : </label>
    <input type="text"  name="Name" value="${Name}"><br>
    <input type="submit" value="Submit">
</form>
</html>