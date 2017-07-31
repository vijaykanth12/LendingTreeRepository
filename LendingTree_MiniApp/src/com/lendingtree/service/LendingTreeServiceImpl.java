package com.lendingtree.service;

import javax.ejb.Stateless;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lendingtree.dao.LendingTreeDao;

//@Service("LendingTreeService")
@Stateless
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class LendingTreeServiceImpl implements LendingTreeService<Object>{

	@Autowired
	 private LendingTreeDao ltdao;

	@Override
	public void add(Object g) {
		// TODO Auto-generated method stub
		ltdao.add(g);
	}

	@Override
	public void edit(Object g) {
		// TODO Auto-generated method stub
		ltdao.edit(g);
	}
	
	
}
