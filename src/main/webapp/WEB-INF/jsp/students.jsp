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
          <h1 id="tables">Students list</h1>
        </div>
        <div class="bs-component">
          <table class="table table-striped table-hover ">
            <thead>
            <tr>
              <th>#</th>
              <th>Student name</th>
              <th>Student Surname</th>
              <th>Faculty name</th>
              <th colspan="3" class="actions">Actions</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="student" items="${students}" varStatus="status">
              <tr>
                <td>${status.index + 1}</td>
                <td>${student.name}</td>
                <td>${student.surname}</td>
                <td>${student.faculty.name}</td>
                <td>
                  <a href="${pageContext.request.contextPath}/universities/students/${student.idstudent}">View</a>
                </td>
                <td>
                  <a href="${pageContext.request.contextPath}/universities/students/edit/${student.idstudent}">Edit</a>
                </td>
                <td>
                  <a href="${pageContext.request.contextPath}/universities/students/delete/${student.idstudent}">Delete</a>
                    <%--<input type="button"  onclick="location.href='/delete'" value="Register" >--%>
                </td>
              </tr>

            </c:forEach>

            </tbody>
            <tbody>
            <tr>
              <td colspan="6"><a href="${pageContext.request.contextPath}/universities/studentForm">Add</a>
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
