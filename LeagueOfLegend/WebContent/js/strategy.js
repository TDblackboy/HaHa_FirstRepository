/**
 *  
 */
//加载页面时
$(document).ready(function(){
	//=========1给搜索图标添加点击事件======================
	$(".button").on("mouseover",function(){
		$(".button").css("cursor","pointer");
	});
	
	//================初始加载页面显示所有英雄===========
	alert("初始加载数据....................");
	$.ajax({
		type:"post",//提交方式
		async:true,   //是否为异步请求
		url:"/LeagueOfLegend/LoadServlet",//提交到servlet的地址
		data:{"operator":"all"},//向后台传的参数 
		dataType:"json",//后台返回的数据类型
		success:function(data){//后台返回成功是执行的函数，data是返回值
			print(data);//成功时执行函数的代码 
		},
		error:function(){//错误时执行的代码
			alert("无法查看全部数据");
		},
	});
});

//=================== 1 查询名字===============================
function search(){
	var name=$(".in").val();
	//消除之前的内容
	$('.showLegend').html("");
	//再添加新内容
	$.ajax({
		type:"post",
		async:true,
		url:"/LeagueOfLegend/LoadServlet",
		data:{"operator":"name","name":name},
		dataType:"json",
		success:function(datas){
			//打印新内容
			print(datas);
		},
		error:function(){
			alert("无法查看数据");
		},
	});
	//alert("end");
}

//===================2分类 浏览===============================

function getLegend(data){
	//先消除之前的内容
	$('.showLegend').html("");
	//再添加新内容
	$.ajax({
		type:"post",
		async:true,   
		url:"/LeagueOfLegend/LoadServlet",
		data:{"operator":"type","value":data},
		dataType:"json",
		success:function(datas){
			//打印新内容
			print(datas);
		},
		error:function(){
			alert("无法查看数据");
		},
	});
}

//=================格式化输出json—>string,jsp输出string[var]=====================
function print(data){
	$.each(data,function(index,value){//遍历json数组
		
		//alert(value['name']);
		//alert(index);
		//元数据 - 将一个json连接成字符串
		var content="<a href='./detail.jsp?id="+value['id']+"'>"+value['neck']+"-"+value['name']+"</a>";
		//alert(content);
		//再包装 - 一行显示几个，啥时候换行
		if((index+1)%6!=0){
			var hang="<td class='tdleg'>"+content+"</td>";
		}else{
			var hang="<tr class='trleg'><td class='tdleg'>"+content+"</td></tr>";
		}
		//alert(hang);
		//添加
		$(".showLegend").append(hang);
	}); 
}
//