<%@page language="java" %>
<html>
<%--<head> <a href="style.css"/> </head>--%>
<h1>Assigning Project to Employee:</h1>
<form action="/assignPrjct"  >
    <%--@declare id="Id"--%><%--@declare id="name"--%><%--@declare id="lastname"--%><%--@declare id="role"--%><%--@declare id="salary"--%><%--@declare id="id"--%><%--@declare id="prjctid"--%><label for="empId">Enter Id : </label>
    <label for="prjctid">Enter Id: </label>
    <input type="number"  name="prjctid"><br>
        <input type="hidden" name="empId" value=${empId}>
    <input type="submit" value="Submit">
</form>
</html>