<%--
  Created by IntelliJ IDEA.
  User: andreealibotean
  Date: 11/27/2015
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Home page</title>
</head>
<body>
<h1>Home page</h1>
<p>This is Home page. It's available for all users.<br/>
    <a href="${pageContext.request.contextPath}/sec/moderation.html">Moderation page</a><br/>
    <a href="${pageContext.request.contextPath}/admin/first.html">First Admin page</a><br/>
    <a href="${pageContext.request.contextPath}/admin/second.html">Second Admin page</a><br/>
</p>
</body>
</html>
