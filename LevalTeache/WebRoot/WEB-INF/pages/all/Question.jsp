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
    
    <title>选项管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		a{
			text-decoration: none;
			color: #2FA0EC;
		}
		a:HOVER {
			color: #8FDAC3;
		}
		h3{
			font-family:Microsoft YaHei;
			color: black;
		}
	</style>
  </head>
  
  <body>
  	<h3>基本选项列表</h3>
 	<table border="0" style="font-family:Microsoft YaHei;color: black;text-align: left;">
 		<tr>
 			<th>序号</th>
 			<th>内容</th>
 			<th style="text-align: center;">操作</th>
 		</tr>
	  	<c:forEach items="${questions }" var="q" varStatus="str">
	  		<tr>
	  			<td>${str.index+1}.</td>
	  			<td style="width: 800px;">${q.content }</td>
	  			<td style="width: 100px;text-align:center;" >
	  				<a href="${pageContext.request.contextPath }/evaluate/toUpdateQuestionJsp.action?id=${q.id}" target="myframe">编辑 </a>
	  				<c:if test="${str.index+1 >10}">
	  					<a href="${pageContext.request.contextPath }/evaluate/deleteQuestion.action?id=${q.id}" target="myframe"> 删除</a>
	  				</c:if>
	  			</td>
	  		</tr>
	  		<c:if test="${str.index+1==10}">
	  			<tr>
	  				<td colspan="3"><hr color="#2FA0EC"/></td>
		  		</tr>
		  		<tr>
		  			<td colspan="2"><h3>扩展选项列表</h3></td>
		  			<td><a href="${pageContext.request.contextPath }/evaluate/toAddQuestionJsp.action" style="margin-right: 20px;font-family:Microsoft YaHei;" target="myframe">添加扩展选项</a></td>
		  		</tr>
		  		<tr>
		 			<th>序号</th>
		 			<th>内容</th>
		 			<th style="text-align: center;">操作</th>
		 		</tr>
	  		</c:if>
	  	</c:forEach>
  	</table>
  </body>
</html>
