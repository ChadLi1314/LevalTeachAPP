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
    <title>课程评价</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/sources/css/404.css">
<script src="${pageContext.request.contextPath }/sources/js/prefixfree.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/sources/js/index.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/sources/js/jquery-2.1.4.min.js" type="text/javascript"></script>
 <style>
                body
                {
                    background: #d4d4d4;
                    padding: 50px;
                }
                html {
				  display: flex;
				  justify-content: center;
				  align-items: center;
				  height: 100%;
				}

                #bottomSpacer
                {
                    padding-top: 30px;
                }

            div.error404_main
                {
                    background: url(sources/pictures/Evaluate.jpg) no-repeat;
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
				input {
				  -webkit-appearance: none; /* remove default */
				  margin: 10px;
				  width: 24px;
				  height: 24px;
				  border-radius: 12px;
				  cursor: pointer;
				  vertical-align: middle;
				  box-shadow: hsla(0,0%,100%,.15) 0 1px 1px, inset hsla(0,0%,0%,.5) 0 0 0 1px;
				  background-color: hsla(0,0%,0%,.2);
				  background-image: -webkit-radial-gradient( hsla(200,100%,90%,1) 0%, hsla(200,100%,70%,1) 15%, hsla(200,100%,60%,.3) 28%, hsla(200,100%,30%,0) 70% );
				  background-repeat: no-repeat;
				  -webkit-transition: background-position .15s cubic-bezier(.8, 0, 1, 1),
				    -webkit-transform .25s cubic-bezier(.8, 0, 1, 1);
				}
				input:checked {
				  -webkit-transition: background-position .2s .15s cubic-bezier(0, 0, .2, 1),
				    -webkit-transform .25s cubic-bezier(0, 0, .2, 1);
				}
				input:active {
				  -webkit-transform: scale(1.5);
				  -webkit-transition: -webkit-transform .1s cubic-bezier(0, 0, .2, 1);
				}
				
				/* The up/down direction logic */
				
				input,
				input:active {
				  background-position: 0 24px;
				}
				input:checked {
				  background-position: 0 0;
				}
				input:checked ~ input,
				input:checked ~ input:active {
				  background-position: 0 -24px;
				}
				ul{
				list-style:none;margin:0;
				}
				li{
				display:inline; 
				}
            </style>
</head>
  <body>
      <body class="noie page_response nouser">

            <div class="error404_main" style="width: 100%;height: 100%;">
            <form action="${pageContext.request.contextPath }/evaluate/saveEvaluate.action" method="post">
            	<c:forEach items="${strs }" var="v" varStatus="str">
            	<h2 style="font-family:Microsoft YaHei;font-size: 15px; ">${str.index+1}.${v}</h2>
	            	<ul>
						<li><input type="radio" name="${str.index+1}" value="10"/>优良</li>
						<li><input type="radio" name="${str.index+1}" value="8" />良好</li>
						<li><input type="radio" name="${str.index+1}" value="6" checked="checked"/>及格</li>
						<li><input type="radio" name="${str.index+1}" value="4" />不及格</li>
				    </ul>
				    <c:if test="${str.index+1 ==10}">
				    	<hr color="#2FA0EC"/>
				    	<h1 style="font-family:Microsoft YaHei;color: black;font-size: 18px;">附加选项:</h1>
				    </c:if>
            	</c:forEach>
            	<textarea name="content" cols="40" rows="6" placeholder="对教师评语的意见，写此处:"></textarea>
            	<input type="hidden" name="c_id" value="${cname }"/>
			  <h1></h1>
			  <button onclick="fn()" type="submit" style="width: 80px;height: 20px;text-align: center;">提交</button>
			</form>
            </div>

   <script type="text/javascript">
   /*var inpArr = document.getElementsByTagName("input"),result = 0;*/
    var inpArr = $("input");
    function fn(){
        var result = 0;
        for(var i=0;i<inpArr.length;i++){
            if(inpArr[i].checked){
                result+=parseInt(inpArr[i].value);
            }
        }
        $("h1").html("");
        $("h1").append("评价结果:<input  readonly='true' style='width: 80px;height: 20px;text-align: center;' type='text' name='result' value='"+result+"'/>");
    }
   </script>
</html>
