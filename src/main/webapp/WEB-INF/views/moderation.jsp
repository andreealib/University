<%--
  Created by IntelliJ IDEA.
  User: andreealibotean
  Date: 11/27/2015
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>
<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <link href="<c:url value="/resources/core/css/bootstrap.min.css" />" rel="stylesheet">
    <title>Moderation page</title>
</head>
<body>
<div class="container">
    <h1>Moderation page</h1>

    <p>This is Moderation page. It's available for moderators.<br/>


    <div class="navbar-header">
        <ul class="nav navbar-nav navbar-right">
            <li><a href="http://localhost:8080">Home</a></li>
            <li><a href="<%=request.getContextPath()%>/students/page=1">Students</a></li>
            <li><a href="<%=request.getContextPath()%>/professors/page=1">Professors</a></li>
            <li><a href="<%=request.getContextPath()%>/courses/page=1">Courses</a></li>
        </ul>
    </div>
    </br>


    <div class="form-group">
        <div class="col-lg-12">
            <a href="<c:url value="/j_spring_security_logout" />" class="btn btn-info">Logout</a>
            <a href="${pageContext.request.contextPath}/index.html" class="btn btn-info">Home page</a>
        </div>
    </div>
</div>
</body>
</html>
