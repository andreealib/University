<%--
  Created by IntelliJ IDEA.
  User: andreealibotean
  Date: 11/11/2015
  Time: 9:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add courses for professor</title>
    <link href="<c:url value="/resources/core/css/bootstrap.min.css" />" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="navbar-header">
        <ul class="nav navbar-nav navbar-right">
            <li><a href="<%=request.getContextPath()%>/WEB-INF/views/index.jsp">Home</a></li>
            <li><a href="<%=request.getContextPath()%>/universities/faculties">Faculties</a></li>
            <li><a href="<%=request.getContextPath()%>/universities/students">Students</a></li>
            <li><a href="<%=request.getContextPath()%>/universities/professors">Professors</a></li>
            <li><a href="<%=request.getContextPath()%>/universities/courses">Courses</a></li>
        </ul>
    </div>
    <div class="bs-docs-section">
        <div class="row">
            <div class="col-lg-12">
                <div class="page-header">
                    <h1 id="forms">Professor Details</h1>
                </div>
            </div>
        </div>

        <div class="row" style="left: 10px">
            <div class="col-lg-8">
                <div class="well bs-component">
                    <form class="form-horizontal">
                        <fieldset>
                            <legend>Add courses for professor:</legend>

                            <%--Professor Name--%>
                            <div class="form-group">
                                <label class="col-lg-2 control-label">Name:</label>

                                <div class="col-lg-8">
                                    <div class="radio">
                                        <label>
                                            ${professor.name}
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
                                            ${professor.faculty.name}
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
                                            ${professor.CNP}
                                        </label>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-lg-12">
                                    <a class="btn btn-default"
                                       href="<%=request.getContextPath()%>/universities/professors">Back to
                                        Professors</a>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>

        <%--List of courses assigned to professor--%>
        <div class="row table-bordered">
            <div class="form-group">
                <label class="col-lg-2 control-label">Courses assigned to professor:</label>

                <div class="col-lg-10">
                    <div class="radio">
                        <label>
                            <table class="table table-striped table-hover ">
                                <tbody>
                                <c:forEach var="course" items="${courseList}">
                                    <tr>
                                        <td><a class="btn btn-default"
                                               href="<%=request.getContextPath()%>/universities/courses/${course.idcourse}">${course.name}</a>
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


        <%--Form to add courses to professor --%>
        <c:choose>
            <c:when test="${not empty allCourses}">
                <div class="row table-bordered">
                    <div class="form-group">

                        <form:form method="post" modelAttribute="professorCourseHandler" class="form-horizontal">
                            <fieldset>

                                <label class="col-lg-2 control-label">Add courses for professor:</label>

                                <div class="col-lg-10">
                                    <div class="radio">
                                        <label>
                                            <table class="table table-striped table-hover ">
                                                <tbody>
                                                <c:forEach var="course" items="${allCourses}">
                                                    <tr>
                                                        <td>
                                                            <form:checkbox path="idcourses" value="${course.idcourse}"/>${course.name}
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                        </label>

                                    </div>
                                </div>


                                <div class="form-group">
                                    <label class="col-lg-4 control-label"></label>

                                    <div class="col-lg-8" hidden="true">
                                        <form:input type="text" path="idprofessor" value="${professor.idprofessor}"/>
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
                <b>There are no more courses available to assign to this professor.Please return to</b> <a
                    class="btn btn-default" href="<%=request.getContextPath()%>/universities/professors">Professors</a>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>































