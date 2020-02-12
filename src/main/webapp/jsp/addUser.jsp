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
<div class="form-style-2-heading">Add user</div>
<div class="form-style-2">
    <form method="post" action="/users">
        <label for="first_name"> First name
            <input class="input-field" type="text" id="first_name" name="first_name"/>
        </label>
        <label for="last_name"> Last name
            <input  class="input-field" type="text" id="last_name" name="last_name"/>
        </label>
        <input class="select-field" type="submit" value="Add user">
    </form>
    </div>
</body>
</html>