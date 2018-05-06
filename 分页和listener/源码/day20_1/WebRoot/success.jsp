<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>

	<a href="${pageContext.request.contextPath}/findAll">查看所有客户信息</a><br>
	
	<a href="${pageContext.request.contextPath}/findAllByPage">查看所有客户信息(分页展示)</a><br>
  </body>
</html>
