<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: andreealibotean
  Date: 11/27/2015
  Time: 10:36 AM
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
    <title>Home page</title>
</head>
<body>
<div class="container">
    <br>

    <h1>Home page</h1>
    <br/>

    <p style="font-size: 130%">This is Home page. It's available for all users.<br/><br/>

    <div class="list-group">

        <a href="${pageContext.request.contextPath}/sec/moderation.html" class="list-group-item"><h2 align="center"
                                                                                                     style="color: #204d74">
            Moderation page</h2></a><br/>

        <a href="${pageContext.request.contextPath}/admin/first.html" class="list-group-item"><h2 align="center"
                                                                                                  style="color: #204d74">
            Admin page</h2></a><br/>

    </div>

    </p>
</div>
</body>
</html>
