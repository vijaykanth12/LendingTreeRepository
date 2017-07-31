package com.lendingtree.bean;

import java.io.Serializable;

public class ApplicationLogBean implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String applicationlogid;
	private String  ip;
	private String hostname;
    private String userame;
    private String logindate;
    private String openPage;
    private String logouttime;
    private String type;
	
    public String getApplicationlogid() {
		return applicationlogid;
	}
	public void setApplicationlogid(String applicationlogid) {
		this.applicationlogid = applicationlogid;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getUserame() {
		return userame;
	}
	public void setUserame(String userame) {
		this.userame = userame;
	}
	public String getLogindate() {
		return logindate;
	}
	public void setLogindate(String logindate) {
		this.logindate = logindate;
	}
	public String getOpenPage() {
		return openPage;
	}
	public void setOpenPage(String openPage) {
		this.openPage = openPage;
	}
	public String getLogouttime() {
		return logouttime;
	}
	public void setLogouttime(String logouttime) {
		this.logouttime = logouttime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
