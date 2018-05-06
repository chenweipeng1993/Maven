package cn.itcast.customer.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.customer.domain.Customer;
import cn.itcast.customer.service.CustomerService;

public class CustomerSimpleSelectServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		// 1.得到请求参数
		String field = request.getParameter("field"); // 字段名称
		String msg = request.getParameter("msg"); // 字段值

		// 2.调用service完成查询操作
		CustomerService service = new CustomerService();

		try {
			List<Customer> cs = service.simpleSelect(field, msg);

			request.setAttribute("cs", cs);

			request.getRequestDispatcher("/showCustomer.jsp").forward(request,
					response);
			return;

		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("条件查询失败");
			return;
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
