package com.lendingtree.dao;

import java.util.List;

import com.lendingtree.bean.LoanBean;
import com.lendingtree.bean.RegistrationBean;
import com.lendingtree.model.Loan;
import com.lendingtree.model.Registration;

@SuppressWarnings("unused")
public interface LoanDao {

	public void addloan(Loan loan);
	public List<Loan> getLoans();
	public List<Loan> getLoanId(int id);
	public void editLoan(Loan loan);
	public void deleteLoan(String id);
	public List<Loan> getLoanss(LoanBean bean);
	
	public List<Loan> listLoanTypes();
	public List<Loan> getLoan(String loantype, String bname);
	
	public List<Loan> listBankType(String loantype);
	
	public List<Loan> getInterest(String loantype, String bank);
	
	
	public List<Loan> getInterestrates(String loantype);
	
	
	public List<Loan> getDeptids(String dname);
}
