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
	var flag = false;
	$(function(){
		
		/*院级Ajax*/
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
							$("#t_id").html("");
							$.each(data,function(i, item) {
								var statem = "<option value='"+item.t_id+"'>"+item.tname+"</option>";
								$("#t_id").append(statem);
							});
							
						}
					},
					error:function(){
							alert("方法执行不成功!");
						}  
					 });
				  }
				});

			/*教师Ajax*/
			$("#t_id").change(function(){
				var t_id = $("#t_id").val();
				var i_id = $("#i_id").val();
				if(t_id==""){
					alert("您还未选中值，请选择！");
				}else{
					$.ajax({
					type:"POST",
					url:"conllection/t_id.action",
					dataType:"json",
					data:{i_id:i_id},
					success:function(data){
						if(data=="{}"){
							alert("该院没有查询到数据!");
						}else{
							$("#c_id").html("");
							$.each(data,function(i, item) {
								var statem = "<option value='"+item.c_id+"'>"+item.cname+"</option>";
								$("#c_id").append(statem);
							});
							
						}
					},
					error:function(){
							alert("方法执行不成功!");
						}  
					 });
				}
			});

			/*教师课程链接检测*/
			$("#c_id").change(function(){
				if(t_id==""||i_id==""){
					alert("您还未选中值，请选择！");
				}else{
					$.ajax({
					type:"POST",
					url:"conllection/ErrorCollection.action",
					dataType:"json",
					async: false,
					data:{t_id:$("#t_id").val(),c_id:$("#c_id").val()},
					success:function(data){
						if(data==1){
							alert("该教师和课程已经存在数据!");
							flag=false;
						}else{
							alert("该教师和课程可以建立关系!");
							flag=true;
						}
					},
					error:function(){
							alert("方法执行不成功!");
						}  
					 });
				}
			});
			
			
		});
		//提交之前检查是否存在关系
		function check(){
			if(flag){
				return true;
			}else{
				alert("您选择的课程或者老师已经存在关系，请重新填写!");
				return false;
			}
		}
</script>
  </head>
  
  <body>
    <div align="center">
		<table border="1" width="47%" height="250" style="border-width: 0px">
			<tr>
				<td style="border-style: none; border-width: medium">　
				<form class="contact_form" action="${pageContext.request.contextPath }/collection/conllection.action" method="post" name="contact_form" onsubmit="return check()">
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
		        <li>
		            <label for="name">教师:</label>
		            <select name="t_id" id="t_id">
		            	<option value="">--选择--</option>     				
					</select>
		        </li>
		        <!-- <li>
		            <label for="message">结果:</label>
		            <textarea name="census" id="result" cols="40" rows="6" placeholder="查询结果"></textarea>
		        </li> -->
		        <!-- <li>
		        	<label for="message">结果:</label>
		        	<div id="result1"></div>
		        </li> -->
		        <li>
		            <label for="name">课程:</label>
		            <select name="c_id" id="c_id">
		            	<option value="">--选择--</option>     				
					</select>
		        </li>
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
