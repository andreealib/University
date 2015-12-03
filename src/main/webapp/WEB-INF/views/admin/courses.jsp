<%--
  Created by IntelliJ IDEA.
  User: Lei Florin
  Date: 01.10.2015
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Coursess List</title>
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

    <div class="bs-docs-section">
        <div class="row">
            <div class="col-lg-12">
                <div class="page-header">
                    <h1 id="tables">Courses list</h1>
                </div>
                <div class="bs-component">
                    <table class="table table-striped table-hover ">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Course name</th>
                            <th colspan="3" class="actions">Actions</th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="courseDTO" items="${courses}" varStatus="status">
                            <tr>
                                <td>${status.index + 1}</td>
                                <td>${courseDTO.name}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/admin/courses/${courseDTO.idCourse}">View</a>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/admin/courses/edit/${courseDTO.idCourse}">Edit</a>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/admin/courses/delete/${courseDTO.idCourse}">Delete</a>
                                </td>
                            </tr>

                        </c:forEach>

                        </tbody>
                        <tbody>
                        <tr>
                            <td>
                                <div class="pagination-container">
                                    <c:forEach var="page" begin="1" end="${numberOfPages}">
                                        <c:url var="url" value="/admin/courses/page=${page}"/>
                                        <span id="page-number"> <a href="${url}"> ${page} </a> </span>
                                    </c:forEach>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="6"><a href="${pageContext.request.contextPath}/admin/courseForm">Add</a>
                            </td>
                        </tr>


                        <tr>
                            <a class="btn btn-default" href="<%=request.getContextPath()%>/coursesPdf" target="_blank">PDF</a>
                        </tr>


                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>