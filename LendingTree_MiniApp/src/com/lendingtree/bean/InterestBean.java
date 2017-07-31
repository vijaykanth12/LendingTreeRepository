package com.lendingtree.bean;

public class InterestBean {
	private String loantype;
	private String bname;
	public String getLoan() {
		return loantype;
	}
	public void setLoan(String loan) {
		this.loantype = loan;
	}
	public String getBank() {
		return bname;
	}
	public void setBank(String bank) {
		this.bname = bank;
	}

}
