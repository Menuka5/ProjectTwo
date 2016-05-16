
/*
$(document).ready(function(){
    $("#sbtn").click(function(){

        var fname = $("#fname").val();
        var lname = $("#lname").val();
        var dob = $("#date").val();
        var country = $("#country").val();

        var city = $("#states").val();
        var email= $("#email").val();
        var mobile= $("#mnumber").val();
        var userRole= $("#userRole").val();

        alert(fname+ " " + lname+" " + dob + " " +country+ " " +city+ " " +email +" " + mobile+" " + userRole);

        $.ajax({



            // The URL for the request
            url: "UpdateUser",

            // The data to send (will be converted to a query string)
            data: {
                fname: fname,
                lname: lname,
                dob: dob,
                country: country,
                city: city,
                email: email,
                mobile: mobile,
                userRole: userRole

            },

            // Whether this is a POST or GET request
            type: "GET",

            // The type of data we expect back
            dataType: "json",
            success: function (data2) {
                alert("We could be immortal");
                console.log("Passed");
            },
            error: function (data) {
                alert("failed");
                console.log("failed");
            }
        })
    });
});*/
