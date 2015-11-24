<%--
  Created by IntelliJ IDEA.
  User: Lei Florin
  Date: 28.09.2015
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Students List</title>
  <link href="<c:url value="/resources/core/css/bootstrap.min.css" />" rel="stylesheet">
</head>
<body>
<div class="container">
  <div class="navbar-header">
    <ul class="nav navbar-nav navbar-right">
      <li><a href="http://localhost:8080">Home</a></li>
      <li><a href="<%=request.getContextPath()%>/students">Students</a></li>
      <li><a href="<%=request.getContextPath()%>/professors">Professors</a></li>
      <li><a href="<%=request.getContextPath()%>/courses">Courses</a></li>
    </ul>
  </div>

  <div class="bs-docs-section">
    <div class="row">
      <div class="col-lg-12">
        <div class="page-header">
          <h1 id="tables">Students list</h1>
        </div>
        <div class="bs-component">
          <table class="table table-striped table-hover ">
            <thead>
            <tr>
              <th>#</th>
              <th>Student name</th>
              <th>Student Surname</th>

              <th colspan="3" class="actions">Actions</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="student" items="${students}" varStatus="status">
              <tr>
                <td>${status.index + 1}</td>
                <td>${student.name}</td>
                <td>${student.surname}</td>

                <td>
                  <a href="${pageContext.request.contextPath}/students/${student.idStudent}">View</a>
                </td>
                <td>
                  <a href="${pageContext.request.contextPath}/students/edit/${student.idStudent}">Edit</a>
                </td>
                <td>
                  <a href="${pageContext.request.contextPath}/students/delete/${student.idStudent}">Delete</a>

                </td>
              </tr>

            </c:forEach>

            </tbody>
            <tbody>
            <tr>
              <td colspan="6"><a href="${pageContext.request.contextPath}/studentForm">Add</a>
              </td>
            </tr>

            <tr>
              <a class="btn btn-default" href="<%=request.getContextPath()%>/studentsPdf" target="_blank">PDF</a>
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
