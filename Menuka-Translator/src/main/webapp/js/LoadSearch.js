/**
 * Created by hsenid on 5/12/16.
 */

//Bootstrap table configurations

$(document).ready(function () {
    $("#country").change(function () {
        var country = $("#country").val();
        //alert(country);
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
                height: 610,
                minimumCountColumns: 2,
                columns: [{
                    field: 'firstName',
                    title: 'First Name',
                    align: 'left',
                    //visible: false,
                    valign: 'bottom',
                    sortable: true
                }, {
                    field: 'lastName',
                    title: 'Last Name',
                    align: 'left',
                    //visible: false,
                    valign: 'middle',
                    sortable: true,

                }, {
                    field: 'country',
                    title: 'Country',
                    align: 'left',
                    valign: 'top',
                    sortable: true,

                }, {
                    field: 'dob',
                    title: 'Date of Birth',
                    align: 'Center',
                    valign: 'bottom',
                    sortable: true
                }, {
                    field: 'mobile',
                    title: 'Mobile',
                    align: 'Center',
                    valign: 'bottom',
                    sortable: true
                }, {
                    field: 'email',
                    title: 'Email',
                    visible: false,
                    align: 'left',
                    valign: 'bottom',
                    sortable: true
                }, {
                    field: 'username',
                    title: 'Username',
                    align: 'left',
                    valign: 'bottom',
                    sortable: true
                }, {
                    field: 'userRole',
                    title: 'User Role',
                    align: 'left',
                    valign: 'bottom',
                    sortable: true
                }, {
                    field: 'cityId',
                    title: 'City id',
                    align: 'left',
                    visible: false,
                    valign: 'bottom',
                    sortable: true
                }, {
                    field: 'city',
                    title: 'City',
                    align: 'left',
                    valign: 'bottom',
                    sortable: true
                }, {
                    field: 'operate',
                    title: 'Delete User',
                    align: 'center',
                    valign: 'middle',
                    formatter: operateFormatter,
                    events: operateEvents
                }]
            });


        },
        error: function (data) {
            console.log(data);
        }
    })

});


//Delete Edit Button Configuration



function operateFormatter(value, row, index) {
    return [
        '<a class="edit ml10 btn btn-danger" href="javascript:void(0)" title="Edit">','Edit ',
        '<i class="glyphicon glyphicon-edit"></i>',
        '</a>',' ',
        '<a class="remove ml10 btn btn-danger" href="javascript:void(0)" title="Remove">','Delete ',
        '<i class="glyphicon glyphicon-remove"></i>',
        '</a>'
    ].join('');
}


window.operateEvents = {
    'click .edit': function (e, value, row, index) {

        var jstring = JSON.stringify(row);
        var datarecieve = JSON.parse(jstring);
        $("#fname").val(datarecieve.firstName);
        $("#lname").val(datarecieve.lastName);
        $("#mnumber").val(datarecieve.mobile);
        $("#email").val(datarecieve.email);
        $("#country").val(datarecieve.country);
        $("#username").val(datarecieve.username);
        $("#date").val(datarecieve.dob);



        //alert(datarecieve.username);

        var country = datarecieve.country;
        // Setting the City Option menu
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

                //Set the Current user sity as default selected option in edit user
                for (var i = 0; i < data2.length; i++) {
                    //alert()
                    if(data2[i].city_id == datarecieve.cityId){
                        $("#states").append('<option value=' + data2[i].city_id + ' selected >' + data2[i].city + '</option>');
                    }else{
                        $("#states").append('<option value=' + data2[i].city_id + ' >' + data2[i].city + '</option>');
                    }
                }


            },
            error: function (data) {
                console.log(data);
            }

        });


        //Setting the role of the user

        $.ajax({

            // The URL for the request
            url: "SendUserRole",

            // Whether this is a POST or GET request
            type: "GET",

            // The type of data we expect back
            dataType: "json",
            success: function (data2) {

                //$("#states").empty();

                //Set the Current user sity as default selected option in edit user
                for (var i = 0; i < data2.length; i++) {
                    //alert(data2[i].group_id + data2[i].group_name );
                    if(data2[i].group_name == datarecieve.userRole){
                        $("#userRole").append('<option value=' + data2[i].group_id + ' selected >' + data2[i].group_name + '</option>');
                    }else{
                        $("#userRole").append('<option value=' + data2[i].group_id + ' >' + data2[i].group_name + '</option>');
                    }
                }


            },
            error: function (data) {
                console.log(data);
            }

        });


        $("#updateUserProfile").modal("show");

    },
    'click .remove': function (e, value, row, index) {
        var jstring = JSON.stringify(row);
        var obj = JSON.parse(jstring);

        $("#username").text(obj.username);

        $("#deleteUser").modal("show");
    }
};


//Search User

$(document).ready(function(){
    $("#bn1").click(function(){
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
            dataType : "json",
            success: function (data2) {
                $('#table').bootstrapTable('load', data2);
            },
            error: function(data){ console.log(data); }
        })
    });
});


//delete User

$(document).ready(function () {

    $("#deleteUserData").click(function () {
        var deleteUser = $("#username2").text();
        //alert(deleteUser);
        $.ajax({

            // The URL for the request
            url: "DeleteUser",

            // The data to send (will be converted to a query string)
            data: {
                delete: deleteUser
            },

            // Whether this is a POST or GET request
            type: "GET",

            // The type of data we expect back
            success: function (data2) {
                alert("User " + deleteUser +" Successfully deleted!!!");
            },
            error: function (data) {
                console.log(data);
            }
        })

    });
});



