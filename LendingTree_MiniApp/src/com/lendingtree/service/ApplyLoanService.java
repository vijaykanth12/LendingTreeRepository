package com.lendingtree.service;


import java.util.List;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;




import com.lendingtree.model.ApplyLoan;
import com.lendingtree.model.LoanApply;

@Local
public interface ApplyLoanService {
	
	public void addapplyloan(ApplyLoan loan);
	public void updateapplyloan(LoanApply loan);
	public List<LoanApply> getCustomers();
	public List<LoanApply> getCustId(int id);
	public List<ApplyLoan> getRegid(HttpServletRequest request, Integer ids);
	
	
	public List<ApplyLoan> getList(Integer ids);
	
	public List<ApplyLoan> getEmpName(String name,String dept);
	@SuppressWarnings("rawtypes")
	public List searchStatusType(String status);
	
	public void applypersonalloan(LoanApply loan);
	public List<LoanApply> getPersonalloan();
	public List<LoanApply> getLoanCustomers();
	
	public List searchDate(String da1, String da2);
	
	public List<LoanApply> sanctiondates(String start, String end);
	
	public void addDocs(LoanApply pm);
	
	public void addexcel(LoanApply loan);
	
	
	
	
	
	
	
	
	
	
	
	


	

}
