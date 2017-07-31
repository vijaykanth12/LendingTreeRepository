package com.lendingtree.service;

import javax.ejb.Local;



@Local
public interface LendingTreeService<G>{

	void add(Object g);

	void edit(Object g);
	

	
	

	
}
