package com.lendingtree.service;

import java.util.List;




import javax.ejb.Local;

import com.lendingtree.model.Dept;
import com.lendingtree.model.Employee;
@Local
public interface DeptService {

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
