$.ajax({
         type:"GET",
         url:"/courses/stuUserid/weektime",
         dataType:"json",
         data:{stuUserid:"1512190201",weektime:"1"},
         success:function(data) {
             $.each(data, function(idx, obj) {
                 var body=$("#tbody-result");
                 var s=body.children().eq(Number(obj.courseTimestart));
                 var ss=s.children().children().eq(Number(obj.courseWeek));
                 var txt="<a href='#' rel='rs-dialog' data-target='myModal'>"+obj.courseName+"</a>"+"<br>"+obj.courseAddress+"";
                 ss.html(txt);
             });
         }
     })
// $.ajax({
//     type:"get",
//     url:"/courses/stuUserid/weektime",
//     data:{stuUserid:"1512190201",weektime:"1"},
//     success:function(data) {
//         $('#header_name').html(data.stuName);
//         $('.account-name').html(data.stuName);
//
//     }
// })
function updateClass() {
    var major = $("select");
    //删除option所有的兄弟
    $(major).children().remove();
//  $(major).append($('<option value="">请选择</option>'));
    //生成与学院相对应的专业
    $.ajax({
        url: "/courses/getallcourse",
        type: "POST", //GET
        async: true,    //或false,是否异步
        data: {stuUserid: "1512190201"},
        timeout: 5000,    //超时时间
        dataType: "json",    //返回的数据格式：json/xml/html/script/jsonp/text
        success: function (data) {
            $.each(data, function(idx, obj) {
                var $txt = $('<option value='+'obj.courseName'+'>'+obj.courseName+'</option>');
                $(major).append($txt);
            });
        },
        error: function (data) {
            //alert("error:"+data.status);
        },
    });
}
function CourseMessage(){
	$.ajax({
		url:"/courses/coursedata",
		type:"POST", //GET
		async:true,    //或false,是否异步
		data:{cid:"000001",week:"1"},
		timeout:5000,    //超时时间
		dataType:"json",    //返回的数据格式：json/xml/html/script/jsonp/text
		success:function(data){
			$("#modal-body1").children().html(data.courseOutline);
			$("#modal-body2").children().html(data.courseData);
			$("#modal-body3").children().html(data.courseHomework);
			$("#myModalLabel").html(data.courseName);
		},
		error:function(data){
         //alert("error:"+data.status);
		},
	});
}
function show() {
    console("test");
}