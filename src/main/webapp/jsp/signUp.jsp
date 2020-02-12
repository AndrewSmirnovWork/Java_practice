<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.werdna.models.User" %>
<%--
  Created by IntelliJ IDEA.
  User: ЗТЛ
  Date: 19.08.2019
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%--<link rel="stylesheet" type="text/css" href="css/style.css"/>--%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
</head>
<body>
<div class="form-style-2-heading">Sign up</div>
<div class="form-style-2">
    <form method="post" action="/signUp">
        <label for="name"> User name
            <input class="input-field" type="text" id="name" name="name"/>
        </label>
        <label for="birthDate"> Birth date
            <input class="input-field"  type="text" id="birthDate" name="birthDate"/>
        </label>
        <label for="name"> password
            <input  class="input-field" type="password" id="password" name="password"/>
        </label>
        <input class="select-field" type="submit" value="Sign Up">
    </form>
    <table>
        <tr>
            <th>User name</th>
            <th>Birth Date</th>
        </tr>
        <c:forEach items="${usersFromServer}" var="user">
            <tr>
                <td>${user.name}</td>
                <td>${user.birthDate}</td>
            </tr>
        </c:forEach>

    </table>

</div>
</body>
</html>
