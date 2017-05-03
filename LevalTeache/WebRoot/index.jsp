<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link href="<%=basePath%>/sources/pictures/Teacher.ico" rel="shortcut icon" type="image/x-icon"/>
    <title>评教系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" media="screen" type="text/css" href="${pageContext.request.contextPath }/sources/css/normalize.css">
	<link rel="stylesheet" media="screen" type="text/css" href="${pageContext.request.contextPath }/sources/css/default.css">
	<link rel="stylesheet" media="screen" type="text/css" href="${pageContext.request.contextPath }/sources/css/styles1.css">
  </head>
  
  <body>
  <h2 style="font-family:Microsoft YaHei;color: #8FDAC3;text-align: center;">积极参与评价，共建和谐校园!</h2>
    	<div class="htmleaf-container">
		<header class="htmleaf-header">
			<h1 style="font-family:Microsoft YaHei;color: #8FDAC3;">学生登录</h1>
			<div class="htmleaf-links" style="margin-top: -20px;">
				<a class="htmleaf-icon icon-htmleaf-home-outline" href="${pageContext.request.contextPath }/index1.jsp" style="font-family:Microsoft YaHei;color: #8FDAC3;"  title="教师登录">教师登录</a>
				<a style="margin-left: 60px;font-family:Microsoft YaHei;color: #8FDAC3;" class="htmleaf-icon icon-htmleaf-arrow-forward-outline" href="${pageContext.request.contextPath }/index2.jsp" title="管理员登录">管理员登录</a>
			</div>
		</header>
		<div class="wrapper">
			<div class="container">
				<h1>Welcome</h1>
				<form class="form" action="${pageContext.request.contextPath }/login/studentlogin.action" method="post">
					<%
					if(request.getParameter("error")!=null){
						out.print("用户名或密码错误！请重新填写!");
					}
					%>
					<input type="text" name="username" placeholder="输入学号:" required >
					<input type="password" name="password" placeholder="输入密码:" required>
					<!-- <button type="submit" id="login-button">Login</button> -->
					<button type="submit">登录</button>
				</form>
			</div>
			<ul class="bg-bubbles">
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			</ul>
		</div>
	</div>
	<script src="${pageContext.request.contextPath }/sources/js/jquery-2.1.4.min.js" type="text/javascript"></script>
<!-- 	<script src="http://libs.useso.com/js/jquery/2.1.1/jquery.min.js" type="text/javascript"></script> -->
	<script>window.jQuery || document.write('<script src="${pageContext.request.contextPath }/sources/js/jquery-2.1.4.min.js"><\/script>')</script>
	<script>
	$('#login-button').click(function (event) {
	    event.preventDefault();
	    $('form').fadeOut(500);
	    $('.wrapper').addClass('form-success');
	});
	</script>
  </body>
</html>
