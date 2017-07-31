package com.lendingtree.bean;

import com.lendingtree.model.Userlist;

public class UserRoleBean {
	
	private String userroleid;
	private String role;
	private Userlist usersListModel;
	
	
	public String getUserroleid() {
		return userroleid;
	}
	public void setUserroleid(String userroleid) {
		this.userroleid = userroleid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Userlist getUsersListModel() {
		return usersListModel;
	}
	public void setUsersListModel(Userlist usersListModel) {
		this.usersListModel = usersListModel;
	}
	

}
