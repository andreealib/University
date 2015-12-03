<%--
  Created by IntelliJ IDEA.
  User: Lei Florin
  Date: 01.10.2015
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit course</title>
    <link href="<c:url value="/resources/core/css/bootstrap.min.css" />" rel="stylesheet">
</head>

<body>
<div class="container">

    <div class="navbar-header">
        <ul class="nav navbar-nav navbar-right">
            <li><a href="<%=request.getContextPath()%>/admin/first.html">Home</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/students/page=1">Students</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/professors/page=1">Professors</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/courses/page=1">Courses</a></li>
        </ul>
    </div>
    <a href="<c:url value="/j_spring_security_logout" />" class="btn btn-info" style="position: relative;left: 65%;top: 10%;">Logout</a>

    <div class="row">
        <div class="col-lg-12">
            <div class="page-header">
                <h1 id="forms">Edit course</h1>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-6">
            <div class="well bs-component">
                <form:form method="post" modelAttribute="course" class="form-horizontal">
                    <fieldset>
                        <legend>Edit course</legend>

                        <div class="form-group">
                            <label class="col-lg-4 control-label">Course name</label>

                            <div class="col-lg-8">
                                <div class="radio">
                                    <form:input type="text" path="name" placeholder="name..."
                                                value="${course.name}"/>
                                </div>
                                <div class="has-error" style="color: #ff0700">
                                    <form:errors path="name"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">


                            <div class="form-group">
                                <div class="col-lg-6 col-lg-offset-6">
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                    <button type="reset" class="btn btn-default">Cancel</button>
                                    <a class="btn btn-default"
                                       href="<%=request.getContextPath()%>/admin/courses/page=1">Back</a>
                                </div>
                            </div>

                    </fieldset>
                </form:form>
            </div>
        </div>
    </div>
</div>

</body>
</html>