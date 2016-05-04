<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search Users</title>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.11/css/dataTables.bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.1/bootstrap-table.min.css">
    <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.1/bootstrap-table.min.js"></script>


</head>
<body>
<%@include file="top.jsp" %>
<%
    ArrayList users = (ArrayList) request.getAttribute("name");
    ArrayList dob = (ArrayList) request.getAttribute("dob");
    ArrayList country = (ArrayList) request.getAttribute("country");
    ArrayList email = (ArrayList) request.getAttribute("email");
    ArrayList usernames = (ArrayList) request.getAttribute("username");
    ArrayList mobile = (ArrayList) request.getAttribute("mnumber");
    String count = (String) request.getAttribute("count");

%>
<table id="#example" data-toggle="table" class="table table-bordered table-striped table-hover table-responsive">
    <thead>
    <tr>
        <th>Names of Users</th>
        <th>Date of Birth</th>
        <th>Country</th>
        <th>Email</th>
        <th>Mobile</th>
        <th>Usernames</th>

    </tr>
    </thead>
    <tbody>
    <%
        out.println(count);
    %>
    <%

        for (int i = 0; i < users.size(); i++) {
            out.println("<tr> <td>" + users.get(i) + "</td> <td>" + dob.get(i) + "</td> <td>" + country.get(i) + "</td> <td>" + email.get(i) + "</td> <td>" + mobile.get(i) + "</td> <td>" + usernames.get(i) + "</td></tr>");
        }
    %>

    </tbody>
</table>

<script>
    $(document).ready(function () {
        $("#example").DataTable();
    });
</script>


<table id="table">
</table>

<script>
    $('#table').bootstrapTable({
        columns: [{
            field: 'id',
            title: 'Item ID'
        }, {
            field: 'name',
            title: 'Item Name'
        }, {
            field: 'price',
            title: 'Item Price'
        }],
        data: [{
            id: 1,
            name: 'Item 1',
            price: '$1'
        }, {
            id: 2,
            name: 'Item 2',
            price: '$2'
        }]
    });
</script>
</body>
</html>
