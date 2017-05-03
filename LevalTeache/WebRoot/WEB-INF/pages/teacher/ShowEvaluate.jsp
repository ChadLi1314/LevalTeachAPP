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
    <title>My JSP 'ShowEvaluate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	h1{
	font-family: Microsoft YaHei;
	}
	#div2{
	width: 700px;
	height: 30px;
	font-family: Microsoft YaHei;
	}
	#div3{
	width: 700px;
	height: 50px;
	font-family: Microsoft YaHei;
	}
</style>
  </head>
  
  <body>
  <c:if test="${!empty evaluate==''}">
  		<h1>该课程没有任何评价!</h1>
  </c:if>
  <c:if test="${empty evaluate==''}">
  		<c:forEach items="${evaluate}" var="v" varStatus="status">
	  		<div id="div2">${status.index+1}:${v.cname}——评价结果:${v.result }</div>
	  		<c:if test="${!empty v.content}">
	  			<div id="div3">评语:${v.content}</div>
	  		</c:if>
 		 </c:forEach>
  </c:if>
  
  </body>
</html>
