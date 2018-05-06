package cn.itcast.listener.demo;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//用于监听session对象创建，如果创建了，将其保存到一个集合中。
public class MyHttpSessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		// session创建了.

		// 1.得到session
		HttpSession session = se.getSession();

		// 2.将session保存到集合中.
		// 集合是在ServletContext中存储的，我们只需要从ServletContext中获取就可以。
		ServletContext context = session.getServletContext();
		List<HttpSession> sessions = (List<HttpSession>) context
				.getAttribute("sessions");

		sessions.add(session);

		System.out.println(session.getId() + " 添加到了集合");
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub

	}

}
