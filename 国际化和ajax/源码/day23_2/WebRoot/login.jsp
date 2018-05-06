<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'index.jsp' starting page</title>
<script type="text/javascript">
	function sendForm() {
		document.getElementById("f").submit();
	}
</script>
</head>

<body>
	<form id="f" action="${pageContext.request.contextPath}/login.jsp"
		method="post">
		<select name="country" onchange="sendForm()">
			<option>--请选择国家--</option>
			<option value="china">中国</option>
			<option value="us">US</option>
		</select>
	</form>

	<%
		String country = request.getParameter("country");

		ResourceBundle bundle = null;
		
		if("us".equals(country)){
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
