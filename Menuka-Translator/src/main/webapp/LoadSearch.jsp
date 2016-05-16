<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Search a User</title>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.1/bootstrap-table.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.1/bootstrap-table.min.js"></script>

    <script src="js/LoadSearch.js"></script>
    <script src="js/UpdateUser.js"></script>

</head>
<body>
<%@include file="top.jsp" %>
<center>
    <input type="text" id="search">

    <button id="bn1" class="btn btn-primary btn-large"><i class="icon-white icon-zoom-in"></i>Search</button>
    <br>
    <br>
</center>
<div class="col-md-12">
    <table id="table"></table>
</div>

<%-- Delete User model--%>
<div class="modal fade" id="deleteUser" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <center> <h4 class="modal-title">Delete User</h4></center>
            </div>
            <div class="modal-body">

                <p>Do you want to delete <label id="username2"></label>
                     </p>
                <button type="button" class="btn btn-default" data-dismiss="modal" id="deleteUserData">Delete</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
            </div>
        </div>

    </div>
</div>

<%--Update user modal--%>

<div class="modal fade" id="updateUserProfile" role="dialog">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">

            <div class="modal-body">
                <form class="form-horizontal" action="UpdateUser" method="get">
                    <fieldset>

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

                        <%--Birthday --%>

                        <div class="form-group">
                            <label class="col-md-4 control-label" for="date">Date of Birth</label>

                            <div class="col-md-5">
                                <input class="form-control" id="date" name="date" placeholder="YYYY/MM/DD" class="form-control input-md"
                                       type="text" required readonly/>
                                <span class="help-block">Click on year to select year</span>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-4 control-label" for="selectbasic">Country</label>

                            <div class="col-md-4">
                                <select id="country" name="country" class="form-control">
                                    <option>Select Country</option>
                                    <option value="Sri Lanka">Sri Lanka</option>
                                    <option value="Japan">Japan</option>
                                    <option value="United Kingdom">United Kingdom</option>
                                    <option value="United States">United States</option>
                                    <option value="Australia">Australia</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-4 control-label" for="states">City</label>

                            <div class="col-md-4">
                                <select id="states" name="states" class="form-control">
                                    <option>Select City</option>
                                </select>
                                <span class="help-block">First Select the country to get cities</span>
                            </div>
                        </div>



                        <div class="form-group">
                            <label class="col-md-4 control-label" for="email">Email</label>

                            <div class="col-md-5">
                                <input id="email" name="email" type="email" placeholder="Type Your Email Here"
                                       class="form-control input-md" value="menuka@gmail.com" required="">

                            </div>
                        </div>

                        <%-- Mobile number--%>

                        <div class="form-group">
                            <label class="col-md-4 control-label" for="mnumber">Mobile Number</label>

                            <div class="col-md-5">
                                <input id="mnumber" name="mnumber" type="text" pattern="[0-9]{11}" placeholder="Your Mobile Number"
                                       class="form-control input-md" required="" maxlength=”11” value="94716310375">
                                <span class="help-block">with country code. Ex: Sri lanka 94...</span>
                            </div>
                        </div>

                        <!-- User role-->

                        <div class="form-group">
                            <label class="col-md-4 control-label" for="userRole">User Role</label>

                            <div class="col-md-4">
                                <select id="userRole" name="userRole" class="form-control">
                                    <option>Select User role</option>
                                </select>
                                <span class="help-block">Select a user role</span>
                            </div>
                        </div>

                        <!-- Username-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="username">Username</label>

                            <div class="col-md-5">
                                <input id="username" name="username" type="text" placeholder="Type a Unique Username"
                                       class="form-control input-md" required="" readonly>
                            </div>

                            <diV id="usernamemsg"></diV>
                        </div>

                        <!-- Button -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="sbtn"></label>

                            <div class="col-md-4">
                                <button id="sbtn" name="sbtn" class="btn btn-success" type="submit">Update user</button>
                            </div>
                        </div>

                    </fieldset>
                </form>
            </div>

        </div>
    </div>
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
</body>
</html>
