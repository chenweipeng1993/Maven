package cn.itcast.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;

import cn.itcast.domain.Person;

public class Ajax7Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/xml;charset=utf-8");

		List<Person> ps = new ArrayList<Person>();
		ps.add(new Person(1, "tom", 20));
		ps.add(new Person(2, "fox", 30));

		XStream xs = new XStream();

		xs.autodetectAnnotations(true);
		String xml = xs.toXML(ps);

		response.getWriter().write(xml);
		response.getWriter().close();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
