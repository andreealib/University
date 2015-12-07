<%--
  Created by IntelliJ IDEA.
  User: andreealibotean
  Date: 12/7/2015
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<?xml version="1.0" encoding="ISO-8859-1" ?>


<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Send email</title>
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
    <a href="<c:url value="/j_spring_security_logout" />" class="btn btn-info"
       style="position: relative;left: 65%;top: 10%;">Logout</a>

    <div class="row">
        <div class="col-lg-12">
            <div class="page-header">
                <h1 id="forms">Contact</h1>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-6">
            <div class="well bs-component">
                <form:form method="post" modelAttribute="email" class="form-horizontal">
                    <fieldset>
                        <legend>Complete the fields below</legend>

                            <%--Email address--%>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">From:</label>

                            <div class="col-lg-8">
                                <form:input type="text" path="from" placeholder="enter receiver address"/>
                                <div class="has-error" style="color: #ff0700">
                                    <form:errors path="from"/>
                                </div>
                            </div>
                        </div>
                            <%--Subject--%>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">Subject:</label>

                            <div class="col-lg-8">
                                <form:input type="text" path="subject" placeholder="short subject"/>
                                <div class="has-error" style="color: #ff0700">
                                    <form:errors path="subject"/>
                                </div>
                            </div>
                        </div>

                            <%--Text(email body)--%>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">Message</label>

                            <div class="col-lg-8">
                                <form:textarea path="message" placeholder="enter message here..." rows="15" cols="40"/>
                                <div class="has-error" style="color: #ff0700">
                                    <form:errors path="message"/>
                                </div>
                            </div>
                        </div>


                        <div class="form-group">
                            <div class="col-lg-6 col-lg-offset-6">
                                <button type="submit" class="btn btn-primary">Submit</button>
                                <a class="btn btn-default" href="<%=request.getContextPath()%>/admin/first.html">Back
                                    to Moderation Page</a>
                            </div>
                        </div>

                    </fieldset>
                </form:form>
            </div>
        </div>
    </div>
    <p style="color: #3e8f3e;font-size: medium">${msg}</p>

</div>

</body>
</html>
