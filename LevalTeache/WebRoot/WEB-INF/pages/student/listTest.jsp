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
    <title>评教系统后台</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<script src="${pageContext.request.contextPath }/sources/js/jquery-2.1.4.min.js" type="text/javascript"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/sources/css/default1.css">
<!--<link href="http://fonts.useso.com/css?family=Open+Sans:400,700,600" rel="stylesheet" type="text/css">
    <link href="http://libs.useso.com/js/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet"> -->
    <link href="${pageContext.request.contextPath }/sources/css/app.css" rel="stylesheet" type="text/css">
<style type="text/css">
	ul{
	font-family: Microsoft YaHei;
	font-size: 24px;
	}
</style>   
  </head>
<body>
	<div id="contentWrapper">
	    <div id="contentLeft">
	        <ul id="leftNavigation">
	        
	            <li class="active">
	                <a href="#"><i class="fa fa-coffee leftNavIcon"></i>注册信息--</a>
	                <ul>
	                    <li>
	                        <a href="${pageContext.request.contextPath }/courtyard/Register.action" target="myframe"><i class="fa fa-angle-right leftNavIcon"></i>注册院级</a>
	                    </li>
	                    <li>
	                        <a href="${pageContext.request.contextPath }/courtyard/TeacherRegister.action" target="myframe"><i class="fa fa-angle-right leftNavIcon"></i>注册教师</a>
	                    </li>
	                    <li>
	                        <a href="${pageContext.request.contextPath }/student/toStudentRegister.action" target="myframe"><i class="fa fa-angle-right leftNavIcon"></i>注册学生</a>
	                    </li>
	                    <li>
	                        <a href="${pageContext.request.contextPath }/course/toregister.action" target="myframe"><i class="fa fa-angle-right leftNavIcon"></i>注册课程</a>
	                    </li>
	                </ul>
	            </li>
	            <li>
	                <a href="#"><i class="fa fa-flask leftNavIcon"></i>更新信息--</a>
	                <ul>
	                    <li>
	                        <a href="${pageContext.request.contextPath }/update/update.action" target="myframe"><i class="fa fa-angle-right leftNavIcon"></i>更新个人信息</a>
	                    </li>
	                </ul>
	            </li>
	            <li>
	                <a href="#"><i class="fa fa-truck leftNavIcon"></i>建立关系--</a>
	                <ul>
	                    <li>
	                        <a href="${pageContext.request.contextPath }/conllection/toTeacheAndCourse.action" target="myframe"><i class="fa fa-angle-right leftNavIcon"></i>建立老师和课程关系</a>
	                    </li>
	                    <li>
	                        <a href="${pageContext.request.contextPath }/collection/toGradeCourse.action" target="myframe"><i class="fa fa-angle-right leftNavIcon"></i>建立班级和课程关系</a>
	                    </li>
	                </ul>
	            </li>
	            <li class="clickable">
	                <a href="${pageContext.request.contextPath }/evaluate/toManageEvaluateJsp.action" target="myframe"><i class="fa fa-envelope-o leftNavIcon"></i>选项管理--</a>
	            </li>
	            <li class="clickable">
	                <a href="${pageContext.request.contextPath }/teacher/toShowPieChartjsp.action" target="myframe"><i class="fa fa-envelope-o leftNavIcon"></i>图表分析--</a>
	            </li>
	            <li class="clickable">
	                <a href="${pageContext.request.contextPath }/sendemail/toemail.action" target="myframe"><i class="fa fa-envelope-o leftNavIcon"></i>生成文档--</a>
	            </li>
	        </ul>
	    </div>
	    <div id="contentRight">
	    	<h2><a href="${pageContext.request.contextPath }/outlogin/outlogin.action">用户退出--</a></h2>
	        <p style="font-family: Microsoft YaHei;font-size: 19px;">该评教系统基于可以为所有高校所使用的系统，并可实时分析数据，分析出教师在该学年中的教学质量，并分析出报告。</p>
			<iframe name="myframe" frameborder="0" style="width: 1110px;height:100%; "></iframe>
	    </div>

	</div>
<!-- 	<div class="related" style="font-family: Microsoft YaHei;font-size: 22px;">
	   嘀哩评教系统
	</div> -->
	<script src="${pageContext.request.contextPath }/sources/js/jquery.ssd-vertical-navigation.min.js"></script>
	<script src="${pageContext.request.contextPath }/sources/js/app.js"></script>
</body>
</html>
