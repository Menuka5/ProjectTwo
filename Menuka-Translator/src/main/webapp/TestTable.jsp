<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title></title>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
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

</head>
<body>
<div class="col-md-12">
    <table id="table"></table>
</div>

<button >visible</button>
<script>
    $(document).ready(function(){

        $.ajax({

            // The URL for the request
            url: "AllData",

            // Whether this is a POST or GET request
            type: "GET",

            // The type of data we expect back
            dataType: "json",
            success: function (data2) {

            }error: function (data) {
                console.log(data);
            }
        })

            $('#table').bootstrapTable('showColumn', 'operate');
            $('#table').bootstrapTable('hideColumn', 'city');
    });
</script>
</body>
</html>
