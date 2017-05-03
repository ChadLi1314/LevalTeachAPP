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
    
    <title>Update Page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" media="screen" type="text/css" href="${pageContext.request.contextPath }/sources/css/styles.css">
	<script src="${pageContext.request.contextPath }/sources/js/jquery-2.1.4.min.js" type="text/javascript"></script>
<style>
    .contact_form{padding-top:40px;}
	.title {background-color:rgba(0,0,0,0.56); text-align:center; width:100%; position:fixed; top:0; left:0; padding:5px 0;}
	.title a {color:#FFF; text-decoration:none; font-size:16px; font-weight:bolder; line-height:24px;}
</style>
<script type="text/javascript">
	$(function(){
			$("#i_id").change(function(){
				var i_id = $("#i_id").val();
				if(i_id==""){
					alert("您还未选中值，请选择！")
				}else{
					$.ajax({
					type:"POST",
					url:"update/i_id.action",
					dataType:"json",
					data:{i_id:i_id},
					success:function(data){
						if(data=="{}"){
							alert("该院没有查询到数据!");
						}else{
							$("#result1").html("");
							$.each(data,function(i, item) {
								var statem = "<a class='a'  target='myframe' href='${pageContext.request.contextPath}/update/teacherT_id.action?t_id="+item.t_id+"' style='text-decoration: none;color:red;' target='_blank'>"+item.tname+"</a>&nbsp;&nbsp;&nbsp;&nbsp;";
								$("#result1").append(statem);
							});
							
						}
					},
					error:function(){
							alert("方法执行不成功!");
						}  
					 });
				  }
				});
		});
</script>
  </head>
  
  <body>
    <div align="center">
		<table border="1" width="47%" height="250" style="border-width: 0px">
			<tr>
				<td style="border-style: none; border-width: medium">　
				<form class="contact_form" action="#" method="post" name="contact_form">
		    <ul>
		        <li>
		             <h2>更新信息</h2>
		             <span class="required_notification">* 表示必填项</span>
		        </li>
		        <li>
		            <label for="name">院级:</label>
		            <select name="i_id" id="i_id">
		            	<option value="">--选择--</option>
			            <c:forEach items="${courtyard}" var="v">
							   <option value="${v.i_id }">${v.iname }</option>
						</c:forEach>     				
					</select>
		        </li>
		        <!-- <li>
		            <label for="message">结果:</label>
		            <textarea name="census" id="result" cols="40" rows="6" placeholder="查询结果"></textarea>
		        </li> -->
		        <li>
		        	<label for="message">结果:</label><br/><br/>
		        	<div id="result1" style="padding: 15px;"></div>
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
