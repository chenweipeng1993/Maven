package cn.itcast.listener.request.copy;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyRequestListener implements ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("request对象销毁");

	}

	public void requestInitialized(ServletRequestEvent arg0) {

		System.out.println("request对象创建");
	}

}
