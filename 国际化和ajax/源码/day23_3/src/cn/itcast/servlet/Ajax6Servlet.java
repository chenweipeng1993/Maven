package cn.itcast.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ajax6Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FileInputStream fis = new FileInputStream(
				"D:\\java1110\\workspace\\day23_3\\src\\person.xml");

		OutputStream os = response.getOutputStream();

		int len = -1;
		byte[] b = new byte[1024];

		while ((len = fis.read(b)) != -1) {
			os.write(b, 0, len);
			os.flush();
		}
		fis.close();
		os.close();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
