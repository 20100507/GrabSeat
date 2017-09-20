package org.bianqi.seat.center;

import org.bianqi.seat.login.SeatLogin;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;

/**
 *个人中心查看 是否预约
 */
public class PersonCenter {
	
	public static void main(String[] args) throws Exception {
		enterCenter("http://172.16.47.84/InfoSearch.aspx","http://172.16.47.84/", "2014023002", "123456");
	}
	
	public static String enterCenter(String appUrl,String cookieUrl, String username, String password) throws Exception {
		String cookie = SeatLogin.getCookie(cookieUrl, username, password);
		Connection connect = Jsoup.connect(appUrl);
		connect.cookie("ASP.NET_SessionId", cookie);
		connect.header("Accept", "*/*");
		connect.header("Accept-Encoding", "gzip, deflate");
		connect.header("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
		connect.header("Cache-Control", "no-cache");
		connect.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		connect.header("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.79 Safari/537.36");
		Response response = connect.execute();
		System.out.println(response.body());
		return null;
	}
}
