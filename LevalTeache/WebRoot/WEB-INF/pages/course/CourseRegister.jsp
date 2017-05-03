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
    <title>Courtyard Register Page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/jsp;charset=utf-8">
	
	<link rel="stylesheet" media="screen" type="text/css" href="${pageContext.request.contextPath }/sources/css/styles.css">
	<script src="${pageContext.request.contextPath }/sources/js/jquery-2.1.4.min.js" type="text/javascript"></script>
	<script type="text/javascript">
	var flag = false;
		$(function(){
			$("#cname").on('blur',function(){
				var cname = $("#cname").val();
				$.ajax({
					type:"POST",
					url:"course/result.action",
					dataType:"json",
					async: false,
					data:{name:cname},
					success:function(data){
						if(data == 0){
						 	alert("存在，不可使用:"+data);
						 	flag=false;
						}else{
							alert("不存在，可使用:"+data);
							flag=true;
						}
					},
					error:function(){
							alert("方法执行不成功!");
						}  
					 });
				});

		});
		function check(){
			if(flag){
				return true;
			}else{
				alert("您填写的课程已经存在，请重新填写!");
				return false;
			}
		}
	</script>
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
					<form target="myframe" class="contact_form" action="${pageContext.request.contextPath}/course/saveCourse.action" method="post" name="contact_form" onsubmit="return check()" enctype="multipart/form-data">
					    <ul>
					        <li>
					             <h2>注册课程</h2>
					             <span class="required_notification">* 表示必填项</span>
					        </li>
					        <li>
					            <label for="cname" style="font-size: 18px;">课程名称:</label>
					            <input type="text" name="cname" id="cname" placeholder="课程名称，不包含特殊字符"/>
					        </li>
					        <li>
					            <label for="grade">上传Excel文件:</label>
					            <input style="height: 35px;" type="file" name="file"  placeholder="如:标准格式EXCEL文件,10或03版"  accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"/>
					        </li>
					        <li>
					        	<button class="submit" type="submit">注册</button>
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
