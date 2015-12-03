<%--
  Created by IntelliJ IDEA.
  User: andreealibotean
  Date: 12/3/2015
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Professor details</title>
    <link href="<c:url value="/resources/core/css/bootstrap.min.css" />" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="navbar-header">
        <ul class="nav navbar-nav navbar-right">
            <li><a href="<%=request.getContextPath()%>/sec/moderation.html">Home</a></li>
            <li><a href="<%=request.getContextPath()%>/students/page=1">Students</a></li>
            <li><a href="<%=request.getContextPath()%>/professors/page=1">Professors</a></li>
            <li><a href="<%=request.getContextPath()%>/courses/page=1">Courses</a></li>
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
                            <legend>Professor details</legend>

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


                            <%--Professor Surname--%>
                            <div class="form-group">
                                <label class="col-lg-2 control-label">Surname:</label>

                                <div class="col-lg-8">
                                    <div class="radio">
                                        <label>
                                            ${professor.surname}
                                        </label>
                                    </div>
                                </div>
                            </div>


                            <%--Gender--%>
                            <div class="form-group">
                                <label class="col-lg-2 control-label">Gender:</label>

                                <div class="col-lg-8">
                                    <div class="radio">
                                        <label>
                                            ${professor.gender}
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
                                            ${professor.cnp}
                                        </label>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-lg-12">
                                    <a class="btn btn-default"
                                       href="<%=request.getContextPath()%>/professors/page=1">Back</a>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>

        <%--List of courses that professor teaches--%>
        <div class="row table-bordered">
            <div class="form-group">
                <label class="col-lg-2 control-label">Teaches at courses:</label>

                <div class="col-lg-10">
                    <div class="radio">
                        <label>
                            <table class="table table-striped table-hover ">
                                <tbody>
                                <c:forEach var="courseDTO" items="${teachingCourses}">
                                    <tr>
                                        <td><a class="btn btn-default"
                                               href="<%=request.getContextPath()%>/courses/${courseDTO.idCourse}">${courseDTO.name}</a>
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


    </div>

</div>

</div>

</body>
</html>
