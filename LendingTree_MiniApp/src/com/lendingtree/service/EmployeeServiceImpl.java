package com.lendingtree.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lendingtree.bean.EmployeeBean;
import com.lendingtree.dao.EmployeeDao;
import com.lendingtree.model.Dept;
import com.lendingtree.model.Employee;

//@Service("EmployeeService")
@Stateless
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	 private EmployeeDao empdao;
	
	/*
	@Override
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public void addemployee(Dept dept, Employee emp) {
		// TODO Auto-generated method stub
		empdao.addemployee(emp,dept);
	}*/


	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return empdao.getEmployees();
	}


	@Override
	public List<Employee> getEmployeeId(String id) {
		// TODO Auto-generated method stub
		return empdao.getEmployeeId(id);
	}


	@Override
	public void editEmployee(Employee emp) {
		// TODO Auto-generated method stub
		empdao.editEmployee(emp);
	}


	@Override
	public void deleteEmploye(String id) {
		// TODO Auto-generated method stub
		empdao.deleteEmploye(id);
	}


	@Override
	public List<Employee> getEmployee(EmployeeBean beans) {
		// TODO Auto-generated method stub
		return empdao.getEmployee(beans);
	}


	@Override
	public List<Employee> getEmployeeList(String uname, String pwd) {
		// TODO Auto-generated method stub
		return empdao.getEmployeeList(uname, pwd);
	}


	@Override
	public void editVerification(Employee emp) {
		// TODO Auto-generated method stub
		empdao.editVerification(emp);
	}


	@Override
	public List<Employee> getUser(String uname, String pwd) {
		// TODO Auto-generated method stub
		return empdao.getUser(uname, pwd);
	}


	@Override
	public void empchangePassword(String id, String newpassword,
			String confirmnewpwd) {
		// TODO Auto-generated method stub
		empdao.empchangePassword(id, newpassword, confirmnewpwd);
	}


	@Override
	public List<Employee> listDepts() {
		// TODO Auto-generated method stub
		return empdao.listDepts();
	}


	@Override
	public List<Employee> listUsers() {
		// TODO Auto-generated method stub
		return empdao.listUsers();
	}

/*	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public void addemployee(Employee emp, HttpServletRequest request) {
		// TODO Auto-generated method stub
		empdao.addemployee(emp,request);
	}*/


	@Override
	public void addemp(Dept dept) {
		// TODO Auto-generated method stub
		empdao.addemp(dept);
	}


	@Override
	public List<Employee> emplist() {
		// TODO Auto-generated method stub
		return empdao.emplist();
	}


	@Override
	public List<Employee> getEmpss(String un, String pwds) {
		// TODO Auto-generated method stub
		
		return empdao.getEmpss(un, pwds);
	}


	

}
