<%--
  Created by IntelliJ IDEA.
  User: Lei Florin
  Date: 01.10.2015
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
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
                    <h1 id="forms">Course Details</h1>
                </div>
            </div>
        </div>

        <div class="row" style="left: auto">
            <div class="col-lg-6">
                <div class="well bs-component">
                    <form class="form-horizontal">
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
                                <div class="col-lg-12">
                                    <a class="btn btn-default" href="<%=request.getContextPath()%>/courseForm">Add
                                        course</a>
                                    <a class="btn btn-default"
                                       href="<%=request.getContextPath()%>/courses/edit/${course.idCourse}">Update
                                        course</a>
                                    <a class="btn btn-default" href="<%=request.getContextPath()%>/courses">Back</a>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>

        <!--Students registered at this course: -->

        <div class="row table-bordered">
            <div class="form-group">
                <label class="col-lg-2 control-label">Registered students:</label>

                <div class="col-lg-10">
                    <div class="radio">
                        <label>
                            <table class="table table-striped table-hover ">
                                <tbody>
                                <c:forEach var="studentDTO" items="${registeredStudents}">
                                    <tr>
                                        <td><a class="btn btn-default"
                                               href="<%=request.getContextPath()%>/students/${studentDTO.idStudent}">${studentDTO.name}${' '}${studentDTO.surname}</a>
                                        </td>

                                        <td>
                                            <a href="${pageContext.request.contextPath}/courses/${course.idCourse}/deleteStud/${studentDTO.idStudent}">Delete</a>
                                        </td>

                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </label>
                    </div>
                </div>
            </div>
        </div>

        <!-- add students to course-->
        <div>
            <label>
                <a class="btn btn-default"
                   href="<%=request.getContextPath()%>/courses/${course.idCourse}/addStudents">Add
                    students</a>
            </label>
        </div>


        <!--Professors registered at this course: -->

        <div class="row table-bordered">
            <div class="form-group">
                <label class="col-lg-2 control-label">Registered professors:</label>

                <div class="col-lg-10">
                    <div class="radio">
                        <label>
                            <table class="table table-striped table-hover ">
                                <tbody>
                                <c:forEach var="professorDTO" items="${registeredProfessors}">
                                    <tr>
                                        <td><a class="btn btn-default"
                                               href="<%=request.getContextPath()%>/professors/${professorDTO.idProfessor}">${professorDTO.name}${' '}${professorDTO.surname}</a>
                                        </td>

                                        <td>
                                            <a href="${pageContext.request.contextPath}/courses/${course.idCourse}/deleteProf/${professorDTO.idProfessor}">Delete</a>
                                        </td>

                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </label>
                    </div>
                </div>
            </div>
        </div>

        <!--add professors to course-->
        <div>
            <label>
                <a class="btn btn-default"
                   href="<%=request.getContextPath()%>/courses/${course.idCourse}/addProfessors">Add
                    professors</a>
            </label>
        </div>


    </div>

</div>

</body>
</html>
