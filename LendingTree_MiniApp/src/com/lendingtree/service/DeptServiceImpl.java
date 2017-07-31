package com.lendingtree.service;

import java.util.List;

import javax.ejb.Stateless;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lendingtree.dao.DeptDao;
import com.lendingtree.model.Dept;
import com.lendingtree.model.Employee;

//@Service("DeptService")
@Stateless
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class DeptServiceImpl implements DeptService{

	@Autowired
	 private DeptDao ddao;

	@Override
	public void adddept(Dept dept) {
		// TODO Auto-generated method stub
		ddao.adddept(dept);
	}

	@Override
	public List<Dept> getDepts() {
		// TODO Auto-generated method stub
		return ddao.getDepts();
	}

	@Override
	public List<Dept> getDeptId(String id) {
		// TODO Auto-generated method stub
		return ddao.getDeptId(id);
	}

	@Override
	public void editDept(Dept dept) {
		// TODO Auto-generated method stub
		ddao.editDept(dept);
	}

	@Override
	public void deleteDept(String id) {
		// TODO Auto-generated method stub
		ddao.deleteDept(id);
	}

	@Override
	public List<Dept> listDepts() {
		// TODO Auto-generated method stub
		return ddao.listDepts();
	}

	@Override
	public List<Employee> getDepts(int id) {
		// TODO Auto-generated method stub
		
		return ddao.getDepts(id);
	}

	@Override
	public List<Dept> listDept() {
		// TODO Auto-generated method stub
		return ddao.listDept();
	}

	@Override
	public List<Dept> viewdepts(String did) {
		// TODO Auto-generated method stub
		return ddao.viewdepts(did);
	}

	
	

	
}
