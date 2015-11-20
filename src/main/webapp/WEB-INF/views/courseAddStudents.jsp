<%--
  Created by IntelliJ IDEA.
  User: andreealibotean
  Date: 11/18/2015
  Time: 4:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add students for course</title>
    <link href="<c:url value="/resources/core/css/bootstrap.min.css" />" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="navbar-header">
        <ul class="nav navbar-nav navbar-right">
            <li><a href="<%=request.getContextPath()%>/index">Home</a></li>
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

        <div class="row" style="left: 10px">
            <div class="col-lg-8">
                <div class="well bs-component">
                    <form class="form-horizontal">
                        <fieldset>
                            <legend>Add students for course:</legend>


                            <div class="form-group">
                                <label class="col-lg-2 control-label">Name:</label>

                                <div class="col-lg-8">
                                    <div class="radio">
                                        <label>
                                            ${courseDTO.name}
                                        </label>
                                    </div>
                                </div>
                            </div>


                            <div class="form-group">
                                <div class="col-lg-12">
                                    <a class="btn btn-default"
                                       href="http://localhost:8080/courses">Back to
                                        courses</a>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>

        <%--List of students for course--%>
        <div class="row table-bordered">
            <div class="form-group">
                <label class="col-lg-2 control-label">Students assigned to course:</label>

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
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </label>
                    </div>
                </div>

            </div>
        </div>


        <%--Form to add students --%>
        <c:choose>
            <c:when test="${not empty students}">
                <div class="row table-bordered">
                    <div class="form-group">

                        <form:form method="post" modelAttribute="courseDTO" class="form-horizontal">
                            <fieldset>

                                <label class="col-lg-2 control-label">Enroll students:</label>

                                <div class="col-lg-10">
                                    <div class="radio">
                                        <label>
                                            <table class="table table-striped table-hover ">
                                                <tbody>
                                                <c:forEach var="studentDTO" items="${students}">
                                                    <tr>
                                                        <td>
                                                            <form:checkbox path="studentsIds"
                                                                           value="${studentDTO.idStudent}"/>${studentDTO.name}${' '}${studentDTO.surname}
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                        </label>

                                    </div>
                                </div>


                                <div class="form-group">
                                    <div class="col-lg-6 col-lg-offset-6">
                                        <button type="submit" class="btn btn-primary">Submit</button>
                                    </div>
                                </div>
                            </fieldset>
                        </form:form>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <b>There are no more students available to enroll to this course.Please return to</b> <a
                    class="btn btn-default" href="<%=request.getContextPath()%>/courses">Courses</a>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>

