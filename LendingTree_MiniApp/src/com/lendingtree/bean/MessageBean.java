package com.lendingtree.bean;

public class MessageBean {
	private Integer id;
	private Integer regid;
	private String fromu;
	private String tou;
	private String subjectu;
	private String messageu;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRegid() {
		return regid;
	}
	public void setRegid(Integer regid) {
		this.regid = regid;
	}
	
	
	public String getMessageu() {
		return messageu;
	}
	public void setMessageu(String messageu) {
		this.messageu = messageu;
	}
	public String getFromu() {
		return fromu;
	}
	public void setFromu(String fromu) {
		this.fromu = fromu;
	}
	public String getTou() {
		return tou;
	}
	public void setTou(String tou) {
		this.tou = tou;
	}
	public String getSubjectu() {
		return subjectu;
	}
	public void setSubjectu(String subjectu) {
		this.subjectu = subjectu;
	}
}
