package org.bianqi.seat.navigation;


import org.bianqi.seat.login.SeatLogin;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

public class DayNavigation {

	public static void main(String[] args) throws Exception {
		getPageDayNavigation("http://172.16.47.84/DayNavigation.aspx","http://172.16.47.84", "", "");
	}
	
	public static String getPageDayNavigation(String mainUrl,String cookieUrl, String username, String password) throws Exception {
		String cookie = SeatLogin.getCookie(cookieUrl, username, password);
		Connection connect = Jsoup.connect(mainUrl);
		connect.cookie("ASP.NET_SessionId", cookie);
		connect.header("Accept", "*/*");
		connect.header("Accept-Encoding", "gzip, deflate");
		connect.header("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
		connect.header("Cache-Control", "no-cache");
		connect.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		connect.header("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.79 Safari/537.36");
		Response response = connect.execute();
		System.out.println(response.body());
		return "";
	}
}
