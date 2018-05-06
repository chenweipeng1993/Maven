<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>登录窗口</title>
<script type="text/javascript">
	function change() {

		document.getElementById("f").submit();
	}
</script>
</head>

<body>
	<form action="login2.jsp" method="post" id="f">
		<select name="locale" onchange="change();">
			<option>---请求选择国家---</option>
			<option value="en_US">US</option>
			<option value="zh_CN">CHINA</option>
		</select>
	</form>

	
	
	
	
	<br> 使用JSTL国际化标签完成
	<br>
	
	<fmt:setLocale value="${param.locale}" /><!-- new Local()-->
	
	<fmt:setBundle basename="message" var="bundle" scope="page" /> <!-- ResourceBundle bundle=ResourceBundle.getBundle("message",local) -->
	<h1>
		<fmt:message bundle="${bundle }" key="title" /> <!-- bundle.getString(title) -->
	</h1>
	<hr>
	<table>
		<tr>
			<td><fmt:message bundle="${bundle }" key="username" />
			</td>
			<td><input type="text" name="username"></td>
		</tr>

		<tr>
			<td><fmt:message bundle="${bundle }" key="password" />
			</td>
			<td><input type="text" name="password"></td>
		</tr>

		<tr>
			<td colspan="2"><input type="submit"
				value="<fmt:message bundle="${bundle }" key="submit" />">
			</td>

		</tr>
	</table>

</body>
</html>
