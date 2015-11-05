<%--
  Created by IntelliJ IDEA.
  User: Lei Florin
  Date: 27.09.2015
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New Faculty</title>
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
    <div class="row">
        <div class="col-lg-12">
            <div class="page-header">
                <h1 id="forms">New Faculty</h1>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-6">
            <div class="well bs-component">
                <form:form  method="post" modelAttribute="faculty" class="form-horizontal">
                    <fieldset>
                        <legend>Add new faculty</legend>
                        <%--Faculty name--%>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">Faculty Name</label>
                            <div class="col-lg-8">
                                <div class="radio">
                                    <form:input type="text" path="name" placeholder="Name"/>
                                    <div class="has-error" style="color: #ff0700">
                                        <form:errors path="name"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%--Location--%>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">Location</label>
                            <div class="col-lg-8">
                                <form:input type="text" path="city" placeholder="City"/>
                                <div class="has-error" style="color: #ff0700">
                                    <form:errors path="city"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-lg-4 control-label">Details</label>
                            <div class="col-lg-8">
                                <form:input type="text" path="info" placeholder="Info"/>
                                <div class="has-error" style="color: #ff0700">
                                    <form:errors path="info"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-lg-6 col-lg-offset-6">
                                <button type="submit" class="btn btn-primary">Submit</button>
                                <a class="btn btn-default" href="<%=request.getContextPath()%>/universities/faculties">Back</a>
                            </div>
                        </div>

                    </fieldset>
                </form:form>
            </div>
        </div>
    </div>
</div>

</body>
</html>