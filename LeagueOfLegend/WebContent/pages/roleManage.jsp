<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="per.sun.modal.*" %>
<%@ page import="per.sun.dao.*" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/rolemanagecss.css">
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/addAndSee.js"></script>
<title>Mango</title>
</head>
<body>
<div class="box">
	<div class="hhhh">
	<div class="header">
		<div class="left"><img class="logo" src="../img/logo2.jpg"></div>
		<div class="right">
			<ul class="head-ul">
				<li><a href="/LeagueOfLegend/pages/strategy.jsp">攻略中心</a></li>
				<li class="head-ul-li2"><a href="#">管理</a></li>
				<!-- <li class="login"><a href="#">管理员登陆</a></li> -->
			</ul>	
		</div>
	</div>
	</div>
	<div class="con">
	<div class="left-menu">
		<div class="menu2">
		<ul class="menu-ul">
			<li><p><button class="p-look">查看</button></p></li>
			<li><p><button class="p-add">添加</button></p></li>
		</ul>
		</div>
	</div>
	<div class="right-con">
		<div class="search-l">
			<div class="sea-di">
				<p>英雄资料</p>
				<table align="center">
					<tr class="tr-title"><td>名字</td><td>称号</td><td>阵营</td><td>详情</td><td colspan="2">操作</td></tr>
					<%
						LegendDao dao=new LegendDaoImp();
						if(dao.loadAll()!=null){
							List<Legend> list=dao.loadAll();
							for(Legend one:list){
					%>
					<tr>
						<td><%=one.getName() %></td>
						<td><%=one.getNeck() %></td>
						<td><%=one.getCamp() %></td>
						<td><a href="./detail.jsp?op=see&id=<%=one.getId()%>">查看</a></td>
						<td><a href="./detail.jsp?op=update&id=<%=one.getId()%>">修改</a></td>
						<td><a href="../ManagerOprate?op=delete&id=<%=one.getId()%>">删除</a></td>
					</tr>
					<%
							}
						}
					%>
				</table>
			</div>
		</div>
		<div class="add-l">
			<form action="../ManagerOprate?op=add" method="post">
				<div class="ta1">
				<table class="tab1">
					<tr class="tab-head">
						<td colspan="4">英雄资料 >></td>
					</tr>
					<tr>
						<td class="td-na">名字</td>
						<td class="td-in"><input type="text" name="lname"></td>
					
						<td class="td-na">称号</td>
						<td class="td-in"><input type="text" name="lneck"></td>
					</tr>
					<tr>
						<td class="td-na">位置</td>
						<td>
						<select name="ltype" style="width:100px;height:30px;">
							<option value="战士">战士</option>
							<option value="法师">法师</option>
							<option value="刺客">刺客</option>
							<option value="坦克">坦克</option>
							<option value="射手">射手</option>
							<option value="辅助">辅助</option>
						</select>
						</td>
					</tr>
					<tr>
						<td class="td-na">阵营</td>
						<td class="td-in"><input type="text" name="lhome"></td>
					</tr>
					<tr>
						<td class="td-na">背景</td>
						<td class="td-in" colspan="3"><textarea rows="3" cols="90" style="resize:none;" name="lcontext"></textarea></td>
					</tr>
				</table>
				</div>
				<div class="ta2">
				<table class="tab2">
					<tr class="tab-head"><td colspan="10">技能 >></td></tr>
					<tr>
						<td>被动</td>
						<td><input type="text" name="lpsiv"></td>
						<td>Q</td>
						<td><input type="text" name="lq"></td>
						<td>W</td>
						<td><input type="text" name="lw"></td>
						<td>E</td>
						<td><input type="text" name="le"></td>
						<td>R</td>
						<td><input type="text" name="lr"></td>
					</tr>
				</table>
				</div>
				<div class="ta3">
				<table class="tab3">
					<tr class="tab-head">
						<td colspan="4">上传资料 >></td>
					</tr>
					<tr>
						<td>头像图</td>
						<td>描述图</td>
						<td>介绍视频</td>
					</tr>
					<tr>
						<td class="shbor"><img src="../img/logo.png" alt="img"></td>
						<td class="shbor"><img src="../img/logo.png"  alt="img"></td>
						<td class="shbor"><img src="../img/logo.pn"  alt="video"></td>
					</tr>
					<tr>
						<td><input type="file" name="hept"></td>
						<td><input type="file" name="despt"></td>
						<td><input type="file" name="video"></td>
						<td><input type="submit" value="提交以上资料"  class="sub"></td>
					</tr>
				</table>
				</div>
			</form>
		</div>
	</div>
	</div>
	<div class="end">
		<p>石家庄铁道大学&nbsp;&nbsp;信息学院软件工程系</p>
		<p>王牌飞行员库奇 出品</p>
	</div>
</div>
</body>
</html>