<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <fmt:setLocale value="en"/>
    <fmt:bundle basename="languageFiles.Language">
    <title><fmt:message key="top.Add"/> <fmt:message key="top.User"/></title>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>


    <script src="js/registration.js"></script>

</head>

<body>
<%@include file="top.jsp" %>
<form action="AddUser" method="post" class="form-horizontal" onsubmit="confirmPass();">
    <fieldset>

        <!-- Form Name -->
        <center>
            <legend><fmt:message key="registration.Registration"/></legend>
        </center>
        <!-- Text input-->


        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="fname"><fmt:message key="registration.First"/> <fmt:message key="registration.Name"/></label>

            <div class="col-md-5">
                <input id="fname" name="fname" type="text" class="form-control input-md" required placeholder=<fmt:message key="registration.YourFirstName"/> >

            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="lname"><fmt:message key="registration.Last"/> <fmt:message key="registration.Name"/></label>

            <div class="col-md-5">
                <input id="lname" name="lname" type="text" placeholder="Your Last Name" class="form-control input-md">

            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="date"><fmt:message key="registration.Birthday"/></label>

            <div class="col-md-5">
                <input class="form-control" id="date" name="date" placeholder="YYYY/MM/DD" class="form-control input-md"
                       type="text" required readonly/>
                <span class="help-block"><fmt:message key="registration.SelectYear"/></span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="selectbasic"><fmt:message key="registration.Country"/></label>

            <div class="col-md-4">
                <select id="country" name="country" class="form-control">
                    <option><fmt:message key="registration.Select"/> <fmt:message key="registration.Country"/></option>
                    <option value="Sri Lanka"><fmt:message key="registration.SriLanka"/></option>
                    <option value="Japan"><fmt:message key="registration.Japan"/></option>
                    <option value="United Kingdom"><fmt:message key="registration.UnitedKingdom"/></option>
                    <option value="United States"><fmt:message key="registration.UnitedStates"/></option>
                    <option value="Australia"><fmt:message key="registration.Australia"/></option>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="states"><fmt:message key="registration.City"/></label>

            <div class="col-md-4">
                <select id="states" name="states" class="form-control">
                    <option><fmt:message key="registration.Select"/> <fmt:message key="registration.City"/></option>
                </select>
                <span class="help-block"><fmt:message key="registration.SelectCities"/></span>
            </div>
        </div>


        <div class="form-group">
            <label class="col-md-4 control-label" for="email"><fmt:message key="registration.Email"/></label>

            <div class="col-md-5">
                <input id="email" name="email" type="email" placeholder=<fmt:message key="registration.EmailPlaceHolder"/>"Type Your Email Here"
                       class="form-control input-md" value="menukcvffa@gmail.com" required="">

            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="mnumber"><fmt:message key="registration.Mobile"/> <fmt:message key="registration.Number"/></label>

            <div class="col-md-5">
                <input id="mnumber" name="mnumber" type="text" pattern="[0-9]{11}" placeholder="Your Mobile Number"
                       class="form-control input-md" required="" maxlength=”11” value="94716310375">
                <span class="help-block"><fmt:message key="registration.CountryCode"/></span>
            </div>
        </div>

        <!-- User role-->

        <div class="form-group">
            <label class="col-md-4 control-label" for="userRole"><fmt:message key="registration.UserRole"/></label>

            <div class="col-md-4">
                <select id="userRole" name="userRole" class="form-control">
                </select>
                <span class="help-block"><fmt:message key="registration.SelectUserRole"/></span>
            </div>
        </div>

        <!-- Username-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="username"><fmt:message key="registration.Username"/></label>

            <div class="col-md-5">
                <input id="username" name="username" type="text" placeholder="Type a Unique Username"
                       class="form-control input-md" required="">
            </div>

            <diV id="usernamemsg"></diV>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="pass1"><fmt:message key="registration.Password"/></label>

            <div class="col-md-5">
                <input id="pass1" name="password" type="password" placeholder="Type a password here"
                       class="form-control input-md" required="">

            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="pass2"><fmt:message key="registration.Confirm"/> <fmt:message key="registration.Password"/></label>

            <div class="col-md-5">
                <input id="pass2" name="cpassword" type="password" placeholder="Confirm Your Password"
                       class="form-control input-md" required="" onblur="confirmPass()">

            </div>
        </div>

        <!-- Submit button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="sbtn"></label>

            <div class="col-md-4">
                <button id="sbtn" name="sbtn" class="btn btn-success" onclick="confirmPass()"><fmt:message key="top.Add"/>Add <fmt:message key="top.User"/>User</button>
            </div>
        </div>

    </fieldset>
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
    date_input.datepicker(options);
</script>

</fmt:bundle>
</body>
</html>