package org.bianqi.seat.bean;

/**
 * 登录参数封装
 * @author BIANQI
 *
 */
public class LoginPageBean {
	private String scriptManager;
	private String eventtarget;
	private String eventargument;
	private String viewstates;
	private String eventvalidation;
	private String username;
	private String password;
	private String asyncpost;
	private String button1;
	public String getScriptManager() {
		return scriptManager;
	}
	public void setScriptManager(String scriptManager) {
		this.scriptManager = scriptManager;
	}
	public String getEventtarget() {
		return eventtarget;
	}
	public void setEventtarget(String eventtarget) {
		this.eventtarget = eventtarget;
	}
	public String getEventargument() {
		return eventargument;
	}
	public void setEventargument(String eventargument) {
		this.eventargument = eventargument;
	}
	public String getViewstates() {
		return viewstates;
	}
	public void setViewstates(String viewstates) {
		this.viewstates = viewstates;
	}
	public String getEventvalidation() {
		return eventvalidation;
	}
	public void setEventvalidation(String eventvalidation) {
		this.eventvalidation = eventvalidation;
	}
	public String getUsername() {
		return username;
	}
	public void argsLoginPage(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAsyncpost() {
		return asyncpost;
	}
	public void setAsyncpost(String asyncpost) {
		this.asyncpost = asyncpost;
	}
	public String getButton1() {
		return button1;
	}
	public void setButton1(String button1) {
		this.button1 = button1;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "ArgsPage [scriptManager=" + scriptManager + ", eventtarget=" + eventtarget + ", eventargument="
				+ eventargument + ", viewstates=" + viewstates + ", eventvalidation=" + eventvalidation + ", username="
				+ username + ", password=" + password + ", asyncpost=" + asyncpost + ", button1=" + button1 + "]";
	}
}
