package cn.itcast.customer.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import cn.itcast.customer.domain.Customer;
import cn.itcast.customer.service.CustomerService;

public class CustomerUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 处理请求编码，
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 1.得到所有请求参数 ，封装到javaBean中.

		Customer c = new Customer();

		DateConverter dc = new DateConverter(); // 这是一个日期类型转换器.
		dc.setPattern("yyyy-MM-dd");

		try {
			ConvertUtils.register(dc, java.util.Date.class);
			BeanUtils.populate(c, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		// 调用service中修改操作
		CustomerService service = new CustomerService();

		try {
			service.update(c);

			// 跳转到CustomerFindAllServlet,就是要重新查询一次
			response.sendRedirect(request.getContextPath() + "/findAll");
			return;

		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("修改失败");
			return;
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
