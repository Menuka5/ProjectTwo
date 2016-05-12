<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search a User</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#call').click(function () {
                $.ajax({
                    type: "post",
                    url: "Search", //this is my servlet
                    data: "input=" + $('#ip').val() + "&output=" + $('#op').val(),
                    success: function (msg) {
                        $('#output').append(msg);
                    }
                });
            });

        });
    </script>
</head>
<body>


<form method="post" class="form-horizontal">
    <fieldset>


        <div class="form-group">
            <label class="col-md-4 control-label" for="searchword">Search a User</label>

            <div class="col-md-5">
                <input id="searchword" name="searchword" type="text" placeholder="Add User's name"
                       class="form-control input-md" required="">

            </div>
        </div>


        <div class="form-group">
            <label class="col-md-4 control-label" for=""></label>

            <div class="col-md-3">
                <button id="search1" name="" class="btn btn-block btn-success">Search</button>
            </div>
        </div>

    </fieldset>
</form>
</body>
</html>
