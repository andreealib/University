<%--
  Created by IntelliJ IDEA.
  User: Lei Florin
  Date: 27.09.2015
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Faculty details</title>
        <link href="<c:url value="/resources/core/css/bootstrap.min.css" />" rel="stylesheet">
    </head>
<body>

<div class="container">
    <div class="navbar-header">
        <ul class="nav navbar-nav navbar-right">
            <li><a href="<%=request.getContextPath()%>/index.jsp">Home</a></li>
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
                    <h1 id="forms">Faculty Details</h1>
                </div>
            </div>
        </div>

        <div class="row" style="atsc-nav-left: 300px">
            <div class="col-lg-6">
                <div class="well bs-component">
                    <form class="form-horizontal">
                        <fieldset>
                            <legend>Faculty details</legend>

                            <%--Faculty Name--%>
                            <div class="form-group">
                                <label class="col-lg-2 control-label">Name</label>
                                <div class="col-lg-10">
                                    <div class="radio">
                                        <label>
                                            ${faculty.name}
                                        </label>
                                    </div>
                                </div>
                            </div>

                            <%--Faculty locatin--%>
                            <div class="form-group">
                                <label class="col-lg-2 control-label">Location</label>
                                <div class="col-lg-10">
                                    <div class="radio">
                                        <label>
                                            ${faculty.city}
                                        </label>
                                    </div>
                                </div>
                            </div>

                            <%-- Facylty details (info for faculty) --%>
                            <div class="form-group">
                                <label class="col-lg-2 control-label">Details</label>
                                <div class="col-lg-10">
                                    <div class="radio">
                                        <label>
                                            ${faculty.info}
                                        </label>
                                    </div>

                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-lg-12">
                                    <a class="btn btn-default" href="<%=request.getContextPath()%>/universities//facultyForm">Add faculty</a>
                                    <a class="btn btn-default" href="<%=request.getContextPath()%>/universities/faculties/edit/${faculty.idfaculty}">Update faculty</a>
                                    <a class="btn btn-default" href="<%=request.getContextPath()%>/universities/faculties">Back</a>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>

        <div class="row table-bordered" >
            <div class="form-group">
                <label class="col-lg-2 control-label">Courses</label>
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

</body>
</html>