<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>

<head>
    <title>Menuka's Login Page</title>


</head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="background.css">
<link rel="stylesheet" href="css/index.css">
<body class="container">


<div class="login container-fluid">
    <%
        String s2 = (String) request.getAttribute("Error");
        if (s2 != null) {
            out.println(s2);
        }
    %>

    <div class="text-warning">

        <form action="MyServlet" class="form-horizontal" method="post">
            <div class="form-group">
                <label for="uname" class="col-sm-3 control-label textclr">Username : </label>

                <div class="col-sm-9">
                    <input type="text" name="username" class="form-control" placeholder="Enter username" id="uname"
                           value="test">
                </div>

            </div>
            <div class="form-group">
                <label for="pword" class="col-sm-3 control-label textclr">password : </label>

                <div class="col-sm-9">
                    <input type="password" name="password" id="pword" class="form-control" placeholder="Enter password"
                           value="test123">
                </div>
            </div>
            <div class="form-group">

                <input type="submit" class="btn btn-success btn-block" value="Login">


            </div>


        </form>
    </div>


</div>

</body>
</html>