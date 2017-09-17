package org.bianqi.seat.login;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.bianqi.seat.bean.LoginPageBean;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;

/**
 * 拿到登录的cookie
 * @author BIANQI
 */
public class SeatLogin {
	
	/***
	 * 得到cookie
	 * @param url
	 * @return
	 * @throws Exception 
	 */
	 public static String getCookie(String url,String username,String password) throws Exception {
		 Connection connect = Jsoup.connect(url);
		 Response execute = connect.execute();
		 Document parse = execute.parse();
		 Node node = parse.childNodes().get(1);
		 Node node2 = node.childNodes().get(2);
		 Node node3 = node2.childNodes().get(1);
		 Node arg1 = node3.childNodes().get(1);
		 String attr = arg1.attr("value");
		 Node arg3 = node3.childNodes().get(5);
		 String attr3 = arg3.attr("value");
		 Map<String, String> loginPage = loginPage(url, attr, attr3, username, password);
		 Set<String> keySet = loginPage.keySet();
		 for (String string : keySet) {
			 if(string.equals("ASP.NET_SessionId")){
				 return loginPage.get(string);
			 }
		}
		 return "";
	 }
	 
	public static Map<String, String> loginPage(String url,String viewsStates,String eventValidation,
			String username,String password) throws Exception{
		 LoginPageBean argsLoginPage = new LoginPageBean();

		 argsLoginPage.setScriptManager("UpdatePanel1|Button1");
		 argsLoginPage.setEventtarget("");
		 argsLoginPage.setEventargument("");
		 argsLoginPage.setEventvalidation(eventValidation);
		 argsLoginPage.setViewstates(viewsStates);
		 argsLoginPage.setUsername(username);
		 argsLoginPage.setPassword(password);
		 argsLoginPage.setButton1("登      录");
		 argsLoginPage.setAsyncpost("true");
		 
		 Connection connect = Jsoup.connect(url);
		 HashMap<String,String> data = new HashMap<>();
		 data.put("ScriptManager1",argsLoginPage.getScriptManager());
		 data.put("__EVENTTARGET",argsLoginPage.getEventtarget());
		 data.put("__EVENTARGUMENT",argsLoginPage.getEventargument());
		 data.put("__VIEWSTATE", argsLoginPage.getViewstates());
		 data.put("__EVENTVALIDATION",argsLoginPage.getEventvalidation());
		 data.put("TextBox1",argsLoginPage.getUsername());
		 data.put("TextBox2",argsLoginPage.getPassword());
		 data.put("__ASYNCPOST", argsLoginPage.getAsyncpost());
		 data.put("Button1",argsLoginPage.getButton1());
		 connect.data(data).method(Method.POST);
		 connect.header("Accept", "*/*");
		 connect.header("Accept-Encoding", "gzip, deflate");
		 connect.header("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
		 connect.header("Cache-Control", "no-cache");
		 connect.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		 connect.header("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.79 Safari/537.36");
		 connect.header("X-MicrosoftAjax", "Delta=true");
		 connect.header("X-Requested-With", "XMLHttpRequest");
		 Response execute = connect.execute();
		 Map<String, String> cookies = execute.cookies();
		 return cookies;
	}
}
