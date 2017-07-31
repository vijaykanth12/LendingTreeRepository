package com.lendingtree.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="applyloan")
public class ApplyLoan implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name = "id")
	 private Integer id;
	
	 @Column(name="regid")
	 private Integer regid;
	 
	 @Column(name="firstname")
	 private String firstname;
	
	 @Column(name="lastname")
	 private String lastname;
	 
	 @Column(name="emailid")
	 private String emailid;
	 
	 @Column(name="mobile")
	 private String mobile;
	 
	 @Column(name="gender")
	 private String gender;
	 
	 @Column(name="dateofbirth")
	 private String dateofbirth;
	 
	 @Column(name="pan")
	 private String pan;
	 
	 @Column(name="qualification")
	 private String qualification;

	 @Column(name="occupation")
	 private String occupation;
	 
	 @Column(name="company")
	 private String company;
	 
	 @Column(name="workmail")
	 private String workmail;
	 
	 @Column(name="ofccontact")
	 private String ofccontact;
	 
	 @Column(name="ofcaddress")
	 private String ofcaddress;
	 
	 
	 @Column(name="salary")
	 private String salary;
	 
	
	 
	 @Column(name="loantype")
	 private String loantype;
	 
	 @Column(name="banktype")
	 private String banktype;
	 
	 
	 
	 @Column(name="amount")
	 private Integer amount;
	 
	 
	 @Column(name="Interest")
	 private String interest;
	 
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

	 @Column(name="statustype")
	 private String statustype;
	 
	 @Column(name="assignto")
	 private String assignto;
	 
	 @Column(name="payslips")
	 private String payslips;
	 
	 @Column(name="offerletter")
	 private String offerletter;
	 
	 @Column(name="companydetails")
	 private String companydetails;
	 
	 @Column(name="addressproof")
	 private String addressproof;
	 
	 @Column(name="photoidentity")
	 private String photoidentity;
	 
	 @Column(name="itreturns")
	 private String itreturns;

	 @Column(name="pancard")
	 private String pancard;
	 
	 @Column(name="personalenquiry")
	 private String personalenquiry;
	 
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

		
		public String getFirstname() {
			return firstname;
		}


		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}


		public String getLastname() {
			return lastname;
		}


		public void setLastname(String lastname) {
			this.lastname = lastname;
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


		public String getPan() {
			return pan;
		}


		public void setPan(String pan) {
			this.pan = pan;
		}


		public String getQualification() {
			return qualification;
		}


		public void setQualification(String qualification) {
			this.qualification = qualification;
		}


		public String getOccupation() {
			return occupation;
		}


		public void setOccupation(String occupation) {
			this.occupation = occupation;
		}


		public String getCompany() {
			return company;
		}


		public void setCompany(String company) {
			this.company = company;
		}


		public String getWorkmail() {
			return workmail;
		}


		public void setWorkmail(String workmail) {
			this.workmail = workmail;
		}


		public String getOfccontact() {
			return ofccontact;
		}


		public void setOfccontact(String ofccontact) {
			this.ofccontact = ofccontact;
		}


		public String getOfcaddress() {
			return ofcaddress;
		}


		public void setOfcaddress(String ofcaddress) {
			this.ofcaddress = ofcaddress;
		}


		public String getSalary() {
			return salary;
		}


		public void setSalary(String salary) {
			this.salary = salary;
		}


		public String getLoantype() {
			return loantype;
		}


		public void setLoantype(String loantype) {
			this.loantype = loantype;
		}


		public String getBanktype() {
			return banktype;
		}


		public void setBanktype(String banktype) {
			this.banktype = banktype;
		}

		public Integer getAmount() {
			return amount;
		}


		public void setAmount(Integer amount) {
			this.amount = amount;
		}


		public String getInterest() {
			return interest;
		}


		public void setInterest(String interest) {
			this.interest = interest;
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


		public String getStatustype() {
			return statustype;
		}


		public void setStatustype(String statustype) {
			this.statustype = statustype;
		}


		public String getAssignto() {
			return assignto;
		}


		public void setAssignto(String assignto) {
			this.assignto = assignto;
		}
		 
		public String getPayslips() {
			return payslips;
		}


		public void setPayslips(String payslips) {
			this.payslips = payslips;
		}


		public String getOfferletter() {
			return offerletter;
		}


		public void setOfferletter(String offerletter) {
			this.offerletter = offerletter;
		}


		public String getCompanydetails() {
			return companydetails;
		}


		public void setCompanydetails(String companydetails) {
			this.companydetails = companydetails;
		}


		public String getAddressproof() {
			return addressproof;
		}


		public void setAddressproof(String addressproof) {
			this.addressproof = addressproof;
		}


		public String getPhotoidentity() {
			return photoidentity;
		}


		public void setPhotoidentity(String photoidentity) {
			this.photoidentity = photoidentity;
		}


		public String getItreturns() {
			return itreturns;
		}


		public void setItreturns(String itreturns) {
			this.itreturns = itreturns;
		}


		public String getPancard() {
			return pancard;
		}


		public void setPancard(String pancard) {
			this.pancard = pancard;
		}


		public String getPersonalenquiry() {
			return personalenquiry;
		}


		public void setPersonalenquiry(String personalenquiry) {
			this.personalenquiry = personalenquiry;
		}
		 

		
}
