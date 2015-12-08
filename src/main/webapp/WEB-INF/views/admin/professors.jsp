<%--
  Created by IntelliJ IDEA.
  User: andreealibotean
  Date: 11/9/2015
  Time: 5:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Professors list</title>
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
            <li><a href="<%=request.getContextPath()%>/admin/emails">Emails</a></li>

        </ul>
    </div>

    <a href="<c:url value="/j_spring_security_logout" />" class="btn btn-info" style="position: relative;left: 65%;top: 10%;">Logout</a>

        <div class="row">
            <div class="col-lg-12">
                <div class="page-header">
                    <h1 id="tables">Professors list</h1>
                </div>
                <div class="bs-component">
                    <table class="table table-striped table-hover ">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Professor name</th>
                            <th>Professor surname</th>
                            <th colspan="3" class="actions">Actions</th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="professor" items="${professors}" varStatus="status">
                            <tr>
                                <td>${status.index + 1}</td>
                                <td>${professor.name}</td>
                                <td>${professor.surname}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/admin/professors/${professor.idProfessor}">View</a>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/admin/professors/edit/${professor.idProfessor}">Edit</a>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/admin/professors/delete/${professor.idProfessor}">Delete</a>

                                </td>
                            </tr>

                        </c:forEach>

                        </tbody>
                        <tbody>

                        <tr>
                            <td>
                                <div class="pagination-container">
                                    <c:forEach var="page" begin="1" end="${numberOfPages}">
                                        <c:url var="url" value="/admin/professors/page=${page}"/>
                                        <span id="page-number"> <a href="${url}"> ${page} </a> </span>
                                    </c:forEach>
                                </div>
                            </td>
                        </tr>

                        <tr>
                            <td colspan="6"><a
                                    href="${pageContext.request.contextPath}/admin/professorForm">Add</a>
                            </td>
                        </tr>


                        <tr>
                            <a class="btn btn-default" href="<%=request.getContextPath()%>/admin/professorsPdf"
                               target="_blank">PDF</a>
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
