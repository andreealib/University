<%--
  Created by IntelliJ IDEA.
  User: andreealibotean
  Date: 11/10/2015
  Time: 12:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New professor</title>
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

    <div class="row">
        <div class="col-lg-12">
            <div class="page-header">
                <h1 id="forms">New professor</h1>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-6">
            <div class="well bs-component">
                <form:form  method="post" modelAttribute="professor" class="form-horizontal">
                    <fieldset>
                        <legend>Add new professor</legend>
                            <%--Faculty--%>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">Faculty Name</label>
                            <div class="col-lg-8">
                                <div class="radio">

                                    <form:select path="idfaculty">
                                        <form:option value="" label="Select faculty of origin" />
                                        <form:options items="${faculties}" itemValue="idfaculty" itemLabel="name"/>
                                    </form:select>



                                    <div class="has-error" style="color: #ff0700">
                                        <form:errors path="idfaculty"/>
                                    </div>

                                </div>
                            </div>
                        </div>
                            <%--Name--%>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">Name</label>
                            <div class="col-lg-8">
                                <form:input type="text" path="name" placeholder="Name"/>
                                <div class="has-error" style="color: #ff0700">
                                    <form:errors path="name"/>
                                </div>
                            </div>
                        </div>

                            <%--Date of birth--%>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">Date of birth</label>
                            <div class="col-lg-8">
                                <form:input type="text" path="birthDate" placeholder="yyyy-mm-dd"/>
                                <div class="has-error" style="color: #ff0700">
                                    <form:errors path="birthDate"/>
                                </div>
                            </div>
                        </div>
                            <%--Sex--%>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">Gender</label>
                            <div class="col-lg-8">
                                <form:input type="text" path="sex" placeholder="M / F"/>
                                <div class="has-error" style="color: #ff0700">
                                    <form:errors path="sex"/>
                                </div>
                            </div>
                        </div>
                            <%--CNP--%>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">CNP</label>
                            <div class="col-lg-8">
                                <form:input type="text" path="CNP" placeholder="insert 13 digits no."/>
                                <div class="has-error" style="color: #ff0700">
                                    <form:errors path="CNP"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-lg-6 col-lg-offset-6">
                                <button type="submit" class="btn btn-primary">Submit</button>
                                <a class="btn btn-default" href="<%=request.getContextPath()%>/universities/professors">Back</a>
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

