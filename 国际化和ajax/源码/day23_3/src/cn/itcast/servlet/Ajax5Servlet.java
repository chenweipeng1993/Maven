package cn.itcast.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import cn.itcast.domain.Product;
import cn.itcast.jsonlib.JsonLibTest;

public class Ajax5Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		List<Product> ps = new ArrayList<Product>();
		ps.add(new Product(1, "洗衣机", 1800));
		ps.add(new Product(2, "电视机", 3800));
		ps.add(new Product(3, "空调", 5800));

		// 返回的是json数据
		PrintWriter out = response.getWriter();

		String json = JSONArray.fromObject(ps).toString();
		out.print(json);

		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
