<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Search a User</title>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.1/bootstrap-table.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.1/bootstrap-table.min.js"></script>


    <script>
        $(document).ready(function () {

            $.ajax({

                // The URL for the request
                url: "AllData",

                // Whether this is a POST or GET request
                type: "GET",

                // The type of data we expect back
                dataType: "json",
                success: function (data2) {

                    $('#table').bootstrapTable({
                        method: 'get',
                        data: data2,
                        striped: true,
                        pagination: true,
                        pageSize: 10,
                        pageList: [10, 25, 50, 100, 200],
                        search: false,
                        showColumns: false,
                        showRefresh: false,
                        height: 500,
                        minimumCountColumns: 2,
                        columns: [{
                            field: 'firstName',
                            title: 'First Name',
                            align: 'left',
                            valign: 'bottom',
                            sortable: true
                        }, {
                            field: 'lastName',
                            title: 'Item Name',
                            align: 'left',
                            valign: 'middle',
                            sortable: true,

                        }, {
                            field: 'country',
                            title: 'Item Price',
                            align: 'left',
                            valign: 'top',
                            sortable: true,

                        }, {
                            field: 'dob',
                            title: 'First Name',
                            align: 'Center',
                            valign: 'bottom',
                            sortable: true
                        }, {
                            field: 'mobile',
                            title: 'First Name',
                            align: 'Center',
                            valign: 'bottom',
                            sortable: true
                        }, {
                            field: 'email',
                            title: 'First Name',
                            align: 'left',
                            valign: 'bottom',
                            sortable: true
                        }, {
                            field: 'username',
                            title: 'First Name',
                            align: 'left',
                            valign: 'bottom',
                            sortable: true
                        }]
                    });


                },
                error: function (data) {
                    console.log(data);
                }
            })

        });
    </script>
    <%-- On click Table--%>
    <script>
        $(document).ready(function () {

            $("button").click(function () {
                var searchdata = $("#search").val();
                $.ajax({

                    // The URL for the request
                    url: "Search",

                    // The data to send (will be converted to a query string)
                    data: {
                        searchword: searchdata
                    },

                    // Whether this is a POST or GET request
                    type: "GET",

                    // The type of data we expect back
                    dataType: "json",
                    success: function (data2) {

                        $('#table').bootstrapTable('load', data2);


                    },
                    error: function (data) {
                        console.log(data);
                    }
                })

            });
        });
    </script>


</head>
<body>
<%@include file="../top.jsp" %>
<center>
    <input type="text" id="search">

    <button id="bn1" class="btn btn-primary btn-large"><i class="icon-white icon-zoom-in"></i>Search</button>
    <br>
</center>
<div class="col-md-12">
    <table id="table"></table>
</div>

</body>
</html>
