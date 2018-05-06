package cn.itcast;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {

	public static void main(String[] args) {

		Timer t = new Timer();

		t.schedule(new TimerTask() {

			@Override
			public void run() {
				System.out.println("hello timer");
			}
		}, 1000,2000);
	}
}
