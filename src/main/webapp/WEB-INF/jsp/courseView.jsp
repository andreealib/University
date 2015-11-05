<%--
  Created by IntelliJ IDEA.
  User: Lei Florin
  Date: 01.10.2015
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Course details</title>
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
          <h1 id="forms">Course Details</h1>
        </div>
      </div>
    </div>

    <div class="row" style="left: auto">
      <div class="col-lg-6">
        <div class="well bs-component">
          <form class="form-horizontal" >
            <fieldset>
              <legend>Course details</legend>
              <div class="form-group">
                <label class="col-lg-2 control-label">Name</label>
                <div class="col-lg-10">
                  <div class="radio">
                    <label>
                      ${course.name}
                    </label>
                  </div>
                </div>
              </div>

              <div class="form-group">
                <label class="col-lg-2 control-label">Professor name</label>
                <div class="col-lg-10">
                  <div class="radio">
                    <label>
                      ${course.professorName}
                    </label>
                  </div>
                </div>
              </div>

              <div class="form-group">
                <label class="col-lg-2 control-label">Belongs to:</label>
                <div class="col-lg-10">
                  <div class="radio">
                    <label>
                      ${course.faculty.name}
                    </label>
                  </div>
                </div>
              </div>

              <div class="form-group">
                <div class="col-lg-12">
                  <a class="btn btn-default" href="<%=request.getContextPath()%>/universities//courseForm">Add course</a>
                  <a class="btn btn-default" href="<%=request.getContextPath()%>/universities/courses/edit/${course.idcourse}">Update course</a>
                  <a class="btn btn-default" href="<%=request.getContextPath()%>/universities/courses">Back</a>
                </div>
              </div>
            </fieldset>
          </form>
        </div>
      </div>
    </div>

    <div class="row table-bordered">
      <div class="form-group">
        <label class="col-lg-2 control-label">Students</label>
        <div class="col-lg-10">
          <div class="radio">
            <label>
              <table class="table table-striped table-hover ">
                <tbody>
                <c:forEach var="student" items="${studentList}">
                  <tr>
                    <td><a class="btn btn-default" href="<%=request.getContextPath()%>/universities/students/${student.idstudent}">${student.name}&nbsp;${student.surname}</a></td>
                  </tr>
                </c:forEach>
                </tbody>
              </table>
            </label>
          </div>
        </div>
      </div>
    </div>

  </div>

</div>

</body>
</html>
