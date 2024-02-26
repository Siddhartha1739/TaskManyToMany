<%@page language="java" %>
<html>
<%--<head> <a href="style.css"/> </head>--%>
<h1>Assigning Employee to Project;</h1>
<form action="/assignEmployee"  >
    <%--@declare id="Id"--%><%--@declare id="name"--%><%--@declare id="lastname"--%><%--@declare id="role"--%><%--@declare id="salary"--%><%--@declare id="id"--%><%--@declare id="prjctid"--%><%--@declare id="empid"--%><label for="empId">Enter Id : </label>
    <label for="empId">Enter Id: </label>
    <input type="number"  name="empId"><br>
    <input type="hidden" name="prjctid" value=${prjctid}>
    <input type="submit" value="Submit">
</form>
</html>