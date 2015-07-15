$(document).ready(function() {

        var frm = $('#updateUserInfoForm');
        var id = $('#idInput').val();
        frm.submit(function (ev) {
            $.ajax({
                type: "PUT",
                url: "/web/users/" + id,
                data: frm.serialize(),
                success: function (data) {
                    window.location = "http://localhost:8080/web/users";
                }
            });
            ev.preventDefault();
        });
});