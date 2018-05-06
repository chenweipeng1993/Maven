<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>ajax开发---xml返回</title>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/my.js"></script>

<script type="text/javascript">
	window.onload = function() {
		//得到id=t的文本框
		var btn = document.getElementById("btn");

		btn.onclick = function() {

			//第一步:得到XMLHttpRequest对象.
			var xmlhttp = getXmlHttpRequest();
			//2.设置回调函数
			xmlhttp.onreadystatechange = function() {

				//5.处理响应数据  当信息全部返回，并且是成功
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

					var xml = xmlhttp.responseXML;
					
					alert(xml);
					var names = xml.getElementsByTagName("name");
					
					for(var i=0;i<names.length;i++){
						//alert(names[i].firstChild.nodeValue);
						alert(names[i].innerHTML);
					}
				}
			};

			//post请求方式，参数设置
			xmlhttp.open("GET", "${pageContext.request.contextPath}/ajax7");

			xmlhttp.send(null);
		};
	};
</script>

</head>

<body>
	<input type="button" value="接收xml" id="btn">
</body>
</html>
