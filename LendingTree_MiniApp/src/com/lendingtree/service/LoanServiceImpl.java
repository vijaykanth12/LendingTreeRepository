package com.lendingtree.service;

import java.util.List;

import javax.ejb.Stateless;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lendingtree.bean.LoanBean;
import com.lendingtree.dao.LoanDao;
import com.lendingtree.model.Loan;
//@Service("LoanService")
@Stateless
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class LoanServiceImpl implements LoanService {

	@Autowired
	 private LoanDao ldao;
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public void addloan(Loan loan) {
		// TODO Auto-generated method stub
		ldao.addloan(loan);
	}

	@Override
	public List<Loan> getLoans() {
		// TODO Auto-generated method stub
		return ldao.getLoans();
	}

	@Override
	public List<Loan> getLoanId(int id) {
		// TODO Auto-generated method stub
		return ldao.getLoanId(id);
	}

	@Override
	public void editLoan(Loan loan) {
		// TODO Auto-generated method stub
		ldao.editLoan(loan);
	}

	@Override
	public void deleteLoan(String id) {
		// TODO Auto-generated method stub
		ldao.deleteLoan(id);
	}

	@Override
	public List<Loan> getLoan(String loantype, String bname) {
		// TODO Auto-generated method stub
		return ldao.getLoan(loantype, bname);
	}

	@Override
	public List<Loan> getLoanss(LoanBean bean) {
		// TODO Auto-generated method stub
		return ldao.getLoanss(bean);
	}

	@Override
	public List<Loan> listLoanTypes() {
		// TODO Auto-generated method stub
		return ldao.listLoanTypes();
	}

	@Override
	public List<Loan> listBankType(String loantype) {
		// TODO Auto-generated method stub
		return ldao.listBankType(loantype);
	}

	@Override
	public List<Loan> getInterest(String loantype, String bank) {
		// TODO Auto-generated method stub
		return ldao.getInterest(loantype, bank);
	}

	@Override
	public List<Loan> getInterestrates(String loantype) {
		// TODO Auto-generated method stub
		return ldao.getInterestrates(loantype);
	}

	@Override
	public List<Loan> getDeptids(String dname) {
		// TODO Auto-generated method stub
		return ldao.getDeptids(dname);
	}

	
	
	
	

	

}
