package cn.itcast.listener.session;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent arg0) {

		System.out.println("session对象创建了");
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("session对象销毁了");
	}

}
