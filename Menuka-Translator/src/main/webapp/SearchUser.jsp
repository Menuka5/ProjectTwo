<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search Users</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="top.jsp" %>

<%
    ArrayList users = (ArrayList) request.getAttribute("name");
    ArrayList dob = (ArrayList) request.getAttribute("dob");
    ArrayList country = (ArrayList) request.getAttribute("country");
    ArrayList email = (ArrayList) request.getAttribute("email");
    ArrayList usernames = (ArrayList) request.getAttribute("username");
    ArrayList mobile = (ArrayList) request.getAttribute("mnumber");
%>

<%
    for (int i = 0; i < users.size(); i++) {
        out.println(users.get(i) + " " + dob.get(i) + " " + country.get(i) + " " + email.get(i) + " " + mobile.get(i) + " " + usernames.get(i) + "<br>");
    }
%>
</body>
</html>
