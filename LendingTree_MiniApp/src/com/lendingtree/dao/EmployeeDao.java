package com.lendingtree.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lendingtree.bean.EmployeeBean;
import com.lendingtree.model.Dept;
import com.lendingtree.model.Employee;

public interface EmployeeDao {
	
/*	public void addemployee(Employee emp,HttpServletRequest request);*/
	public List<Employee> getEmployees();
	public List<Employee> getEmployeeId(String id);
	public void editEmployee(Employee emp);
	public void deleteEmploye(String id);
	public List<Employee> getEmployee(EmployeeBean beans);
	
	public List<Employee> getEmployeeList(String uname, String pwd);
	
	
	public void editVerification(Employee emp);
	
	
	public List<Employee> getUser(String uname, String pwd);
	
	
	public void empchangePassword(String id, String newpassword,
			String confirmnewpwd);
	
	public List<Employee> listDepts();
	public List<Employee> listUsers();
	
	public void addemp(Dept dept);
	
	public List<Employee> emplist();
	
	public List<Employee> getEmpss(String un, String pwds);

}
