<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link href="<%=basePath%>/sources/pictures/Teacher.ico" rel="shortcut icon" type="image/x-icon"/>
    <title>Teacher Course Page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" media="screen" type="text/css" href="${pageContext.request.contextPath }/sources/css/showcourse.css">
  </head>
  
  <body>
  <div style="margin-left: 1150px; width: 150px;height: 60px;"><a href="${pageContext.request.contextPath }/outlogin/outlogin.action">用户退出--</a></div>
  <div style="margin-left: 1150px; width: 150px;height: 60px;"><a href="${pageContext.request.contextPath }/teacher/toShowCourtyardPieChartjsp.action">排行榜评比</a></div>
<ul>
<c:forEach items="${courses }" var="v">
	<li>
		<a href="${pageContext.request.contextPath }/teacher/toshowEvaluatejsp.action?c_id=${v.c_id}" target="_blank">
			<div id="div1">
				<div id="div2">
					<img src="${pageContext.request.contextPath }/sources/pictures/2.jpg" alt="" width="100%" height="100%">
				</div>
				<div id="div3">
					${v.cname}
				</div>
			</div>
		</a>
	</li>
</c:forEach>
</ul>
</body>
</html>
