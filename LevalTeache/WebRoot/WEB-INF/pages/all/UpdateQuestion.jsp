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
    <title>Update Question Page</title>
    
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
			<!-- MSTableType="layout" -->
			<tr>
				<td style="border-style: none; border-width: medium">　
					<form target="myframe" class="contact_form" action="${pageContext.request.contextPath}/evaluate/UpdateSaveQuestion.action" method="post" name="contact_form">
					    <ul>
					        <li>
					             <h2>选项管理</h2>
					             <span class="required_notification">* 表示必填项</span>
					        </li>
					        <li>
					            <input type="hidden" name="id" value="${questions.id }"  placeholder="不包括特殊内容，必填项:" required />
					        </li>
					        <li>
		          			  <label for="message">问题内容:</label>
		          			  <textarea name="content" cols="40" rows="4" placeholder="不包括特殊内容，必填项:" required >${questions.content }</textarea>
		        			</li>
					        <li>
					        	<button class="submit" type="submit">更新</button>
					        </li>
					    </ul>
			    	</form>
		    	</td>
			</tr>
		</table>
	</div>
	<div style="text-align:center;clear:both">
	</div>
  </body>
</html>
