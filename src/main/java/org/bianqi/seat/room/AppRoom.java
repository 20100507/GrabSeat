package org.bianqi.seat.room;

import java.util.HashMap;
import java.util.Map;

import org.bianqi.seat.login.SeatLogin;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;

/**
 * 自动占座位
 */
public class AppRoom {

	public static void main(String[] args) throws Exception {
		// 第一个参数不修改 第二个参数不修改，第三个参数为用户名，第四个参数为密码，第五个参数为座位
		// 【第四个参数每个数字代表的含义】
		// 第一个数字:[1为东区2.为中区4.为西区]
		// 二到四数字代表:401为教室
		// 五到七数字代表:229为座位的位置
		// 比如:1401229代表 东区401自习室229座位
		getSeat("http://172.16.47.84/SkipToday.aspx", "http://172.16.47.84/", "2014023002", "123456", "1401229");
	}

	public static void getSeat(String appUrl, String cookieUrl, String username, String password, String seatId)
			throws Exception {
		String cookie = SeatLogin.getCookie(cookieUrl, username, password);
		Connection connect = Jsoup.connect(appUrl);
		connect.cookie("ASP.NET_SessionId", cookie);
		connect.header("Accept", "*/*");
		connect.header("Accept-Encoding", "gzip, deflate");
		connect.header("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
		connect.header("Cache-Control", "no-cache");
		connect.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		connect.header("User-Agent",
				"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.79 Safari/537.36");
		Map<String, String> map = new HashMap<String, String>();
		map.put("seatId", seatId);
		connect.data(map);
		connect.method(Method.GET);
		Response response = connect.execute();
		System.out.println(response.body());
	}
}
