<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link href="<%=basePath%>/sources/pictures/Teacher.ico" rel="shortcut icon" type="image/x-icon"/>
    
    <title> TeacherRegister  Page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" media="screen" type="text/css" href="${pageContext.request.contextPath }/sources/css/styles.css">
	
<style>
    .contact_form{padding-top:40px;}
	.title {background-color:rgba(0,0,0,0.56); text-align:center; width:100%; position:fixed; top:0; left:0; padding:5px 0;}
	.title a {color:#FFF; text-decoration:none; font-size:16px; font-weight:bolder; line-height:24px;}
</style>
  </head>
  
  <body>
    <div align="center">
		<table border="1" width="47%" height="250" style="border-width: 0px">
			<tr>
				<td style="border-style: none; border-width: medium">　
				<form target="myframe" class="contact_form" action="${pageContext.request.contextPath }/student/save.action" method="post" name="contact_form" enctype="multipart/form-data">
		    <ul>
		        <li>
		             <h2>注册学生</h2>
		             <span class="required_notification">* 表示必填项</span>
		        </li>
		        <li>
		            <label for="s_id">学号:</label>
		            <input type="text" name="s_id"  placeholder="如:2013193102"  />
		        </li>
		        <li>
		            <label for="password">密码:</label>
		            <input type="text" name="password"  placeholder="如:2013193102" />
		        </li>
		        <li>
		            <label for="sname">姓名:</label>
		            <input type="text" name="sname"  placeholder="如:李三"  />
		        </li>
		         <li>
		            <label for="sex">性别:</label>
				            男:<input style="width: 15px;" type="radio" name="sex" checked="checked" value="男" />
				            女:<input style="width: 15px;" type="radio" name="sex" value="女" />
		        </li>
		        <li>
		            <label for="grade">专业班级:</label>
		            <input type="text" name="grade"  placeholder="如:软件1311班"  />
		        </li>
		        
		        <li>
		            <label for="grade">上传Excel文件:</label>
		            <input style="height: 35px;" type="file" name="file"  placeholder="如:标准格式EXCEL文件,10或03版"  accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"/>
		        </li>
		       <!--  <li>
		            <label for="email">出生日期:</label>
		            <input type="text" name="date" placeholder="如:1999-06-05" required pattern="^((?:19|20)\d\d)-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$" />
		            <span class="form_hint">正确格式为：1999-06-05</span>
		        </li> -->
		        <li>
		        	<button class="submit" type="submit">Submit</button>
		        </li>
		    </ul>
		    </form></td>
			</tr>
		</table>
	</div>
  <div style="text-align:center;clear:both"></div>
  </body>
</html>