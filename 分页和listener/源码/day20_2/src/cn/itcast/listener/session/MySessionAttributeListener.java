package cn.itcast.listener.session;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MySessionAttributeListener implements HttpSessionAttributeListener {

	public void attributeAdded(HttpSessionBindingEvent arg0) {

		// arg0.getSession(); 获取事件源，也就是获取session对象.
		System.out.println(arg0.getName());
		System.out.println(arg0.getValue());
		System.out.println("向session中添加属性");
	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		System.out.println("从session中移除属性");
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		System.out.println("将session中的属性修改");
	}

}
