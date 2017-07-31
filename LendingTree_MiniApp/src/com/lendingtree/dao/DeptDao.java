package com.lendingtree.dao;

import java.util.List;

import com.lendingtree.model.Dept;
import com.lendingtree.model.Employee;

public interface DeptDao {

	public void adddept(Dept dept);
	public List<Dept> getDepts();
	public List<Dept> getDeptId(String id);
	public void editDept(Dept dept);
	public void deleteDept(String id);	
	
	
	public List<Dept> listDepts();	
	
	public List<Employee> getDepts(int id);
	
	public List<Dept> listDept();
	
	public List<Dept> viewdepts(String did);
	
}
