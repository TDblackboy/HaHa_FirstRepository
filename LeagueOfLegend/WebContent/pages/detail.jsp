<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="per.sun.modal.*" %>
<%@ page import="per.sun.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- detail css -->
<link rel="stylesheet" href="../css/infor.css">

<title>Mango</title>
</head>
<body>
<div class="header">
		<div class="left"><img class="logo" src="../img/logo2.jpg"></div>
		<div class="right">
			<ul class="head-ul">
				<li><a href="./strategy.jsp">攻略中心</a></li>
				<li class="head-ul-li2"><a href="./roleManage.jsp">管理</a></li>
				<!-- <li class="login"><a href="#">管理员登陆</a></li> -->
			</ul>	
		</div>
	</div>
<div class="information">
<div class="con">
<div class="div_table">
<!-- 没有返回链接 -->
<!-- <p><a href="./strategy.jsp">>> 返回首页</a></p>
<p><a href="./roleManage.jsp">>> go back</a><p> -->
<%
	/* 查看&修改 */
	
	/*======================查看===========================*/
	if(request.getParameter("id")!=null){
		int id=Integer.parseInt(request.getParameter("id"));
		LegendDao dao=new LegendDaoImp();
		Legend one=dao.loadById(id);
		if(request.getParameter("op")==null||request.getParameter("op").equals("see")){//查看详情
	%>
	<table>
		<tr><td class="otd">名字</td><td><%=one.getName() %></td></tr>
		<tr><td class="otd">称号</td><td><%=one.getNeck() %></td></tr>
		<tr><td class="otd">类型</td><td><%=one.getType() %></td></tr>
		<tr><td class="otd">阵营</td><td><%=one.getCamp() %></td></tr>
		<tr><td class="otd">被动</td><td><%=one.getPassive() %></td></tr>
		<tr><td class="otd">Q</td><td><%=one.getSkillq() %></td></tr>
		<tr><td class="otd">W</td><td><%=one.getSkillw() %></td></tr>
		<tr><td class="otd">E</td><td><%=one.getSkille() %></td></tr>
		<tr><td class="otd">R</td><td><%=one.getSkillr() %></td></tr>
		<tr><td class="otd">背景</td><td><%=one.getContext() %></td></tr>
	</table>
	<%
	/*======================修改===========================*/
		}else{
	%>			
		<form action="..//ManagerOprate?op=update&type=update&id=<%=one.getId() %>" method="post">
			<table>
			<tr><td class="otd">名字</td><td><input type="text" name="lname" value="<%=one.getName() %>"></td></tr>
			<tr><td class="otd">称号</td><td><input type="text" name="lneck" value="<%=one.getNeck() %>"></td></tr>
			<tr><td class="otd">类型</td><td><input type="text" name="ltype" value="<%=one.getType() %>"></td></tr>
			<tr><td class="otd">阵营</td><td><input type="text" name="lhome" value="<%=one.getCamp() %>"></td></tr>
			<tr><td class="otd">背景</td><td><input type="text" name="lcontext" value="<%=one.getContext() %>"></td></tr>
			<tr><td class="otd">被动</td><td><input type="text" name="lpsiv" value="<%=one.getPassive() %>"></td></tr>
			<tr><td class="otd">Q</td><td><input type="text" name="lq" value="<%=one.getSkillq() %>"></td></tr>
			<tr><td class="otd">W</td><td><input type="text" name="lw" value="<%=one.getSkillw() %>"></td></tr>
			<tr><td class="otd">E</td><td><input type="text" name="le" value="<%=one.getSkille() %>"></td></tr>
			<tr><td class="otd">R</td><td><input type="text" name="lr" value="<%=one.getSkillr() %>"></td></tr>
			<tr><td></td><td><input type="submit" value="修改"></td></tr>
		</table>
		</form>
	<%
		}
	}
%>
</div>
</div>
</div>
<div class="end">
<p>石家庄铁道大学&nbsp;&nbsp;信息学院软件工程系</p>
<p>王牌飞行员库奇 出品</p>
</div>
</body>
</html>