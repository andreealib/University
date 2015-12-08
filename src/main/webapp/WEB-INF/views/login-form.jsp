<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: andreealibotean
  Date: 11/27/2015
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<?xml version="1.0" encoding="ISO-8859-1" ?>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <link href="<c:url value="/resources/core/css/bootstrap.min.css" />" rel="stylesheet">
    <title>Login page</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Login page</h1>
    <br/>

    <p>
        <c:if test="${error == true}">
            <b class="error">Invalid login or password.</b>
        </c:if>
    </p>

    <form method="post" action="<c:url value='j_spring_security_check'/>">

        <div class="form-group">
            <label for="j_username">Login:</label>
            <input type="text" name="j_username" id="j_username" size="30" maxlength="40" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="j_password">Password:</label>
            <input type="password" name="j_password" id="j_password" size="30" maxlength="32" class="form-control"/>
        </div>
        <button type="submit" class="btn btn-default">Log in</button>

    </form>
    <br/>

    <p>
        <a href="${pageContext.request.contextPath}/index.html" class="btn btn-info">Home page</a><br/>
    </p>
    <br/>
    <p>
        <a href="${pageContext.request.contextPath}/moderForm" class="btn btn-info">Add new account</a><br/>
    </p>
</div>
</body>
</html>
