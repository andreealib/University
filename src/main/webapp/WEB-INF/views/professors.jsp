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
            <li><a href="<%=request.getContextPath()%>/index.jsp">Home</a></li>
            <li><a href="<%=request.getContextPath()%>/students">Students</a></li>
            <li><a href="<%=request.getContextPath()%>/professors">Professors</a></li>
            <li><a href="<%=request.getContextPath()%>/courses">Courses</a></li>
        </ul>
    </div>

    <div class="bs-docs-section">
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
                                    <a href="${pageContext.request.contextPath}/professors/${professor.idProfessor}">View</a>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/professors/edit/${professor.idProfessor}">Edit</a>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/professors/delete/${professor.idProfessor}">Delete</a>

                                </td>
                            </tr>

                        </c:forEach>

                        </tbody>
                        <tbody>
                        <tr>
                            <td colspan="6"><a
                                    href="${pageContext.request.contextPath}/professorForm">Add</a>
                            </td>
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
