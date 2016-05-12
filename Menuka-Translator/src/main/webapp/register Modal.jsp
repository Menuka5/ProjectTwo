<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modal Register</title>

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


<button id="btn1">test</button>


<div class="modal fade" id="myModal" role="dialog">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Update user profile</h4>
      </div>
      <div class="modal-body">
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
                       class="form-control input-md" required="">
              </div>

              <diV id="usernamemsg"></diV>
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
      </div>

    </div>
  </div>
</div>

</body>
</html>
