<%--
  Created by IntelliJ IDEA.
  User: Lei Florin
  Date: 28.09.2015
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Student details</title>
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
          <h1 id="forms">Student Details</h1>
        </div>
      </div>
    </div>

    <div class="row" style="left: 10px">
      <div class="col-lg-8">
        <div class="well bs-component">
          <form class="form-horizontal">
            <fieldset>
              <legend>Student details</legend>

              <%--Student Name--%>
              <div class="form-group">
                <label class="col-lg-2 control-label">Name:</label>
                <div class="col-lg-8">
                  <div class="radio">
                    <label>
                      ${student.name}
                    </label>
                  </div>
                </div>
              </div>

              <%--Student Surname--%>
              <div class="form-group">
                <label class="col-lg-2 control-label">Surname:</label>
                <div class="col-lg-8">
                  <div class="radio">
                    <label>
                      ${student.surname}
                    </label>
                  </div>
                </div>
              </div>

              <%--Faculty--%>
              <div class="form-group">
                <label class="col-lg-2 control-label">Faculty:</label>
                <div class="col-lg-8">
                    <div class="radio">
                        <label>
                            ${student.faculty.name}
                        </label>
                    </div>
                </div>
              </div>

              <%--City--%>
              <div class="form-group">
                <label class="col-lg-2 control-label">City:</label>
                <div class="col-lg-8">
                  <div class="radio">
                    <label>
                      ${student.faculty.city}
                    </label>
                  </div>
                </div>
              </div>

              <%--Date of birth--%>
              <div class="form-group">
                <label class="col-lg-2 control-label">Date of birth:</label>
                <div class="col-lg-8">
                  <div class="radio">
                    <label>
                      ${student.birth_date}
                    </label>
                  </div>
                </div>
              </div>

              <%--Sex--%>
              <div class="form-group">
                <label class="col-lg-2 control-label">Sex:</label>
                <div class="col-lg-8">
                  <div class="radio">
                    <label>
                      ${student.sex}
                    </label>
                  </div>
                </div>
              </div>

              <%--CNP--%>
              <div class="form-group">
                <label class="col-lg-2 control-label">CNP:</label>
                <div class="col-lg-8">
                  <div class="radio">
                    <label>
                      ${student.CNP}
                    </label>
                  </div>
                </div>
              </div>

              <div class="form-group">
                <div class="col-lg-12">
                  <a class="btn btn-default" href="<%=request.getContextPath()%>/universities/studentForm">Add student</a>
                  <a class="btn btn-default" href="<%=request.getContextPath()%>/universities/students/edit/${student.idstudent}">Update student</a>
                  <a class="btn btn-default" href="<%=request.getContextPath()%>/universities/students">Back</a>
                </div>
              </div>
            </fieldset>
          </form>
        </div>
      </div>
    </div>

    <%--List of courses--%>
    <div class="row table-bordered">
      <div class="form-group">
        <label class="col-lg-2 control-label">Courses list</label>
        <div class="col-lg-10">
          <div class="radio">
            <label>
              <table class="table table-striped table-hover ">
                <tbody>
                <c:forEach var="course" items="${courseList}">
                  <tr>
                    <td><a class="btn btn-default" href="<%=request.getContextPath()%>/universities/courses/${course.idcourse}">${course.name}</a></td>
                  </tr>
                </c:forEach>
                </tbody>
            </label>
          </div>
        </div>
      </div>
    </div>

  </div>

  </div>

</div>

</body>
</html>
