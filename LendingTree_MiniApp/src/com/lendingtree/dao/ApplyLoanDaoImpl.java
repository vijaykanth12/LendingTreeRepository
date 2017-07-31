package com.lendingtree.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lendingtree.model.ApplyLoan;
import com.lendingtree.model.Dept;
import com.lendingtree.model.Employee;
import com.lendingtree.model.LoanApply;

@SuppressWarnings("unused")
@Repository("aploanDao")
public class ApplyLoanDaoImpl implements ApplyLoanDao{

	@Autowired
	 private SessionFactory sessionFactory;
	@Override
	public void addapplyloan(ApplyLoan loan) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(loan);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<LoanApply> getCustomers() {
		// TODO Auto-generated method stub
		return(List<LoanApply>) 
				 sessionFactory.getCurrentSession().createCriteria(LoanApply.class).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<LoanApply> getCustId(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From LoanApply where id='"+id+"'").list();
	}
	
	
	
	
	
	
	/*@SuppressWarnings("unchecked")
	@Override
	public List<ApplyLoan> getCustId(String id) {
		// TODO Auto-generated method stub
		return (List<ApplyLoan>) sessionFactory.getCurrentSession().get(ApplyLoan.class, id);
	}*/
	@Override
	public void updateapplyloan(LoanApply loan) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(loan);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ApplyLoan> getRegid(Integer ids, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From LoanApply where regid='"+ids+"'").list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ApplyLoan> getList(Integer ids) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From Registration where id='"+ids+"'").list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ApplyLoan> getEmpName(String name,String dept) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From LoanApply where assignedto='"+name+"' and status='"+dept+"'").list();
	}
	@SuppressWarnings("rawtypes")
	@Override
	public List searchStatusType(String status) {
		// TODO Auto-generated method stub
		List li=sessionFactory.getCurrentSession().createQuery("FROM LoanApply WHERE status='"+status+"'").list();
		 System.out.println("the jsj size"+li.size());
		 return li;
	}
	@Override
	public void applypersonalloan(LoanApply loan) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(loan);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<LoanApply> getPersonalloan() {
		// TODO Auto-generated method stub
		return(List<LoanApply>) 
				 sessionFactory.getCurrentSession().createCriteria(LoanApply.class).list();
	}
	@Override
	public List<LoanApply> getLoanCustomers() {
		// TODO Auto-generated method stub
		return  sessionFactory.getCurrentSession().createQuery("From LoanApply where status='Applied'").list();
	}
	@Override
	public List searchDate(String da1, String da2) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(LoanApply.class).list(); 
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<LoanApply> sanctiondates(String start, String end) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From LoanApply where loanacceptdate between'"+start+"' and '"+end+"'").list();
	}
	@Override
	public void addDocs(LoanApply pm) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(pm);
	}
	@Override
	public void addexcel(LoanApply loan) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(loan);
	}

	
	
	


}
