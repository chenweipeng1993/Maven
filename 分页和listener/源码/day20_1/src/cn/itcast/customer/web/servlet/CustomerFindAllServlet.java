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

public class CustomerFindAllServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

		// 调用servic中查询所有方法
		CustomerService service = new CustomerService();
		try {
			List<Customer> cs = service.findAll();

			request.setAttribute("cs", cs);

			request.getRequestDispatcher("/showCustomer.jsp").forward(request,
					response);
			return;
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("查询客户信息失败");
			return;
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
