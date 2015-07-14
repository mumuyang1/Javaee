function deleteUser(id) {

    $.ajax({
        url: '/web/users/' + id,
        type: 'DELETE',
        dataType: 'text',
        success: function () {
            window.location.reload();
        }
    })
}

////function updateUser(id) {
//    var formData = new FormData($('form')[0]);
//    console.log(formData+'----------');
//    console.log($('#updateUserInfoForm').serialize());
//
//    jQuery.ajax({
//        url: '/web/users' + id,
//        method: 'PUT',
//        data: $('#updateUserInfoForm').serialize()
//    }).done(function (response) {
//        // Do something with the response
//    }).fail(function () {
//        // Whoops; show an error.
//    });
//
//    //$.ajax({
//    //    url: '/web/users/' + id,
//    //    type: 'DELETE',
//    //    dataType: 'text',
//    //    data: $('#the-form').serialize()}.
//    //    success: function () {
//    //        window.location.reload();
//    //    }
//    //})
//
////}

//$("#updateUserInfoForm").submit(function(id) {
//
//    var url = '/web/users' + id; // the script where you handle the form input.
//    console.log('----------');
//    $.ajax({
//        type: "POST",
//        url: url,
//        data: $("#updateUserInfoForm").serialize(), // serializes the form's elements.
//        success: function(data)
//        {
//            alert(data); // show response from the php script.
//        }
//    });
//
//    return false; // avoid to execute the actual submit of the form.
//});

var frm = $('#updateUserInfoForm');
frm.submit(function (ev) {
    $.ajax({
        type: "PUT",
        url: "/web/users/put",
        data: frm.serialize(),
        success: function (data) {
            alert('更新信息成功');
        }
    });

    ev.preventDefault();
});

