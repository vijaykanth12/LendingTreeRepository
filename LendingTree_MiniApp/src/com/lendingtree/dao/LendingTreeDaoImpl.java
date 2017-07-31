package com.lendingtree.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("ltdao")
public class LendingTreeDaoImpl implements LendingTreeDao<Object>{



@Autowired
private SessionFactory sessionFactory;

@Override
public void add(Object g) {
	// TODO Auto-generated method stub
	sessionFactory.getCurrentSession().save(g);
}

@Override
public void edit(Object g) {
	// TODO Auto-generated method stub
	sessionFactory.getCurrentSession().update(g);
}

}
