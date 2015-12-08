<%--
  Created by IntelliJ IDEA.
  User: andreealibotean
  Date: 12/8/2015
  Time: 10:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New user</title>
    <link href="<c:url value="/resources/core/css/bootstrap.min.css" />" rel="stylesheet">

</head>

<body>
<div class="container">

    <div class="navbar-header">
        <ul class="nav navbar-nav navbar-right">
            <li><a href="<%=request.getContextPath()%>/sec/moderation.html">Home</a></li>
        </ul>
    </div>

    <div class="row">
        <div class="col-lg-12">
            <div class="page-header">
                <h1 id="forms">Add new account</h1>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-6">
            <div class="well bs-component">
                <form:form method="post" modelAttribute="user" class="form-horizontal">
                    <fieldset>
                        <legend>Add new user</legend>

                            <%--Name--%>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">Username</label>

                            <div class="col-lg-8">
                                <form:input type="text" path="login" placeholder="enter username here..."/>
                                <div class="has-error" style="color: #ff0700">
                                    <form:errors path="login"/>
                                </div>
                            </div>
                        </div>
                            <%--Password--%>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">Password</label>

                            <div class="col-lg-8">
                                <form:input type="password" path="password" placeholder="enter password here..."/>
                                <div class="has-error" style="color: #ff0700">
                                    <form:errors path="password"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-lg-6 col-lg-offset-6">
                                <button type="submit" class="btn btn-primary">Submit</button>
                                <a class="btn btn-default" href="${pageContext.request.contextPath}/index.html" class="btn btn-info">Back to Homepage</a>
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
