<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<html>

<head>
    <title>Menuka's Login Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <style type="text/css">
        .login {
            width: 500px;
            clear: both;
            margin-left: 25%;
            margin-top: 15%;

        }

        .login input {
            width: 80%;
            clear: both;
        }

        body {
            background: url(images/background.png) no-repeat center;
            background-size: cover;
            width: 100%;
            height: 100%;
        }

        .textclr {
            color: white;
        }
    </style>
</head>
<body class="container">


<div class="login container-fluid">
    <%
    String s2 = (String) request.getAttribute("Error");
    if (s2 != null) {
    out.println(s2);
    }
    %>

    <div class="text-warning">

        <form action="MyServlet" class="form-horizontal">
            <div class="form-group">
                <label for="uname" class="col-sm-3 control-label textclr">Username : </label>

                <div class="col-sm-9">
                    <input type="text" name="username" class="form-control" placeholder="Enter username" id="uname">
                </div>

            </div>
            <div class="form-group">
                <label for="pword"  class="col-sm-3 control-label textclr">password : </label>

                <div class="col-sm-9">
                    <input type="password" name="password" id="pword" class="form-control" placeholder="Enter password">
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