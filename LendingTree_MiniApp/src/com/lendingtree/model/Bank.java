package com.lendingtree.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="lendbanks")

public class Bank implements Serializable{

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
	 @Column(name = "branch")
	private String branch;
	 @Column(name = "address")
	private String address;
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
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
