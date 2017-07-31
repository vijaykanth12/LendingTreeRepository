package com.lendingtree.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.lendingtree.bean.BankBean;
import com.lendingtree.model.Bank;


@SuppressWarnings("unused")
@Repository("bDao")
public class BankDaoImpl implements BankDao{

	@Autowired
	 private SessionFactory sessionFactory;
	@Override
	public void addbank(Bank bank) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(bank);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Bank> getBanks() {
		// TODO Auto-generated method stub
		return  (List<Bank>) 
				 sessionFactory.getCurrentSession().createCriteria(Bank.class).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Bank> getBankId(int id) {
		// TODO Auto-generated method stub
		return  sessionFactory.getCurrentSession().createQuery("From Bank where id='"+id+"'").list();
	}
	@Override
	public void editBank(Bank bank) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(bank);
	}
	@Override
	public void deleteBank(String id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Bank WHERE  id = '"+id+"'").executeUpdate();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Bank> listBanks() {
		// TODO Auto-generated method stub
		return  sessionFactory.getCurrentSession().createQuery("select DISTINCT bname FROM Bank").list();
	}
	

}
