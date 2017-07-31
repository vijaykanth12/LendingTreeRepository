package com.lendingtree.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="lendemployes")
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 @Id

	 @Column(name = "id")
	 private String id;
	
	
	 
	 @Column(name="name")
	 private String name;
	 
	
	 @Column(name="desig")
	 private String desig;
	 
	 @Column(name="dept")
	 private String dept;
	 
	 
	 @Column(name="email")
	 private String email;
	 
	 @Column(name="username")
	 private String username;
	 
	 @Column(name="password")
	 private String password;
	 
	 
	 @Column(name="confirmpassword")
	 private String confirmpassword;
	 
	 @Column(name="mobile")
	 private String mobile;
	 
	 @Column(name="address")
	 private String address;
	 
	 @Column(name="newpassword")
	 private String newpassword;
	 @Column(name="confirmnewpassword")
	 private String confirmnewpassword;
	
	 @Column(name="type")
	 private String type;
	 public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getDesig() {
			return desig;
		}
		public void setDesig(String desig) {
			this.desig = desig;
		}
		public String getDept() {
			return dept;
		}
		public void setDept(String dept) {
			this.dept = dept;
		}
		
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getNewpassword() {
			return newpassword;
		}

		public void setNewpassword(String newpassword) {
			this.newpassword = newpassword;
		}

		public String getConfirmnewpassword() {
			return confirmnewpassword;
		}

		public void setConfirmnewpassword(String confirmnewpassword) {
			this.confirmnewpassword = confirmnewpassword;
		}

		public String getConfirmpassword() {
			return confirmpassword;
		}

		public void setConfirmpassword(String confirmpassword) {
			this.confirmpassword = confirmpassword;
		}
       
		public String getDeptid() {
			return deptid;
		}

		public void setDeptid(String deptid) {
			this.deptid = deptid;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		private String deptid;
	
	
		
	 

}
