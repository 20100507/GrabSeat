package org.bianqi.seat.test;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class TimerTest {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		// 定制每天的13:00:00执行
		calendar.set(year, month, day, 12, 39, 00);
		Date date = calendar.getTime();
		Timer timer = new Timer();
		
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				try {
					System.out.println("Java");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		timer.schedule(task, date, 1);
	}
}
