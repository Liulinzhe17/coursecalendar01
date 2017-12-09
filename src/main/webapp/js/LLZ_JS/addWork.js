//全局变量
	var $txt = $("<p>提示框出错</p>");//txt为提示的具体内容
//预加载
$(document).ready(function(){
	//固定导航栏
//	var navoffset = $("#nav").offset().top;//nav至顶部的偏移量
	$(window).scroll(function(){
		var scrollPos=$(window).scrollTop();
		if(scrollPos>45){
			$("#nav").addClass("navfixed");
		}else{
			$("#nav").removeClass("navfixed");
		}
	})
	
	//ajax请求学院数据
	ajaxAcademy();
	//监听列表框
	observe();
})
//监听列表框
function observe() {
    $("select").eq(4).change(function(){
    	ajaxMajor($("select").eq(4).val());
	});
    $("select").eq(5).change(function(){
        ajaxClasses($("select").eq(5).val());
    });
}
//改变表格中列的颜色
function changeState(me){
	if(me.getAttribute("class")=="success"){
		me.setAttribute("class","");
	}else{
		me.setAttribute("class","success");
	}	
}
//全选
function selectAll(){
	var trs = document.getElementsByTagName("tr");
	for (var i=0;i<trs.length;i++) {
		if(trs[i].getAttribute("onclick")){
			trs[i].setAttribute("class","success");
		}
	}
}
//全不选
function selectNone(){
	var trs = document.getElementsByTagName("tr");
	for (var i=0;i<trs.length;i++) {
		if(trs[i].getAttribute("onclick")){
			trs[i].setAttribute("class","");
		}
	}
}
//添加学生
function addStu(){
	//被选中的行
	var $selected = $(".success");
	for (var i=0;i<$($selected).length;i++) {
			//被选中行的后辈元素数组
			var $childrens = $($selected[i]).children();
			var $txt = $("<a href='#' class='list-group-item'>"
					        +"<h4 class='list-group-item-heading'>"
					        	+$($childrens[4]).text()
					        	+"<button type='button' class='btn btn-default btn-danger' onclick='delStu(this)'>删除</button>"
					    		+"</h4>"
				    			+"</a>");
			$("#stuTpl").after($txt);		    
	}
	//取消选中的学生状态
	selectNone();
	//提示框
	showAlert("add",$($selected).length);
}
//删除学生
function delStu(me){
	var $parent = $(me).parent().parent();
	//删除
	$parent.remove();
	//提示
	showAlert("del",1);
}

//提示框
function showAlert(opt,num){
	
	if(opt == "add"){
		$txt = $("<div class='alert alert-dismissable alert-info'>"
		    +"<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button>"
			+"<h4>提示</h4>你已成功添加"
			+num
			+"位学生"
			+"</div>");
	}else if(opt == "del"){
		$txt = $("<div class='alert alert-dismissable alert-danger'>"
		    +"<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button>"
			+"<h4>提示</h4>你已成功删除"
			+num
			+"位学生"
			+"</div>");
	}
	//插入HTML
	$("#tips").after($txt);
	//2秒后自动消失
	setTimeout("delSelf($txt)",2000);
}
//删除自己及所有后代元素
function delSelf(me){
	$(me).remove();
}
//验证事务信息
function validate(){
	var str ="时间：";
	//添加时间信息
	for(var i=0;i<$("select").length;i++){
		switch(i){
			case 0:	
				str+="第"+$("select").eq(0).val()+"周；";
				break;
			case 1:	
				str+="周"+$("select").eq(1).val()+"；";
				break;
			case 2:	
				str+="第"+$("select").eq(2).val()+"节~";
				break;
			case 3:	
				str+="第"+$("select").eq(3).val()+"节；";
				break;				
			default:
				break;
		}
	}
	//添加学生信息
	str+="学生：";
	var $bro=$("#stuTpl").nextAll();
	for (var j=0;j<$($bro).length;j++) {
		str+=$($bro).eq(j).text()+"、";
	}
	str=str.replace(/删除/g,"");
	
	//添加事务说明
	str+="内容：";
	str+=$("textarea").val();
	
	$("#validateText").text(str);
}
//引导至成功界面
function publish(){
	location="addSuccess.html";
}
//ajax刷新table里的信息
function ajaxUserInfo(){
	if ($("select").eq(6).val()==""){
		alert("筛选条件不正确！");
		return;
	}
	var url='/students/'+$("select").eq(6).val();
	$.ajax({
		url:url,
		type:"GET", //GET
		async:true,    //或false,是否异步
		data:{
			// stuClass:$("select").eq(6).val()
		},
		timeout:5000,    //超时时间
		dataType:"json",    //返回的数据格式：json/xml/html/script/jsonp/text
		success:function(data){
			updateStudent(data);
		},
        error:function(data){
            // alert("getStudentsError:"+data.status)
        },
	})
}
//ajax请求学院数据
function ajaxAcademy(){
	$.ajax({
		url:"/academys",
		type:"GET", //GET
		async:true,    //或false,是否异步
		data:{
	//      name:'yang',age:25
		},
		timeout:5000,    //超时时间
		dataType:"json",    //返回的数据格式：json/xml/html/script/jsonp/text
		success:function(data){
			updateAcademy(data);
		},
		error:function(data){
            // alert("getAcademysError:"+data.status)
		},
	})
}
//ajax根据学院id查询专业
function ajaxMajor(academyId){
	var url='/majors/'+academyId;
    $.ajax({
        url:url,
        type:"GET", //GET
        async:true,    //或false,是否异步
        data:{
        	// academyId:academyId
        },
        timeout:5000,    //超时时间
        dataType:"json",    //返回的数据格式：json/xml/html/script/jsonp/text
        success:function(data){
            updateMajor(data);
        },
        error:function(data){
            // alert("getMajorsError:"+data.status)
        },
    })
}
//ajax根据专业id查询班级
function ajaxClasses(majorId){
	var url ='/classes/'+majorId;
    $.ajax({
        url:url,
        type:"GET", //GET
        async:true,    //或false,是否异步
        data:{
            // majorId:majorId
        },
        timeout:5000,    //超时时间
        dataType:"json",    //返回的数据格式：json/xml/html/script/jsonp/text
        success:function(data){
            updateClasses(data);
        },
        error:function(data){
            // alert("getClassesError:"+data.status)
        },
    })
}

//ajax根据学生id判断空闲状态
function ajaxStatus(stuUserid) {
    var url='/students/'+stuUserid+'/status';
    $.ajax({
        url:url,
        type:"GET", //GET
        async:true,    //或false,是否异步
        data:{
            weekday:$("select").eq(1).val(),
			start:$("select").eq(2).val(),
			end:$("select").eq(3).val(),
			week:$("select").eq(0).val()
        },
        timeout:5000,    //超时时间
        dataType:"json",    //返回的数据格式：json/xml/html/script/jsonp/text
        success:function(data){
            updateStatus(stuUserid,data);
            // alert(data.data);
        },
        error:function(data){
            // alert("getStudentsError:"+data.status)
        },
    })
}

//动态生成学院列表
function updateAcademy(result){
	var academy=$("select").eq(4);
	for (var i=0;i<result.data.length;i++){
        var $txt = $('<option value='
			+result.data[i].academyId
			+'>'
            +result.data[i].academyName
            +'</option>');
        $(academy).append($txt);
	}

}
//动态生成专业列表
function updateMajor(result){
    var major=$("select").eq(5);
    //删除option所有的兄弟
    $(major).children().remove();
    $(major).append($('<option value="">请选择</option>'));
	//生成与学院相对应的专业
    for (var i=0;i<result.data.length;i++){
        var $txt = $('<option value='
            +result.data[i].majorId
            +'>'
            +result.data[i].majorName
            +'</option>');
        $(major).append($txt);
    }
    //动态生成班级列表
    ajaxClasses($("select").eq(5).val());

}
//动态生成班级列表
function updateClasses(result){
    var classes=$("select").eq(6);
    //删除option所有的兄弟
    $(classes).children().remove();
    $(classes).append($('<option value="">请选择</option>'));
    //生成与专业相对应的班级
    for (var i=0;i<result.data.length;i++){
        var $txt = $('<option value='
            +result.data[i].classesId
            +'>'
            +result.data[i].classesName
            +'</option>');
        $(classes).append($txt);
    }

}
//动态生成学生信息列表
function updateStudent(result){
    var body=$("tbody");
    //删除tbody里所有的兄弟
    $(body).children().remove();
    //无数据拦截
    if(result.data.length<1){
        $(body).append($('<tr class="warning"><td colspan="100%">无数据，请重新选择筛选条件！</td></tr>)'));
        return;
	}
    for (var i=0;i<result.data.length;i++){
        var $txt = $('<tr onclick="changeState(this)">'
            +'<td>'+result.data[i].stuAcademy+'</td>'
            +'<td>'+result.data[i].stuClass+'</td>'
            +'<td>'+result.data[i].stuName+'</td>'
            +'<td>'+result.data[i].stuUserid+'</td>'
            +'<td>'+result.data[i].stuPhonenum+'</td>'
            +'<td><img src="img/LLZ_IMG/LLZdefault32.png"></td>'
            +'</tr>');
        $(body).append($txt);
    }
    //刷新状态
    for (var i=0;i<result.data.length;i++){
		ajaxStatus(result.data[i].stuUserid);
	}
}
//刷新状态
function updateStatus(stuUserid, result) {
	var body=$("tbody");
	var trs=$(body).children();
	for (var i=0;i<trs.length;i++){
		var tds=$(trs).eq(i);
		//如果id相同
		if(stuUserid==$(tds).children().eq(3).text()){
			//如果没空
			if(result.data==0){
				$(tds).addClass("danger");//添加危险属性
				$(tds).removeAttr("onclick");//移除点击事件
				$(tds).children().find("img").attr("src","img/LLZ_IMG/LLZyellow32.png");//更换图片
			}else {
                $(tds).children().find("img").attr("src","img/LLZ_IMG/LLZgreen32.png");
			}
		}
	}

}