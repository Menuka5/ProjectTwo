/**
 * Created by hsenid on 5/12/16.
 */






// I think this was test function check it and remove

function confirmPass() {
    var pass = document.getElementById("pass1").value
    var confPass = document.getElementById("pass2").value
    if (pass != confPass) {
        alert('Wrong confirm password !');
        return false
    } else {
        return true;
    }
}



//Ajax call to get city list

$(document).ready(function () {
    $("#country").change(function () {
        var country = $("#country").val();
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


//Username checking



$(document).ready(function () {
    $("#username").blur(function () {
        var uname = $("#username").val();
        $.ajax({

            // The URL for the request
            url: "UChecker",

            // The data to send (will be converted to a query string)
            data: {
                searchword: uname
            },

            // Whether this is a POST or GET request
            type: "GET",

            // The type of data we expect back
            dataType: "json",
            success: function (data2) {
                if (data2.boolVal) {
                    alert("Username is already taken!!");

                    $("#username").val("");
                } else {
                    $("usernamemsg").update("");
                }

            },
            error: function (data) {
                console.log(data);
            }
        })
    });
});



//User role sending function

$(document).ready(function () {
    $.ajax({

        // The URL for the request
        url: "SendUserRole",

        // Whether this is a POST or GET request
        type: "GET",

        // The type of data we expect back
        dataType: "json",
        success: function (data2) {
            for (var i = 0; i < data2.length; i++) {
                var obj = data2[i];

                $("#userRole").append('<option value=' + obj.group_id + '>' + obj.group_name + '</option>');
            }

        },
        error: function (data) {
            console.log(data);
        }
    })
});


function operateFormatter(value, row, index) {
    return [
        '<a class="remove ml10 btn btn-danger btn-large" href="javascript:void(0)" title="Remove">','Delete',
        '<i class="glyphicon glyphicon-remove"></i>',
        '</a>'
    ].join('');
}
window.operateEvents = {
    'click .remove': function (e, value, row, index) {
        alert(value);
    }
};
