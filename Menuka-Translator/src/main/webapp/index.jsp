<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<fmt:setLocale value="en"/>
<fmt:bundle basename="Language">
<head>
    <title><fmt:message key="index.translator"/> <fmt:message key="index.login"/> <fmt:message key="index.page"/></title>


</head>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="background.css">
<link rel="stylesheet" href="css/index.css">
<body class="container">


<div class="login container-fluid">
 <%--   <%
        String s2 = (String) request.getAttribute("Error");
        if (s2 != null) {
            out.println(s2);

        }
    %>--%>
    <div style="color: white; align-content: center">
     <c:set var="s2" value='${requestScope["Error"]}' />

     <c:if test="${not empty s2}">
         <c:out value="${s2}"></c:out>
     </c:if>
    </div>
    <div class="text-warning">

        <form action="MyServlet" class="form-horizontal" method="post">
            <div class="form-group">
                <label for="uname" class="col-sm-3 control-label textclr"><fmt:message key="index.Username"/> : </label>

                <div class="col-sm-9">
                    <input type="text" name="username" class="form-control" placeholder="Enter username" id="uname"
                           value="test">
                </div>

            </div>
            <div class="form-group">
                <label for="pword" class="col-sm-3 control-label textclr"><fmt:message key="index.Password"/> : </label>

                <div class="col-sm-9">
                    <input type="password" name="password" id="pword" class="form-control" placeholder="Enter password"
                           value="test123">
                </div>
            </div>
            <div class="form-group">

                <input type="submit" class="btn btn-success btn-block" value=<fmt:message key="index.Login"/>>


            </div>


        </form>
    </div>


</div>
</fmt:bundle>
</body>
</html>