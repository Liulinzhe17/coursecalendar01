var cweek="1";
$.ajax({
    type:"post",
    url:"/course/findweek",
    data:{id:"84527"},
    success:function(data) {
        var txt="<ul style=\"margin-left:-31px;width:140px\">"
        var se=data.split('-');
        for(var a=se[0];a<=se[1];a++){
            var add="<li><a class='weeknumber' id='"+a+"'>Week__"+a+"</a></li>";
            txt+=add;
        }
        txt+="</ul>";
        $('#weeknum').html(txt);
    }
})
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> cx
$.ajax({
    type:"post",
    url:"/course/findcourse",
    data:{cid:"84527"},
    success:function (data) {
        var name=data.courseName;
        var address=data.courseAddress;
        var na="课程名："+name+"&nbsp;&nbsp;&nbsp;&nbsp;"+"教学地点："+address;
        $("#class_header").html(na);
    },
    error:function(data){
        alert(data.status);
    }
})
<<<<<<< HEAD
>>>>>>> cx
=======
$.ajax({
    type:"post",
    url:"/course/findteacher",
    data:{cid:"84527"},
    success:function (data) {
        alert(data);
    },
    error:function(data){
        alert(data.status);
    }
})
>>>>>>> cx
sub.onclick=function(){
    var content=document.getElementById("con").value;
    $.ajax({
        type:"post",
        url:"/course/updatec_outline",
        data:{cid:"84527",con:content,week:cweek},
        success:function (data) {
<<<<<<< HEAD
<<<<<<< HEAD
            alert("123");
=======
>>>>>>> cx
=======
>>>>>>> cx
            $('#sk').html(content);
        },
        error:function(data){
            alert(data.status);
        }
    })
}
sub1.onclick=function(){
    var content=document.getElementById("con1").value;
    $.ajax({
        type:"post",
        url:"/course/updatec_homework",
        data:{cid:"84527",con:content,week:cweek},
        success:function (data) {
<<<<<<< HEAD
<<<<<<< HEAD
            alert("123");
=======
>>>>>>> cx
=======
>>>>>>> cx
            $('#zy').html(content);
        },
        error:function(data){
            alert(data.status);
        }
    })
}
window.onload = function () {
    window.setTimeout(function () {
        var s=$(".weeknumber");
        for(var a=0;a<s.length;a++){
            s.eq(a).click(function () {
                var week=this.text.split("__");
                $.ajax({
                    type:"post",
                    url:"/course/finddata",
                    data:{cid:"84527",week:week[1]},
                    success:function(data) {
                        cweek=week[1];
                        $('#sk').html(data.courseOutline);
<<<<<<< HEAD
<<<<<<< HEAD
                        $('#zl').html(data.courseData);
=======
=======
>>>>>>> cx
                        var cd=data.courseData;
                        var reg = /(http:\/\/|https:\/\/)((\w|=|\?|\.|\/|&|-)+)/g;
                        cd = cd.replace(reg, "<a href='$1$2' target=\"_blank\">$1$2</a>").replace(/\n/g, "<br />");
                        $('#zl').html(cd);
<<<<<<< HEAD
>>>>>>> cx
=======
>>>>>>> cx
                        $('#zy').html(data.courseHomework);
                    }
                })
            })
        }
    },"500");


}