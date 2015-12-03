<%--
  Created by IntelliJ IDEA.
  User: andreealibotean
  Date: 12/3/2015
  Time: 10:22 AM
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
            <li><a href="<%=request.getContextPath()%>/sec/moderation.html">Home</a></li>
            <li><a href="<%=request.getContextPath()%>/students/page=1">Students</a></li>
            <li><a href="<%=request.getContextPath()%>/professors/page=1">Professors</a></li>
            <li><a href="<%=request.getContextPath()%>/courses/page=1">Courses</a></li>
        </ul>
    </div>

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
                                    <a href="${pageContext.request.contextPath}/courses/${courseDTO.idCourse}">View</a>
                                </td>

                            </tr>

                        </c:forEach>

                        </tbody>
                        <tbody>
                        <tr>
                            <td>
                                <div class="pagination-container">
                                    <c:forEach var="page" begin="1" end="${numberOfPages}">
                                        <c:url var="url" value="/courses/page=${page}"/>
                                        <span id="page-number"> <a href="${url}"> ${page} </a> </span>
                                    </c:forEach>
                                </div>
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
