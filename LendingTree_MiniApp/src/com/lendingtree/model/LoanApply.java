package com.lendingtree.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="applyloans")
public class LoanApply implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name = "id")
	 private Integer id;
	 @Column(name = "regid")
	 private Integer regid;
	 @Column(name = "firstname")	
	 private String firstname;
	 @Column(name = "middlename")
	 private String middlename;
	 @Column(name = "lastname")	
	 private String lastname;
	 @Column(name = "email")	
	 private String email;
	 @Column(name = "fsname")	
	 private String fsname;
	 @Column(name = "aadhaarno")	
	 private String aadhaarno;
	 @Column(name = "passportno")	
	 private String passportno;
	 @Column(name = "mobile")	
	 private String mobile;
	 @Column(name = "gender")	
	 private String gender;
	 @Column(name = "dateofbirth")	
	 private String dateofbirth;
	 @Column(name = "maritalstatus")	
	 private String maritalstatus;
	 @Column(name = "pan")	
	 private String pan;
	 @Column(name = "educationqualification")	
	 private String educationqualification;
	 @Column(name = "country")	
	 private String country;
	 @Column(name = "state")	
	 private String state;
	 @Column(name = "city")	
	 private String city;
	 @Column(name = "pincode")	
	 private String pincode;
	 @Column(name = "address")	
	 private String address;
		
	 @Column(name = "designation")	
	 private String designation;        //personal loan , Salaried 
	 @Column(name = "company")	
	 private String company;
	 @Column(name = "workemail")	
	 private String workemail;
	 @Column(name = "ofccontact")	
	 private String ofccontact;
	 @Column(name = "ofcaddress")	
	 private String ofcaddress;
	 @Column(name = "salary")	
	 private String salary;

	 @Column(name = "firm")
	 private String firm; 
	 @Column(name = "profession")
	 private String profession;         // Self employee
	 @Column(name = "natureofbusiness")	
	 private String natureofbusiness;
	 @Column(name = "noofexp")	
	 private String noofexp;
	 @Column(name = "income")	
	 private String income;
		
		
		
	@Column(name = "loanamount")	
	private String loanamount;       // Loan Details
	@Column(name = "purpose")	
	private String purpose;
	@Column(name = "banktype")	
	private String banktype;
	@Column(name = "loantype")	
	private String loantype;
	@Column(name = "interestrate")	
	private String interestrate;
	
	@Column(name = "tenture")	
	private String tenture;
	
	

	
	@Column(name = "status")	
	private String status;
	
	@Column(name = "assignedto")	
	private String assignedto;
	
	@Column(name = "occupation")	
	private String occupation;
	
	@Column(name = "admissionstatus")							// Education Loan
	private String admissionstatus; 
	@Column(name = "university")										
	private String university;
	@Column(name = "namecourse")
	private String namecourse;
	@Column(name = "courseduration")
	private String courseduration;
	@Column(name = "coursetype")
	private String coursetype;
	@Column(name = "collegecountry")
	private String collegecountry;
	@Column(name = "collegestate")
	private String collegestate;
	@Column(name = "collegecity")
	private String collegecity;
	@Column(name = "collegepin")
	private String collegepin;
	
	
	@Column(name = "collegeaddress")
	private String collegeaddress;
	
	@Column(name = "buildername")            // BusinessLoan
	private String buildername;
	@Column(name = "buildingname")									
	private String buildingname;
	@Column(name = "builtuparea")
	private String builtuparea;
	@Column(name = "sellername")
	private String sellername;
	@Column(name = "sellercontactno")
	private String sellercontactno;
	@Column(name = "selleraddress")
	private String selleraddress;
	@Column(name = "propertycost")
	private String propertycost;
	@Column(name = "loanpurpose")
	private String loanpurpose;
	
	@Column(name = "legalstatus")
	private String legalstatus;                     // BusinessLoan
	@Column(name = "yearofincorp")
	private String yearofincorp;
	@Column(name = "rocregno")
	private String rocregno;
	@Column(name = "regofcaddress")
	private String regofcaddress;
	@Column(name = "ownership")
	private String ownership;
	@Column(name = "noofbranches")
	private String noofbranches;
	@Column(name = "nameofcities")
	private String nameofcities;
	@Column(name = "noofownedbranches")
	private String noofownedbranches;
	@Column(name = "noofrentedbranches")
	private String noofrentedbranches;
	@Column(name = "noofemployees")
	private String noofemployees;
	@Column(name = "taxpaid")
	private String taxpaid;
	@Column(name = "landline")
	private String landline;
	@Column(name = "fax")
	private String fax;
	@Column(name = "directorname")
	
	private String directorname;
	@Column(name = "directordob")
	private String directordob;
	@Column(name = "educationalbackground")
	private String educationalbackground;
	@Column(name = "experience")
	private String experience;
	@Column(name = "directorcontactno")
	private String directorcontactno;

	//Require Documents for personal Loan 
	@Column(name = "proofofidentity")
	private String proofofidentity;
	@Column(name = "pandocument")
	private String pandocument;
	@Column(name = "bankstatement")
	private String bankstatement;
	@Column(name = "payslips")
	private String payslips;
	@Column(name = "itreturns")
	private String itreturns;
	@Column(name = "addressprooff")
	private String addressprooff;
	@Column(name = "personalInquiry")
	private String personalInquiry;
	
	// Required Documents for educational loan
		@Column(name = "marksheet")
		private String marksheet;
		@Column(name = "admisssionproof")
		private String admisssionproof;
		@Column(name = "rankcopy")
		private String rankcopy;
		@Column(name = "scholarshipcopy")
		private String scholarshipcopy;
		
		// Required Documents for Home loan
		@Column(name = "residenceproof")
		private String residenceproof;
		@Column(name = "propertytax")
		private String propertytax;
		@Column(name = "businessaddress")
		private String businessaddress;
		
		
		// Required Documents for Business loan
		@Column(name = "auditedfinance")
		private String auditedfinance;
		@Column(name = "comaddressproof")
		private String comaddressproof;
		@Column(name = "comprofile")
		private String comprofile;
		@Column(name = "productprofile")
		private String productprofile;
		
		
		
		//Dates 
		
		@Column(name = "loanapplydate")
		private String loanapplydate;
		
		@Column(name = "loanacceptdate")
		private String loanacceptdate;
		
		// File uploads
		
		@Column(name = "fileToUpload")
		private String file;
		
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
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
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
		public String getMaritalstatus() {
			return maritalstatus;
		}
		public void setMaritalstatus(String maritalstatus) {
			this.maritalstatus = maritalstatus;
		}
		public String getPan() {
			return pan;
		}
		public void setPan(String pan) {
			this.pan = pan;
		}
		public String getEducationqualification() {
			return educationqualification;
		}
		public void setEducationqualification(String educationqualification) {
			this.educationqualification = educationqualification;
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
		public String getDesignation() {
			return designation;
		}
		public void setDesignation(String designation) {
			this.designation = designation;
		}
		public String getCompany() {
			return company;
		}
		public void setCompany(String company) {
			this.company = company;
		}
		public String getWorkemail() {
			return workemail;
		}
		public void setWorkemail(String workemail) {
			this.workemail = workemail;
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
		public String getLoanamount() {
			return loanamount;
		}
		public void setLoanamount(String loanamount) {
			this.loanamount = loanamount;
		}
		public String getPurpose() {
			return purpose;
		}
		public void setPurpose(String purpose) {
			this.purpose = purpose;
		}
		public String getBanktype() {
			return banktype;
		}
		public void setBanktype(String banktype) {
			this.banktype = banktype;
		}
		public String getInterestrate() {
			return interestrate;
		}
		public void setInterestrate(String interestrate) {
			this.interestrate = interestrate;
		}
		public String getProfession() {
			return profession;
		}
		public void setProfession(String profession) {
			this.profession = profession;
		}
		public String getNatureofbusiness() {
			return natureofbusiness;
		}
		public void setNatureofbusiness(String natureofbusiness) {
			this.natureofbusiness = natureofbusiness;
		}
		public String getNoofexp() {
			return noofexp;
		}
		public void setNoofexp(String noofexp) {
			this.noofexp = noofexp;
		}
		public String getIncome() {
			return income;
		}
		public void setIncome(String income) {
			this.income = income;
		}
		public String getLoantype() {
			return loantype;
		}
		public void setLoantype(String loantype) {
			this.loantype = loantype;
		}
		public String getFirm() {
			return firm;
		}
		public void setFirm(String firm) {
			this.firm = firm;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getAssignedto() {
			return assignedto;
		}
		public void setAssignedto(String assignedto) {
			this.assignedto = assignedto;
		}
		public String getOccupation() {
			return occupation;
		}
		public void setOccupation(String occupation) {
			this.occupation = occupation;
		}
		public String getFsname() {
			return fsname;
		}
		public void setFsname(String fsname) {
			this.fsname = fsname;
		}
		public String getAadhaarno() {
			return aadhaarno;
		}
		public void setAadhaarno(String aadhaarno) {
			this.aadhaarno = aadhaarno;
		}
		public String getPassportno() {
			return passportno;
		}
		public void setPassportno(String passportno) {
			this.passportno = passportno;
		}
		public String getAdmissionstatus() {
			return admissionstatus;
		}
		public void setAdmissionstatus(String admissionstatus) {
			this.admissionstatus = admissionstatus;
		}
		public String getUniversity() {
			return university;
		}
		public void setUniversity(String university) {
			this.university = university;
		}
		public String getNamecourse() {
			return namecourse;
		}
		public void setNamecourse(String namecourse) {
			this.namecourse = namecourse;
		}
		public String getCourseduration() {
			return courseduration;
		}
		public void setCourseduration(String courseduration) {
			this.courseduration = courseduration;
		}
		public String getCoursetype() {
			return coursetype;
		}
		public void setCoursetype(String coursetype) {
			this.coursetype = coursetype;
		}
		public String getCollegeaddress() {
			return collegeaddress;
		}
		public void setCollegeaddress(String collegeaddress) {
			this.collegeaddress = collegeaddress;
		}
		public String getBuildername() {
			return buildername;
		}
		public void setBuildername(String buildername) {
			this.buildername = buildername;
		}
		public String getBuildingname() {
			return buildingname;
		}
		public void setBuildingname(String buildingname) {
			this.buildingname = buildingname;
		}
		public String getBuiltuparea() {
			return builtuparea;
		}
		public void setBuiltuparea(String builtuparea) {
			this.builtuparea = builtuparea;
		}
		public String getSellername() {
			return sellername;
		}
		public void setSellername(String sellername) {
			this.sellername = sellername;
		}
		public String getSellercontactno() {
			return sellercontactno;
		}
		public void setSellercontactno(String sellercontactno) {
			this.sellercontactno = sellercontactno;
		}
		public String getSelleraddress() {
			return selleraddress;
		}
		public void setSelleraddress(String selleraddress) {
			this.selleraddress = selleraddress;
		}
		public String getPropertycost() {
			return propertycost;
		}
		public void setPropertycost(String propertycost) {
			this.propertycost = propertycost;
		}
		public String getLoanpurpose() {
			return loanpurpose;
		}
		public void setLoanpurpose(String loanpurpose) {
			this.loanpurpose = loanpurpose;
		}
		public String getLegalstatus() {
			return legalstatus;
		}
		public void setLegalstatus(String legalstatus) {
			this.legalstatus = legalstatus;
		}
		public String getYearofincorp() {
			return yearofincorp;
		}
		public void setYearofincorp(String yearofincorp) {
			this.yearofincorp = yearofincorp;
		}
		public String getRocregno() {
			return rocregno;
		}
		public void setRocregno(String rocregno) {
			this.rocregno = rocregno;
		}
		public String getRegofcaddress() {
			return regofcaddress;
		}
		public void setRegofcaddress(String regofcaddress) {
			this.regofcaddress = regofcaddress;
		}
		public String getOwnership() {
			return ownership;
		}
		public void setOwnership(String ownership) {
			this.ownership = ownership;
		}
		public String getNoofbranches() {
			return noofbranches;
		}
		public void setNoofbranches(String noofbranches) {
			this.noofbranches = noofbranches;
		}
		public String getNameofcities() {
			return nameofcities;
		}
		public void setNameofcities(String nameofcities) {
			this.nameofcities = nameofcities;
		}
		public String getNoofownedbranches() {
			return noofownedbranches;
		}
		public void setNoofownedbranches(String noofownedbranches) {
			this.noofownedbranches = noofownedbranches;
		}
		public String getNoofrentedbranches() {
			return noofrentedbranches;
		}
		public void setNoofrentedbranches(String noofrentedbranches) {
			this.noofrentedbranches = noofrentedbranches;
		}
		public String getNoofemployees() {
			return noofemployees;
		}
		public void setNoofemployees(String noofemployees) {
			this.noofemployees = noofemployees;
		}
		public String getTaxpaid() {
			return taxpaid;
		}
		public void setTaxpaid(String taxpaid) {
			this.taxpaid = taxpaid;
		}
		public String getLandline() {
			return landline;
		}
		public void setLandline(String landline) {
			this.landline = landline;
		}
		public String getFax() {
			return fax;
		}
		public void setFax(String fax) {
			this.fax = fax;
		}
		public String getDirectorname() {
			return directorname;
		}
		public void setDirectorname(String directorname) {
			this.directorname = directorname;
		}
		public String getDirectordob() {
			return directordob;
		}
		public void setDirectordob(String directordob) {
			this.directordob = directordob;
		}
		public String getEducationalbackground() {
			return educationalbackground;
		}
		public void setEducationalbackground(String educationalbackground) {
			this.educationalbackground = educationalbackground;
		}
		public String getExperience() {
			return experience;
		}
		public void setExperience(String experience) {
			this.experience = experience;
		}
		public String getDirectorcontactno() {
			return directorcontactno;
		}
		public void setDirectorcontactno(String directorcontactno) {
			this.directorcontactno = directorcontactno;
		}
		public String getCollegecountry() {
			return collegecountry;
		}
		public void setCollegecountry(String collegecountry) {
			this.collegecountry = collegecountry;
		}
		public String getCollegestate() {
			return collegestate;
		}
		public void setCollegestate(String collegestate) {
			this.collegestate = collegestate;
		}
		public String getCollegecity() {
			return collegecity;
		}
		public void setCollegecity(String collegecity) {
			this.collegecity = collegecity;
		}
		public String getCollegepin() {
			return collegepin;
		}
		public void setCollegepin(String collegepin) {
			this.collegepin = collegepin;
		}
		public String getProofofidentity() {
			return proofofidentity;
		}
		public void setProofofidentity(String proofofidentity) {
			this.proofofidentity = proofofidentity;
		}
		public String getPandocument() {
			return pandocument;
		}
		public void setPandocument(String pandocument) {
			this.pandocument = pandocument;
		}
		public String getBankstatement() {
			return bankstatement;
		}
		public void setBankstatement(String bankstatement) {
			this.bankstatement = bankstatement;
		}
		public String getPayslips() {
			return payslips;
		}
		public void setPayslips(String payslips) {
			this.payslips = payslips;
		}
		public String getItreturns() {
			return itreturns;
		}
		public void setItreturns(String itreturns) {
			this.itreturns = itreturns;
		}
		public String getAddressprooff() {
			return addressprooff;
		}
		public void setAddressprooff(String addressprooff) {
			this.addressprooff = addressprooff;
		}
		public String getPersonalInquiry() {
			return personalInquiry;
		}
		public void setPersonalInquiry(String personalInquiry) {
			this.personalInquiry = personalInquiry;
		}
		public String getMarksheet() {
			return marksheet;
		}
		public void setMarksheet(String marksheet) {
			this.marksheet = marksheet;
		}
		public String getAdmisssionproof() {
			return admisssionproof;
		}
		public void setAdmisssionproof(String admisssionproof) {
			this.admisssionproof = admisssionproof;
		}
		public String getRankcopy() {
			return rankcopy;
		}
		public void setRankcopy(String rankcopy) {
			this.rankcopy = rankcopy;
		}
		public String getScholarshipcopy() {
			return scholarshipcopy;
		}
		public void setScholarshipcopy(String scholarshipcopy) {
			this.scholarshipcopy = scholarshipcopy;
		}
		public String getResidenceproof() {
			return residenceproof;
		}
		public void setResidenceproof(String residenceproof) {
			this.residenceproof = residenceproof;
		}
		public String getPropertytax() {
			return propertytax;
		}
		public void setPropertytax(String propertytax) {
			this.propertytax = propertytax;
		}
		public String getBusinessaddress() {
			return businessaddress;
		}
		public void setBusinessaddress(String businessaddress) {
			this.businessaddress = businessaddress;
		}
		public String getAuditedfinance() {
			return auditedfinance;
		}
		public void setAuditedfinance(String auditedfinance) {
			this.auditedfinance = auditedfinance;
		}
		public String getComaddressproof() {
			return comaddressproof;
		}
		public void setComaddressproof(String comaddressproof) {
			this.comaddressproof = comaddressproof;
		}
		public String getComprofile() {
			return comprofile;
		}
		public void setComprofile(String comprofile) {
			this.comprofile = comprofile;
		}
		public String getProductprofile() {
			return productprofile;
		}
		public void setProductprofile(String productprofile) {
			this.productprofile = productprofile;
		}
		public String getTenture() {
			return tenture;
		}
		public void setTenture(String tenture) {
			this.tenture = tenture;
		}
	
		public String getLoanapplydate() {
			return loanapplydate;
		}
		public void setLoanapplydate(String loanapplydate) {
			this.loanapplydate = loanapplydate;
		}
		public String getLoanacceptdate() {
			return loanacceptdate;
		}
		public void setLoanacceptdate(String loanacceptdate) {
			this.loanacceptdate = loanacceptdate;
		}
		public String getFile() {
			return file;
		}
		public void setFile(String file) {
			this.file = file;
		}
	
	
	
	

}
