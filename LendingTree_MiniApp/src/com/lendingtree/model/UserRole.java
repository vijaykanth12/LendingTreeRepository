package com.lendingtree.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="usersroles")

public class UserRole {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userroleid")
	private String userroleid;
	
	
	@Column(name="role",nullable=false,length=45)
	private String role;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="username",nullable=false)
    private Userslist usersListModel;

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

	public Userslist getUsersListModel() {
		return usersListModel;
	}

	public void setUsersListModel(Userslist usersListModel) {
		this.usersListModel = usersListModel;
	}

}
