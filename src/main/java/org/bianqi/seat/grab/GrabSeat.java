package org.bianqi.seat.grab;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.bianqi.seat.room.AppRoom;

/**
 * 定时器抢明天的座位
 * @author BIANQI
 *
 */
public class GrabSeat {
	
	static String response = "";

	public static void main(String[] args) {
		// 第一个参数不修改 第二个参数不修改，第三个参数为用户名，第四个参数为密码，第五个参数为座位
		// 【第四个参数每个数字代表的含义】
		// 第一个数字:[1为东区2.为中区4.为西区]
		// 二到四数字代表:401为教室
		// 五到七数字代表:229为座位的位置
		// 比如:1401229代表 东区401自习室229座位
		taskGrab("http://172.16.47.84/Skip.aspx", "http://172.16.47.84/", "2014023002", "123456", "2211117");
	}
	public static String taskGrab(final String appUrl, final String cookieUrl, final String username, final String password, final String seatId) {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		// 定制每天的13:00:00执行
		calendar.set(year, month, day, 13, 00, 00);
		Date date = calendar.getTime();
		final Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				try {
					response = AppRoom.getSeat(appUrl, cookieUrl, username, password, seatId);
					if(response.equals("明日预约成功")){
						timer.cancel();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		timer.schedule(task, date, 1);
		return response;
	}

}
