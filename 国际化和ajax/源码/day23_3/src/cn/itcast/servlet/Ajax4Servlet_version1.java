package cn.itcast.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Product;

public class Ajax4Servlet_version1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		List<Product> ps = new ArrayList<Product>();
		ps.add(new Product(1, "洗衣机", 1800));
		ps.add(new Product(2, "电视机", 3800));
		ps.add(new Product(3, "空调", 5800));

		PrintWriter out = response.getWriter();

		StringBuilder builder = new StringBuilder();

		builder.append("<table border='1'><tr><td>商品编号</td><td>商品名称</td><td>商品价格</td></tr>");
		for (Product p : ps) {
			builder.append("<tr><td>" + p.getId() + "</td><td>" + p.getName()
					+ "</td><td>" + p.getPrice() + "</td></tr>");
		}

		builder.append("</table>");

		out.print(builder.toString());
		out.flush();
		out.close();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
