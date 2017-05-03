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
    <title>My JSP '404.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/sources/css/404.css">
	
 <style>
                body
                {
                    background: #d4d4d4;
                }

                #bottomSpacer
                {
                    padding-top: 30px;
                }

            div.error404_main
                {
                    background: url(sources/pictures/405.jpg) no-repeat;
                    width: 950px;
                    height: 550px;
                    margin: 48px 21px 0 21px;
                    position: relative;
                }

             span.main_txt
                {
                    display: block;
                    width: 150px;
                    height: 63px;
                    position: absolute;
                    top: 223px;
                    left: 745px;
                    text-align: center;
                    color: #1d1d1d;
                    padding: 2px 0 0 0;
                }

                   span.main_txt span
                    {
                        display: block;
                        margin: 0 0 2px 0;
                    }

                 span.main_txt a
                    {
                        color: #1d1d1d;
                    }

                div.error404_guide
                {
                    width: 950px;
                    height: 84px;
                    background-color: #b4b4b4;
                    margin: 0 21px;
                    position: relative;
                }

         
            </style>
  </head>
  
  <body class="noie page_response nouser">
    <div class="sta_container" id="templateStaContainer">
        <div id="mainTemplateHolder">
            <div class="error404_main"><span class="main_txt"><span>抱歉，您访问的页面没找到</span><span>您可以继续浏览<h2><a class="gray_un" href="${pageContext.request.contextPath }/student/list.action">主页</a></h2>.</span></span></div>
            <div class="clear"></div>
            <div class="clear"></div>
        </div>
        <div id="bottomSpacer"></div>
    </div>
</body>
</html>
