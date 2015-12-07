<%--
  Created by IntelliJ IDEA.
  User: andreealibotean
  Date: 12/7/2015
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Email list</title>
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
        </ul>
    </div>

    <a href="<c:url value="/j_spring_security_logout" />" class="btn btn-info"
       style="position: relative;left: 65%;top: 10%;">Logout</a>

    <div class="row">
        <div class="col-lg-12">
            <div class="page-header">
                <h1 id="tables">Inbox</h1>
            </div>
            <div class="bs-component">
                <table class="table table-striped table-hover ">
                    <thead>
                    <tr>
                        <th>No.</th>
                        <th>From</th>
                        <th>Subject</th>
                        <th colspan="3" class="actions">Actions</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="message" items="${emails}" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td>
                            <td>${message.getFrom()[0]}</td>
                            <td>${message.getSubject()}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/admin/emails/reply/${readingInboxService.userEmail(message.getContent().toString())}">Reply</a>
                            </td>
                        </tr>
                        <tr><td><b>Message:</b></td></tr>
                        <tr><td>${message.getContent()}</td></tr>


                    </c:forEach>

                    </tbody>
                    <tbody>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</div>

</body>
</html>
