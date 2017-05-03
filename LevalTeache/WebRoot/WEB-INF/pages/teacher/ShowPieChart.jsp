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
    <title>ShowPieChart page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${pageContext.request.contextPath }/sources/others/ampie_1.6.4.1/ampie/swfobject.js"></script>
  </head>
  
  <body>
    <!-- localhost:8080/a1/chartExample/pie.jsp -->
	<div id="flashcontent">
		<strong>湖北文理学院评教前十名教师</strong>
	</div>

	<script type="text/javascript">		
		var so = new SWFObject("${pageContext.request.contextPath }/sources/others/ampie_1.6.4.1/ampie/ampie.swf", "ampie", "520", "400", "8", "#FFFFFF");
		so.addVariable("path", "${pageContext.request.contextPath }/sources/others/ampie_1.6.4.1/ampie/");
		so.addVariable("settings_file", escape("${pageContext.request.contextPath }/sources/others/ampie_1.6.4.1/ampie/ampie_settings.xml"));       // you can set two or more different settings files here (separated by commas)
		so.addVariable("data_file", escape("${pageContext.request.contextPath }/file/ampie_data.xml"));		
		so.addVariable("preloader_color", "#999999");
		so.write("flashcontent");
	</script>
	
  </body>
</html>
