$(document).ready(function () {
    $.ajax({
        url: "/compare/execute",
        // dataType : JSON,
        success:function (resultData) {
            var str1=resultData[0];
            var str2=resultData[1];
            $("#str1").html(str1);
            $("#str2").html(str2);
        }
    })
});
