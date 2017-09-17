package org.bianqi.seat.bean;

public class CookieBean {
	private String cookie;

	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	@Override
	public String toString() {
		return "CookieBean [cookie=" + cookie + "]";
	}

	public CookieBean() {
		super();
	}

	public CookieBean(String cookie) {
		super();
		this.cookie = cookie;
	}
	
}
