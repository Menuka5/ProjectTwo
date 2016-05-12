<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    <script>
        $(document).ready(function () {
            $("#country").change(function () {
                var country = $("#country").val();
//                alert(country);
                $.ajax({

                    // The URL for the request
                    url: "CitySender",

                    // The data to send (will be converted to a query string)
                    data: {
                        country: country
                    },

                    // Whether this is a POST or GET request
                    type: "GET",

                    // The type of data we expect back
                    dataType: "json",
                    success: function (data2) {
//                        alert("Success");
                        $("#states").empty();
                        for (var i = 0; i < data2.length; i++) {
                            var obj = data2[i];

                            $("#states").append('<option value=' + obj.city_id + '>' + obj.city + '</option>');
                        }


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
<form>
    <div class="form-group">
        <label class="col-md-4 control-label" for="country">Country</label>

        <div class="col-md-4">
            <select id="country" class="form-control">
                <option>Select Country</option>
                <option value="Sri Lanka">Sri Lanka</option>
                <option value="Japan">Japan</option>
                <option value="United Kingdom">United Kingdom</option>
                <option value="United States">United States</option>
                <option value="Australia">Australia</option>
            </select>
        </div>
    </div>

    <!-- Select Basic -->
    <div class="form-group">
        <label class="col-md-4 control-label" for="states">City</label>

        <div class="col-md-4">
            <select id="states" class="form-control">
                <option>Select City</option>
            </select>
        </div>
    </div>


</form>

Select Country:
<select id="country">
    <option>Select Country</option>
    <option value="Sri Lanka">Sri Lanka</option>
    <option value="Japan">Japan</option>
    <option value="United Kingdom">United Kingdom</option>
    <option value="United States">United States</option>
    <option value="Australia">Australia</option>
</select>

Select State:
<select id="states1">
    <option>Select State</option>
</select>
</body>
</html>
