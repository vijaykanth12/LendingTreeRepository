package com.lendingtree.service;

import java.util.List;
import javax.ejb.Stateless;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lendingtree.dao.ApplyLoanDao;
import com.lendingtree.model.ApplyLoan;
import com.lendingtree.model.LoanApply;

//@Service("ApplyLoanService")
@Stateless

//@Component
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class ApplyLoanServiceImpl implements ApplyLoanService{

	 @Autowired
	 private ApplyLoanDao aploanDao;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public void addapplyloan(ApplyLoan loan) {
		// TODO Auto-generated method stub
		
		aploanDao.addapplyloan(loan);
	}

	@Override
	public List<LoanApply> getCustomers() {
		// TODO Auto-generated method stub
		return aploanDao.getCustomers();
	}

	@Override
	public List<LoanApply> getCustId(int id) {
		// TODO Auto-generated method stub
		return aploanDao.getCustId(id);
	}

	@Override
	public void updateapplyloan(LoanApply loan) {
		// TODO Auto-generated method stub
		aploanDao.updateapplyloan(loan);
	}

	@Override
	public List<ApplyLoan> getRegid(HttpServletRequest request, Integer ids) {
		// TODO Auto-generated method stub
		return aploanDao.getRegid(ids,request);
	}

	@Override
	public List<ApplyLoan> getList(Integer ids) {
		// TODO Auto-generated method stub
		return aploanDao.getList(ids);
	}

	@Override
	public List<ApplyLoan> getEmpName(String name,String dept) {
		// TODO Auto-generated method stub
		return aploanDao.getEmpName(name,dept);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List searchStatusType(String status) {
		// TODO Auto-generated method stub
		return aploanDao.searchStatusType(status);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public void applypersonalloan(LoanApply loan) {
		// TODO Auto-generated method stub
		aploanDao.applypersonalloan(loan);
	}

	@Override
	public List<LoanApply> getPersonalloan() {
		// TODO Auto-generated method stub
		return aploanDao.getPersonalloan();
	}

	public List<LoanApply> getLoanCustomers() {
		// TODO Auto-generated method stub
		return aploanDao.getLoanCustomers();
	}

	@Override
	public List searchDate(String da1, String da2) {
		// TODO Auto-generated method stub
		return aploanDao.searchDate(da1, da2);
	}

	@Override
	public List<LoanApply> sanctiondates(String start, String end) {
		// TODO Auto-generated method stub
		return aploanDao.sanctiondates(start, end);
	}

	@Override
	public void addDocs(LoanApply pm) {
		// TODO Auto-generated method stub
	    aploanDao.addDocs(pm);
	}

	@Override
	public void addexcel(LoanApply loan) {
		// TODO Auto-generated method stub
		aploanDao.addexcel(loan);
	}

	
	



	
	


}
