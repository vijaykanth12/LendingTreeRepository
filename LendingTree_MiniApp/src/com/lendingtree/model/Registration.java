package com.lendingtree.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="regusers")
public class Registration  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name = "id")
	 private Integer id;
	 
	 @Column(name="firstname")
	 private String firstname;
	 
	 @Column(name="middlename")
	 private String middlename;
	 
	 @Column(name="lastname")
	 private String lastname;
	 
	 @Column(name="username")
	 private String username;
	 
	 @Column(name="password")
	 private String password;
	 
	 @Column(name="conformpassword")
	 private String conformpassword;
	 
	 @Column(name="emailid")
	 private String emailid;
	 
	 @Column(name="mobile")
	 private String mobile;
	 
	 @Column(name="gender")
	 private String gender;
	 
	 
	 @Column(name="dateofbirth")
	 private String dateofbirth;
	 
	 @Column(name="languagesknown")
	 private String languagesknown;
	 
	 @Column(name="country")
	 private String country;

	 @Column(name="state")
	 private String state;
	 
	 @Column(name="city")
	 private String city;
	 
	 @Column(name="pincode")
	 private String pincode;
	 
	 @Column(name="address")
	 private String address;

	 @Column(name="type")
	 private String type;
	 
	 @Column(name="newpassword")
	 private String newpassword;
	 @Column(name="confirmnewpassword")
	 private String confirmnewpassword;

	 @Column(name="status")
	 private Integer status;
	 
	 @Column(name="captcha")
	 private String captcha;
	 
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}
	 public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getMiddlename() {
			return middlename;
		}
		public void setMiddlename(String middlename) {
			this.middlename = middlename;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
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
		public String getConformpassword() {
			return conformpassword;
		}
		public void setConformpassword(String conformpassword) {
			this.conformpassword = conformpassword;
		}
		public String getEmailid() {
			return emailid;
		}
		public void setEmailid(String emailid) {
			this.emailid = emailid;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getDateofbirth() {
			return dateofbirth;
		}
		public void setDateofbirth(String dateofbirth) {
			this.dateofbirth = dateofbirth;
		}
		public String getLanguagesknown() {
			return languagesknown;
		}
		public void setLanguagesknown(String languagesknown) {
			this.languagesknown = languagesknown;
		}

		
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
				public String getPincode() {
			return pincode;
		}
		public void setPincode(String pincode) {
			this.pincode = pincode;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
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

		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}

		public String getCaptcha() {
			return captcha;
		}

		public void setCaptcha(String captcha) {
			this.captcha = captcha;
		}

}
