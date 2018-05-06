package cn.itcast.web.listener.application;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("servletContext对象销毁");
	}

	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("servletContext对象创建");
	}

}
