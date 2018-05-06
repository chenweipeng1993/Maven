package cn.itcast.listener.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

public class MyServletContextListener implements ServletContextListener {

	private List<HttpSession> sessions = Collections
			.synchronizedList(new ArrayList<HttpSession>());// 线程安全的List集合.

	public void contextDestroyed(ServletContextEvent sce) {

	}

	public void contextInitialized(ServletContextEvent sce) {
		// 这个方法执行了，就说明项目启动了.

		// 1.得到ServletContext对象
		ServletContext context = sce.getServletContext();

		// 2,将集合保存到context中.
		context.setAttribute("sessions", sessions);

		// 3.开始扫描
		Timer t = new Timer();

		t.schedule(new TimerTask() {

			@Override
			public void run() {
				System.out.println("开始扫描session");
				// 判断session是否过期.----session如果10秒钟没有使用，将其销毁.
				for (Iterator<HttpSession> it = sessions.iterator(); it
						.hasNext();) {
					HttpSession session = it.next();
					// 判断session是否过期
					if (System.currentTimeMillis()
							- session.getLastAccessedTime() > 10000) {

						System.out.println(session.getId() + " 已经超时，被销毁了。");
						// sessions.remove(session);// 从集合中删除
						it.remove();
						session.invalidate();// 销毁session
					}

				}

			}
		}, 1000, 3000);

	}

}
