package com.lendingtree.dao;

import java.util.List;

import com.lendingtree.bean.RegistrationBean;
import com.lendingtree.model.UserRole;
import com.lendingtree.model.Userslist;

public interface SecurityDao {

	@SuppressWarnings("rawtypes")
	public List getSearchDetails(RegistrationBean login);
	
	public Userslist findByUserName(String username);
	
	public List<UserRole> loadUserRoleByUsername(String username);
	
	@SuppressWarnings("rawtypes")
	public List searchUser(RegistrationBean login);
	
}
