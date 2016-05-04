<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Username Availability</title>
    <style type="text/css">
        .flable {
            color: gray;
        }

        .status {
            font-family: verdana;
            font-size: 12px;
        }

        .username {
            color: blue;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
</head>
<body>

<script type="text/javascript">

    $(document).ready(function () {
        $(".username").change(function () {
            var username = $(this).val();
            if (username.length >= 3) {
                $(".status").html("<font color=gray> Checking availability...</font>");
                $.ajax({
                    type: "POST",
                    url: "CheckAvalability",
                    data: "uname=" + username,
                    success: function (msg) {
                        alert(msg);
                        $(".status").ajaxComplete(function (event, request, settings) {
                            $(".status").html(msg);

                        });
                    }
                });
            }
            else {

                $(".status").html("<font color=red>Username should be <b>3</b> character long.</font>");
            }

        });
    });
</script>


<div>
    <label class="flable">User Name :</label> <input class="username" type="text" name="username"> <span
        class="status"></span>
</div>

</body>
</html>
