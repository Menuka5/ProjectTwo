<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add User</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap.css">

    <link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css"/>
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

</head>
<body>
<%@include file="top.jsp" %>
<form action="AddUser" method="post" class="form-horizontal" onsubmit="confirmPass();">
    <fieldset>

        <!-- Form Name -->
        <center>
            <legend>Registration</legend>
        </center>
        <!-- Text input-->


        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="fname">First Name</label>

            <div class="col-md-5">
                <input id="fname" name="fname" type="text" placeholder="You First Name" class="form-control input-md"
                       required="dsfsdffsa">

            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="lname">Last Name</label>

            <div class="col-md-5">
                <input id="lname" name="lname" type="text" placeholder="Your Last Name" class="form-control input-md">

            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="date">Date of Birth</label>

            <div class="col-md-5">
                <input class="form-control" id="date" name="date" placeholder="YYYY/MM/DD" class="form-control input-md"
                       type="text" required/>
                <span class="help-block">Click on year to select year</span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="selectbasic">Country</label>

            <div class="col-md-4">
                <select id="selectbasic" name="country" class="form-control">
                    <option value="Sri Lanka">Sri Lanka</option>
                    <option value="Japan">Japan</option>
                    <option value="United Kingdom">United Kingdom</option>
                    <option value="United States">United States</option>
                    <option value="Australia">Australia</option>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="email">Email</label>

            <div class="col-md-5">
                <input id="email" name="email" type="email" placeholder="Type Your Email Here"
                       class="form-control input-md" value="menuka@gmail.com" required="">

            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="mnumber">Mobile Number</label>

            <div class="col-md-5">
                <input id="mnumber" name="mnumber" type="text" pattern="[0-9]{11}" placeholder="Your Mobile Number"
                       class="form-control input-md" required="" maxlength=”11” value="94716310375">
                <span class="help-block">with country code. Ex: Sri lanka 94...</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="username">Username</label>

            <div class="col-md-5">
                <input id="username" name="username" type="text" placeholder="Type a Unique Username"
                       class="form-control input-md" required="">

            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="pass1">Password</label>

            <div class="col-md-5">
                <input id="pass1" name="password" type="password" placeholder="Type a password here"
                       class="form-control input-md" required="">

            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="pass2">Confirm Password</label>

            <div class="col-md-5">
                <input id="pass2" name="cpassword" type="password" placeholder="Confirm Your Password"
                       class="form-control input-md" required="" onblur="confirmPass()">

            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="sbtn"></label>

            <div class="col-md-4">
                <button id="sbtn" name="sbtn" class="btn btn-success" onclick="confirmPass()">Add User</button>
            </div>
        </div>

    </fieldset>
</form>

</form>
</div>

<script>
    var date_input = $('input[name="date"]'); //our date input has the name "date"
    var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
    var options = {
        format: "yyyy/mm/dd",
        container: container,
        startView: 2,
        daysOfWeekHighlighted: "0,6",
        defaultViewDate: {year: 1990, month: 01, day: 01}

    };
    date_input.datepicker(options); //initiali110/26/2015 8:20:59 PM ze plugin
</script>

<script type="text/javascript">
    function confirmPass() {
        var pass = document.getElementById("pass1").value
        var confPass = document.getElementById("pass2").value
        if (pass != confPass) {
            alert('Wrong confirm password !');
            return false
        } else {
            return true;
        }
    }
</script>
</body>
</html>