package com.lendingtree.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lendingtree.bean.LoanBean;
import com.lendingtree.model.Loan;
@Repository("ldao")
public class LoanDaoImpl implements LoanDao{

	@Autowired
	 private SessionFactory sessionFactory;
	@Override
	public void addloan(Loan loan) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(loan);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Loan> getLoans() {
		// TODO Auto-generated method stub
		return(List<Loan>) 
				 sessionFactory.getCurrentSession().createCriteria(Loan.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Loan> getLoanId(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From Loan where id='"+id+"'").list();
	}

	@Override
	public void editLoan(Loan loan) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(loan);
	}

	@Override
	public void deleteLoan(String id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Loan WHERE  id = '"+id+"'").executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Loan> getLoan(String loantype, String bname) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("FROM Loan where loantype='"+loantype+"'and bname='"+bname+"'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Loan> getLoanss(LoanBean bean) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("FROM Loan where loantype='"+bean.getLoantype()+"'and bname='"+bean.getBname()+"'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Loan> listLoanTypes() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("select distinct loantype FROM Loan").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Loan> listBankType(String loantype) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("select distinct bname FROM Loan where loantype='"+loantype+"'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Loan> getInterest(String loantype, String bank) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("select interest FROM Loan where loantype='"+loantype+"' and bname='"+bank+"'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Loan> getInterestrates(String loantype) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery(" FROM Loan where loantype='"+loantype+"'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Loan> getDeptids(String dname) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery(" Select deptid FROM Dept where dname='"+dname+"'").list();
	}

}
