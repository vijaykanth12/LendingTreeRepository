package com.lendingtree.bean;

public class LoanBean {

	private Integer id;
	private String bname;
	private String loantype;
	private String interest;
	 public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getLoantype() {
		return loantype;
	}
	public void setLoantype(String loantype) {
		this.loantype = loantype;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
}
