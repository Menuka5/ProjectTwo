//Bootstrap table configurations

$(document).ready(function () {
    $("#country").change(function () {
        var country = $("#country").val();
        $.ajax({

            url: "CitySender",

            data: {
                country: country
            },

            type: "GET",

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
        url: "FirstDataLoad",
        type: "GET",
        dataType: "json",
        success: function (data2) {

            $('#table').bootstrapTable({
                method: 'get',
                data: data2,
                striped: true,
                pagination: false,
                pageSize: 10,
                pageList: [10, 25, 50, 100, 200],
                search: false,
                showColumns: false,
                showRefresh: false,
                height: 487,
                minimumCountColumns: 2,
                columns: [{
                    field: 'firstName',
                    title: 'First Name',
                    align: 'left',
                    valign: 'bottom',
                    sortable: true
                }, {
                    field: 'lastName',
                    title: 'Last Name',
                    align: 'left',
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
                    title: 'Edit User',
                    align: 'center',
                    visible: false,
                    valign: 'middle',
                    formatter: operateFormatter,
                    events: operateEvents
                }, {
                    field: 'operate2',
                    title: 'Delete User',
                    align: 'center',
                    visible: false,
                    valign: 'middle',
                    formatter: operateFormatter2,
                    events: operateEvents
                }]
            });


        },
        error: function (data) {
            console.log(data);
        }
    });


    var numberOfPages;
    $.ajax({
        url: "NumberOfPages",
        type: "GET",
        success: function (data2) {
            numberOfPages = data2;
            var pag = $('#pagination').simplePaginator({
                totalPages: parseInt(numberOfPages),
                maxButtonsVisible: 5,
                currentPage: 1,
                nextLabel: 'next',
                prevLabel: 'prev',
                firstLabel: 'first',
                lastLabel: 'last',
                clickCurrentPage: true,
                pageChange: function (page) {
                    $.ajax({
                        url: "WhenPageChange",
                        data: {
                            pageNumber: page
                        },
                        type: "GET",
                        dataType: "json",
                        success: function (data2) {
                            $('#table').bootstrapTable('load', data2);
                        },
                        error: function (data) {
                            alert("Page load failed serverside.js")
                        }
                    })
                }
            });


        },
        error: function (data) {
            console.log(data);
        }

    });

});

function operateFormatter(value, row, index) {
    return [
        '<a class="edit ml10 btn btn-danger" href="javascript:void(0)" title="Edit">', 'Edit ',
        '<i class="glyphicon glyphicon-edit"></i>',
        '</a>'
    ].join('');
}
function operateFormatter2(value, row, index) {
    return [
        '<a class="remove ml10 btn btn-danger" href="javascript:void(0)" title="Remove">', 'Delete ',
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

        var country = datarecieve.country;
        $.ajax({
            url: "CitySender",
            data: {
                country: country
            },
            type: "GET",
            dataType: "json",
            success: function (data2) {
                $("#states").empty();
                for (var i = 0; i < data2.length; i++) {
                    if (data2[i].city_id == datarecieve.cityId) {
                        $("#states").append('<option value=' + data2[i].city_id + ' selected >' + data2[i].city + '</option>');
                    } else {
                        $("#states").append('<option value=' + data2[i].city_id + ' >' + data2[i].city + '</option>');
                    }
                }


            },
            error: function (data) {
                console.log(data);
            }
        });
        $.ajax({
            url: "SendUserRole",
            type: "GET",
            dataType: "json",
            success: function (data2) {
                for (var i = 0; i < data2.length; i++) {
                    if (data2[i].group_name == datarecieve.userRole) {
                        $("#userRole").append('<option value=' + data2[i].group_id + ' selected >' + data2[i].group_name + '</option>');
                    } else {
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
$(document).ready(function () {
    $("#bn1").click(function () {
        var searchdata = $("#search").val();
        $("#pagination").hide();
        $.ajax({
            url: "SearchNumberOfPages",
            type: "GET",
            data: {
                searchword: searchdata
            },
            success: function (data2) {
                numberOfPages = parseInt(data2[0]);
                var pag = $('#pagination2').simplePaginator({
                    totalPages: parseInt(numberOfPages),
                    maxButtonsVisible: 5,
                    currentPage: 1,
                    nextLabel: 'next',
                    prevLabel: 'prev',
                    firstLabel: 'first',
                    lastLabel: 'last',
                    clickCurrentPage: true,
                    pageChange: function (page) {
                        $.ajax({
                            url: "SearchWhenPageChange",
                            data: {
                                pageNumber: page
                            },
                            type: "GET",
                            dataType: "json",
                            success: function (data2) {
                                $('#table').bootstrapTable('load', data2);
                            },
                            error: function (data) {
                                alert("Page load failed serverside.js")
                            }
                        })
                    }
                });
            },
            error: function (data) {
                console.log(data);
            }

        });


        $.ajax({
            url: "Search",
            data: {
                searchword: searchdata
            },
            type: "GET",
            dataType: "json",
            success: function (data2) {
                $('#table').bootstrapTable('load', data2);
            },
            error: function (data) {
                console.log(data);
            }
        });
    });
});
//delete User
$(document).ready(function () {
    $("#deleteUserData").click(function () {
        var deleteUser = $("#username2").text();
        $.ajax({
            url: "DeleteUser",
            data: {
                delete: deleteUser
            },
            type: "GET",
            success: function (data2) {
                alert("User " + deleteUser + " Successfully deleted!!!");
            },
            error: function (data) {
                console.log(data);
            }
        })

    });
});
