<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="per.sun.modal.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mango</title>
<!--css  -->
<link rel="stylesheet" href="../css/indexcss.css">

<!--js  -->
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>

<!--search  -->
<script type="text/javascript" src="../js/strategy.js"></script>

</head>
<body>
<div class="box">
	<div class="header">
		<div class="left"><img class="logo" src="../img/logo2.jpg"></div>
		<div class="right">
			<ul class="head-ul">
				<!-- <li><a href="../index.html">首页</a></li> -->
				<li><a href="../pages/strategy.jsp">攻略中心</a></li>
				<li class="head-ul-li2"><a href="./roleManage.jsp">管理</a></li>
				<!-- <li class="login"><a href="">管理员登陆</a></li> -->
			</ul>	
		</div>
	</div>
	<div class="content">
		<div class="input_box">
			<p class="ptip">攻略中心</p>
			<input type="text" class="in" placeholder="输入英雄名字">
			<button class="button" onclick="search()"><img class="in-img" src="../img/in.jpg"></button>
		</div>
		<div class="other">
		<div class="main-con">
			<div class="catalog">
			<div class="cata-ul">
				<ul class="legend-list">
				<!-- 检索有两种 1 名字， 2 类型 -->
				<!-- 这部分可以写进js -->
					<li class="no-a">LEGENDS >></li>
					<li class="yes-a1"><a class="allstars" href="javascript:void(0);" onclick="getLegend(1)">全部英雄</a></li>
					<li class="yes-a"><a class="warrior" href="javascript:void(0);" onclick="getLegend(2)">战士</a></li>
					<li class="yes-a"><a class="magician" href="javascript:void(0);" onclick="getLegend(3)">法师</a></li>
					<li class="yes-a"><a class="assassin" href="javascript:void(0);" onclick="getLegend(4)">刺客</a></li>
					<li class="yes-a"><a class="tank" href="javascript:void(0);" onclick="getLegend(5)">坦克</a></li>
					<li class="yes-a"><a class="shooter" href="javascript:void(0);" onclick="getLegend(6)">射手</a></li>
					<li class="yes-a"><a class="assistant" href="javascript:void(0);" onclick="getLegend(7)">辅助</a></li>
				</ul>
			</div>
			</div>
			<div class="showCon">
				<!-- 展示英雄信息&根据检索信息 -->
				<div class="infor">
					<p>英雄</p>
					<div class="show-infor">
					<table class="showLegend">
						<!--content  -->
					</table>
					</div>
				</div>
			</div>
		</div>
		</div>
		<div class="end">
				<p>石家庄铁道大学&nbsp;&nbsp;信息学院软件工程系</p>
				<p>王牌飞行员库奇 出品</p>
		</div>
	</div>
</div>
</body>
</html>