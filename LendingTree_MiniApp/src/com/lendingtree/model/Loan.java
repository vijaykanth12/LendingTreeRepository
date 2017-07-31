package com.lendingtree.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lendloans")
public class Loan implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name = "id")
	 private Integer id;
	 @Column(name = "bname")
	private String bname;
	 @Column(name = "loantype")
	private String loantype;
	 @Column(name = "interest")
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
