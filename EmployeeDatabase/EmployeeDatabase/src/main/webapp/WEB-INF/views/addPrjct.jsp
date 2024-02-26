<%@page language="java" %>
<html>
<%--<head> <a href="style.css"/> </head>--%>
<h1>RegisterProject</h1>
<form action="/addedProject"  >
    <%--@declare id="Id"--%><%--@declare id="name"--%><%--@declare id="lastname"--%><%--@declare id="role"--%><%--@declare id="salary"--%><%--@declare id="id"--%><%--@declare id="prjctid"--%><label for="empId">Enter Id : </label>
    <label for="prjctid">Enter Id: </label>
    <input type="number"  name="prjctid"><br>
    <label for="name">Enter Project Name : </label>
    <input type="text"  name="name"><br>
    <input type="submit" value="Submit">
</form>

</html>