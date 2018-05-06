<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="my" uri="http://www.itcast.cn/tag"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'index.jsp' starting page</title>

<script type="text/javascript">
	function changeCurrentPage(value) {

		location.href = "/day20_1/findAllByPage?currentPage=" + value;
	};
</script>
</head>

<body>

	<c:if test="${empty pb.cs}">
		无客户信息
	</c:if>


	<c:if test="${not empty pb.cs}">

		<table border="1" align="center" width="85%">
			<tr>

				<td>客户编号</td>
				<td>客户姓名</td>
				<td>客户性别</td>
				<td>客户生日</td>
				<td>客户电话</td>
				<td>客户邮箱</td>
				<td>客户爱好</td>
				<td>客户类型</td>
				<td>客户备注</td>

			</tr>

			<c:forEach items="${pb.cs}" var="c">
				<tr>

					<td>${c.id }</td>
					<td>${c.name}</td>
					<td>${c.gender }</td>
					<td>${c.birthday }</td>
					<td>${c.cellphone }</td>
					<td>${c.email }</td>
					<td>${c.preference }</td>
					<td>${c.type }</td>
					<td>${c.description }</td>

				</tr>
			</c:forEach>
			<tr>
				<td colspan="9" align="center"><a
					href="/day20_1/findAllByPage?pageNum=1&currentPage=${pb.currentPage}">首页</a>&nbsp;&nbsp;&nbsp;

					<c:if test="${pb.pageNum==1}">
							上一页&nbsp;&nbsp;&nbsp;
						</c:if> <c:if test="${pb.pageNum!=1}">
						<a
							href="/day20_1/findAllByPage?pageNum=${pb.pageNum-1}&currentPage=${pb.currentPage}">上一页</a>&nbsp;&nbsp;&nbsp;
						</c:if> <c:if test="${pb.pageNum==pb.totalPage}">
							下一页&nbsp;&nbsp;&nbsp;
						</c:if> <c:if test="${pb.pageNum!=pb.totalPage}">
						<a
							href="/day20_1/findAllByPage?pageNum=${pb.pageNum+1 }&currentPage=${pb.currentPage}">下一页</a>&nbsp;&nbsp;&nbsp;
						</c:if> <a
					href="/day20_1/findAllByPage?pageNum=${pb.totalPage }&currentPage=${pb.currentPage}">尾页</a>&nbsp;&nbsp;&nbsp;

					<select name="currentPage"
					onchange="changeCurrentPage(this.value);">
						<option>--请选择每页条数--</option>
						<option value="5">5</option>
						<option value="10">10</option>
						<option value="20">20</option>
				</select>
				</td>

			</tr>
			<tr>
				<td colspan="9" align="center"><c:forEach begin="1"
						end="${pb.totalPage}" var="n" step="1">
						<c:if test="${n==pb.pageNum}">
							<a
								href="/day20_1/findAllByPage?pageNum=${n}&currentPage=${pb.currentPage}"><font
								color='red'>第${n}页</font> </a>&nbsp;&nbsp;
							</c:if>

						<c:if test="${n!=pb.pageNum}">
							<a
								href="/day20_1/findAllByPage?pageNum=${n}&currentPage=${pb.currentPage}">第${n}页</a>&nbsp;&nbsp;
					
								</c:if>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td colspan="9" align="center"><my:page pb="${pb}" />
				</td>
			</tr>
		</table>
	</c:if>

</body>
</html>
