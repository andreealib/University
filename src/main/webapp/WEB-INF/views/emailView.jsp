<%--
  Created by IntelliJ IDEA.
  User: andreealibotean
  Date: 12/8/2015
  Time: 1:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Email details</title>
    <link href="<c:url value="/resources/core/css/bootstrap.min.css" />" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="navbar-header">
        <ul class="nav navbar-nav navbar-right">
            <li><a href="<%=request.getContextPath()%>/admin/first.html">Home</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/students/page=1">Students</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/professors/page=1">Professors</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/courses/page=1">Courses</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/emails">Emails</a></li>

        </ul>
    </div>
    <a href="<c:url value="/j_spring_security_logout" />" class="btn btn-info"
       style="position: relative;left: 65%;top: 10%;">Logout</a>

    <div class="bs-docs-section">
        <div class="row">
            <div class="col-lg-12">
                <div class="page-header">
                    <h1 id="forms">Email details</h1>
                </div>
            </div>
        </div>

        <div class="row" style="left: 10px">
            <div class="col-lg-8">
                <div class="well bs-component">
                    <form class="form-horizontal">
                        <fieldset>
                            <legend>Email details</legend>

                            <%--Professor Name--%>
                            <div class="form-group">
                                <label class="col-lg-2 control-label">From:</label>

                                <div class="col-lg-8">
                                    <div class="radio">
                                        <label>
                                            ${readingInboxService.userEmail(message.getContent().toString())}
                                        </label>
                                    </div>
                                </div>
                            </div>


                            <%--Subject--%>
                            <div class="form-group">
                                <label class="col-lg-2 control-label">Subject:</label>

                                <div class="col-lg-8">
                                    <div class="radio">
                                        <label>
                                            ${message.getSubject()}
                                        </label>
                                    </div>
                                </div>
                            </div>


                            <%--Gender--%>
                            <div class="form-group">
                                <label class="col-lg-2 control-label">Content:</label>

                                <div class="col-lg-8">
                                    <div class="radio">
                                        <label>
                                            ${readingInboxService.getContentWithoutEmail(message.getContent().toString())}
                                        </label>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-lg-12">
                                    <a class="btn btn-default"
                                       href="${pageContext.request.contextPath}/admin/emails/reply/${readingInboxService.userEmail(message.getContent().toString())}">
                                        Reply to this email
                                    </a>
                                    <a class="btn btn-default"
                                       href="<%=request.getContextPath()%>/admin/emails">Back</a>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>



    </div>

</div>

</div>

</body>
</html>

