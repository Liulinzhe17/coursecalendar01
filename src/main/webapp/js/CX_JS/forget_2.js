function validate() {
    var pwd1 = $('#newpwd').val();
    var pwd2 = $('#sure_newpwd').val();
    if (pwd1 == pwd2) {
        $('#tip').html("两次密码相同");
        document.getElementById("tip").style.color = "green";
        document.getElementById("sub").style.backgroundColor = "rgb(40,40,40)";
    }
    else {
        $('#tip').html("两次密码不同");
        document.getElementById("sub").style.backgroundColor = "grey";
        document.getElementById("tip").style.color = "red";
    }
}
$(function () {
    $('#sub').click(function () {
        var url = location.href;
        var phone=url.split("=")
        var phone_1=phone[1];
        $.ajax({
            type:"post",
            url:"/student/forget",
            data:{phone:phone_1,pwd:$("#newpwd").val()},
            success:function(data) {
                if(data==1)alert("修改成功！");

            }
        })
    })
})