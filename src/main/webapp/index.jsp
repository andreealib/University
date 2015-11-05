<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Universities</title>
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
        </div>
    </body>
</html>