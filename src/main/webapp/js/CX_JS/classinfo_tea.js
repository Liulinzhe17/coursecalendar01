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
sub.onclick=function(){
    var content=document.getElementById("con").value;
    $.ajax({
        type:"post",
        url:"/course/updatec_outline",
        data:{cid:"84527",con:content,week:cweek},
        success:function (data) {
            alert("123");
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
            alert("123");
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
                        $('#zl').html(data.courseData);
                        $('#zy').html(data.courseHomework);
                    }
                })
            })
        }
    },"500");


}