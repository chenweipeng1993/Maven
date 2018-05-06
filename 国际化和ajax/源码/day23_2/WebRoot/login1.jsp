<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'index.jsp' starting page</title>

</head>

<body>
	
	<%
		String country = request.getHeader("accept-language");

		ResourceBundle bundle = null;
		
		if(country.startsWith("en-US")){
			bundle=ResourceBundle.getBundle("message",Locale.US);
		}else{
			bundle=ResourceBundle.getBundle("message",Locale.CHINA);
		}
		
	%>

	<h1><%=bundle.getString("title") %></h1>
	<form>
		<%=bundle.getString("username") %>:<input type="text" name="username"><br> 
		<%=bundle.getString("password") %>:<input
			type="password" name="password"><br> 
			<input
			type="submit" value="<%=bundle.getString("submit")%>">
	</form>

</body>
</html>
