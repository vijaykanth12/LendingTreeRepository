package com.lendingtree.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="lenddepts")

public class Dept implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// @GeneratedValue(strategy=GenerationType.AUTO)
	 
	 @Id
	 @Column(name = "deptid")
	 private String deptid;
	
	
	 @Column(name = "dname")
	 private String dname;
	
	 public String getDeptid() {
			return deptid;
		}
		public void setDeptid(String deptid) {
			this.deptid = deptid;
		}
	 
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	
	// Relationships
	
	
   /*  @SuppressWarnings("rawtypes")
	 @OneToMany(fetch=FetchType.EAGER,targetEntity=Employee.class,cascade=CascadeType.ALL)
     @JoinColumn(name = "deptid", referencedColumnName="deptid")
	
     private Set children;
     public Set getChildren() {
 		return children;
 	}
 	public void setChildren(Set children) {
 		this.children = children;
 	}*/
	@SuppressWarnings("rawtypes")
	@OneToMany(targetEntity=Employee.class,cascade={CascadeType.ALL},fetch=FetchType.EAGER,mappedBy="deptid")
	private Set Employee = new HashSet(0);
	@SuppressWarnings("rawtypes")
	public Set getEmployee() {
		return Employee;
	}
	@SuppressWarnings("rawtypes")
	public void setEmployee(Set emp) {
		Employee = emp;
	}
}
