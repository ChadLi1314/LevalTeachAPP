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
    
    <title>My JSP 'TeacherRegister.jsp' starting page</title>
    
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
				<form target="myframe" class="contact_form" action="${pageContext.request.contextPath }/teacher/save.action" method="post" name="contact_form">
		    <ul>
		        <li>
		             <h2>注册教师</h2>
		             <span class="required_notification">* 表示必填项</span>
		        </li>
		        <li>
		            <label for="name">院级:</label>
		            <select name="i_id">
			            <c:forEach items="${courtyard}" var="v">
							   <option value="${v.i_id }">${v.iname }</option>
						</c:forEach>     				
					</select>
		        </li>
		        <li>
		            <label for="name">姓名:</label>
		            <input type="text" name="tname"  placeholder="如:李三" required />
		        </li>
		        <li>
		            <label for="nation">民族:</label>
		            <input type="text" name="nation"  placeholder="如:汉族" required />
		        </li>
		         <li>
		            <label for="name">性别:</label>
				            男:<input style="width: 15px;" type="radio" name="sex" checked="checked" value="男" />
				            女:<input style="width: 15px;" type="radio" name="sex" value="女" />
		        </li>
		        <li>
		            <label for="email">出生日期:</label>
		            <input type="text" name="date" placeholder="如:1999-06-05" required pattern="^((?:19|20)\d\d)-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$" />
		            <span class="form_hint">正确格式为：1999-06-05</span>
		        </li>
		        <li>
		            <label for="website111">身份证号:</label>
		            <input type="text" name="Idcard" placeholder="如:42212219940605****" required/>
		            <span class="form_hint">正确格式为：http://sc.chinaz.com</span>
		        </li>
		         <li>
		            <label for="census">户籍:</label>
		            <input type="text" name="census"  placeholder="如:湖北省-襄阳市-襄城区" required />
		        </li>
		         <li>
		            <label for="politics">政治面貌:</label>
		            <input type="text" name="politics"  placeholder="如:中共团员" required />
		        </li>
		         <li>
		            <label for="background">学历:</label>
		            <input type="text" name="background"  placeholder="如:本科" required />
		        </li>
		        <!-- <li>
		            <label for="message">留言:</label>
		            <textarea name="census" cols="40" rows="6" placeholder="jquery素材下载" required ></textarea>
		        </li> -->
		        <li>
		        	<button class="submit" type="submit">Submit</button>
		        </li>
		    </ul>
		    </form></td>
			</tr>
		</table>
	</div>
<div style="text-align:center;clear:both">
</div>
  </body>
</html>
