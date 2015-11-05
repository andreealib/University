<%--
  Created by IntelliJ IDEA.
  User: Lei Florin
  Date: 27.09.2015
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Faculties List</title>
    <link href="<c:url value="/resources/core/css/bootstrap.min.css" />" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="navbar-header">
        <ul class="nav navbar-nav navbar-right">
            <li><a href="<%=request.getContextPath()%>/index.jsp">Home</a></li>
            <li><a href="<%=request.getContextPath()%>/universities/faculties">Faculties</a></li>
            <li><a href="<%=request.getContextPath()%>/universities/students">Students</a></li>
            <li><a href="<%=request.getContextPath()%>/universities/courses">Courses</a></li>
        </ul>
    </div>

    <div class="bs-docs-section">
        <div class="row">
            <div class="col-lg-12">
                <div class="page-header">
                    <h1 id="tables">Faculties list</h1>
                </div>

                <div class="bs-component">
                    <table class="table table-striped table-hover ">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Faculty Name</th>
                            <th>Faculty City</th>
                            <th colspan="3" class="actions">Actions</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="faculty" items="${faculties}" varStatus="status">
                            <tr>
                                <td>${status.index + 1}</td>
                                <td>${faculty.name}</td>
                                <td>${faculty.city}</td>
                                <td><a href="${pageContext.request.contextPath}/universities/faculties/${faculty.idfaculty}">View</a></td>
                                <td><a href="${pageContext.request.contextPath}/universities/faculties/edit/${faculty.idfaculty}">Edit</a></td>
                                <td><a href="${pageContext.request.contextPath}/universities/faculties/delete/${faculty.idfaculty}">Delete</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>

                        <tbody>
                        <tr>
                            <td colspan="6"><a href="${pageContext.request.contextPath}/universities/facultyForm">Add</a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
    </div>
</div>
//
        <form method="get" id="searchFaculty" name="searchFaculty" action="<%=request.getContextPath()%>/faculties/search">
            <div class="small-3 columns">
                <input type="text" id ="txt" name="searchString" >
            </div>
            <div class="small-5 columns end" value="Search" id="button-id" onclick="document.forms[0].submit">Search</div>
            <div> ${player.superTeam} </div>
        </form>
//
</body>
</html>