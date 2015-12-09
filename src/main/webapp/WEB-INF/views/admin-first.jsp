<%--
  Created by IntelliJ IDEA.
  User: andreealibotean
  Date: 11/27/2015
  Time: 10:38 AM
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
    <title>Admin page</title>
</head>
<body>
<div class="container">
    <a href="<c:url value="/j_spring_security_logout" />" class="btn btn-info" style="position: relative;left: 93%;top: 10%;">Logout</a><br/>
    <p style="position: relative;left: 93%;top: 10%;">
        Logged in as: <b>${username}</b>
    </p>
    <h1>Admin page</h1>

    <p>This is Admin page. It's available for admins.<br/>

    <div class="navbar-header">
        <ul class="nav navbar-nav navbar-right">
            <li><a href="http://localhost:8080">Home</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/students/page=1">Students</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/professors/page=1">Professors</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/courses/page=1">Courses</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/emails">Emails</a></li>

        </ul>
    </div>


    <br/>

    <div class="form-group">
        <div class="col-lg-12">
            <a href="${pageContext.request.contextPath}/index.html" class="btn btn-info">Home page</a>
            <a href="${pageContext.request.contextPath}/admin/adminForm" class="btn btn-info">Add new account</a>
        </div>
    </div>

</div>

</body>
</html>
