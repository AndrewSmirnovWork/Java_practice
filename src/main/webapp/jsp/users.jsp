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
<div class="form-style-2">
    <div class="form-style-2-heading">Already registered</div>
    <table>
        <tr>
            <th>First name</th>
        </tr>
    </table>
    <c:forEach items="${usersFromServer}" var="user">
        <tr>
            <td>${user.firstName}</td>
        </tr>
    </c:forEach>
    </div>
</body>
</html>
